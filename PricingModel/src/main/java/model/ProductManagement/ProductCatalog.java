package model.ProductManagement;

import java.util.ArrayList;

/**
 * ProductCatalog class - Adjust Target Prices, Run Simulation, and Maximize Profit Margins
 */
public class ProductCatalog {

    String type;
    ArrayList<Product> products; // list of products

    public ProductCatalog(String n) {
        type = n;
        products = new ArrayList<>();
    }

    public ProductCatalog() {
        type = "unknown";
        products = new ArrayList<>();
    }

    public Product newProduct(int fp, int cp, int tp) {
        Product p = new Product(fp, cp, tp);
        products.add(p);
        return p;
    }

    public Product newProduct(String n, int fp, int cp, int tp) {
        Product p = new Product(n, fp, cp, tp);
        products.add(p);
        return p;
    }

    public ProductsReport generatProductPerformanceReport() {
        ProductsReport productsreport = new ProductsReport();

        for (Product p : products) {
            ProductSummary ps = new ProductSummary(p);
            productsreport.addProductSummary(ps);
        }
        return productsreport;
    }

    public ArrayList<Product> getProductList() {
        return products;
    }

    /**
     * Adjust target prices lower for products with sales below target.
     *
     * @param percentage Percentage to decrease the target price
     */
    public void adjustTargetPricesLower(double percentage) {
        for (Product product : products) {
            if (product.getNumberOfProductSalesBelowTarget() > 0) {
                product.decreaseTargetPrice(percentage);
                System.out.println("Target price lowered for product: " + product.getName());
            }
        }
    }

    /**
     * Adjust target prices higher for products with sales above target.
     *
     * @param percentage Percentage to increase the target price
     */
    public void adjustTargetPricesHigher(double percentage) {
        for (Product product : products) {
            if (product.getNumberOfProductSalesAboveTarget() > 0) {
                product.increaseTargetPrice(percentage);
                System.out.println("Target price increased for product: " + product.getName());
            }
        }
    }

    /**
     * Simulate the total revenue generated for all products.
     *
     * @return Total simulated revenue
     */
    public double simulateTotalRevenue() {
        double totalRevenue = 0.0;
        for (Product product : products) {
            totalRevenue += product.calculateRevenue();
        }
        return totalRevenue;
    }

    /**
     * Optimize profit margins by iteratively adjusting target prices
     * and running revenue simulations.
     *
     * @param percentage Percentage to adjust the target price
     * @param threshold Minimum revenue increase threshold to stop optimization
     */
    public void optimizeProfitMargins(double percentage, double threshold) {
        double previousRevenue = 0.0;
        double currentRevenue = simulateTotalRevenue();

        System.out.println("Initial Revenue: $" + currentRevenue);

        while ((currentRevenue - previousRevenue) > threshold) {
            for (Product product : products) {
                // Adjust prices based on sales performance
                if (product.getNumberOfProductSalesBelowTarget() > 0) {
                    product.decreaseTargetPrice(percentage);
                } else if (product.getNumberOfProductSalesAboveTarget() > 0) {
                    product.increaseTargetPrice(percentage);
                }
            }

            previousRevenue = currentRevenue;
            currentRevenue = simulateTotalRevenue();
            System.out.println("Adjusted Revenue: $" + currentRevenue);
        }

        System.out.println("Optimization Complete. Final Revenue: $" + currentRevenue);
    }
}