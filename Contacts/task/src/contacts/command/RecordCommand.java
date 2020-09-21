package contacts.command;

import contacts.ContactBook;
import contacts.PersonContacts;

import java.util.Scanner;

public class RecordCommand implements Command {
    private final int i;
    private final Scanner scanner = new Scanner(System.in);

    public RecordCommand(int i) {
        this.i = i;
    }

    @Override
    public void execute() {
        boolean flag = false;
        do {
            System.out.println("\n[record] Enter action (edit, delete, menu):");
            String input = scanner.nextLine();
            switch (input) {
                case "edit":
                    EditCommand command = new EditCommand();
                    if (ContactBook.getContact(i) instanceof PersonContacts) {
                        command.editPerson(i);
                    } else {
                        command.editOrganization(i);
                    }
                    break;
                case "delete":
                    RemoveCommand.execute(i);
                    break;
                case "menu":
                    flag = true;
                    break;
            }
        } while (!flag);
    }
}
