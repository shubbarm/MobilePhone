package mobilephone;

import java.util.ArrayList;

/**
 *
 * @author Mustafa Shubbar <codingbox@outlook.com>
 */
public class MobilePhone {

    private ArrayList<Contact> myContacts;
    private String myNumber;

    public MobilePhone(String number) {
        this.myNumber = number;
        this.myContacts = new ArrayList<>();
    }

    public boolean addContact(Contact contact) {
        if (findContact(contact.getName()) >= 0) {
            System.out.println("Contact is already on file.");
            return false;
        }
        myContacts.add(contact);
        return true;
    }

    public boolean updateContact(Contact oldContact, Contact newContact) {
        int position = findContact(oldContact);
        if (position < 0) {
            System.out.println(oldContact.getName() + ", was not found.");
            return false;
        } else if (findContact(newContact.getName()) != -1) {
            System.out.println("Contact name: " + newContact.getName()
                    + " is already on file. Update not successfull.");
            return false;
        }
        this.myContacts.set(position, newContact);
        System.out.println(oldContact.getName() + " was replaced with " + newContact.getName());
        return true;
    }

    // Private, for internal work
    private int findContact(Contact contact) {
        return this.myContacts.indexOf(contact);
    }

    // Another overlapping method
    private int findContact(String name) {
        for (int i = 0; i < this.myContacts.size(); i++) {
            Contact contact = this.myContacts.get(i);
            if (contact.getName().equals(name)) {
                return i;
            }
        }
        return -1;
    }

    public String queryContact(Contact contact) {
        if (findContact(contact) >= 0) {
            return contact.getName();
        }
        return null;
    }

    public Contact queryContact(String name) {
        int position = findContact(name);
        if (position >= 0) {
            return this.myContacts.get(position);
        }
        return null;
    }

    public void listContacts() {
        for (int i = 0; i < myContacts.size(); i++) {
            System.out.println((i + 1) + " " + myContacts.get(i).getName() + " "
                    + myContacts.get(i).getPhoneNumber());
        }
    }

    public boolean removeContact(Contact contact) {
        int position = findContact(contact);
        if (position < 0) {
            System.out.println(contact.getName() + ", was not found.");
            return false;
        }
        this.myContacts.remove(contact);
        System.out.println(contact.getName() + " was deleted.");
        return true;
    }

    public void printContacts() {
        System.out.println("Contact List");
        System.out.println("------------");
        for (int i = 0; i < this.myContacts.size(); i++) {
            System.out.println((i + 1) + ". " + this.myContacts.get(i).getName() + " | "
                    + this.myContacts.get(i).getPhoneNumber());
        }
    }

}
