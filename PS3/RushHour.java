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
public class RushOrder extends Order{
    protected int deliveryDay;
    RushOrder(int dd){
        this.deliveryDay=dd;
    }
    int getTotal(){
        int cost=super.getTotal();
        if (cost==0)
           return 0;
        if (deliveryDay==1)
            return cost+25;
        else if(deliveryDay==2)
            return cost+15;
        else if(deliveryDay==3)
            return cost+10;
        else if (deliveryDay>3)
            return cost;
        return cost;      
    }
    void printOrderedItems(){
        super.printOrderItems();
        System.out.println("delivery : " + getTotal());
        System.out.println("");
    }
}
