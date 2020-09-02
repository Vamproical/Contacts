package contacts.factory;

import contacts.Contact;
import contacts.OrganizationContacts;

public class OrganizationContactFactory {
    public Contact createContact() {
        return new OrganizationContacts();
    }
}
