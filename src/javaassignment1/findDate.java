package javaassignment1;

import java.util.Date;
import java.text.DateFormat;  
import java.text.SimpleDateFormat;  

public class findDate {
    long millis = System.currentTimeMillis();
    Date date = new java.util.Date(millis);
    DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");
    String strDate = dateFormat.format(date);

    public String getDateTime(){
        return strDate;
    }
    
    public String dateToStr(Date date){
        dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        strDate = dateFormat.format(date);
        
        return strDate;
    }
}


