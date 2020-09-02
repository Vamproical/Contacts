package contacts;

import java.util.ArrayList;
import java.util.List;

public class ContactBook {
    private static final List<Contact> contacts = new ArrayList<>();

    public static Contact getContact(int index) {
        return contacts.get(index);
    }

    public static void addContact(Contact contact) {
        contacts.add(contact);
    }

    public static void removeContact(int index) {
        contacts.remove(index);
    }

    public static List<Contact> getAllContacts() {
        return contacts;
    }

    public static int size() {
        return contacts.size();
    }
}
