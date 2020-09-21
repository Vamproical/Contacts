package contacts.command;

import contacts.Contact;
import contacts.ContactBook;

import java.util.ArrayList;
import java.util.Scanner;

public class InfoCommand implements Command {
    private final Scanner scanner = new Scanner(System.in);

    @Override
    public void execute() {
        printContacts();
        while (true) {
            System.out.println("\n[list] Enter action ([number], back):");
            String index = scanner.nextLine();
            if ("back".equals(index)) {
                break;
            }
            try {
                int i = Integer.parseInt(index);
                RecordCommand command = new RecordCommand(i);
                command.execute();
                break;
            } catch (NumberFormatException e) {
                System.out.println("The number format is wrong!");
            }
        }
    }

    public void printContacts() {
        int i = 1;
        for (Contact contact : ContactBook.getAllContacts()) {
            System.out.print(i + ". ");
            contact.info();
            ++i;
        }
    }

    public static void printContacts(ArrayList<Contact> contacts) {
        int i = 1;
        for (Contact contact : contacts) {
            System.out.println(i + ". " + contact.toString());
            ++i;
        }
    }
}
