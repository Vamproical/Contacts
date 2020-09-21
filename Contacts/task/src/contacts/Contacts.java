package contacts;

import contacts.command.*;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Contacts {
    private final Scanner scanner = new Scanner(System.in);

    public Contacts() {

    }

    public void menu() {
        Controller controller = new Controller();
        Map<String, Command> commands = new HashMap<>();
        commands.put("add", new AddCommand());
        commands.put("list", new InfoCommand());
        commands.put("search", new SearchCommand());
        commands.put("count", new CountCommand());

        boolean status = true;
        do {
            System.out.println("[menu]Enter action (add, list, search, count, exit):");
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
