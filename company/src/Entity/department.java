/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;

/**
 *
 * @author Wafaa
 */
public class department implements mainData{
    private int deptNo;
    private String deptName;
    private String Location;

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    public String getDeptName() {
        return deptName;
    }

    public void setDeptName(String deptName) {
        this.deptName = deptName;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String Location) {
        this.Location = Location;
    }

    @Override
    public void add() {
        String insert="insert into department values ( "+
                deptNo+","
                +"'"+deptName+"',"
                +"'"+Location+"')";
        boolean isAdd=dataBase.databaseConnector.runNonQuery(insert);
        if(isAdd){
            Tools.msgBox("Department Added");
        }else{
            Tools.msgBox(" Error ");
        }
    }

    @Override
    public void update() {
       // UPDATE department SET deptname ="ccs",location="alex" WHERE deptno=1
        String update="UPDATE department SET "
                +"deptname ='"+deptName+"',"
                +"location='"+Location+"' "
                +"WHERE deptno="+deptNo;
       
        boolean isupdate=dataBase.databaseConnector.runNonQuery(update);
        if(isupdate){
            Tools.msgBox("Department updated");
        }else{
            Tools.msgBox(" Error ");
        }
        
    }

    @Override
    public void delete() {
        String delete="delete from department where deptno="+deptNo;
        boolean isdelete=dataBase.databaseConnector.runNonQuery(delete);
        if(isdelete){
            Tools.msgBox("Department updated");
        }else{
            Tools.msgBox(" Error ");
        }
    }

    @Override
    public String getAutoNumber() {
        return dataBase.databaseConnector.getAutoNumber("department", "deptno");
    }

    @Override
    public void getAllRows(JTable table) {
        try {
            dataBase.databaseConnector.fillToJTable("department", table);
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getOnerows(JTable table) {
        String strselect="select * from department_data where department_no ="+deptNo;
        try {
            dataBase.databaseConnector.fillToJTable(strselect, table);
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getCustomRow(String statement, JTable table) {
        try {
            dataBase.databaseConnector.fillToJTable(statement, table);
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public String getValueByName(String name) {
        String str="select deptno from department where deptname = '"+name+"'";
        String value="";
        try {
            value=(String)dataBase.databaseConnector.getTableData(str).Items[0][0];
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    @Override
    public String getNameByValue(String value) {
        String str="select deptname from department where deptno = "+value;
        String valueOfName="";
        try {
            valueOfName=(String)dataBase.databaseConnector.getTableData(str).Items[0][0];
        } catch (SQLException ex) {
            Logger.getLogger(department.class.getName()).log(Level.SEVERE, null, ex);
        }
        return valueOfName;
    }
}
