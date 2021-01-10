package mobilephone;

import java.util.ArrayList;

/**
 *
 * @author Mustafa Shubbar <codingbox@outlook.com>
 */
public class MobilePhone {

    private ArrayList<Contact> contacts = new ArrayList<>();

    public void printOptions() {
        System.out.println("Please choose one of the options below:\n"
                + "1- List all contacts\n"
                + "2- Add new Contact\n"
                + "3- Update existing contact\n"
                + "4- Remove contact\n"
                + "5- Search for a contact\n"
                + "6- Quit");
    }

    public void listContacts() {
        for (int i = 0; i < contacts.size(); i++) {
            System.out.println((i + 1) + " " + contacts.get(i).getName() + " "
                    + contacts.get(i).getPhoneNumber());
        }
    }

    public void addContact(String name, String number) {
        Contact newContact = new Contact(name, number);
        contacts.add(newContact);
    }

    public int findContact(String name) {
        int result = contacts.indexOf(name);
        return result;
    }

    public void updateContact(String oldName, String newName, String newPhone) {
        int index = findContact(oldName);
        if (index >= 0) {
            contacts.get(index).setName(newName);
            contacts.get(index).setPhoneNumber(newPhone);
        } else {
            System.out.println("No such contact to edit.");
        }
    }

    public void deleteContact(String name) {
        int index = findContact(name);
        if (index >= 0) {
            contacts.remove(index);
        } else {
            System.out.println("No such contact to delete.");
        }
    }

}
