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
public class workOn implements mainData{
    private int empNo;
    private int projectNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public int getProjectNo() {
        return projectNo;
    }

    public void setProjectNo(int projectNo) {
        this.projectNo = projectNo;
    }

    @Override
    public void add() {
        String strInsert="insert into workon values ( "+empNo+","+projectNo+")";
        boolean isAdded=dataBase.databaseConnector.runNonQuery(strInsert);
        if(isAdded){
            Tools.msgBox("Added");
        }else{
            Tools.msgBox("Error");
        }
    }

    @Override
    public void update() {
        Tools.msgBox("Update method not working in workOn class ");
    }

    @Override
    public void delete() {
        String strDelete="delete from workon where "+
                        "empno="+empNo+" and"+
                        " projectno= "+projectNo;
        boolean isDeleted=dataBase.databaseConnector.runNonQuery(strDelete);
        if(isDeleted){
            Tools.msgBox("Deleted");
        }else{
            Tools.msgBox("Error");
        }
    }

    @Override
    public String getAutoNumber() {
        Tools.msgBox("getAutoNumber method not working in workOn class ");
        return "";
    }

    @Override
    public void getAllRows(JTable table) {
        try {
            dataBase.databaseConnector.fillToJTable("workon_data", table);
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    @Override
    public void getOnerows(JTable table) {
        String strSelect ="select * from workon_data where Employee_no ="+empNo
                          +" and project_no="+projectNo; 
        try {
            dataBase.databaseConnector.fillToJTable(strSelect, table);
        } catch (SQLException ex) {
            Logger.getLogger(workOn.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getCustomRow(String statement, JTable table) {
        try {
            dataBase.databaseConnector.fillToJTable(statement, table);
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    @Override
    public String getValueByName(String name) {
        Tools.msgBox("getValueByName method not working in workOn class ");
        return "";
    }

    @Override
    public String getNameByValue(String value) {
        Tools.msgBox("getNameByValue method not working in workOn class ");
        return "";
    }
    
}
