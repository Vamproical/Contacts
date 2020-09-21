package contacts.command;

import contacts.ContactBook;

import java.util.Scanner;

public class RemoveCommand implements Command {
    public void execute() {
        if (ContactBook.size() == 0) {
            System.out.println("No records to remove!");
            return;
        }
        InfoCommand infoCommand = new InfoCommand();
        infoCommand.printContacts();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Select a record:");
        int index = scanner.nextInt() - 1;
        ContactBook.removeContact(index);
        System.out.println("The record removed!");
    }

    public static void execute(int index) {
        ContactBook.removeContact(index);
        System.out.println("The record removed!");
    }
}
