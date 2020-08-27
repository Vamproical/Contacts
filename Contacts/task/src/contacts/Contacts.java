package contacts;

import java.util.ArrayList;
import java.util.Arrays;
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
                case "list":
                    printContacts();
                    break;
                case "exit":
                    isExit = true;
                    break;
                default:
                    System.out.println("Incorrect command!");
                    break;
            }
        }
    }

    private void add() {
        System.out.println("Enter the name:");
        String name = scanner.nextLine();
        System.out.println("Enter the surname:");
        String surname = scanner.nextLine();
        System.out.println("Enter the number:");
        String phoneNumber = scanner.nextLine();
        if (isCorrectPhoneNumber(phoneNumber)) {
            contacts.add(new Contact(name, surname, phoneNumber));
        } else {
            System.out.println("Wrong number format!");
            contacts.add(new Contact(name, surname));
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
            System.out.println("Select a field (name, surname, number):");
            String field = scanner.nextLine();
            switch (field) {
                case "name":
                    System.out.println("Enter name: ");
                    String name = scanner.nextLine();
                    Contact contactForName = contacts.get(--record);
                    contactForName.setName(name);
                    contacts.set(record, contactForName);
                    break;
                case "surname":
                    System.out.println("Enter surname: ");
                    String surname = scanner.nextLine();
                    Contact contactForSurname = contacts.get(--record);
                    contactForSurname.setSurname(surname);
                    contacts.set(record, contactForSurname);
                    break;
                case "number":
                    System.out.println("Enter number: ");
                    String number = scanner.nextLine();
                    Contact contactForNumber = contacts.get(--record);
                    if (isCorrectPhoneNumber(number)) {
                        contactForNumber.setPhone(number);
                    } else {
                        System.out.println("Wrong number format!");
                        contactForNumber.setPhone("");
                    }
                    contacts.set(record, contactForNumber);
                    break;
            }
            System.out.println("The record updated!");
        }
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
