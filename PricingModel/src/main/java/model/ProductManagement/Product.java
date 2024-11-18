/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.ProductManagement;

import java.util.ArrayList;
import java.util.HashMap;

import model.OrderManagement.OrderItem;

/**
 *
 * @author kal bugrara
 */
public class Product {
    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    ArrayList<OrderItem> orderitems;
    HashMap<Integer,ProductRep> productRep;

    public Product( int fp, int cp, int tp) {

        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderitems = new ArrayList();
        productRep = new HashMap<>();
    }
    public Product(String n, int fp, int cp, int tp) {
        name = n;
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        orderitems = new ArrayList();
        productRep = new HashMap<>();
        
    }
        public Product updateProduct(int fp, int cp, int tp) {
        floorPrice = fp;
        ceilingPrice = cp;
        targetPrice = tp;
        return this; //returns itself
    }

    public void setProductRep() {
        ProductRep productrep = new ProductRep();
        productrep.setAboveTargetNo(getNumberOfProductSalesAboveTarget());
        //System.out.println();
        productrep.setBelowTargetNo(getNumberOfProductSalesBelowTarget());
        productrep.setMargin(getOrderPricePerformance());
        
        productRep.put(targetPrice,productrep);
        //System.out.println(productRep.keySet());
    }

    public HashMap<Integer, ProductRep> getProductRep() {
        return productRep;
    }
    
    
    
    public int getTargetPrice() {return targetPrice;}
    public void addOrderItem(OrderItem oi){     
        orderitems.add(oi);
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }
    
    
    
    
    //Number of item sales above target 
    public int getNumberOfProductSalesAboveTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==true) sum = sum +1;
        }
        return sum;
    }
    public int getNumberOfProductSalesBelowTarget(){
        int sum = 0;
        for (OrderItem oi: orderitems){
            if(oi.isActualBelowTarget()==true) sum = sum +1;
        }
        return sum;
    }    
    
        public boolean isProductAlwaysAboveTarget(){
        
        for (OrderItem oi: orderitems){
            if(oi.isActualAboveTarget()==false) return false; //
        }
        return true;
    }
    //calculates the revenues gained or lost (in relation to the target)
    //For example, if target is at $2000 and actual is $2500 then revenue gained
    // is $500 above the expected target. If the actual is $1800 then the lose will be $200
    // Add all these difference to get the total including wins and loses
    
        public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.calculatePricePerformance();     //positive and negative values       
        }
        return sum;
    }
        public int getSalesVolume() {
        int sum = 0;
        for (OrderItem oi : orderitems) {
            sum = sum + oi.getOrderItemTotal();     //positive and negative values       
        }
        return sum;
    }
    public int getMean(){
        return getSalesVolume()/getQuantity();
    }
    
    public int totalActualPrice(){
      try{
          int count =0;
          int sum = 0;
            for (OrderItem oi : orderitems) {
                sum = sum + oi.getActualPrice();     //positive and negative values       
            }
            return sum==0?0:sum/orderitems.size();
      }
      catch(Exception e){
       e.printStackTrace();
      }
      return 0;
    }
    public void setName(String n){
        name = n;
    }
    public int getFloorPrice(){
        return floorPrice;
    }
    public int getCeilingPrice(){
        return ceilingPrice;
    }
  
    public String getName() {
        return name;
    }

    public int getQuantity(){
        int Qauntity =0;
        for (OrderItem oi : orderitems) {
            if(oi.getSelectedProduct().getName().equals(name)){
                Qauntity = Qauntity + oi.getQuantity();     //positive and negative values     
            }  
        }
        
        return Qauntity;
    }
    @Override
    public String toString() {
        return  name;
    }
    
    
}
