/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package company;
import library.*;
/**
 *
 * @author Wafaa
 */
public class Table {
    public int columns;
    
    public Table(int coulmns){
        this.columns=columns;
        
       
    }
    public Object [][] Items=new Object [0][columns];
     public void addNewRow(Object row){
            singlyLinkedList obj =new singlyLinkedList();
            for(int x=0;x<Items.length;x++ ){
                obj.add(Items[x]);
            }
            obj.add(row);
            Items=new Object[obj.size()][columns];
            for(int x=0;x<obj.size();x++ ){
                Items[x]=(Object[]) obj.get(x);
            }
            
            
        }
     public void printItems(){
         for(Object[] ob:Items){
             for(Object ele:ob){
                 System.out.print(ele);
                 System.out.print(' ');
             }
              System.out.println();
         }
     }
}
