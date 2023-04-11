import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.regex.Pattern;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    // Constructor
    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    // Getters and Setters
    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    // toString method for displaying contact details
    @Override
    public String toString() {
        return "Name: " + name + ", Phone Number: " + phoneNumber + ", Email: " + email;
    }
}

public class ContactManagementSystem {
    private Map<String, Contact> contacts; // Store contacts using HashMap

    // Constructor
    public ContactManagementSystem() {
        contacts = new HashMap<>();
    }

    // Add a new contact
    public void addContact(String name, String phoneNumber, String email) {
        Contact contact = new Contact(name, phoneNumber, email);
        contacts.put(name, contact);
        System.out.println("Contact added successfully: " + contact);
    }

    // Edit an existing contact
    public void editContact(String name, String newPhoneNumber, String newEmail) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            contact.setPhoneNumber(newPhoneNumber);
            contact.setEmail(newEmail);
            System.out.println("Contact updated successfully: " + contact);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Delete a contact
    public void deleteContact(String name) {
        if (contacts.containsKey(name)) {
            Contact contact = contacts.get(name);
            contacts.remove(name);
            System.out.println("Contact deleted successfully: " + contact);
        } else {
            System.out.println("Contact not found: " + name);
        }
    }

    // Search contacts by name
    public void searchContactsByName(String name) {
        boolean found = false;
        for (Map.Entry<String, Contact> entry : contacts.entrySet()) {
            if (Pattern.compile(Pattern.quote(name), Pattern.CASE_INSENSITIVE).matcher(entry.getKey()).find()) {
                System.out.println(entry.getValue());
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found with the given name: " + name);
        }
    }

    // Search contacts by phone number
    public void searchContactsByPhoneNumber(String phoneNumber) {
        boolean found = false;
        for (Contact contact : contacts.values()) {
            if (contact.getPhoneNumber().contains(phoneNumber)) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found with the given phone number: " + phoneNumber);
        }
    }

    // Search contacts by email
    public void searchContactsByEmail(String email) {
        boolean found = false;
        for (Contact contact : contacts.values()) {
            if (Pattern.compile(Pattern.quote(email), Pattern.CASE_INSENSITIVE).matcher(contact.getEmail()).find()) {
                System.out.println(contact);
                found = true;
            }
        }
        if (!found) {
            System.out.println("No contacts found with the given email: " + email);
        }
    }

        // Display all contacts
    public void displayAllContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts found.");
        } else {
            System.out.println("All Contacts:");
            for (Contact contact : contacts.values()) {
                System.out.println(contact);
            }
        }
    }

    // Main method to run the Contact Management System
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactManagementSystem cms = new ContactManagementSystem();

        while (true) {
            System.out.println("\nContact Management System");
            System.out.println("1. Add Contact");
            System.out.println("2. Edit Contact");
            System.out.println("3. Delete Contact");
            System.out.println("4. Search Contacts by Name");
            System.out.println("5. Search Contacts by Phone Number");
            System.out.println("6. Search Contacts by Email");
            System.out.println("7. Display All Contacts");
            System.out.println("8. Exit");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter Name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter Phone Number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();
                    cms.addContact(name, phoneNumber, email);
                    break;
                case 2:
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    System.out.print("Enter New Phone Number: ");
                    String newPhoneNumber = scanner.nextLine();
                    System.out.print("Enter New Email: ");
                    String newEmail = scanner.nextLine();
                    cms.editContact(name, newPhoneNumber, newEmail);
                    break;
                case 3:
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    cms.deleteContact(name);
                    break;
                case 4:
                    System.out.print("Enter Name: ");
                    name = scanner.nextLine();
                    cms.searchContactsByName(name);
                    break;
                case 5:
                    System.out.print("Enter Phone Number: ");
                    phoneNumber = scanner.nextLine();
                    cms.searchContactsByPhoneNumber(phoneNumber);
                    break;
                case 6:
                    System.out.print("Enter Email: ");
                    email = scanner.nextLine();
                    cms.searchContactsByEmail(email);
                    break;
                case 7:
                    cms.displayAllContacts();
                    break;
                case 8:
                    System.out.println("Thank you for using Contact Management System!");
                    scanner.close();
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}

