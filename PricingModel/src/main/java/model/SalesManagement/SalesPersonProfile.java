package model.SalesManagement;

import java.util.ArrayList;

import model.OrderManagement.Order;
import model.Personnel.Person;
import model.Personnel.Profile;

/**
 * SalesPersonProfile class - Extended for sales feedback and analysis
 */
public class SalesPersonProfile extends Profile {
    private ArrayList<Order> salesOrders;

    // New fields for sales feedback
    private int feedbackScore; // Aggregate score from feedback
    private String feedbackComments; // Detailed qualitative feedback

    public SalesPersonProfile(Person p) {
        super(p);
        salesOrders = new ArrayList<>();
        feedbackScore = 0; // Default feedback score
        feedbackComments = "No feedback available"; // Default feedback comments
    }

    public void addSalesOrder(Order o) {
        salesOrders.add(o);
    }

    @Override
    public String getRole() {
        return "Sales";
    }

    // ===== New Methods for Sales Feedback =====

    /**
     * Adjust price based on feedback score
     * @param basePrice Base price of the product
     * @return Adjusted price based on feedback impact
     */
    public double adjustPriceBasedOnFeedback(double basePrice) {
        return basePrice * (1 + (feedbackScore / 100.0)); // Adjust by feedback percentage
    }

    /**
     * Generate a feedback report for this salesperson
     * @return A detailed feedback report
     */
    public String generateSalesFeedbackReport() {
        return String.format("Salesperson: %s, Feedback Score: %d, Feedback Comments: %s",
                             this.getPerson().getFullName(), feedbackScore, feedbackComments);
    }

    // ===== Getters and Setters for Feedback =====

    public int getFeedbackScore() {
        return feedbackScore;
    }

    public void setFeedbackScore(int feedbackScore) {
        this.feedbackScore = feedbackScore;
    }

    public String getFeedbackComments() {
        return feedbackComments;
    }

    public void setFeedbackComments(String feedbackComments) {
        this.feedbackComments = feedbackComments;
    }

    // ===== Optional: Sales Summary =====

    /**
     * Generate a summary of sales performance
     * @return A detailed sales summary
     */
    public String generateSalesSummary() {
        int totalSales = salesOrders.size();
        int totalRevenue = salesOrders.stream().mapToInt(Order::getOrderTotal).sum();
        return String.format("Salesperson: %s, Total Sales: %d, Total Revenue: $%d",
                             this.getPerson().getFullName(), totalSales, totalRevenue);
    }
}
