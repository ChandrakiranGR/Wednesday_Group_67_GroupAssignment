package model.Personnel;

import java.util.ArrayList;

/**
 * PersonDirectory class - Updated to align with Person constructor
 */
public class PersonDirectory {

    private ArrayList<Person> personList;

    public PersonDirectory() {
        personList = new ArrayList<>();
    }

    // Updated method to create a new person
    public Person newPerson(String id, String firstName, String lastName) {
        Person p = new Person(id, firstName, lastName);
        personList.add(p);
        return p;
    }

    // Find a person by ID
    public Person findPerson(String id) {
        for (Person p : personList) {
            if (p.isMatch(id)) {
                return p;
            }
        }
        return null; // Not found after searching the entire list
    }

    // Getter for personList (optional)
    public ArrayList<Person> getPersonList() {
        return personList;
    }
}
