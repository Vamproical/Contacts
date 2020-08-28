package contacts;

import java.time.DateTimeException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Contacts {
    private final List<Contact> contacts = new ArrayList<>();
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        boolean isExit = false;
        while (!isExit) {
            System.out.println("Enter action (add, remove, edit, count, list, exit): ");
            String command = scanner.nextLine();
            switch (command) {
                case "add":
                    add();
                    break;
                case "remove":
                    remove();
                    break;
                case "edit":
                    edit();
                    break;
                case "count":
                    System.out.println("The Phone Book has " + contacts.size() + " records.");
                    break;
                case "info":
                    info();
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Incorrect command!");
                    break;
            }
            System.out.println();
        }
    }

    private void add() {
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
        if (isCorrectPhoneNumber(phoneNumber)) {
            contacts.add(new PersonContacts(name, phoneNumber, surname, date, gender));
        } else {
            System.out.println("Wrong number format!");
            contacts.add(new PersonContacts(name, "", surname, date, gender));
        }
        System.out.println("The record added.");
    }

    private void addOrganization() {
        System.out.println("Enter the organization name:");
        String name = scanner.nextLine();
        System.out.println("Enter the address:");
        String address = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        if (isCorrectPhoneNumber(phoneNumber)) {
            contacts.add(new OrganizationContacts(name, phoneNumber, address));
        } else {
            System.out.println("Wrong number format!");
            contacts.add(new OrganizationContacts(name, "", address));
        }
        System.out.println("The record added.");
    }

    private void remove() {
        if (contacts.size() == 0) {
            System.out.println("No records to remove!");
        } else {
            printContacts();
            System.out.println("Select a record:");
            int index = Integer.parseInt(scanner.nextLine());
            contacts.remove(--index);
            System.out.println("The record removed!");
        }
    }

    private void edit() {
        if (contacts.size() == 0) {
            System.out.println("No records to edit!");
        } else {
            printContacts();
            System.out.println("Select a record:");
            int record = Integer.parseInt(scanner.nextLine());
            if (contacts.get(--record) instanceof PersonContacts) {
                editPerson(record);
            } else {
                editOrganization(record);
            }
        }
    }

    private void editPerson(int index) {
        System.out.println("Select a field (name, surname, birth, gender, number):");
        String field = scanner.nextLine();
        switch (field) {
            case "name":
                System.out.println("Enter name: ");
                String name = scanner.nextLine();
                Contact contactForName = contacts.get(index);
                contactForName.setName(name);
                contacts.set(index, contactForName);
                break;
            case "surname":
                System.out.println("Enter surname: ");
                String surname = scanner.nextLine();
                PersonContacts contactForSurname = (PersonContacts) contacts.get(index);
                contactForSurname.setSurname(surname);
                contacts.set(index, contactForSurname);
                break;
            case "number":
                System.out.println("Enter number: ");
                String number = scanner.nextLine();
                Contact contactForNumber = contacts.get(index);
                if (isCorrectPhoneNumber(number)) {
                    contactForNumber.setPhone(number);
                } else {
                    System.out.println("Wrong number format!");
                    contactForNumber.setPhone("");
                }
                contacts.set(index, contactForNumber);
                break;
            case "gender":
                System.out.println("Enter the gender(M, F): ");
                String gender = scanner.nextLine();
                if (!gender.equals("M") && !gender.equals("F")) {
                    System.out.println("Bad gender!");
                    gender = null;
                }
                PersonContacts genderForPerson = (PersonContacts) contacts.get(index);
                genderForPerson.setGender(gender);
                contacts.set(index, genderForPerson);
                break;
            case "birth":
                System.out.println("Enter the birth date: ");
                String birth = scanner.nextLine();
                LocalDate date;
                try {
                    date = LocalDate.parse(birth);
                } catch (DateTimeException e) {
                    System.out.println("Bad birth date!");
                    date = null;
                }
                PersonContacts birthForPerson = (PersonContacts) contacts.get(index);
                birthForPerson.setBirthDay(date);
                contacts.set(index, birthForPerson);
                break;
        }
        System.out.println("The record updated!");
    }

    private void editOrganization(int index) {
        System.out.println("Select a field (name, address, number):");
        String field = scanner.nextLine();
        switch (field) {
            case "name":
                System.out.println("Enter the organization name: ");
                String name = scanner.nextLine();
                Contact contactForName = contacts.get(index);
                contactForName.setName(name);
                contacts.set(index, contactForName);
                break;
            case "address":
                System.out.println("Enter the address: ");
                String address = scanner.nextLine();
                OrganizationContacts contactForAddress = (OrganizationContacts) contacts.get(index);
                contactForAddress.setAddress(address);
                contacts.set(index, contactForAddress);
                break;
            case "number":
                System.out.println("Enter number: ");
                String number = scanner.nextLine();
                Contact contactForNumber = contacts.get(index);
                if (isCorrectPhoneNumber(number)) {
                    contactForNumber.setPhone(number);
                } else {
                    System.out.println("Wrong number format!");
                    contactForNumber.setPhone("");
                }
                contacts.set(index, contactForNumber);
                break;
        }
        System.out.println("The record updated!");
    }

    private void info() {
        printContacts();
        System.out.println("Enter index to show info: ");
        int index = Integer.parseInt(scanner.nextLine());
        contacts.get(--index).info();
    }

    private void printContacts() {
        int i = 1;
        for (Contact contact : contacts) {
            System.out.println(i + ". " + contact.toString());
            ++i;
        }
    }

    private boolean isCorrectPhoneNumber(String number) {
        String withoutParentheses = "[+]?[\\da-z]+([ -][\\da-z]{2,})*";
        String firstGroupParentheses = "[+]?\\([\\da-z]+\\)([ -][\\da-z]{2,})*";
        String secondGroupParentheses = "[+]?[\\da-z]+([ -][\\da-z]{2,})*([ -]\\([\\da-z]{2,})\\)([ -][\\da-z]{2,})*";
        Pattern pattern = Pattern.compile(withoutParentheses +
                "|" + firstGroupParentheses +
                "|" + secondGroupParentheses, Pattern.CASE_INSENSITIVE);
        Matcher matcher = pattern.matcher(number);
        return matcher.matches();
    }
}
