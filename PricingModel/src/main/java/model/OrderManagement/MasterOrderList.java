/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.OrderManagement;

import java.util.ArrayList;

import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonProfile;
import model.SalesManagement.SalesPersonProfile;

/**
 *
 * @author kal bugrara
 */
public class MasterOrderList {
    ArrayList<CurrentOrder> orders;
    MasterOrderReport masterorderreport;
    
    public MasterOrderList(){
        orders = new ArrayList();
       
    }
    
    public CurrentOrder newOrder(CustomerProfile cp){
        CurrentOrder o= new CurrentOrder(cp);
        orders.add(o);
        return o;
    }
    public CurrentOrder newOrder(CustomerProfile cp, SalesPersonProfile spp){
        CurrentOrder o= new CurrentOrder(cp, spp);
        orders.add(o);
        return o;
    }
    
    public CurrentOrder newOrder(CustomerProfile cp, SalesPersonProfile spp, CurrentOrder order){
        orders.add(order);
        return order;
    }
    
    public MasterOrderReport generateMasterOrderReport(){
    masterorderreport = new MasterOrderReport();
        
    return masterorderreport;
        
}

public int getSalesVolume(){

int sum = 0;
for(CurrentOrder order: orders){
    sum = sum + order.getOrderTotal();
}
return sum;
    }

}
