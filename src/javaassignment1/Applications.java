/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment1;

import java.util.ArrayList;

/**
 *
 * @author User
 */
public class Applications extends ManageStudentData {

    @Override
    public ArrayList<String> viewID(){
        ArrayList<String> appIDs = new ArrayList<>();
        ArrayList<ArrayList<String>> lst = file.readFile("application.txt");
        for (int i=0; i<lst.size(); i++){
            appIDs.add(lst.get(i).get(0));
        }
        return appIDs;
    }
    
     @Override
    public ArrayList<ArrayList<String>> getStudentData(){
        ArrayList<ArrayList<String>> application = new ArrayList();
        
        for (int i = 0; i<data.size(); i++){
            System.out.println(data.get(i).get(1).equals(getStudId()));
            System.out.println(data.get(i).get(1));
            System.out.println(getStudId());
            if (data.get(i).get(1).equals(getStudId())){
                application.add(data.get(i));
            }
        }
        
        System.out.println(application);
        return application;
    }
    
    private String applicationID;
    private String studId;
    private String applicationDate;
    private String type;
    private String status;
    private final txtfile file = new txtfile();
    private final String filename = "application.txt";
    private final ArrayList<ArrayList<String>> data = file.readFile(getFilename());
     public Applications(){
    
    }
    
    // for room assignment
    public Applications(String studentID){  
        //super(studentID);\
        this.studId=studentID;
        ArrayList<ArrayList<String>> applications = file.readFile("application.txt");
        for (int i = 0; i < applications.size(); i++){
            if(studentID.equals(applications.get(i).get(1))){
                this.applicationID = applications.get(i).get(0);
                this.applicationDate = applications.get(i).get(3);
                this.status = applications.get(i).get(4);
                this.type = applications.get(i).get(2);
                System.out.println(this.type);
                //room.setType(applications.get(i).get(2));// is not setting the type
                //System.out.println(applications.get(i).get(2));
            }
        }
    }

     // prob should get rid of this but for now idk how to load it into the super class
    public String getType() {
        return type;
    }

    public String getStatus() {
        return status;
    }
    
    //get all application IDs in application.txt
    public String getStudId() {
        return studId;
    }

    
    public void setStudId(String studId) {
        this.studId = studId;
    }

    
    public String getApplicationID() {
        return applicationID;
    }

    
    public void setApplicationID(String applicationID) {
        this.applicationID = applicationID;
    }

    
    public void setType(String type) {
        this.type = type;
    }

    
    public void setStatus(String status) {
        this.status = status;
    }
    
 
    //get all Student ID in application.txt
    public  ArrayList<String> viewApplicationsStudentID(){
        ArrayList<String> roomNumS = new ArrayList<>();
        ArrayList<ArrayList<String>> lst = file.readFile("application.txt");
        for (int i=0; i<lst.size(); i++){
            roomNumS.add(lst.get(i).get(1));
        }
        return roomNumS;
    }
    
    //Radio button filter for types of applications
    public ArrayList<String> filter(String type){
        //parse the text of the radio button as the string then u can reuse the method from the class
        ArrayList<ArrayList<String>> lst = file.readFile("application.txt");
        ArrayList<String> appIDs = new ArrayList<>();
        for (int i = 0; i <lst.size();i++){
                if(lst.get(i).get(4).equals(type)){     
                    appIDs.add(lst.get(i).get(0));
                }
            }
        return appIDs;
    }
    
    public void deleteApplication(){
        ArrayList<ArrayList<String>> lst = file.readFile("application.txt");
         try{
            for (int i = 0; i<lst.size(); i++){
                if (this.getStudId().equals(lst.get(i).get(1))){
                    lst.remove(i);
                }
            }
            System.out.println(lst);
            file.writeData("application.txt", lst); 
        }
        catch(Exception e){}
    }
    
   
    
    public String generateApplicationId(){
        String newId;
        
        int lastId = Integer.parseInt(data.get(data.size()-1).get(0));
        newId = String.valueOf(lastId +1);
        
        
        return newId;
    }
    
    public String getFilename() {
        return filename;
    }
    
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(AssignRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(AssignRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(AssignRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(AssignRoom.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                new Applications("123"). deleteApplication();
//            }
//        });
//    }
    
}
