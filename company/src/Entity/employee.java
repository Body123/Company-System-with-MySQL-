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
public class employee implements mainData{
    private int empNo;
    private String empName;
    private String address;
    private double salary;
    private String hiringDate;
    private String birthDate;
    private int deptNo;

    public int getEmpNo() {
        return empNo;
    }

    public void setEmpNo(int empNo) {
        this.empNo = empNo;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getHiringDate() {
        return hiringDate;
    }

    public void setHiringDate(String hiringDate) {
        this.hiringDate = hiringDate;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }

    public int getDeptNo() {
        return deptNo;
    }

    public void setDeptNo(int deptNo) {
        this.deptNo = deptNo;
    }

    @Override
    public void add() {
        String strInsert="insert into employee values ( "+
                empNo+",'"+empName+"',"+"'"+address+"',"+salary+
                ",'"+hiringDate+"',"+
                "'"+birthDate+"',"
                +deptNo+")";
        boolean isAdded=dataBase.databaseConnector.runNonQuery(strInsert);
        if(isAdded){
            Tools.msgBox("Employee is added");
        }else{
            Tools.msgBox("Error occured");

        }
                
        
    }

    @Override
    public void update() {
      String strUpdate="update employee set "+
                  "EmpName= '"+empName+"',"+
                  "Address= '"+address+"',"+
                  "Salary= "+salary+","+
                  "HiringDate= '"+hiringDate+"',"+
                  "BirthDate= '"+birthDate+"',"+
                  "DeptNo= "+deptNo+
                  " where EmpNo = "+empNo;
      boolean isUpdated =dataBase.databaseConnector.runNonQuery(strUpdate);
      if(isUpdated){
          Tools.msgBox("Updated");
      }else{
          Tools.msgBox("Error");

      }
        
    }
    
    

    @Override
    public void delete() {
        String strDeleted="delete from employee where empno = "+empNo;
        boolean isDeleted =dataBase.databaseConnector.runNonQuery(strDeleted);
        if(isDeleted){
            Tools.msgBox("Deleted");
        }else{
            Tools.msgBox("Error");

        }
    }

    @Override
    public String getAutoNumber() {
        return dataBase.databaseConnector.getAutoNumber("Employee", "empNo");
    }

    @Override
    public void getAllRows(JTable table) {
        try {
            dataBase.databaseConnector.fillToJTable("employee_data", table);
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
    }

    @Override
    public void getOnerows(JTable table) {
        try {
            String StrSelected="select * from employee_data "+
                    "where Number = "+empNo;
            dataBase.databaseConnector.fillToJTable(StrSelected, table);
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
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
        String Statement="select number from employee_data where Name = '"
                +name+"'";
        String value ="";
        try {
            value =(String)dataBase.databaseConnector.getTableData(Statement).Items[0][0];
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
        return value;
    }

    @Override
    public String getNameByValue(String value) {
        String Statement="select name from employee_data where number = "
                +value;
        String nameValue ="";
        try {
            nameValue =(String)dataBase.databaseConnector.getTableData(Statement).Items[0][0];
        } catch (SQLException ex) {
            Tools.msgBox(ex.getMessage());
        }
        return nameValue;
    }
    
}
