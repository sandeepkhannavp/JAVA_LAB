package ps3;

import java.util.List;

public class Order{
    int totalCost;
    List <OrderItem> lst;
    void addOrder(OrderItem o1){
        lst.add(o1);
    }
    int getTotal(){
        for(OrderItem oi : lst){
            totalCost+= oi.getCost();
        }
        return totalCost;
    }
    void printOrderItems(){
        for(OrderItem oi : lst){
            System.out.println("upc: "+oi.upc+" "+" quantity: "+oi.quantity+" price: "+oi.price);
        }
    }
}
