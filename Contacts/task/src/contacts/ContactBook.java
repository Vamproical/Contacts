package contacts;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class ContactBook implements Serializable {
    private static List<Contact> contacts = new ArrayList<>();

    public static void setContacts(List<Contact> contacts) {
        ContactBook.contacts = contacts;
    }

    public static Contact getContact(int index) {
        return contacts.get(--index);
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static void removeContact(int index) {
        contacts.remove(index);
    }

    public static ArrayList<Contact> search(String phrase) {
        ArrayList<Contact> contact = new ArrayList<>();
        for (Contact c : contacts) {
            System.out.println(c.toString().toLowerCase());
            System.out.println(phrase);
            if (c.toString().toLowerCase().contains(phrase.toLowerCase())) {
                contact.add(c);
            }
        }
        return contact;
    }

    public static List<Contact> getAllContacts() {
        return contacts;
    }

    public static int size() {
        return contacts.size();
    }
}
