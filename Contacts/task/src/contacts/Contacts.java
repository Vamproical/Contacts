package contacts;

import contacts.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    private final Scanner scanner = new Scanner(System.in);

    public void menu() {
        Controller controller = new Controller();

        Map<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("edit", new EditCommand());
        commands.put("remove", new RemoveCommand());
        commands.put("info", new InfoCommand());
        commands.put("count", new CountCommand());

        boolean status = true;
        do {
            System.out.println("Enter action (add, remove, edit, count, info, exit):");
            String action = scanner.next();
            if (action.equals("exit")) {
                status = false;
            } else {
                controller.setCommand(commands.get(action));
                controller.executeCommand();
            }
        } while (status);
    }
}
