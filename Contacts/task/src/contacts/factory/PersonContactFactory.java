package contacts.factory;

import contacts.Contact;
import contacts.PersonContacts;

public class PersonContactFactory {
    public Contact createContact() {
        return new PersonContacts();
    }
}
