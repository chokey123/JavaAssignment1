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
public class Student extends User implements viewMenuable { 
    
     @Override
    public void viewMenu(){
        studentMenu window = new studentMenu(studentID);
        window.setVisible(true);
    }
    
    private String studentID;
    private String name;
    private String gender;
    private int age;
    private String residence;
    txtfile file = new txtfile();
    private final String filename = "student.txt";
    private final ArrayList<ArrayList<String>> data = file.readFile(filename);
    
    public Student(){
        super();
    }
    
    public Student(String studID){
        
        this.studentID = studID;
        ArrayList<ArrayList<String>> students = file.readFile("student.txt");
        for (int i = 0; i < students.size(); i++){
            if(this.studentID.equals(students.get(i).get(0))){
                this.name = students.get(i).get(1);
                this.gender = students.get(i).get(2);
                this.age = Integer.parseInt(students.get(i).get(3));
                this.residence = students.get(i).get(4);
            }
        }
    }
    
    
    public String getStudentID() {
        return studentID;
    }

    public void setStudentID(String studentID) {
        this.studentID = studentID;
        
    }
    
    public String getGender() {
        return gender;
    }

    
    public void setGender(String gender) {
        this.gender = gender;
    }

   
   
    // get all the names of the students
    public ArrayList<String> viewStudentsName(){
        ArrayList<String> students = new ArrayList<>();
        ArrayList<ArrayList<String>> lst = file.readFile("student.txt");
        for (int i=0; i<lst.size(); i++){
            students.add(lst.get(i).get(1));
        }
        return students;
    }
    
    //update student living status in or off campus
    public void updateSudentStatus(){
        try{
        ArrayList<ArrayList<String>> lst = file.readFile("student.txt");
        for (int i = 0; i<lst.size(); i++){
            if (this.studentID.equals(lst.get(i).get(0))){
                if (lst.get(i).get(4).equals("Not Living in Hostel")){
                    lst.get(i).set(4,"hostel");
                }
                else
                    lst.get(i).set(4,"Not Living in Hostel");
            }
        }
        file.writeData("student.txt", lst);
        
        }
        catch(Exception e){
        
        }
        
    }
    
    public ArrayList<String> getStudentProfile(){
        ArrayList<String> profile = new ArrayList();
        
        for (int i=0; i<data.size(); i++){
            if (data.get(i).get(0).equals(studentID)){
                profile = data.get(i); 
            }
        }
        return profile;
    }
    
   
}
