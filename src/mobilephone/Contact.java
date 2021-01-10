package mobilephone;

/**
 *
 * @author Mustafa Shubbar <codingbox@outlook.com>
 */
public class Contact {

    private String name;
    private String phoneNumber;

    // No setters, just the constructor
    public Contact(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    public String getName() {
        return name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public static Contact createContact(String name, String phoneNumber) {
        return new Contact(name, phoneNumber);
    }

}
