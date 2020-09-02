package contacts.command;

import contacts.ContactBook;

public class CountCommand implements Command {
    public void execute() {
        System.out.println("The Phone Book has " + ContactBook.size() + " records.");
    }
}
