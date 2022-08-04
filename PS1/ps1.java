
package ps1;

import java.util.*;
import java.lang.*;
public class PS1 {
    
    public static void main(String[] args) {
        q6();
    }
    
    public static void q2(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter a letter grade: ");
        String grade = obj.nextLine();
        Map <Character,Double> mp = new HashMap<Character,Double>(){
            {
                put('A',4.0);
                put('B',3.0);
                put('C',2.0);
                put('D',1.0);
                put('F',0.0);
            }
        };
        char []arr = grade.toCharArray();
        double res = mp.get(arr[0]);
        if(arr.length > 1){
            switch(arr[2]){
                case '+':
                    res+=0.3;
                    break;
                case '-':
                    res-=0.3;
                    break;
            }
        }
        System.out.println(res);  
    }
    
    public static void q3(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the card notation: ");
        String card = obj.nextLine();
        Map <Character,String> mp = new HashMap<Character,String>(){
            {
                put('A',"Ace");
                put('Q',"Queen");
                put('K',"King");
                put('D',"Diamonds");
                put('S',"Spades");
                put('C',"Clubs");
                put('J',"Jack");         
            }
        };
        char []arr = card.toCharArray();
        Boolean flag = Character.isDigit(arr[0]);
        if(flag){
            System.out.println(arr[0] + " of "+ mp.get(arr[1]));
        }
        else{
            System.out.println(mp.get(arr[0])+" of "+mp.get(arr[1]));
        }
    }
    
    public static void q4(){
        
        Scanner obj2 = new Scanner(System.in);
        System.out.println("The number of gallons of gas in the tank: ");
        double fuelLeft = obj2.nextDouble();
        System.out.println("The fuel efficiency in miles per gallon: ");
        double fuelEff = obj2.nextDouble();
        System.out.println("The price of gas per gallon: ");
        double price = obj2.nextDouble();
        double maxDist = fuelLeft * fuelEff; 
        System.out.println("The car can go for: " + maxDist);
        System.out.println("Cost per miles: " + (100/fuelEff)*price); 
    }
    
    
    
    
    public static void q7(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the month: ");
        int month = obj.nextInt();
        System.out.println("Enter the day: ");
        int day = obj.nextInt();
        System.out.println("Enter the year: ");
        int year = obj.nextInt();
        boolean flag = true;
        boolean leap = false;
        if (year % 4 == 0) { 
           if (year % 100 == 0) {
              if (year % 400 == 0)
                leap = true;
              else
                leap = false;
            }
        else
        leap = true;
       }
        else{
          leap = false;
        }
        if(month==1 || month==3 || month==5 || month==7 || month==8 || month==10 || month==12)
           if(day>31)
               flag=false;
        else if(month==4 || month==6 || month==9 || month==11)
            if(day>30)
                flag=false;
        else if(leap){
            if(day>29)
                flag=false;
        }
        else{
            if(day>28)
                flag=false;
        }
        
        if(flag)
          System.out.println("Valid Date!");
        else
          System.out.println("Invalid Date!");

    }
    
    public static void q8(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the character: ");
        char ch =obj.next().charAt(0); 
        int ascii = ch;
        System.out.println("The ASCII value of " + ch + " is: " + ascii);
    }
    
    public static void q9(){
         int[][] arr = { { 1, 2,3,4,5 }, {2, 3, 4 ,5,6} };
         System.out.println("A\tB\tPow(A,B)");
         for(int i=0;i<5;i++){
             System.out.println(arr[0][i]+ "\t"+arr[1][i] + "\t" +Math.pow(arr[0][i],arr[1][i]));
         }    
    }
    
    public static void q10(){
        int[][] arr = new int[5][4];
        for(int i=0;i<4;i++){
            for(int j=0;j<4;j++){
                Scanner obj = new Scanner(System.in);
                System.out.println("Enter the element:" + i + j);
                int ele = obj.nextInt();
                arr[i][j]=ele;
            }
        }
        for(int i=0;i<4;i++){
            int sum=0;
            for(int j=0;j<4;j++){
                sum+=arr[j][i];
            }
            arr[4][i]=sum;
        }
        for(int i=0;i<5;i++){
            for(int j=0;j<4;j++){
                System.out.print(arr[i][j]+ " ");
            }
            System.out.println("");
        }
    }
    private static boolean checkPrime(int num){
         boolean flag = false;
         for (int i = 2; i <= num / 2; ++i) {
            if (num % i == 0) {
                 flag = true;
                 break;
            }
        }
        return flag;
    }
    public static void q11(){
        Scanner obj = new Scanner(System.in);
        System.out.println("Enter the left limit: ");
        int a = obj.nextInt();
        System.out.println("Enter the right limit: ");
        int b = obj.nextInt();
        for(int i=a;i<=b;i++)
        {
            if(!checkPrime(i))
                System.out.println(i+ " ");
        }
    }
    
    public static void q12(){
        String[] names = {"Elena", "Thomas", "Hamilton", "Suzie" , "Phil" , "Matt"};
        int[] arr = {341,273,278,329,445,402};
        int max = -10000;
        int index = 0;
        int max2 = -10000;
        int index2 = 0;
        for(int i=0;i<arr.length;i++){
            if(arr[i]>max)
            {
                max2=max;
                index2=index;
                max = arr[i];
                index = i;
            }
            else if(arr[i]>max2){
                max2 = arr[i];
                index2 = i;
            }
        }
        System.out.println("The fastest is: "+names[index]);
        System.out.println("The second fastest is: "+names[index2]);
    }
    
    public static void q6(){
       String s;
       while(true){
       Scanner obj = new Scanner(System.in);
       System.out.println("Enter the character: ");
       s =obj.nextLine();  
       boolean isNumeric = s.chars().allMatch( Character::isDigit );
       if(isNumeric)
           break;
    }
       String intValue = s.replaceAll("[^0-9]", "");
       int i = Integer.parseInt(intValue);
       System.out.println("After parsing the integer is: "+i);
       char b = (char) (i+'0'); //unicode is not printable thus we are converting it 
       System.out.println("Unicode: "+b); 
    }
};
         
       
