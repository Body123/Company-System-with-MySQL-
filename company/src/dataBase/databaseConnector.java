/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dataBase;
import company.Table;
import company.Tools;
import java.sql.*;
import java.util.Vector;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
/**
 *
 * @author Wafaa
 */
public class databaseConnector {
    private static String url="";
    private static String dbName="company";
    private static Connection con;
    
    public static void setURL(){
        url="jdbc:mysql://localhost:3306/"+dbName
                + "?useUnicode=true&characterEncoding=UTF-8";
    }
    public static void setConnection() throws SQLException{
        setURL();
        con=DriverManager.getConnection(url,"root","");
    }
    public static boolean checkUserAndPass(String userName,String password) throws SQLException{
        setConnection();
        Statement stmt =con.createStatement();
        String strCheaker="Select * from users where username='"+userName+"'And pass='"+password+"'";
        stmt.executeQuery(strCheaker);
        while(stmt.getResultSet().next()){
            con.close();
            return true;
        }
        return false;
    }
    public static boolean runNonQuery(String sqlStatement){
        try{
            setConnection();
            Statement stmt=con.createStatement();
            stmt.execute(sqlStatement);
            con.close();
            return true;
        }catch(SQLException e){
          
            Tools.msgBox(e.getMessage());
            return false;
        }
    }
    public static String getAutoNumber(String tableName,String columnName){
        try{
            setConnection();
            Statement stmt=con.createStatement();
            String Auto="select "+"max("+columnName+")+1 as autoNum "+"from "+tableName;
            stmt.executeQuery(Auto);
            String num="";
            while(stmt.getResultSet().next()){
                num=stmt.getResultSet().getString("autonum");
                
            }
            con.close();
            if(num==null||"".equals(num))
                return "1";
            else
                return num;
        }catch(SQLException e){
            Tools.msgBox(e.getMessage());
            return "0";
        }
    }
    public static Table getTableData(String statement) throws SQLException{
        setConnection();
        Statement stmt=con.createStatement();
        ResultSet rs =stmt.executeQuery(statement);
        ResultSetMetaData rsmd=rs.getMetaData();
        int numberOfColumns=rsmd.getColumnCount();
        Table table=new Table(numberOfColumns);
        while(rs.next()){
            Object row[]=new Object[numberOfColumns];
            for(int i=0; i<numberOfColumns;i++){
                row[i]=rs.getString(i+1);
            }
            table.addNewRow(row);
        }
        con.close();
        return table;
        
    }
    public static void fillComboBox(String tableName,String columnName,JComboBox combo) throws SQLException{
        setConnection();
        Statement stmt=con.createStatement();
        String strSelect ="Select "+columnName+" from "+tableName;
        
        ResultSet rs=stmt.executeQuery(strSelect);
        rs.last();
        int numberOfRows=rs.getRow();
        rs.beforeFirst();
        int i=0;
        Object []values=new Object[numberOfRows];
        while(rs.next()){
            values[i++]=rs.getString(1);
        }
        con.close();
        combo.setModel(new DefaultComboBoxModel(values));
       
    }
    public static void fillToJTable(String tableNameOrSelectStatement,JTable table) throws SQLException{
        setConnection();
        Statement stmt=con.createStatement();
        ResultSet res;
        String Cheacker =tableNameOrSelectStatement.substring(0,7).toLowerCase();
        String strSelect;
        if("select ".equals(Cheacker)){
            strSelect=tableNameOrSelectStatement;
        }else{
            strSelect="select * from "+tableNameOrSelectStatement;
        }
        res=stmt.executeQuery(strSelect);
        ResultSetMetaData rsmd=res.getMetaData();
        int c=rsmd.getColumnCount();
        DefaultTableModel model= (DefaultTableModel)table.getModel();
        Vector row =new Vector();
        model.setRowCount(0);
        
        while(res.next()){
        	row=new Vector();
            for(int i=1;i<=c;i++){
                 
                 row.add(res.getString(i));
                 
            }
            model.addRow(row);
        }
        con.close();
               
        if(table.getColumnCount()!=c){
            Tools.msgBox("JTable columns count Not Equal To Query columns count Query Table has "+c+"columns");
            
        }
        
    }
}
