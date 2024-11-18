/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Business;

//import model.Business.Business;
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
        UserAccount adminAccount = uad.newUserAccount(employeeprofile001, "Admin", "Admin");
        // Salesperson username and password
        UserAccount salesaccount1 = uad.newUserAccount(salesPersonProfile001, "001", "001");
        UserAccount salesaccount2 = uad.newUserAccount(salesPersonProfile002, "002", "002");
        UserAccount salesaccount3 = uad.newUserAccount(salesPersonProfile003, "003", "003");
        UserAccount salesaccount4 = uad.newUserAccount(salesPersonProfile004, "004", "004");
        UserAccount salesaccount5 = uad.newUserAccount(salesPersonProfile005, "005", "005");
          
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
        //Person customer011 = persondirectory.newPerson("RedHat");
    
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
        //CustomerProfile customerprofile11 = customedirectory.newCustomerProfile(customer011);

        // making new products for each supplier   
        Random random = new Random();
        for (Supplier s: sd.getSuplierList()){
            ProductCatalog productcatalog = s.getProductcatalog();
            for (int i=1; i<11; i++){
                int fp = random.nextInt(501) + 500;  // Floor price values from 500 to 1000
                int cp = random.nextInt(2001) + 2000;   // Ceiling price values from 2000 to 4000
                int tp = (fp + cp)/2;
                Product product = productcatalog.newProduct(s.getName()+i, fp, cp, tp);
                //System.out.println(product.getName());
            
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
        
//          SupplierDirectory supplierdirectory = business.getSupplierDirectory();
//
//          //Supplier supplier1 = supplierdirectory.newSupplier("Lenovo");
//          ProductCatalog productcatalog = supplier1.getProductCatalog();
//          Product products1p1 = productcatalog.newProduct("Scanner 3  1", 2000, 16500, 10000);
//          Product products1p2 = productcatalog.newProduct("Scanner 4", 10000, 25000, 16500);
//          Product products1p3 = productcatalog.newProduct("Printer 2", 22000, 40000, 36500);        
//          Product products1p4 = productcatalog.newProduct("Photocopier 2 ", 30000, 70000, 50000);
//          Product products1p5 = productcatalog.newProduct("Scanner  5", 19000, 36500, 25000);
//          Product products1p6 = productcatalog.newProduct("Scanner 6", 90000, 125000, 105000);
//          Product products1p7 = productcatalog.newProduct("Printer 3", 22000, 60000, 36500);
//          Product products1p8 = productcatalog.newProduct("Photocopier 3", 30000, 70000, 50000);
//           
//          //SupplierDirectory suplierdirectory = business.getSupplierDirectory();
//           Supplier supplier2 = supplierdirectory.newSupplier("Epson");
//          productcatalog = supplier2.getProductCatalog();
//          Product products2p1 = productcatalog.newProduct("Scanner 13  1", 12000, 26000, 18500);
//          Product products2p2 = productcatalog.newProduct("Scanner 14", 90000, 165000, 125000);
//          Product products2p3 = productcatalog.newProduct("Color Printer 112", 422000, 540000, 495000);
//          Product products2p4 = productcatalog.newProduct("Photocopier 922 ", 430000, 890000, 550000);
//          Product products2p5 = productcatalog.newProduct("Low toner Scanner  102", 195000, 500100, 365102);
//          Product products2p6 = productcatalog.newProduct("Speedy color Scanner 611", 900000, 125000, 1650000);
//          Product products2p7 = productcatalog.newProduct("Premier Printer 300", 322000, 470000, 736500);
//          Product products2p8 = productcatalog.newProduct("Color Photocopier 500", 350000, 580000, 780000);

   
          // Process Orders on behalf of sales person and customer
//        MasterOrderList masterorderlist = business.getMasterOrderList();
//        Order order1 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
//        OrderItem oi1 = order1.newOrderItem(products1p1, 18000, 1);
//        OrderItem oi2 = order1.newOrderItem(products1p2, 19500, 4);
//        OrderItem oi3 = order1.newOrderItem(products1p3, 36500, 10);
//        OrderItem oi4 = order1.newOrderItem(products1p4, 50000, 1);
//        OrderItem oi5 = order1.newOrderItem(products1p5, 25000, 3);
//        OrderItem oi6 = order1.newOrderItem(products1p6, 105000, 2);
//        OrderItem oi7 = order1.newOrderItem(products1p7, 36500, 3);
//        OrderItem oi8 = order1.newOrderItem(products1p8, 50000, 2);
//
//        Order order12 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
//        OrderItem oi112 = order12.newOrderItem(products1p1, 17000, 1);
//        OrderItem oi12 = order12.newOrderItem(products1p2, 9500, 4);
//        OrderItem oi13 = order12.newOrderItem(products1p3, 29500, 10);
//        OrderItem oi14 = order12.newOrderItem(products1p4, 30000, 1);
//        OrderItem oi15 = order12.newOrderItem(products1p5, 2000, 3);
//        OrderItem oi16 = order12.newOrderItem(products1p6, 95000, 2);
//        OrderItem oi17 = order12.newOrderItem(products1p7, 26500, 3);
//        OrderItem oi18 = order12.newOrderItem(products1p8, 40000, 2);
//
//        Order order13 = masterorderlist.newOrder(customerprofile4, salespersonprofile);
//        oi112 = order13.newOrderItem(products1p1, 19000, 1);
//        oi12 = order13.newOrderItem(products1p2, 10500, 4);
//        oi13 = order13.newOrderItem(products1p3, 20500, 10);
//        oi14 = order13.newOrderItem(products1p4, 40000, 1);
//        oi15 = order13.newOrderItem(products1p5, 4000, 3);
//        oi16 = order13.newOrderItem(products1p6, 105000, 2);
//        oi17 = order13.newOrderItem(products1p7, 36500, 3);
//        oi18 = order13.newOrderItem(products1p8, 550000, 1);
//
//        ProductSummary ps = new ProductSummary(products1p8);
//        
//         System.out.println("Stats==========================");
//        System.out.println("Sales Volume:  " + ps.getSalesRevenues());
//        System.out.println("Profit Margin:  " + ps.getProductPricePerformance());
//        System.out.println("Frequency above target:  " + ps.getNumberAboveTarget());
//        System.out.println("Frequency Below:  " + ps.getNumberBelowTarget());
          
          
          return business;
  }
  
  public static SalesPersonProfile getRandomSalesman(SalesPersonDirectory sd){
      Random random = new Random();
      int index = random.nextInt(sd.getSalespersonlist().size());
      return sd.getSalespersonlist().get(index);
  }
  
}
