/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;

import Entity.workOn;
import forms.FormWorkOn;
import forms.formDepartment;
import forms.formEmployee;
import forms.formLogin;
import forms.formProject;
import forms.frmMain;
import forms.frtest;

/**
 *
 * @author Wafaa
 */
public class Company {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Tools.openForm(new formLogin());
        //Tools.openForm(new frtest());
        //Tools.openForm(new FormWorkOn());
        
    }
    
}
