/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ps3;

/**
 *
 * @author 20PT29
 */
public class OrderItem{
    String upc;
    int quantity;
    int price;
    int getCost(){
       return price; 
    }
    
    OrderItem(String upc, int quantity, int price){
        this.upc = upc;
        this.quantity = quantity;
        this.price = price;
    }
}
