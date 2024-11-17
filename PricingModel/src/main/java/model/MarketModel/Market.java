package model.MarketModel;

import java.util.ArrayList;
import model.ProductManagement.SolutionOffer;

/**
 * Market class - Extended for market trends and feedback
 */
public class Market {
    private ArrayList<SolutionOffer> solutionOffers;
    private ArrayList<MarketChannelAssignment> channels;
    private ArrayList<String> characteristics;
    private ArrayList<Market> submarkets;
    private int size;

    // New fields for market trend data
    private double demandFactor; // Multiplier to simulate demand impact
    private double priceCompetitiveness; // Competitive pricing scale (e.g., 0.0 to 1.0)
    private String customerPreference; // Qualitative feedback

    // Constructor
    public Market(String characteristic) {
        characteristics = new ArrayList<>();
        characteristics.add(characteristic);
        solutionOffers = new ArrayList<>();
        channels = new ArrayList<>();
        submarkets = new ArrayList<>();
        demandFactor = 1.0; // Default: no impact on price
        priceCompetitiveness = 1.0; // Default: no impact on price
        customerPreference = "Neutral"; // Default: neutral preference
    }

    // New methods for adjusting price based on market trends
    public double adjustPriceBasedOnDemand(double basePrice) {
        return basePrice * demandFactor;
    }

    public double adjustPriceForCompetitiveness(double basePrice) {
        return basePrice * priceCompetitiveness;
    }

    // New method for generating market trend report
    public String generateMarketReport() {
        return String.format("Demand Factor: %.2f, Competitiveness: %.2f, Customer Preference: %s",
                             demandFactor, priceCompetitiveness, customerPreference);
    }

    // Getters and Setters for new fields
    public double getDemandFactor() {
        return demandFactor;
    }

    public void setDemandFactor(double demandFactor) {
        this.demandFactor = demandFactor;
    }

    public double getPriceCompetitiveness() {
        return priceCompetitiveness;
    }

    public void setPriceCompetitiveness(double priceCompetitiveness) {
        this.priceCompetitiveness = priceCompetitiveness;
    }

    public String getCustomerPreference() {
        return customerPreference;
    }

    public void setCustomerPreference(String customerPreference) {
        this.customerPreference = customerPreference;
    }

    // Existing methods remain unchanged
    public ArrayList<SolutionOffer> getSolutionOffers() {
        return solutionOffers;
    }

    public ArrayList<MarketChannelAssignment> getChannels() {
        return channels;
    }

    public ArrayList<String> getCharacteristics() {
        return characteristics;
    }

    public ArrayList<Market> getSubmarkets() {
        return submarkets;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }
}
