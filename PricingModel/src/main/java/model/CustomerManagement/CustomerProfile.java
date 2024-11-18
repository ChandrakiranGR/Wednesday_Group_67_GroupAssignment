/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.CustomerManagement;

import java.util.ArrayList;

import model.MarketModel.Market;
import model.OrderManagement.CurrentOrder;
import model.Personnel.Person;

/**
 *
 * @author kal bugrara
 */
public class CustomerProfile {
    ArrayList<CurrentOrder> orders;
    ArrayList<Market> markets;
    
    Person person;

    public CustomerProfile(Person person) {

        person = person;
        orders = new ArrayList();

    }

           
    public int getTotalPricePerformance(){
        return 0;
    }
 
    public int    getNumberOfOrdersAboveTotalTarget(){ 
        int sum = 0;
        for(CurrentOrder o: orders){
            if(o.isOrderAboveTotalTarget()==true) sum = sum + 1;
        }
        
        return sum;}
    
    public int getNumberOfOrdersBelowTotalTarget() {
        return 0;
    }
      
        
    public boolean isMatch(String id) {
        if (person.getPersonId().equals(id)) {
            return true;
        }
        return false;
    }
    public void addCustomerOrder(CurrentOrder o){
        orders.add(o);
    }
    
    public String getCustomerId(){
        return person.getPersonId();
    }
            public Person getPerson(){
        return person;
    }

    @Override
    public String toString() {
        return person.getPersonId();
    }
        
        
    
}
