package model.Personnel;

import java.util.ArrayList;

/**
 * Profile class - Updated to enhance compatibility and functionality
 */
public abstract class Profile {
    private Person person; // Updated to private for encapsulation

    // Constructor
    public Profile(Person p) {
        this.person = p;
    }

    // Abstract method to be implemented by subclasses
    public abstract String getRole();

    // Getter for Person
    public Person getPerson() {
        return person;
    }

    // Setter for Person (optional, for flexibility)
    public void setPerson(Person person) {
        this.person = person;
    }

    // Match by Person ID
    public boolean isMatch(String id) {
        return person.getPersonId().equals(id);
    }

    // Generate a profile summary
    public String generateProfileSummary() {
        return String.format("Profile Role: %s, Full Name: %s, ID: %s",
                             getRole(), person.getFullName(), person.getPersonId());
    }
}
