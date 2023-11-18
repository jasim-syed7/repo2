import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phoneNumber;
    private String email;

    public Contact(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "Name: " + name + "\nPhone Number: " + phoneNumber + "\nEmail: " + email + "\n";
    }
}

class ContactsApp {
    private ArrayList<Contact> contacts;

    public ContactsApp() {
        contacts = new ArrayList<>();
    }

    public void addContact(Contact contact) {
        contacts.add(contact);
        System.out.println("Contact added successfully.\n");
    }

    public void displayContacts() {
        if (contacts.isEmpty()) {
            System.out.println("No contacts available.\n");
        } else {
            for (Contact contact : contacts) {
                System.out.println(contact);
            }
        }
    }

    public void searchContact(String keyword) {
        boolean found = false;
        for (Contact contact : contacts) {
            if (contact.getName().toLowerCase().contains(keyword.toLowerCase()) ||
                contact.getPhoneNumber().contains(keyword) ||
                contact.getEmail().toLowerCase().contains(keyword.toLowerCase())) {
                System.out.println(contact);
                found = true;
            }
        }

        if (!found) {
            System.out.println("No matching contacts found.\n");
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ContactsApp contactsApp = new ContactsApp();

        while (true) {
            System.out.println("Contacts App Menu:");
            System.out.println("1. Add Contact");
            System.out.println("2. Display Contacts");
            System.out.println("3. Search Contacts");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume the newline character

            switch (choice) {
                case 1:
                    System.out.print("Enter contact name: ");
                    String name = scanner.nextLine();
                    System.out.print("Enter contact phone number: ");
                    String phoneNumber = scanner.nextLine();
                    System.out.print("Enter contact email: ");
                    String email = scanner.nextLine();

                    Contact newContact = new Contact(name, phoneNumber, email);
                    contactsApp.addContact(newContact);
                    break;
                case 2:
                    contactsApp.displayContacts();
                    break;
                case 3:
                    System.out.print("Enter search keyword: ");
                    String keyword = scanner.nextLine();
                    contactsApp.searchContact(keyword);
                    break;
                case 4:
                    System.out.println("Exiting the Contacts App. Goodbye!");
                    System.exit(0);
                default:
                    System.out.println("Invalid choice. Please enter a valid option.\n");
            }
        }
    }
}

