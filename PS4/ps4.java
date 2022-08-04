//BY 20PT29 - SANDEEP KHANNA V P
package ps4;

import java.util.Date; 

abstract class Books{
    final String title;
    final int dayTaken;
    Books(String title,int dayTaken){
        this.title = title;
        this.dayTaken = dayTaken;
    }
   int daysOverDue(){
        Date date1 = new Date(122, 7, 1);
        Date date2 = new Date();
        int overdue_date = (int)((date2.getTime() - date1.getTime()) / 86400000);
//        int overdue_date = 14+dayTaken;
//        Date date = Calendar.getInstance().getTime();  
//        DateFormat dateFormat = new SimpleDateFormat("dd");  
//        String strDate = dateFormat.format(date); 
//        int today =Integer.parseInt(strDate);
        return overdue_date;

}
    abstract boolean isOverDue();
    
    abstract int computeFine();
}

class RegularBook extends Books{
    String author;
    RegularBook(String title, int dayTaken , String author){
        super(title,dayTaken);
        this.author = author;
    }
    
     boolean isOverDue(){
        if(this.daysOverDue()>14)
            return true;
        else
            return false;
    }
     
    @Override
    int computeFine(){
        int PerDay = 1;
        if(this.isOverDue()){
            return (this.daysOverDue()-14 * PerDay);
        }
        return 0;
    }
}

class RefBook extends Books{
    RefBook(String title, int dayTaken){
        super(title,dayTaken);
    }
    
    @Override
    boolean isOverDue(){
        if(this.daysOverDue()>2)
            return true;
        else
            return false;
    }
    @Override
    int computeFine(){
        int PerDay = 1;
        if(this.isOverDue()){
            return (this.daysOverDue()-14 * PerDay);
        }
        return 0;
    }
}

class AudioBook extends Books{
    String author;
    AudioBook(String title, int dayTaken , String author){
        super(title,dayTaken);
        this.author = author;
    }
    @Override
    boolean isOverDue(){
        if(this.daysOverDue()>14)
            return true;
        else
            return false;
    }
    @Override
    int computeFine(){
        int PerDay = 2;
        if(this.isOverDue()){
            return (this.daysOverDue()-14 * PerDay);
        }
        return 0;
    }
}

public class PS4 {

    public static void main(String[] args) {
       RegularBook b = new RegularBook("xyz" , 17 , "jai");
       System.out.println("The number of days over due : "+b.daysOverDue());
       System.out.println("The fine is : "+b.computeFine());
    }
    
}
