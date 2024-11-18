/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;


import java.util.Random;
import model.CustomerManagement.CustomerDirectory;
import model.CustomerManagement.CustomerProfile;
import model.MarketingManagement.MarketingPersonDirectory;
import model.MarketingManagement.MarketingPersonProfile;
import model.OrderManagement.MasterOrderList;
import model.OrderManagement.CurrentOrder;
import model.OrderManagement.OrderItem;
import model.Personnel.EmployeeDirectory;
import model.Personnel.EmployeeProfile;
import model.Personnel.Person;
import model.Personnel.PersonDirectory;
import model.Personnel.Profile;
import model.ProductManagement.Product;
import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.SalesManagement.SalesPersonDirectory;
import model.SalesManagement.SalesPersonProfile;
import model.Supplier.Supplier;
import model.Supplier.SupplierDirectory;
import model.UserAccountManagement.UserAccount;
import model.UserAccountManagement.UserAccountDirectory;

/**
 *
 * @author kal bugrara
 */
public class ConfigureABusiness {

  public static Business initialize() {
    Business business = new Business("Xerox");
    
    // Create Persons by initializing the person directory
        PersonDirectory persondirectory = business.getPersonDirectory();

    // Person representing sales organization        
        //Person xeroxmarketingperson001 = persondirectory.newPerson("Xerox marketing");
        
    // Creating admin of business
        Person xeroxadmin = persondirectory.newPerson("Admin");
    //Creating salesman for the business
        Person salesperson001 = persondirectory.newPerson("Salesman 1");
        Person salesperson002 = persondirectory.newPerson("Salesman 2");
        Person salesperson003 = persondirectory.newPerson("Salesman 3");
        Person salesperson004 = persondirectory.newPerson("Salesman 4");
        Person salesperson005 = persondirectory.newPerson("Salesman 5");
        
        // Adding the admin in the employee directory
        EmployeeDirectory employeedirectory = business.getEmployeeDirectory(); 
        EmployeeProfile employeeprofile001 = employeedirectory.newEmployeeProfile(xeroxadmin);
        
        // Adding the sales persons in the salesPerson Directory
        SalesPersonDirectory salesPersonDirectory = business.getSalesPersonDirectory();
        
        SalesPersonProfile salesPersonProfile001 = salesPersonDirectory.newSalesPersonProfile(salesperson001);
        SalesPersonProfile salesPersonProfile002 = salesPersonDirectory.newSalesPersonProfile(salesperson002);
        SalesPersonProfile salesPersonProfile003 = salesPersonDirectory.newSalesPersonProfile(salesperson003);
        SalesPersonProfile salesPersonProfile004 = salesPersonDirectory.newSalesPersonProfile(salesperson004);
        SalesPersonProfile salesPersonProfile005 = salesPersonDirectory.newSalesPersonProfile(salesperson005);
             
        // Creating Accounts for Admin and SalesPerson Profiles, so that they can login in the application
        UserAccountDirectory uad = business.getUserAccountDirectory();
        // Admin username and password
        UserAccount adminAccount = uad.newUserAccount(employeeprofile001, "Administrator", "admin@123");
        // Salesperson username and password
        UserAccount salesaccount1 = uad.newUserAccount(salesPersonProfile001, "Shivani", "shivani@123");
        UserAccount salesaccount2 = uad.newUserAccount(salesPersonProfile002, "Chandrakiran", "ck@123");
        UserAccount salesaccount3 = uad.newUserAccount(salesPersonProfile003, "Vishwesh", "vish@123");
        UserAccount salesaccount4 = uad.newUserAccount(salesPersonProfile004, "Deepak", "deepak@123");
        UserAccount salesaccount5 = uad.newUserAccount(salesPersonProfile005, "Sneha", "sneha@123");
          
     // Create person objects to represent supplier organizations. 
        Person supplier001 = persondirectory.newPerson("Xerox Scanner");
        Person supplier002 = persondirectory.newPerson("Xerox Printer");
        Person supplier003 = persondirectory.newPerson("Xerox Copier");
        Person supplier004 = persondirectory.newPerson("Xerox JumboPrinter");
        Person supplier005 = persondirectory.newPerson("Xerox UVPrinter"); 

    // Add Suppliers to the Supplier directory
        SupplierDirectory sd = business.getSupplierDirectory();
        
        Supplier supplier1 = sd.newSupplier(supplier001.getPersonId());
        Supplier supplier2 = sd.newSupplier(supplier002.getPersonId());
        Supplier supplier3 = sd.newSupplier(supplier003.getPersonId());
        Supplier supplier4 = sd.newSupplier(supplier004.getPersonId());
        Supplier supplier5 = sd.newSupplier(supplier005.getPersonId());
        
        
    // Create Customers
        Person customer001 = persondirectory.newPerson("Dell");
        Person customer002 = persondirectory.newPerson("Microsoft");
        Person customer003 = persondirectory.newPerson("Google");
        Person customer004 = persondirectory.newPerson("JP Morgan");
        Person customer005 = persondirectory.newPerson("Apple");
        Person customer006 = persondirectory.newPerson("IBM");
        Person customer007 = persondirectory.newPerson("Walmart");
        Person customer008 = persondirectory.newPerson("Meta");
        Person customer009 = persondirectory.newPerson("Oracle");
        Person customer010 = persondirectory.newPerson("VMWare");
    
        // creating customer profile
        CustomerDirectory customerdirectory = business.getCustomerDirectory();
        CustomerProfile customerprofile1 = customerdirectory.newCustomerProfile(customer001);
        CustomerProfile customerprofile2 = customerdirectory.newCustomerProfile(customer002);
        CustomerProfile customerprofile3 = customerdirectory.newCustomerProfile(customer003);
        CustomerProfile customerprofile4 = customerdirectory.newCustomerProfile(customer004);
        CustomerProfile customerprofile5 = customerdirectory.newCustomerProfile(customer005);
        CustomerProfile customerprofile6 = customerdirectory.newCustomerProfile(customer006);
        CustomerProfile customerprofile7 = customerdirectory.newCustomerProfile(customer007);
        CustomerProfile customerprofile8 = customerdirectory.newCustomerProfile(customer008);
        CustomerProfile customerprofile9 = customerdirectory.newCustomerProfile(customer009);
        CustomerProfile customerprofile10 = customerdirectory.newCustomerProfile(customer010);
        // making new products for each supplier   
        Random random = new Random();
        for (Supplier s: sd.getSuplierList()){
            ProductCatalog productcatalog = s.getProductcatalog();
            for (int i=1; i<11; i++){
                int fp = random.nextInt(501) + 500;  
                int cp = random.nextInt(2001) + 2000;   
                int tp = (fp + cp)/2;
                Product product = productcatalog.newProduct(s.getName()+i, fp, cp, tp);
                
            
            }
        }
        
        // creating orders for each customer 10 orders per product, 50 orders made by each customer
        MasterOrderList mol = business.getMasterOrderList();
        
        for (int j=0; j< sd.getSuplierList().size();j++){
            Supplier s = sd.getSuplierList().get(j);
            
            for(int k=0; k<s.getProductcatalog().getProductList().size();k++){
                Product p = s.getProductcatalog().getProductList().get(k);
                for(CustomerProfile cp:customerdirectory.getCustomerlist()){
                    CurrentOrder order = mol.newOrder(cp, getRandomSalesman(salesPersonDirectory));
                    int actualprice = random.nextInt(p.getCeilingPrice()-p.getFloorPrice()+1)+p.getFloorPrice();
                    OrderItem oi1=order.newOrderItem(p, actualprice, random.nextInt(91)+10);
                }
               
            }
        }
          
          return business;
  }
  
  public static SalesPersonProfile getRandomSalesman(SalesPersonDirectory sd){
      Random random = new Random();
      int index = random.nextInt(sd.getSalespersonlist().size());
      return sd.getSalespersonlist().get(index);
  }
  
}
