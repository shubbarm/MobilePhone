package mobilephone;

import java.util.Scanner;

/**
 *
 * @author Mustafa Shubbar <codingbox@outlook.com>
 */
public class Main {

    private static Scanner sc = new Scanner(System.in);

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MobilePhone mobile = new MobilePhone();
        mobile.printOptions();
        boolean quit = false;
        int choice = sc.nextInt();
        while (!quit) {
            switch (choice) {
                case 1:
                    mobile.listContacts();
                    break;
                case 2:
                    System.out.println("Enter name for the new contact:");
                    String name = sc.nextLine();
                    System.out.println("Enter phone number for the new contact:");
                    String phoneNumber = sc.nextLine();
                    mobile.addContact(name, phoneNumber);
                    break;
                case 3:
                    System.out.println("Enter a name to update:");
                    String oldName = sc.nextLine();
                    System.out.println("Enter a new name:");
                    String newName = sc.nextLine();
                    System.out.println("Enter a new phone number:");
                    String newPhone = sc.nextLine();
                    mobile.updateContact(oldName, newName, newPhone);
                    break;
                case 4:
                    System.out.println("Enter a name to search for:");
                    String nameToSearch = sc.nextLine();
                    int result = mobile.findContact(nameToSearch);
                    if (result >= 0) {
                        System.out.println("contact found at index: " + result);
                    } else {
                        System.out.println("contact not found.");
                    }
                    break;
                case 5:
                    System.out.println("Enter a name to delete:");
                    String nameToDelete = sc.nextLine();
                    mobile.deleteContact(nameToDelete);
                    break;
                case 6:
                    quit = true;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }
        }
    }

}
