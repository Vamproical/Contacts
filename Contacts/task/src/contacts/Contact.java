package contacts;

public class Contact {
    private String name;
    private String surname;
    private String phone;

    public Contact(String name, String surname, String phone) {
        this.name = name;
        this.surname = surname;
        this.phone = phone;
    }

    public Contact(String name, String surname) {
        this.name = name;
        this.surname = surname;
        this.phone = "";
    }

    public boolean hasPhone() {
        return !phone.equals("");
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        if (phone.equals("")) {
            return name + " " + surname + ", " + "[no number]";
        }
        else {
            return name + " " + surname + ", " + phone;
        }
    }
}
