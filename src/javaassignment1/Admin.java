/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment1;

/**
 *
 * @author User
 */
public class Admin extends User implements viewMenuable {
    @Override
    public void viewMenu(){
        AdminMenu window = new AdminMenu();
        window.setVisible(true);
    }
}
