//BY 20PT29 - SANDEEP KHANNA V P
package ps4;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
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

abstract class PassengerTicket{
    int seatNo;
    boolean seatAvailable;
    String seatStatus, passengerName, passengerGender;
    String departure, destination, departureDateTime, issueDateTime;
    double totalPrice;
    
     PassengerTicket() {
        seatNo = 0;
        seatAvailable = true;
        seatStatus = null;
        passengerName = null;
        passengerGender = null;
        departure = null;
        destination = null;
        departureDateTime = "yyyy/mm/dd HH:mm:ss";
        issueDateTime = "yyyy/mm/dd HH:mm:ss";
        totalPrice = 0;
    }
    
     PassengerTicket(int sNo, boolean sA, String sStatus, String pName, String pGender, String dep, String des, String depTime, String iTime, double price) {
        seatNo = sNo;
        seatAvailable = sA;
        seatStatus = sStatus;
        passengerName = pName;
        passengerGender = pGender;
        departure = dep;
        destination = des;
        departureDateTime = depTime;
        issueDateTime = iTime;
        totalPrice = price;
    }
     
    abstract void setTotalPrice();

    @Override
    public String toString() {
        return "seatNo : " + seatNo + "\nseatAvailable : " + seatAvailable + "\nseatStatus : " + seatStatus + "\npassengerName : " + passengerName + "\ndeparture : " + departure + "\ndepartureTime : " + departureDateTime + "\nissueDateTime : " + issueDateTime + "\ntotalPrice : " + totalPrice;
    }

    public int getSeatNo() {
        return seatNo;
    }

    public void setSeatNo(int x) {
        seatNo = x;
    }

    public boolean getSeatAvailable() {
        return seatAvailable;
    }

    public void setSeatAvailable(boolean x) {
        seatAvailable = x;
    }

    public String getSeatStatus() {
        return seatStatus;
    }

    public void setSeatStatus(String x) {
        seatStatus = x;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public void setPassengerName(String x) {
        passengerName = x;
    }

    public String getPassengerGender() {
        return passengerGender;
    }

    public void setPassengerGender(String x) {
        passengerGender = x;
    }

    public String getDeparture() {
        return departure;
    }

    public void setDeparture(String x) {
        departure = x;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String x) {
        destination = x;
    }

    public String getDepartureDateTime() {
        return departureDateTime;
    }

    public void setDepartureDateTime(String x) {
        departureDateTime = x;
    }

    public String getIssueDateTime() {
        return issueDateTime;
    }

    public void setIssueDateTime(String x) {
        issueDateTime = x;
    }

    public double getTotalPrice() {
        return totalPrice;
    }
    
}

class BusTicket extends PassengerTicket {

    int distance;
    double serviceCharge;

    BusTicket() {
        distance = 250;
        serviceCharge = 2.5;
    }

    BusTicket(int d, double s) {
        distance = d;
        serviceCharge = s;
    }

    @Override
    void setTotalPrice() {
        totalPrice = distance * 0.08 + serviceCharge;
    }
}

interface TicketOperations {

    public boolean makeReservation(BusTicket ticket, String name, String gender);

    public boolean cancelReservation(BusTicket ticket);

    public boolean buyTicket(BusTicket ticket, String name, String gender);

    public boolean cancelTicketSold(BusTicket ticket);
}

class Officer implements TicketOperations {

    String name, address;

    Officer() {
        name = "unknown";
        address = "unknown";
    }

    Officer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    String getName() {
        return name;
    }

    void setName(String s) {
        name = s;
    }

    String getAddress() {
        return address;
    }

    void setAddress(String s) {
        address = s;
    }


    @Override
    public boolean buyTicket(BusTicket ticket, String name, String gender) {
        ticket.setPassengerName(name);
        ticket.setPassengerGender(gender);
        ticket.setSeatAvailable(false);
        ticket.setSeatStatus("SOLD");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setIssueDateTime(now.toString());
        return true;
    }
    
    @Override
    public boolean makeReservation(BusTicket ticket, String name, String gender) {
        ticket.setPassengerName(name);
        ticket.setPassengerGender(gender);
        ticket.setSeatAvailable(false);
        ticket.setSeatStatus("Reserved");
        DateTimeFormatter dtf = DateTimeFormatter.ofPattern("yyyy/MM/dd HH:mm:ss");
        LocalDateTime now = LocalDateTime.now();
        ticket.setIssueDateTime(now.toString());
        return true;
    }
    
    @Override
    public boolean cancelReservation(BusTicket ticket){
        ticket.setPassengerName("");
        ticket.setPassengerGender("");
        ticket.setSeatAvailable(true);
        ticket.setSeatStatus("AVAILABLE");
        ticket.setIssueDateTime("yyyy/MM/dd HH:mm:ss");
        return true;
    }
    @Override
    public boolean cancelTicketSold(BusTicket ticket){
        ticket.setPassengerName("");
        ticket.setPassengerGender("");
        ticket.setSeatAvailable(true);
        ticket.setSeatStatus("AVAILABLE");
        ticket.setIssueDateTime("yyyy/MM/dd HH:mm:ss");
        return true;
    }
    

}

public class PS4 {

    public static void main(String[] args) {
       RegularBook b = new RegularBook("xyz" , 17 , "jai");
       System.out.println("The number of days over due : "+b.daysOverDue());
       System.out.println("The fine is : "+b.computeFine());
    }
    
    
}
