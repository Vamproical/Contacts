package contacts;

import java.time.LocalDate;
import java.time.LocalDateTime;

public class PersonContacts extends Contact {
    private String surname;
    private LocalDate birthDay;
    private String gender;

    public PersonContacts() {
        super();
    }

    public void setSurname(String surname) {
        this.surname = surname;
        super.setLastEdit(LocalDateTime.now());
    }

    public void setBirthDay(LocalDate birthDay) {
        this.birthDay = birthDay;
        super.setLastEdit(LocalDateTime.now());
    }

    public void setGender(String gender) {
        this.gender = gender;
        super.setLastEdit(LocalDateTime.now());
    }

    @Override
    public void info() {
        super.setName(checkNull(super.getName()));
        super.setPhone(checkNull(super.getPhone()));
        surname = checkNull(surname);
        gender = checkNull(gender);
        System.out.println("Name: " + super.getName());
        System.out.println("Surname: " + surname);
        if (birthDay == null) {
            System.out.println("Birth date: [no data]");
        } else {
            System.out.println("Birth date: " + birthDay);
        }
        System.out.println("Gender: " + gender);
        System.out.println("Number: " + super.getPhone());
        System.out.println("Time created: " + super.getCreation());
        System.out.println("Time last edit: " + super.getLastEdit());
    }

    public String checkNull(String check) {
        return check == null ? "[no data]" : check;
    }

    @Override
    public String toString() {
        return super.getName() + " " + surname
                + " " + (birthDay == null ? "no data" : birthDay)
                + " " + checkNull(gender) + " " + super.getPhone();
    }
}
