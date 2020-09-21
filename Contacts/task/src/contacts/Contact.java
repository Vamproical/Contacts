package contacts;

import java.time.LocalDateTime;

public abstract class Contact {
    private String name;
    private String phone;
    private final LocalDateTime creation;
    private LocalDateTime lastEdit;

    public Contact() {
        creation = LocalDateTime.now();
        lastEdit = creation;
    }

    public abstract void info();

    public boolean hasPhone() {
        return !phone.equals("");
    }

    public String getName() {
        return name;
    }

    public String getPhone() {
        return phone;
    }

    public void setName(String name) {
        this.name = name;
        lastEdit = LocalDateTime.now();
    }

    public void setPhone(String phone) {
        this.phone = phone;
        lastEdit = LocalDateTime.now();
    }

    public void setLastEdit(LocalDateTime lastEdit) {
        this.lastEdit = lastEdit;
    }

    public LocalDateTime getCreation() {
        return creation;
    }

    public LocalDateTime getLastEdit() {
        return lastEdit;
    }

    @Override
    public abstract String toString();
}
