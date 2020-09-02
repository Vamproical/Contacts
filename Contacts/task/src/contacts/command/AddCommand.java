package contacts.command;

import contacts.ContactBook;
import contacts.OrganizationContacts;
import contacts.PersonContacts;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.Scanner;

public class AddCommand implements Command {
    Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        System.out.println("Enter the type (person, organization): ");
        String type = scanner.nextLine();
        switch (type) {
            case "person":
                addPerson();
                break;
            case "organization":
                addOrganization();
                break;
        }
    }

    private void addPerson() {
        PersonContacts person = new PersonContacts();
        System.out.println("Enter the name: ");
        String name = scanner.nextLine();
        System.out.println("Enter the surname: ");
        String surname = scanner.nextLine();
        System.out.println("Enter the birth date: ");
        String birthDate = scanner.nextLine();
        LocalDate date;
        try {
            date = LocalDate.parse(birthDate);
        } catch (DateTimeException e) {
            System.out.println("Bad birth date!");
            date = null;
        }
        System.out.println("Enter the gender(M, F): ");
        String gender = scanner.nextLine();
        if (!gender.equals("M") && !gender.equals("F")) {
            System.out.println("Bad gender!");
            gender = null;
        }
        System.out.println("Enter the number: ");
        String phoneNumber = scanner.nextLine();
        person.setName(name);
        person.setSurname(surname);
        person.setBirthDay(date);
        person.setGender(gender);
        if (isCorrectNumber.isCorrect(phoneNumber)) {
            person.setPhone(phoneNumber);
        } else {
            System.out.println("Wrong number format!");
            person.setPhone("[no data]");
        }
        ContactBook.addContact(person);
        System.out.println("The record added.");
    }

    private void addOrganization() {
        System.out.println("Enter the organization name:");
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        OrganizationContacts organization = new OrganizationContacts();
        organization.setName(name);
        organization.setAddress(address);
        if (isCorrectNumber.isCorrect(phoneNumber)) {
            organization.setPhone(phoneNumber);
        } else {
            System.out.println("Wrong number format!");
            organization.setPhone("[no data]");
        }
        ContactBook.addContact(organization);
        System.out.println("The record added.");
    }
}
