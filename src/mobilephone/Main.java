package mobilephone;

import java.util.Scanner;

/**
 *
 * @author Mustafa Shubbar <codingbox@outlook.com>
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);
    private static MobilePhone mobile = new MobilePhone("5412152");

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {

        boolean quit = false;
        startPhone();
        printActions();
        while (!quit) {
            System.out.println("\nEnter action: (6 to show available actions)");
            int choice = Integer.parseInt(sc.nextLine());
            switch (choice) {
                case 0:
                    System.out.println("Shutting down...");
                    quit = true;
                    break;
                case 1:
                    mobile.printContacts();
                    break;
                case 2:
                    addNewContact();
                    break;
                case 3:
                    updateContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    queryContact();
                    break;
                case 6:
                    printActions();
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

    private static void addNewContact() {
        System.out.println("Enter contact name:");
        String name = sc.nextLine();
        System.out.println("Enter phone number:");
        String phone = sc.nextLine();
        Contact contact = Contact.createContact(name, phone);
        if (mobile.addContact(contact)) {
            System.out.println("New contact added: name = " + name + ", "
                    + "phone = " + phone);
        } else {
            System.out.println("Cannot add " + name + ", it's already on file");
        }
    }

    private static void updateContact() {
        System.out.print("Enter name to update: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mobile.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Enter new contact name:");
        String newName = sc.nextLine();
        System.out.println("Enter new contact phone number:");
        String newNumber = sc.nextLine();
        Contact newContact = Contact.createContact(newName, newNumber);
        if (mobile.updateContact(existingContactRecord, newContact)) {
            System.out.println("Successfully updated.");
        } else {
            System.out.println("Error updating record.");
        }
    }

    private static void removeContact() {
        System.out.print("Enter name to remove: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mobile.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        if (mobile.removeContact(existingContactRecord)) {
            System.out.println("Successfully deleted record.");
        } else {
            System.out.println("Error deleting record.");
        }
    }

    private static void queryContact() {
        System.out.print("Enter existing name to check: ");
        String name = sc.nextLine();
        Contact existingContactRecord = mobile.queryContact(name);
        if (existingContactRecord == null) {
            System.out.println("Contact not found.");
            return;
        }
        System.out.println("Name: " + existingContactRecord.getName()
                + " -> " + existingContactRecord.getPhoneNumber());
    }

    public static void startPhone() {
        System.out.println("Starting the phone...");
    }

    public static void printActions() {
        System.out.println("Please choose one of the options below:\n"
                + "0- Shutdown\n"
                + "1- List all contacts\n"
                + "2- Add new Contact\n"
                + "3- Update existing contact\n"
                + "4- Remove contact\n"
                + "5- Query for a contact\n"
                + "6- Print a list of available actions");
    }

}
