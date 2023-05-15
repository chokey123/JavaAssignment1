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
public class Receipt extends Payment  {

    private String paidTime;
    
    public Receipt(String id, String studId) {
        super(id, studId);
        
    }
    
    public String getPaidTime() {
        return paidTime;
    }

    
    public void setPaidTime(String paidTime) {
        this.paidTime = paidTime;
    }
    
    
    public ArrayList<String> makeReceipt(){
        ArrayList<String> receipt = new ArrayList();
        for (int i=0;i<super.data.size();i++){
            if (super.data.get(i).get(0).equals(super.id)){
                receipt = data.get(i);
            }
        }
        return receipt;
    }
   
}
