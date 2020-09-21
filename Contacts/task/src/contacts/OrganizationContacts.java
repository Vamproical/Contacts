package contacts;

public class OrganizationContacts extends Contact {
    private String address;

    public OrganizationContacts() {
        super();
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void info() {
        System.out.println("Organization name: " + super.getName());
        System.out.println("Address: " + address);
        System.out.println("Number: " + super.getPhone());
        System.out.println("Time created: " + super.getCreation());
        System.out.println("Time last edit: " + super.getLastEdit());
    }

    @Override
    public String toString() {
        return super.getName() + " " + address + super.getPhone();
    }
}
