package contacts.command;

import contacts.Contact;
import contacts.ContactBook;

import java.util.ArrayList;
import java.util.Scanner;

public class SearchCommand implements Command {
    @Override
    public void execute() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter search query:");
        ArrayList<Contact> contact = ContactBook.search(scanner.nextLine());
        System.out.println("Found " + contact.size() + " results:");
        InfoCommand.printContacts(contact);

        while (true) {
            System.out.println("\n[search] Enter action ([number], back, again):");
            String input = scanner.nextLine();
            if ("back".equals(input)) {
                break;
            } else if ("again".equals(input)) {
                System.out.println("Enter search query:");
                contact = ContactBook.search(scanner.nextLine());
                System.out.println("Found " + contact.size() + " results:");
                InfoCommand.printContacts(contact);
            } else {
                try {
                    int i = Integer.parseInt(input);
                    RecordCommand command = new RecordCommand(i);
                    command.execute();
                    break;
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
