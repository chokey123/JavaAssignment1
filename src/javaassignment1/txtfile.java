/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package javaassignment1;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;  // Import the File class
import java.io.IOException; 
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
/**
 *
 * @author User
 */
public class txtfile {
    public void writeFile(String filename, ArrayList<String> lst){
         try {
      File theFile = new File("./src/javaassignment1/Data/"+filename);
      //System.out.println(String.valueOf(theFile.length()));

      FileWriter writer = new FileWriter(theFile,true);
      BufferedWriter bw = new BufferedWriter(writer);
      if (theFile.length() != 0){
          bw.write("\n");
      }
      for(int i=0; i<lst.size(); i++){
          bw.write(lst.get( i) + ",");
      }
      bw.close();
      
      //System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      //System.out.println("An error occurred.");
      e.printStackTrace();
    }
    }
    
    //write every data into the txt file
    public void writeData(String filename, ArrayList<ArrayList<String>> lst){
         try {
      File theFile = new File("./src/javaassignment1/Data/"+filename);
      FileWriter writer = new FileWriter(theFile); //{0-9 which is total 10}
      BufferedWriter bw = new BufferedWriter(writer);
      if (theFile.length() != 0){
          bw.write("\n");
      }
      for (int i =0; i<lst.size(); i++){
          for (int j=0; j<lst.get(i).size(); j++){
              bw.write(lst.get(i).get(j)+",");
          }
          if(i < lst.size()-1){
              bw.write("\n");
          }
      }
      bw.close();
      System.out.println("Successfully wrote to the file.");
    } catch (IOException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    }        
    }
    
    public ArrayList<ArrayList<String>> readFile(String filename){
        ArrayList<String> innerList = new ArrayList<>();
        ArrayList<ArrayList<String>> list = new  ArrayList();
        ArrayList rList;
        
        try {
          File file = new File("./src/javaassignment1/Data/"+filename);
          Scanner reader = new Scanner(file);
          while (reader.hasNextLine()){
              String data = reader.nextLine();
              String[] splitData = data.split(",");
              innerList.addAll(Arrays.asList(splitData));
              rList = (ArrayList)innerList.clone();
              list.add(rList);
              innerList.removeAll(innerList);
          }
          
        } catch (FileNotFoundException e){
            System.out.println("File not found");
            e.printStackTrace();
        }
        
        return list;
    }

}
