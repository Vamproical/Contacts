package contacts;

import java.io.*;
import java.util.ArrayList;

public class SerializationUtils {
    public static void serialize(ArrayList<Contact> phoneBook) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(new File("phonebook.db")))) {
            oos.writeObject(phoneBook);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static ArrayList<Contact> deserialize() {
        ArrayList<Contact> contacts;
        try {
            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(new File("phonebook.db")));
            contacts = (ArrayList<Contact>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            contacts = new ArrayList<>();
            e.printStackTrace();
        }
        return contacts;
    }
}
