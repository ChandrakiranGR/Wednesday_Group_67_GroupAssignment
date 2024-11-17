package model.ProductManagement;

import java.util.ArrayList;
import model.OrderManagement.OrderItem;

/**
 * Updated Product Class
 * Author: kal bugrara
 */
public class Product {
    private String name;
    private int floorPrice;
    private int ceilingPrice;
    private int targetPrice;
    private ArrayList<OrderItem> orderItems;

    // Constructors
    public Product(int fp, int cp, int tp) {
        this.floorPrice = fp;
        this.ceilingPrice = cp;
        this.targetPrice = tp;
        this.orderItems = new ArrayList<>();
    }

    public Product(String n, int fp, int cp, int tp) {
        this.name = n;
        this.floorPrice = fp;
        this.ceilingPrice = cp;
        this.targetPrice = tp;
        this.orderItems = new ArrayList<>();
    }

    // Updates the product prices
    public Product updateProduct(int fp, int cp, int tp) {
        this.floorPrice = fp;
        this.ceilingPrice = cp;
        this.targetPrice = tp;
        return this; // Returns itself
    }

    // Getters and Setters
    public int getTargetPrice() {
        return targetPrice;
    }

    public void setTargetPrice(int targetPrice) {
        this.targetPrice = targetPrice;
    }

    public void setName(String n) {
        this.name = n;
    }

    public String getName() {
        return name;
    }

    public int getFloorPrice() {
        return floorPrice;
    }

    public int getCeilingPrice() {
        return ceilingPrice;
    }

    // Add OrderItem to Product
    public void addOrderItem(OrderItem oi) {
        this.orderItems.add(oi);
    }

    // Calculates the number of sales above the target price
    public int getNumberOfProductSalesAboveTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualAboveTarget()) {
                sum++;
            }
        }
        return sum;
    }

    // Calculates the number of sales below the target price
    public int getNumberOfProductSalesBelowTarget() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            if (oi.isActualBelowTarget()) {
                sum++;
            }
        }
        return sum;
    }

    // Checks if all sales are above the target price
    public boolean isProductAlwaysAboveTarget() {
        for (OrderItem oi : orderItems) {
            if (!oi.isActualAboveTarget()) {
                return false;
            }
        }
        return true;
    }

    // Calculates the total price performance
    public int getOrderPricePerformance() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum += oi.calculatePricePerformance(); // Positive and negative values
        }
        return sum;
    }

    // Calculates the total sales volume
    public int getSalesVolume() {
        int sum = 0;
        for (OrderItem oi : orderItems) {
            sum += oi.getOrderItemTotal();
        }
        return sum;
    }

    // Adjust the target price dynamically (helper for simulation)
    public void adjustTargetPrice(double percentage, boolean increase) {
        if (increase) {
            this.targetPrice += this.targetPrice * (percentage / 100.0);
        } else {
            this.targetPrice -= this.targetPrice * (percentage / 100.0);
        }
    }
    
    public void decreaseTargetPrice(double percentage) {
    // Reduce the target price by a percentage
    this.targetPrice -= this.targetPrice * (percentage / 100.0);

    // Ensure target price does not go below the floor price
    if (this.targetPrice < this.floorPrice) {
        this.targetPrice = this.floorPrice;
    }
}
    public void increaseTargetPrice(double percentage) {
    // Increase the target price by a percentage
    this.targetPrice += this.targetPrice * (percentage / 100.0);

    // Ensure target price does not exceed the ceiling price
    if (this.targetPrice > this.ceilingPrice) {
        this.targetPrice = this.ceilingPrice;
    }
}
    public double calculateRevenue() {
    return this.getSalesVolume() * this.getTargetPrice();
}




    @Override
    public String toString() {
        return name;
    }
}