package ps2;
public class TestAccount {
    public static void main(String[] args){
        Account t1 = new Account("Sandeep");
        System.out.println(t1.AccNumber);
        t1.deposit(1000);
        t1.withdraw(500);
        System.out.println(t1.Balance);
        Account t2 = new Account(500 ,"Agilan");
        System.out.println(t2.AccNumber);
        System.out.println(t2.getNumAcc());
    }
}
