package ps2;
import java.lang.Math;
public class Account {
    String owner;
    long AccNumber;
    double Balance;
    private static int NumAcc=0;
    private static int NumDep=0;
    private static int NumWith=0;
    private static int TotalWith=0;
    private static int TotalDep=0;
    Account (double initBal, String owner, long number){
        this.owner = owner;
        this.AccNumber = number;
        this.Balance = initBal;
        NumAcc+=1;
    }
    Account (double initBal, String owner){
        this.Balance = initBal;
        this.owner = owner;
        this.AccNumber = (long) (Math.random()*Math.pow(10,10));
        NumAcc+=1;
    }
    Account (String owner){
        this.owner = owner;
        this.Balance = 0;
        this.AccNumber = (long) (Math.random()*Math.pow(10,10));
        NumAcc+=1;
    }
    double getBalance(){
        return this.Balance;
    }
    
    static int getNumAcc(){
        return NumAcc;
    }
    static int getNumDep(){
        return NumDep;
    }
    static int getNumWith(){
        return NumWith;
    }
    static int getTotalWith(){
        return TotalWith;
    }
    static int getTotalDep(){
        return TotalDep;
    }
    void deposit(double balance){
        this.Balance+=balance;
        NumDep+=1;
        TotalDep+=balance;
    }
    void withdraw(double amount){
        if((Balance-amount)>=0)
            Balance-=amount;
        else{
            System.out.println("Insufficient Balance");
        }
        NumWith+=1;
        TotalWith+=amount;
    }
    void Close(){
        this.owner = this.owner + "CLOSED";
        this.Balance = 0;
        NumAcc-=1;
    }

}
