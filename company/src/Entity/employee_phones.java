/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Table;
import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Wafaa
 */
public class employee_phones implements mainData{
    private int empno;
    private String empphones;
    
    public int getEmpno() {
        return empno;
    }

    public void setEmpno(int empno) {
        this.empno = empno;
    }

    public String getPhones() {
        return empphones;
    }

    public void setPhones(String phones) {
        this.empphones = phones;
    }

    @Override
    public void add() {
        String strAdd="insert into employee_phones values ("+
                empno+" ,'"+empphones+"')";
        boolean isAdd= dataBase.databaseConnector.runNonQuery(strAdd);
        if(isAdd){
            //Tools.msgBox("Added");
        }else{
            Tools.msgBox("Error");
        }
    }

    @Override
    public void update() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void delete() {
        String strDelete="delete from employee_phones "+
                "where empno= "+empno+
                " and  phone = '"+empphones+"'";
        boolean isDeleted=dataBase.databaseConnector.runNonQuery(strDelete);
        if(isDeleted){
            //Tools.msgBox("Deleted");
        }else{
            Tools.msgBox("Error");
        }
    }
    public void deletebyemp(){
        String strDelete="delete from employee_phones where empno = "+empno;
        boolean isDeleted=dataBase.databaseConnector.runNonQuery(strDelete);
        if(isDeleted){
            //Tools.msgBox("Deleted");
        }else{
            Tools.msgBox("Error");
            
        }
    }
    @Override
    public String getAutoNumber() {
        return null;
    }

    @Override
    public void getAllRows(JTable table) {
        String strSelected ="select phone from employee_phones where empno ="+empno;
        try {
            dataBase.databaseConnector.fillToJTable(strSelected, table);
        } catch (SQLException ex) {
            Logger.getLogger(employee_phones.class.getName()).log(Level.SEVERE, null, ex);
        }
        }

    @Override
    public void getOnerows(JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void getCustomRow(String statement, JTable table) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getValueByName(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getNameByValue(String value) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getEmpnoByPhone(String requestphone) throws SQLException{
        String strSelect="select empno from employee_phones "
                        +" where Phone like '%"+requestphone+"%'";
        Object [][]row= dataBase.databaseConnector.getTableData(strSelect).Items;
        String empNo="";
        if(row.length>0){
            empNo=(String) row[0][0];
        }else{
            return "0";
        }
        return empNo;
    }
}
