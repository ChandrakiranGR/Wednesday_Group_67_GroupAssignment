package model.Personnel;

/**
 * Person class - Updated to include full name functionality
 */
public class Person {

    private String id;
    private String firstName; // New field for first name
    private String lastName;  // New field for last name

    // Updated constructor to include first and last name
    public Person(String id, String firstName, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
    }

    // Getter for Person ID
    public String getPersonId() {
        return id;
    }

    // Getter for first name
    public String getFirstName() {
        return firstName;
    }

    // Setter for first name
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    // Getter for last name
    public String getLastName() {
        return lastName;
    }

    // Setter for last name
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    // Method to return full name
    public String getFullName() {
        return firstName + " " + lastName;
    }

    // Check if person ID matches
    public boolean isMatch(String id) {
        return getPersonId().equals(id);
    }

    @Override
    public String toString() {
        return "Person ID: " + getPersonId() + ", Name: " + getFullName();
    }
}
