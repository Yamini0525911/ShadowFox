import java.util.ArrayList;
import java.util.Scanner;

class Contact {
    private String name;
    private String phone;
    private String email;

    public Contact(String name, String phone, String email) {
        this.name = name;
        this.phone = phone;
        this.email = email;
    }

    // Getters
    public String getName() { return name; }
    public String getPhone() { return phone; }
    public String getEmail() { return email; }

    // Setters
    public void setName(String name) { this.name = name; }
    public void setPhone(String phone) { this.phone = phone; }
    public void setEmail(String email) { this.email = email; }

    public void printInfo() {
        System.out.println("Name : " + name);
        System.out.println("Phone: " + phone);
        System.out.println("Email: " + email);
    }
}

public class ContactManager {

    static ArrayList<Contact> contactList = new ArrayList<>();
    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {
        int choice = -1;

        do {
            showMenu();
            try {
                choice = Integer.parseInt(input.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Please enter a valid number.");
                continue;
            }

            switch (choice) {
                case 1:
                    addNewContact();
                    break;
                case 2:
                    listAllContacts();
                    break;
                case 3:
                    modifyContact();
                    break;
                case 4:
                    removeContact();
                    break;
                case 5:
                    System.out.println("Thanks for using the app. Goodbye!");
                    break;
                default:
                    System.out.println("Oops, that's not a valid option.");
            }
        } while (choice != 5);
    }

    static void showMenu() {
        System.out.println("\n=== Contact Management ===");
        System.out.println("1. Add a Contact");
        System.out.println("2. Show All Contacts");
        System.out.println("3. Edit a Contact");
        System.out.println("4. Delete a Contact");
        System.out.println("5. Exit");
        System.out.print("Select an option (1-5): ");
    }

    static void addNewContact() {
        System.out.print("Full name: ");
        String newName = input.nextLine();
        System.out.print("Phone number: ");
        String newPhone = input.nextLine();
        System.out.print("Email address: ");
        String newEmail = input.nextLine();

        Contact c = new Contact(newName, newPhone, newEmail);
        contactList.add(c);
        System.out.println(">> Contact saved!");
    }

    static void listAllContacts() {
        if (contactList.isEmpty()) {
            System.out.println("No contacts to show.");
            return;
        }

        System.out.println("\n--- Your Contacts ---");
        for (int i = 0; i < contactList.size(); i++) {
            System.out.println("[" + (i + 1) + "]");
            contactList.get(i).printInfo();
            System.out.println("----------------------");
        }
    }

    static void modifyContact() {
        listAllContacts();
        if (contactList.isEmpty()) return;

        System.out.print("Which contact to edit (number)? ");
        int pos;
        try {
            pos = Integer.parseInt(input.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (pos >= 0 && pos < contactList.size()) {
            Contact existing = contactList.get(pos);

            System.out.print("New name (leave blank to keep same): ");
            String newName = input.nextLine();
            if (!newName.trim().isEmpty()) {
                existing.setName(newName);
            }

            System.out.print("New phone (leave blank to keep same): ");
            String newPhone = input.nextLine();
            if (!newPhone.trim().isEmpty()) {
                existing.setPhone(newPhone);
            }

            System.out.print("New email (leave blank to keep same): ");
            String newEmail = input.nextLine();
            if (!newEmail.trim().isEmpty()) {
                existing.setEmail(newEmail);
            }

            System.out.println(">> Contact updated.");
        } else {
            System.out.println("No contact found at that number.");
        }
    }

    static void removeContact() {
        listAllContacts();
        if (contactList.isEmpty()) return;

        System.out.print("Enter number of contact to delete: ");
        int toDelete;
        try {
            toDelete = Integer.parseInt(input.nextLine()) - 1;
        } catch (NumberFormatException e) {
            System.out.println("Invalid input.");
            return;
        }

        if (toDelete >= 0 && toDelete < contactList.size()) {
            contactList.remove(toDelete);
            System.out.println(">> Contact removed.");
        } else {
            System.out.println("Invalid selection.");
        }
    }
}
