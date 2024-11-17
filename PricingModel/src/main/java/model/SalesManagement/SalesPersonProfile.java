package model.SalesManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;

/**
 * SalesPersonProfile class - Extended for sales feedback and analysis
 */
public class SalesPersonProfile extends Profile {
    ArrayList<Order> salesorders;


    public SalesPersonProfile(Person p) {

        super(p); 
        salesorders = new ArrayList();

    }
    public void addSalesOrder(Order o){
        salesorders.add(o);
    }
    @Override
    public String getRole(){
        return  "Sales";
    }

}