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
public class Payment extends ManageStudentData{
    protected String id;
    protected String studId;
    protected double amount;
    protected String DueDate;
    protected String status;
    protected String paymentType;
    private final txtfile txt = new txtfile();
    protected final ArrayList<ArrayList<String>> data = txt.readFile("payment.txt");
    
    public Payment(int i){
        
        this.id = data.get(i).get(0);
        this.studId = data.get(i).get(1);
        this.amount = Double.parseDouble(data.get(i).get(2));
        this.DueDate = data.get(i).get(3);
        this.status = data.get(i).get(4);
    }
    
    
    public Payment(String studId){
        this.studId = studId;
    }
    
    public Payment(String id, String studId){
        this.id = id;
        this.studId = studId;
    }

    public String getId() {
        return id;
    }

    public String getStudId() {
        return studId;
    }

    public double getAmount() {
        return amount;
    }

    public String getDueDate() {
        return DueDate;
    }

    public String getStatus() {
        return status;
    }
    
    public String getPaymentType() {
        return paymentType;
    }

    
    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }
 
    @Override
    public ArrayList<ArrayList<String>> getStudentData(){  
 
        ArrayList<ArrayList<String>> studentData = new ArrayList();
        for (int i=0;i<data.size();i++){
            if (data.get(i).get(1).equals(studId)){
                studentData.add(data.get(i));
            }
        }
        
        return studentData;
    } 
    
   
    
    public double getUnpaidFees(){
        double fees = 0;
        //ArrayList<ArrayList<String>> studentData = getStudentData();
        //System.out.println("ArrayList inside getUnpaidFees \n"+studentData);
        for(int i = 0; i < this.data.size(); i ++){
            if(this.studId.equals(this.data.get(i).get(1)) && this.data.get(i).get(4).equals("unpaid")){
                double fee =  Double.parseDouble(this.data.get(i).get(2));
                fees += fee;
            }
        }
        
        return fees;
    }
    
    public String makePayment(){
       String stat = "Error!!!"; 
        
       for (int i=0; i<data.size(); i++){
           if (data.get(i).get(0).equals(id)){
               findDate time = new findDate();
               String timeReceive = time.getDateTime();
               data.get(i).set(4, "paid");
               data.get(i).add(timeReceive);
               stat = "Payment Received.";
           }
       }
       
       txt.writeData("payment.txt",data);
       return stat;
    }

    @Override
    public ArrayList<String> viewID() {
        ArrayList<String> ID = new ArrayList<>();
        for (int i=0; i<data.size(); i++){
            ID.add(data.get(i).get(0));
        }
        return ID;
    }
   

    }

