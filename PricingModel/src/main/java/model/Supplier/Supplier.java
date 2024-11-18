/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model.Supplier;

import java.util.ArrayList;

import model.ProductManagement.ProductCatalog;
import model.ProductManagement.ProductSummary;
import model.ProductManagement.ProductsReport;

/**
 *
 * @author kal bugrara
 */
public class Supplier {
    String name;
    ProductCatalog productcatalog;
    ProductsReport productsreport;
    public Supplier(String n){
        name = n;
        productcatalog = new ProductCatalog("software");
        
    }

    Supplier() {
        
    }

    
    public ProductsReport prepareProductsReport(){
        
        productsreport = productcatalog.generatProductPerformanceReport();
        return productsreport;
    }
    
    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget(){
       
        if(productsreport==null) productsreport = prepareProductsReport();
       return productsreport.getProductsAlwaysAboveTarget();
       
    }
    
    public String getName(){
        return name;
    }

    
   
    public void setName(String name) {
        this.name = name;
    }
       

    public ProductCatalog getProductcatalog() {
        return productcatalog;
    }

    
    public void setProductcatalog(ProductCatalog productcatalog) {
        this.productcatalog = productcatalog;
    }

        @Override
   public String toString(){
       return name;
       
   }
}
