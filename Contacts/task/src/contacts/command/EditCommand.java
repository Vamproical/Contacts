package contacts.command;

import contacts.Contact;
import contacts.ContactBook;
import contacts.OrganizationContacts;
import contacts.PersonContacts;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class EditCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        if (ContactBook.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            InfoCommand infoCommand = new InfoCommand();
            infoCommand.printContacts();
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            if (ContactBook.getContact(--record) instanceof PersonContacts) {
                editPerson(record);
            } else {
                editOrganization(record);
            }
        }
    }

    private void editPerson(int index) {
        System.out.println("Select a field (name, surname, birth, gender, number):");
        String field = scanner.nextLine();
        System.out.println("Enter " + field + ":");
        String value = scanner.nextLine();
        Contact contact = ContactBook.getContact(index);
        PersonContacts personContacts = (PersonContacts) contact;
        switch (field) {
            case "name":
                personContacts.setName(value);
                break;
            case "surname":
                personContacts.setSurname(value);
                break;
            case "number":
                if (isCorrectNumber.isCorrect(value)) {
                    personContacts.setPhone(value);
                } else {
                    System.out.println("Wrong number format!");
                    personContacts.setPhone("[no data]");
                }
                break;
            case "gender":
                if (!value.equals("M") && !value.equals("F")) {
                    System.out.println("Bad gender!");
                    value = null;
                }
                personContacts.setGender(value);
                break;
            case "birth":
                LocalDate date;
                try {
                    date = LocalDate.parse(value);
                } catch (DateTimeException e) {
                    System.out.println("Bad birth date!");
                    date = null;
                }
                personContacts.setBirthDay(date);
                break;
        }
        System.out.println("The record updated!");
    }

    private void editOrganization(int index) {
        System.out.println("Select a field (name, address, number):");
        String field = scanner.nextLine();
        System.out.println("Enter " + field + ":");
        String value = scanner.nextLine();
        Contact contact = ContactBook.getContact(index);
        OrganizationContacts organizationContacts = (OrganizationContacts) contact;
        switch (field) {
            case "name":
                organizationContacts.setName(value);
                break;
            case "address":
                organizationContacts.setAddress(value);
                break;
            case "number":
                if (isCorrectNumber.isCorrect(value)) {
                    organizationContacts.setPhone(value);
                } else {
                    System.out.println("Wrong number format!");
                    organizationContacts.setPhone("[no data]");
                }
                break;
        }
        System.out.println("The record updated!");
    }
}
