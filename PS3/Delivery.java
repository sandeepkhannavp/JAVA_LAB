package ps3;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Delivery {
        public static void main(String[] args) {
        List<Order> orderArr=new ArrayList<Order>();
        OrderItem i1=new OrderItem("i12",2,40);
        Order o1=new Order();
        o1.addOrder(i1);
        RushOrder r1=new RushOrder(1);
        r1.addOrder(i1);
        RushOrder r2=new RushOrder(2);
        r2.addOrder(i1);
        RushOrder r3=new RushOrder(3);
        r3.addOrder(i1);
        orderArr.add(o1);
        orderArr.add(r1);
        orderArr.add(r2);
        orderArr.add(r3); 
        for (Order o:orderArr){
            o.printOrderItems();
        }
        while (true){
            System.out.println("Enter the price: ");
            Scanner sc=new Scanner(System.in);
            String upc=sc.next();
            System.out.println("Enter the quantity: ");
            int qty=sc.nextInt();
            if (upc=="done")
                break;
            int price = (int) ((Math.random() * (100 - 50)) + 50);
            int dd  = (int) ((Math.random() * (7 - 1)) + 1);
            OrderItem t1=new OrderItem(upc,qty,price);
            switch(dd){
                case 1: orderArr.get(1).addOrder(t1);
                        break;
                case 2: orderArr.get(2).addOrder(t1);
                        break;
                case 3: orderArr.get(3).addOrder(t1);
                        break;
                default :orderArr.get(0).addOrder(t1);
                        break;
            }
            
        }
        for(Order x : orderArr){
            System.out.println("Total Cost: " + x.getTotal());
        } 
    }
}
