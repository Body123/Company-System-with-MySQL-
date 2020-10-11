
package company;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Component;
import java.awt.Container;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.Robot;
import java.awt.Toolkit;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.text.MessageFormat;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

public class Tools {
    private String text="";
    private String inverseText="";
    private String texts[];
    public Object Items[][];
    int rows;
    int column;
    
    public Tools(String text){
        this.setText(text);
    }
    public Tools(String[] texts){
        this.texts=texts;
    }
    public Tools(String[][] Items){
        this.Items=Items;
    }
    public Tools(int column){
        this.column=column;
    }

    /**
     * @return the text
     */
    public String getText() {
        return text;
    }

    /**
     * @param text the text to set
     */
    public void setText(String text) {
        this.text = text;
    }

    /**
     * @return the inverseText
     */
    public String getInverseText() {
        return inverseText;
    }

    /**
     * @param inverseText the inverseText to set
     */
    public void setInverseText(String inverseText) {
        this.inverseText = inverseText;
    }
    public void printCharByChar(){
        for(char c: getText().toCharArray()){
            System.out.println(c);
        }
    }
    public void printCharByCharInverse(){
        StringBuilder sb=new StringBuilder(getText());
        setInverseText(sb.reverse().toString());
        for(char c: getInverseText().toCharArray()){
            System.out.println(c);
        }
    }
    public void printStringArray(){
        for(String G:texts){
            System.out.println(G);
        }
    }
    public Object[] mergeTwoArray(Object arr1[],Object arr2[]){
        int l1=arr1.length;
        int l2=arr2.length;
        Object result[]=new Object [l1+l2];
        System.arraycopy(l1, 0, result, 0, l1);
        System.arraycopy(l2, 0, result, l1, l2);
        return result;
    }
    
    public void addNewRow(Object[] row){
        Object temp[][]=Items;
        int c=column;
        Items=new Object[Items.length+1][c];
        for(int x=0; x<temp.length;x++){
            Items[x]=temp[x];
        }
        Items[Items.length-1]= row;
        
    }
    public void editRaw(int rowIndex,int columnIndex,Object newdata){
        Items[rowIndex][columnIndex]=newdata; 
    }
    public void MgsBOx(String Message){
        JOptionPane.showMessageDialog(null, Message);
    }
    public static void createFolder(String folderName,String path){
        File newFolder=new File(path+'/'+folderName);
        newFolder.mkdir();
    }
    public static void openForm(JFrame form){
        form.setLocationRelativeTo(null);
        try {
            Image img=ImageIO.read(Tools.class.getResource("iii.jpg"));
            form.setIconImage(img);
            form.getContentPane().setBackground(Color.white);
        } catch (IOException ex) {
            Logger.getLogger(Tools.class.getName()).log(Level.SEVERE, null, ex);
        }
        form.setVisible(true);
    }
    public static void clearText(Container form){
        for(Component c: form.getComponents()){
            if(c instanceof JTextField){
                JTextField txt=(JTextField) c;
                txt.setText("");
            }else if(c instanceof Component){
                clearText((Container) c);
            }
        }
    }
    public static void creatEmptyFile(String path,String fileName) throws IOException{
        File newFile=new File(path+'/'+fileName+"txt");
        newFile.createNewFile();
    }
    public static void createMultiEmptyFiles (String []files) throws IOException{
        for(String str :files){
            creatEmptyFile(str);
        }
    }
    public static void creatEmptyFile(String fileName) throws IOException{
        File newFile=new File(fileName+".txt");
        newFile.createNewFile();
    }
    public static void writeDataIntoNewFile(String fileName,Object[] data) throws FileNotFoundException{
        PrintWriter p=new PrintWriter(fileName);
        for(Object o:data){
            p.println(o);
        }
        p.close();
    }
    public static void writeDataIntoNewFiles(String []filesName,Object[][]data) throws FileNotFoundException{
        for(int i=0;i<filesName.length;i++){
            writeDataIntoNewFile(filesName[i],data[i]);
        }
    }
    public static Object inputBox(String title){
        Object myObj=JOptionPane.showInputDialog(title);
        return myObj;
    }
    public static String digitsOfString(String text){
        String sub="";
        for(int i=0 ;i<text.length();i++){
            if(Character.isDigit(text.charAt(i))){
                sub+=text.charAt(i);
            }
        }
        return sub;
    }
    public static void printScreen(String imageName) throws AWTException, IOException{
        Robot r=new Robot();
        Rectangle rect =new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img =r.createScreenCapture(rect);
        ImageIO.write(img, "jpg", new File(imageName+".jpg"));
    }
    public static void printScreen(String imageName,JFrame form) throws AWTException, IOException{
        form.setState(1);
        Robot r=new Robot();
        Rectangle rect =new Rectangle(Toolkit.getDefaultToolkit().getScreenSize());
        BufferedImage img =r.createScreenCapture(rect);
        ImageIO.write(img, "jpg", new File(imageName+".jpg"));
        form.setState(0);
    }
    public static void msgBox(String Message){
        JOptionPane.showMessageDialog(null,Message);  
    }
    public static boolean confirmMessage(String Message){
       int MSG= JOptionPane.showConfirmDialog(null, Message);
       if(MSG==JOptionPane.YES_OPTION){
           return true;
       }else{
           return false;
       }
    }
    public static void setReportHeader(JTable table){
        table.getTableHeader().setBackground(new Color(0,0,100));
        table.getTableHeader().setForeground(Color.white);
    }
    public static void printReport(JTable table ,String title){
        try{
            MessageFormat header =new  MessageFormat(title+" Report");
            MessageFormat footer =new  MessageFormat("Page - {0}");
            table.print(JTable.PrintMode.FIT_WIDTH,header,footer);
        }catch(Exception e){
            Tools.msgBox(e.getMessage());
        }
    }
    
   
    
}
