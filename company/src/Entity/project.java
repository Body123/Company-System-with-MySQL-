/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entity;

import company.Tools;
import dataBase.databaseConnector;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JTable;
import javax.tools.Tool;

/**
 *
 * @author Wafaa
 */
public class project implements mainData{
    private int projectno;
    private String projectNAme="";
    private String projectLocation="";
    private int deptno;

    public int getProjectno() {
        return projectno;
    }

    public void setProjectno(int projectno) {
        this.projectno = projectno;
    }

    public String getProjectNAme() {
        return projectNAme;
    }

    public void setProjectNAme(String projectNAme) {
        this.projectNAme = projectNAme;
    }

    public String getProjectLocation() {
        return projectLocation;
    }

    public void setProjectLocation(String projectLocation) {
        this.projectLocation = projectLocation;
    }

    public int getDeptno() {
        return deptno;
    }

    public void setDeptno(int deptno) {
        this.deptno = deptno;
    }

    @Override
    public void add() {
        String StrAdd="insert into project values ("
                +projectno+","
                +"'"+projectNAme+"',"
                +"'"+projectLocation+"',"+
                +deptno+")";
        boolean isAdd=dataBase.databaseConnector.runNonQuery(StrAdd);
        if(isAdd){
            Tools.msgBox("Added");
        }else{
            Tools.msgBox("Error");
            
        }
    }

    @Override
    public void update() {
        String strUpdate="update project set "+
                " projectName= '"+projectNAme+"',"
                +" location ='"+projectLocation+"',"
                +" deptno= "+deptno
                +" where projectno= "+projectno;
        boolean isUpdated=dataBase.databaseConnector.runNonQuery(strUpdate);
        if(isUpdated){
            Tools.msgBox("Updated");
        }else{
            Tools.msgBox("Error");
            
        }
    }

    @Override
    public void delete() {
        String StrDelete ="delete from project where projectNo = "+projectno;
        boolean isDeleted=databaseConnector.runNonQuery(StrDelete);
        if(isDeleted){
            Tools.msgBox("Deleted");
        }else{
            Tools.msgBox("Error");
            
        }
    }

    @Override
    public String getAutoNumber() {
        return dataBase.databaseConnector.getAutoNumber("project","projectno" );
    }

    @Override
    public void getAllRows(JTable table) {
        try {
            databaseConnector.fillToJTable("project_data", table);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    public void getOnerows(JTable table) {
        String strSelect="select * from project_data where PROJECT_NO= "+projectno; 
        try {
            databaseConnector.fillToJTable(strSelect, table);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    

    @Override
    public void getCustomRow(String statement, JTable table) {
        try {
            databaseConnector.fillToJTable(statement, table);
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public String getValueByName(String name) {
        String strSelect ="Select projectNo from project where projectName= '"+name+"'";
        String value="";
        try {
            value=(String) databaseConnector.getTableData(strSelect).Items[0][0];
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
        return value;
    }

    @Override
    public String getNameByValue(String value) {
        String strSelect ="Select projectName from project where projectNo="+value;
        String name="";
        try {
            name=(String) databaseConnector.getTableData(strSelect).Items[0][0];
        } catch (SQLException ex) {
            Logger.getLogger(project.class.getName()).log(Level.SEVERE, null, ex);
        }
        return name;
    }
    
}
