/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment1;

import java.util.ArrayList;
import java.util.Collections;

/**
 *
 * @author User
 */
public class Room implements ManageStudentData {
    private String roomNum;
    private String gender;
    private String type;
    private String capacity;
    private String availability;
    txtfile file = new txtfile();
    private final String filename = "room.txt";
    private final ArrayList<ArrayList<String>> data = file.readFile(filename);
    
//  
    
    
    public Room(int i){
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        this.roomNum = lst.get(i).get(0);
        this.gender = lst.get(i).get(1);
        this.type = lst.get(i).get(2);
        this.capacity = lst.get(i).get(3);
        this.availability = lst.get(i).get(4);
    }

    public Room(String id){
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        for (int i = 0; i<lst.size();i++){
            if(id.equals(lst.get(i).get(0))){
                this.roomNum = lst.get(i).get(0);
                this.gender = lst.get(i).get(1);
                this.type = lst.get(i).get(2);
                this.capacity = lst.get(i).get(3);
                this.availability = lst.get(i).get(4);
            }
        }
    }
    
    
    public Room(){
        
    }
    
    public String getRoomNum() {
        return roomNum;
    }

    public void setRoomNum(String roomNum) {
        this.roomNum = roomNum;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCapacity() {
        return capacity;
    }

    public void setCapacity(String capacity) {
        this.capacity = capacity;
    }

    public String getAvailability() {
        return availability;
    }

    public void setAvailability(String availability) {
        this.availability = availability;
    }
    
    // get all the room ids of room.txt
    @Override
    public ArrayList<String> viewID(){
        ArrayList<String> roomNumS = new ArrayList<>();
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        for (int i=0; i<lst.size(); i++){
            //roomNumS.add(lst.get(i).get(i));
            roomNumS.add(lst.get(i).get(0));
        }
        return roomNumS;
    }
    
     public ArrayList<ArrayList<String>> availableRoom(){ 
        ArrayList<ArrayList<String>> room = new ArrayList();
        
        for (int i = 0; i<data.size(); i++){
           if (data.get(i).get(4).equals("true")){
               room.add(data.get(i));
           }
        }

        
        return room;
    }
    
     public ArrayList<ArrayList<String>> filterGender(ArrayList<ArrayList<String>> lst,String gender){
       ArrayList<ArrayList<String>> finalLst = new ArrayList();
         
       for (int i=0;i<lst.size();i++){
           if (lst.get(i).get(1).equals(gender)){
               finalLst.add(lst.get(i));
           }
       } 
       return finalLst;
    }
    
    //add room to room file
    public String addRoom(){
        String newId;
       
        int count;
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        ArrayList<String> ids = new ArrayList<>();
        //block to make id
        for (int i=0; i<lst.size(); i++){
            String roomNumber = lst.get(i).get(0);
            String b = roomNumber.substring(1,3);
            ids.add(b);
        }
        count = Integer.parseInt(Collections.max(ids));
        if (count >= 9){
            newId = "A" + (count+1);
        }
        else{
            newId = "A0" + (count+1);
        }
        if (this.type.equals("STD")){
            this.capacity = "2";
        }
        else if (this.type.equals("DEL")){
            this.capacity = "1";
        }
       
        ArrayList<String> newRoom = new ArrayList<>();
        newRoom.add(newId);
        newRoom.add(this.gender);
        newRoom.add(this.type);
        newRoom.add(this.capacity);
        newRoom.add("true");
        
        file.writeFile("room.txt",newRoom);
        return "Room successfully added";
    }
    
    //Select Room ID
    public  int selectRoomID(){
        try{
            ArrayList<String> roomIDs= new Room().viewID(); //list of roomIDs
            for(int x = 0; x < roomIDs.size(); x ++){
                if(this.roomNum.equals(roomIDs.get(x))){
                    return 1;
                }
            }
        }catch(Exception e){}
            return 0;
    }
    
    //Update room from available to not available
    public String updateRoomStatus(){
        try{
            ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
            for (int i = 0; i<lst.size(); i++){
                if (this.roomNum.equals(lst.get(i).get(0))){
                    if (lst.get(i).get(4).equals("true")){
                    lst.get(i).set(4,"false");
                }
                else
                    lst.get(i).set(4,"true");
            }
        }
        file.writeData("room.txt", lst);
        return "Room successfully updated";
        }
        catch(Exception e){
        
        }
        return "Room could not be updated";
    }
    
    public String deleteRoom(){ 
        ArrayList<ArrayList<String>> occupiedRoom = file.readFile("student_rooms.txt");
        
        for (int i =0;i<occupiedRoom.size();i++){
            if (occupiedRoom.get(i).get(0).equals(this.roomNum)){
                return "Room Occupied can't be deleted";
            }
        }
        
        try{
            ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
            
            for (int i = 0; i<lst.size(); i++){
                if (this.roomNum.equals(lst.get(i).get(0))){
                    lst.remove(i);
                }
            }
            
            file.writeData("room.txt", lst);
            return "Room successfully deleted";
        }
        catch(Exception e){
        
        }
        return "Room could not be deleted";
    }
    
    //get all data from student_rooms
    public ArrayList<ArrayList<String>> getStudentData(){
        ArrayList<ArrayList<String>> lst = file.readFile("student_rooms.txt");
        return lst;
    }
    
    //enroll student into their new room
    public void enrollStudent(String studID,String roomID){
        ArrayList<String> student_room = new ArrayList<>();
        student_room.add(roomID);
        student_room.add(studID);
        file.writeFile("student_rooms.txt",student_room);
    }
    
    public int checkStudent(String studID){
        // block to check if there is a student living inside
        ArrayList<ArrayList<String>> lst = file.readFile("student_rooms.txt");
        for (int i =0; i <lst.size();i++){
            if (studID.equals(lst.get(i).get(1))){
                
                return 1;
            }
        }
        return 0;
    }
    
    public void evictStudent(String studID){ //incomplete
        
        // block to erase the line in student_rooms
        Student std1 = new Student(studID);
        Applications app1 = new Applications(studID);
        ArrayList<ArrayList<String>> lst = file.readFile("student_rooms.txt");
        try{
            for (int i = 0; i<lst.size(); i++){
                System.out.println(studID + lst.get(i).get(1));
                if (studID.equals(lst.get(i).get(1))){
                    lst.remove(i);
                    System.out.println(lst);
                    file.writeData("student_rooms.txt", lst);
                    this.roomNum = lst.get(i).get(0);
                    updateRoomStatus();
                }
            }
            //return "Room successfully deleted";
        }
        catch(Exception e){
        
        }
        // block to change the student's the staying area
        std1.updateSudentStatus();
        
        //block to maybe delete the accepted application
       new Applications(studID).deleteApplication();
    }
    
    public int availableRooms(){
        int availableRooms =0;
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        for (int i = 0; i <lst.size(); i++){
            if (lst.get(i).get(4).equals("true")){
                availableRooms += 1;
            }
        }
        return availableRooms;
    }
    
    public int availableTypeRooms(String type){
        int availableRooms =0;
        ArrayList<ArrayList<String>> lst = file.readFile("room.txt");
        for (int i = 0; i <lst.size(); i++){
            if (lst.get(i).get(2).equals(type)&& lst.get(i).get(4).equals("true")){
                availableRooms += 1;
            }
        }
        return availableRooms;
    }
    
    public double monthlyIncome(){
        ArrayList<ArrayList<String>> lst = file.readFile("student_rooms.txt");
        ArrayList<ArrayList<String>> lst2 = file.readFile("room.txt");
        ArrayList<String> lstOfTaken = new ArrayList();
        double monthlyIncome = 0;
        try{
            for (int i = 0; i <lst.size(); i++){
                    lstOfTaken.add(lst.get(i).get(0));
                }
            
        }
        
        catch(Exception e){
            System.out.println("nothing here");
            
        }
        for(int i = 0; i <lstOfTaken.size(); i++){
            
            for(int j = 0; j <lst2.size(); j++){
                
                if(lstOfTaken.get(i).equals(lst2.get(j).get(0))){
                    if(lst2.get(j).get(2).equals("STD")){
                        monthlyIncome += 500;
                    }
                    else
                        monthlyIncome += 750;
                }
            } 
        }
        
        return monthlyIncome;
        }
    
//        public static void main(String args[]) {
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
//            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(Report.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the form */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                double i = new Room().monthlyIncome();
//                System.out.println(i);
//            }
//        });
//    }
}
