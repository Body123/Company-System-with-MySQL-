/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package forms;

import Entity.employee;
import Entity.project;
import Entity.workOn;
import company.Tools;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Wafaa
 */
public class FormWorkOn extends javax.swing.JFrame {

    /**
     * Creates new form FormWorkOn
     */
    public FormWorkOn() {
        initComponents();
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        btnGroup = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jLabel9 = new javax.swing.JLabel();
        cbxemp = new controls.JMyCombo();
        cbxproject = new controls.JMyCombo();
        btnAdd = new controls.JMyButton();
        btndelete = new controls.JMyButton();
        btnFind = new controls.JMyButton();
        btnAll = new controls.JMyButton();
        btnBack = new controls.JMyButton();
        txtSearch = new controls.JTextBox(15);
        rdoProjectNo = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        rdoEmpName = new javax.swing.JRadioButton();
        rdoEmpNo = new javax.swing.JRadioButton();
        btnSearch = new controls.JMyButton();
        rdoProjectName = new javax.swing.JRadioButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblWorkOn = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        addWindowListener(new java.awt.event.WindowAdapter() {
            public void windowOpened(java.awt.event.WindowEvent evt) {
                formWindowOpened(evt);
            }
        });

        jLabel1.setFont(new java.awt.Font("Tahoma", 1, 20)); // NOI18N
        jLabel1.setText("Work On Form ");

        jLabel8.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel8.setText("Project :");

        jLabel9.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
        jLabel9.setText("Employee :");

        cbxemp.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        cbxproject.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        btnAdd.setText("Add");
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });

        btndelete.setText("Delete");
        btndelete.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btndeleteActionPerformed(evt);
            }
        });

        btnFind.setText("Find");
        btnFind.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFindActionPerformed(evt);
            }
        });

        btnAll.setText("All");
        btnAll.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                btnAllMouseClicked(evt);
            }
        });
        btnAll.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAllActionPerformed(evt);
            }
        });

        btnBack.setText("Back");
        btnBack.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnBackActionPerformed(evt);
            }
        });

        txtSearch.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N

        rdoProjectNo.setBackground(new java.awt.Color(255, 255, 255));
        rdoProjectNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoProjectNo.setText("Project No");

        jLabel5.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel5.setText("Search By :");

        rdoEmpName.setBackground(new java.awt.Color(255, 255, 255));
        rdoEmpName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoEmpName.setText("Employee Name");

        rdoEmpNo.setBackground(new java.awt.Color(255, 255, 255));
        rdoEmpNo.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoEmpNo.setSelected(true);
        rdoEmpNo.setText("Employee No");

        btnSearch.setText("Seaech");
        btnSearch.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSearchActionPerformed(evt);
            }
        });

        rdoProjectName.setBackground(new java.awt.Color(255, 255, 255));
        rdoProjectName.setFont(new java.awt.Font("Tahoma", 1, 11)); // NOI18N
        rdoProjectName.setText("Project Name");

        tblWorkOn.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Employee No", "Employee Name", "Project No", "project Name"
            }
        ) {
            boolean[] canEdit = new boolean [] {
                false, false, false, false
            };

            public boolean isCellEditable(int rowIndex, int columnIndex) {
                return canEdit [columnIndex];
            }
        });
        tblWorkOn.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tblWorkOnMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tblWorkOn);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(btnAdd)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btndelete)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnFind)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(btnAll))
                    .addComponent(btnBack)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel8))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(cbxemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(cbxproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 84, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel5)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addComponent(rdoEmpNo)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoEmpName)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(rdoProjectNo))
                                    .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, 261, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                    .addComponent(rdoProjectName)
                                    .addComponent(btnSearch)))
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1)
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel9)
                            .addComponent(cbxemp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel8)
                            .addComponent(cbxproject, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 85, Short.MAX_VALUE)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(btnAdd)
                            .addComponent(btndelete)
                            .addComponent(btnFind)
                            .addComponent(btnAll))
                        .addGap(37, 37, 37)
                        .addComponent(btnBack))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(rdoEmpName)
                            .addComponent(rdoEmpNo)
                            .addComponent(rdoProjectNo)
                            .addComponent(rdoProjectName))
                        .addGap(4, 4, 4)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(txtSearch, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(btnSearch))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnSearchActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSearchActionPerformed
        // TODO add your handling code here:
       String strSearch="select * from workon_data where ";
       if(rdoEmpNo.isSelected()){
           strSearch+="employee_no ";
       }else if(rdoEmpName.isSelected()){
           strSearch+="employee_name ";
       }else if(rdoProjectNo.isSelected()){
           strSearch+="project_no ";
       }else{
           strSearch+="project_name ";
       }
       strSearch+=" like'%"+txtSearch.getText()+"%'";
       workOn.getCustomRow(strSearch, tblWorkOn);
    }//GEN-LAST:event_btnSearchActionPerformed

    private void formWindowOpened(java.awt.event.WindowEvent evt) {//GEN-FIRST:event_formWindowOpened
        try {
            // TODO add your handling code here:
            dataBase.databaseConnector.fillComboBox("employee", "empName", cbxemp);
        } catch (SQLException ex) {
            Tools.msgBox("Error"); 
        }
        try {
            dataBase.databaseConnector.fillComboBox("project", "projectName", cbxproject);
        } catch (SQLException ex) {
            Tools.msgBox("Error");
        }
        btnGroup.add(rdoEmpName);
        btnGroup.add(rdoEmpNo);
        btnGroup.add(rdoProjectNo);
        btnGroup.add(rdoProjectName);
        workOn.getAllRows(tblWorkOn);
        tblWorkOn.getTableHeader().setReorderingAllowed(false);
       
        
    }//GEN-LAST:event_formWindowOpened
    employee emp=new employee();
    project pro=new project();
    workOn workOn=new workOn();
    private void btnBackActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnBackActionPerformed
        // TODO add your handling code here:
        this.dispose();
        Tools.openForm(new frmMain());
    }//GEN-LAST:event_btnBackActionPerformed
    private void setValues(){
        String empName=(String) cbxemp.getSelectedItem();
        String projName=(String) cbxproject.getSelectedItem();
        int empNo=Integer.parseInt(emp.getValueByName(empName));
        int projNo=Integer.parseInt(pro.getValueByName(projName));
        workOn.setEmpNo(empNo);
        workOn.setProjectNo(projNo);
       
    }
    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        // TODO add your handling code here:
        setValues();
         workOn.add();
        workOn.getAllRows(tblWorkOn);
    }//GEN-LAST:event_btnAddActionPerformed

    private void btndeleteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btndeleteActionPerformed
        // TODO add your handling code here:
        if(Tools.confirmMessage("Do Yo Want To Delete")){
            setValues();
            workOn.delete();
            workOn.getAllRows(tblWorkOn);
        }
        
    }//GEN-LAST:event_btndeleteActionPerformed

    private void btnFindActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFindActionPerformed
        // TODO add your handling code here:
        String strEmoNo=(String) Tools.inputBox("Enter Employee Number");
        int empNo=Integer.parseInt(strEmoNo);
        String strProjNo=(String) Tools.inputBox("Enter Project Number");
        int projNo=Integer.parseInt(strProjNo);
        workOn.setEmpNo(empNo);
        workOn.setProjectNo(projNo);
        workOn.getOnerows(tblWorkOn);
    }//GEN-LAST:event_btnFindActionPerformed

    private void btnAllActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAllActionPerformed
        // TODO add your handling code here:
        workOn.getAllRows(tblWorkOn);
    }//GEN-LAST:event_btnAllActionPerformed

    private void btnAllMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_btnAllMouseClicked
        // TODO add your handling code here:
        
    }//GEN-LAST:event_btnAllMouseClicked

    private void tblWorkOnMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tblWorkOnMouseClicked
        // TODO add your handling code here:
        int row=tblWorkOn.getSelectedRow();
        cbxemp.setSelectedItem(tblWorkOn.getValueAt(row, 1));
        cbxproject.setSelectedItem(tblWorkOn.getValueAt(row, 3));
    }//GEN-LAST:event_tblWorkOnMouseClicked

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormWorkOn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormWorkOn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormWorkOn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormWorkOn.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormWorkOn().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnAll;
    private javax.swing.JButton btnBack;
    private javax.swing.JButton btnFind;
    private javax.swing.ButtonGroup btnGroup;
    private javax.swing.JButton btnSearch;
    private javax.swing.JButton btndelete;
    private javax.swing.JComboBox<String> cbxemp;
    private javax.swing.JComboBox<String> cbxproject;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JRadioButton rdoEmpName;
    private javax.swing.JRadioButton rdoEmpNo;
    private javax.swing.JRadioButton rdoProjectName;
    private javax.swing.JRadioButton rdoProjectNo;
    private javax.swing.JTable tblWorkOn;
    private javax.swing.JTextField txtSearch;
    // End of variables declaration//GEN-END:variables
}