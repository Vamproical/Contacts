package contacts.command;

import contacts.Contact;
import contacts.ContactBook;
import contacts.OrganizationContacts;
import contacts.PersonContacts;

import java.util.Scanner;

public class InfoCommand implements Command{
    private final Scanner scanner = new Scanner(System.in);
    @Override
    public void execute() {
        printContacts();
        System.out.println("Enter index to show info: ");
        int index = Integer.parseInt(scanner.nextLine());
        Contact contact = ContactBook.getContact(--index);
        if (contact instanceof PersonContacts) {
            PersonContacts personContacts = (PersonContacts) contact;
            personContacts.info();
        } else {
            OrganizationContacts organizationContacts = (OrganizationContacts) contact;
            organizationContacts.info();
        }
    }

    public void printContacts() {
        int i = 1;
        for (Contact contact : ContactBook.getAllContacts()) {
            System.out.println(i + ". " + contact.toString());
            ++i;
        }
    }
}
