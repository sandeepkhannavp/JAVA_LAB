package ps3;

public class BankAccount {
    
    public static void main(String[] args){
        Account a=new Account(500);
        a.deposit(200);
        a.printBalance();
        SavingAccount sa=new SavingAccount(500);
        sa.withdraw(200);
        sa.printBalance();
        sa.applyMonthlyInterest();
        sa.printBalance();
        
    }
    
}
class Account{
    double balance;
    Account(double value){
        balance=value;
    }
    void deposit(double value){
        balance+=value;
    }
    void withdraw(double value){
        if (balance-value>0)
            balance-=value;
        else
            System.out.println("Insufficient funds");
    }
    void printBalance(){
        System.out.println(balance);
    }
}

class SavingAccount extends Account{
    static double defaultInterestRate=2.5;
    SavingAccount(double value){
        super(value);
    }
    static void setDefaultInterestRate(double rate){
        defaultInterestRate=rate;
    }
    void applyMonthlyInterest(){
        balance+=balance*defaultInterestRate/100;
    }
}
