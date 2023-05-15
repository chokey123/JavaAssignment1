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
public class User {
    private String username;
    private String password;
    private String role;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public User(){
        
    }
    
    public User(String username, String password) {
        this.username = username;
        this.password = password;
    }
    
    public void viewMenu(){
        GuestMenu window = new GuestMenu();
        window.setVisible(true);
    }
    
    public String Login(ArrayList<ArrayList<String>> lst, String un, String ps){
        String role = "";
        boolean findUsername;
        boolean findPassword;
        for(int i=0; i<lst.size(); i++){
            findUsername = lst.get(i).get(0).equals(un);
            findPassword = lst.get(i).get(1).equals(ps);
            if (findUsername && findPassword){
                    role = lst.get(i).get(2);
                }
        }
        return role;
    }
}
