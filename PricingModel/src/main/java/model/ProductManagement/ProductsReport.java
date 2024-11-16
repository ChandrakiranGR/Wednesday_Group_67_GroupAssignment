package model.ProductManagement;

import java.util.ArrayList;

/**
 * ProductsReport class - Updated with enhanced functionality
 * Author: Your Name
 */
public class ProductsReport {

    ArrayList<ProductSummary> productSummaryList;

    public ProductsReport() {
        productSummaryList = new ArrayList<>();
    }

    public void addProductSummary(ProductSummary ps) {
        productSummaryList.add(ps);
    }

    public ProductSummary getTopProductAboveTarget() {
        ProductSummary currentTopProduct = null;

        for (ProductSummary ps : productSummaryList) {
            if (currentTopProduct == null) {
                currentTopProduct = ps; // Initial step
            } else if (ps.getNumberAboveTarget() > currentTopProduct.getNumberAboveTarget()) {
                currentTopProduct = ps; // We have a new higher total
            }
        }
        return currentTopProduct;
    }

    public ArrayList<ProductSummary> getProductsAlwaysAboveTarget() {
        ArrayList<ProductSummary> productsAlwaysAboveTarget = new ArrayList<>(); // Temp array list

        for (ProductSummary ps : productSummaryList) {
            if (ps.isProductAlwaysAboveTarget()) {
                productsAlwaysAboveTarget.add(ps);
            }
        }
        return productsAlwaysAboveTarget;
    }

    // ===== New Methods Added Below =====

    /**
     * Generate a comprehensive report displaying product performance
     */
    public void generateReport() {
        System.out.println("===== Product Performance Report =====");
        System.out.printf("%-20s %-10s %-15s %-15s %-15s %-15s%n",
                          "Product Name", "Revenue", "Above Target", "Below Target", "Price Perf.", "Always Above");
        for (ProductSummary ps : productSummaryList) {
            System.out.printf("%-20s %-10d %-15d %-15d %-15d %-15b%n",
                              ps.getSubjectProduct().getName(),
                              ps.getSalesRevenues(),
                              ps.getNumberAboveTarget(),
                              ps.getNumberBelowTarget(),
                              ps.getProductPricePerformance(),
                              ps.isProductAlwaysAboveTarget());
        }
        System.out.println("======================================");
    }

    /**
     * Browse through product summaries for detailed performance insights
     */
    public void browseProductPerformance() {
        System.out.println("===== Browsing Product Performance =====");
        for (ProductSummary ps : productSummaryList) {
            System.out.println(ps.generateProductSummaryReport());
        }
    }

    /**
     * Get the product with the highest price performance
     */
    public ProductSummary getBestPerformingProduct() {
        ProductSummary bestProduct = null;
        int highestPerformance = Integer.MIN_VALUE;

        for (ProductSummary ps : productSummaryList) {
            if (ps.getProductPricePerformance() > highestPerformance) {
                highestPerformance = ps.getProductPricePerformance();
                bestProduct = ps;
            }
        }
        return bestProduct;
    }

    /**
     * Get the product with the lowest price performance
     */
    public ProductSummary getWorstPerformingProduct() {
        ProductSummary worstProduct = null;
        int lowestPerformance = Integer.MAX_VALUE;

        for (ProductSummary ps : productSummaryList) {
            if (ps.getProductPricePerformance() < lowestPerformance) {
                lowestPerformance = ps.getProductPricePerformance();
                worstProduct = ps;
            }
        }
        return worstProduct;
    }

    /**
     * Clear all product summaries for a fresh report
     */
    public void clearReport() {
        productSummaryList.clear();
    }
}
