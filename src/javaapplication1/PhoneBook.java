package javaapplication1;


import java.util.Scanner;

public class PhoneBook {

    public static linkedlist<Event> events;
    public static linkedlist<Contact> contacts;

    public static Scanner input = new Scanner(System.in);

    public PhoneBook() {
        contacts = new linkedlist<Contact>();
        events = new linkedlist<Event>();

    }

    public PhoneBook(linkedlist<Contact> contactlist) {
        contacts = contactlist;
    }

    public static boolean search(Contact c) {

        if (contacts.isEmpty()) {
            return false;
        } else {
            contacts.findfirst();
            while (!contacts.last()) {
                if (contacts.retrieve().getContactName().equals(c.getContactName())
                        || contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())) {
                    return true;
                }
                contacts.findnext();
            }
            if (contacts.retrieve().getContactName().equals(c.getContactName())
                    || contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber())) {
                return true;
            }
        }

        return false;

    }

    public static linkedlist<Contact> searchByFirstName(String name) {

        if (contacts.isEmpty()) {
            System.out.println("No contacts with this first name!");
            return null;
        }

        contacts.findfirst();

        linkedlist<Contact> ContactsList = new linkedlist<Contact>();

        int fName;
        while (!contacts.last()) {
            fName = ((Contact) contacts.retrieve()).getContactName().indexOf(" ");

            if (((Contact) contacts.retrieve()).getContactName().substring(0, fName).equals(name)) {
                ContactsList.addSortedContact(contacts.retrieve());
            }

            contacts.findnext();
        }
        fName = ((Contact) contacts.retrieve()).getContactName().indexOf(" ");
        if (((Contact) contacts.retrieve()).getContactName().substring(0, fName).equals(name)) {
            ContactsList.addSortedContact(contacts.retrieve());
        }
        System.out.println("Contacts found!");
        return ContactsList;
    }

    public static Event searchEventByTitle(String n) {
        if (events.isEmpty()) {
            return null;
        }

        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getTitle().equals(n)) {
                return events.retrieve();
            }

            events.findnext();
        }

        if (events.retrieve().getTitle().equals(n)) {
            return events.retrieve();
        } else {
            return null;
        }

    }

    public static void searchEventByContact(String n) {//1
        if (events.isEmpty()) {
            System.out.println("There are no events with this contact name");
            return;
        }

        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getContactName().equals(n)) {
                events.retrieve().display();
            }

            events.findnext();
        }

        if (events.retrieve().getContactName().equals(n)) {
            events.retrieve().display();
        } else {
            System.out.println("There are no events with this contact name");

        }

    }

    public void PrintContactsShareEvent(Event e) {

        e.contactsinEvent.findfirst();
        while (!e.contactsinEvent.last()) {
            System.out.println(e.contactsinEvent.retrieve().getContactName());
            e.contactsinEvent.findnext();
        }

        System.out.println(e.contactsinEvent.retrieve().getContactName());

    }

    public void AddContact(Contact c) {
        boolean cFound = search(c);
        if (cFound == true) {
            System.out.println("Contact couldn't be added");
        } else {
            contacts.addSortedContact(c);
            System.out.println("Contact added successfully!");
        }
    }

    public static void AddEvent(Event e) {
        Event eFound = searchEventByTitle(e.getTitle());
        if (eFound == null) {
            events.addSortedEvent(e);
        }

    }

    public static void DeleteContact(String m) {

        if (contacts.isEmpty()) {
            System.out.println("Can't delete because the contact is not found ");
            return;
        }

        contacts.findfirst();
        while (!contacts.last()) {
            if (contacts.retrieve().getContactName().equals(m)) {

                deleteEvents(contacts.retrieve());
                contacts.remove();
                System.out.println(m + " has been deleted from the contacts");
                return;
            }
            contacts.findnext();
        }

        if (contacts.retrieve().getContactName().equals(m)) {
            deleteEvents(contacts.retrieve());
            contacts.remove();
            System.out.println(m + " has been deleted from the contacts");
            return;
        }
        System.out.println("Can't delete because the contact is not found ");
    }

    public static void deleteEvents(Contact contact1) { //will delete all events in sent contact
        if (!contact1.contactEvents.isEmpty()) {
            contact1.contactEvents.findfirst();

            while (!contact1.contactEvents.isEmpty()) {
                contact1.contactEvents.remove();
            }

        }

    }

    public static void PrintAllEvents() {
        if (!events.isEmpty()) {
            events.findfirst();
            while (!events.last()) {

                System.out.println(events.retrieve().getTitle());
                events.findnext();
            }
            System.out.println(events.retrieve().getTitle());

        } else {
            System.out.println("There are no events to print");
        }
    }

    public static void schedulingEvent(Event event1, String name) {
        boolean hasConflict = false;
        Contact c1 = contacts.searchByName(name);// to check if contact exists
        if (c1 == null) {
            System.out.println("Can't schedule event, because this contact doesn't exist ");
            return;
        }
        if (!c1.contactEvents.isEmpty()) {

            c1.contactEvents.findfirst();

            while (!c1.contactEvents.last()) {
                if (c1.contactEvents.retrieve().getDate().equals(event1.getDate()) && c1.contactEvents.retrieve().getTime().equals(event1.getTime())) {
                    hasConflict = true; //same date and time in both events so there is a conflict

                }
                c1.contactEvents.findnext();
            }

            if (c1.contactEvents.retrieve().getDate().equals(event1.getDate()) && c1.contactEvents.retrieve().getTime().equals(event1.getTime())) {
                hasConflict = true; //check for the last event in list
            }
        }

        if (!hasConflict) {
            c1.contactEvents.addSortedEvent(event1); //add the event in the contact's list

            event1.contactsinEvent.addSortedContact(c1); //add the contact in the event's list
            event1.setInvolvedContact(c1);
            event1.setContactName(name);

            AddEvent(event1);//add the event in the all events list if not there
            System.out.println("Event scheduled successfully!");

        } else {
            System.out.println("Can't schedule event, because this contact has a conflict with a scheduled event");
        }

    }

    public static int ChooseOption() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int searchCriteria2() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int searchCriteria() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event title");
        System.out.print("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Linked Tree Phonebook!");
        PhoneBook p = new PhoneBook();

        int choice;

        do {
            choice = ChooseOption();
            switch (choice) {
                case 1:

                    System.out.print("Enter the contact's name:");
                    String contactName1 = input.nextLine();
                    contactName1 = input.nextLine();
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber1 = input.nextLine();
                    System.out.print("Enter the contact's email address:");
                    String emailAddress1 = input.nextLine();
                    System.out.print("Enter the contact's address:");
                    String address1 = input.nextLine();
                    System.out.print("Enter the contact's birthday:");
                    String birthday1 = input.nextLine();
                    System.out.print("Enter any notes for the contact:");
                    String notes1 = input.nextLine();
                    Contact c = new Contact(contactName1, phoneNumber1, emailAddress1, address1, birthday1, notes1);
                    p.AddContact(c);

                    break;

                case 2:
                    int choice2 = searchCriteria2();
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter the contact's name:");
                            String name = input.nextLine();
                            name = input.nextLine();
                            if (contacts.searchByName(name) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.searchByName(name)).display();
                            }

                            break;
                        case 2:

                            System.out.print("Enter the contact's Phone Number:");
                            String phonNumber = input.nextLine();
                            phonNumber = input.nextLine();
                            linkedlist<Contact> con = contacts.SearchByPhoneNumber(phonNumber);
                            if (!con.isEmpty()) {
                                con.findfirst();
                                while (!con.last()) {
                                    con.retrieve().display();
                                    con.findnext();
                                }
                                con.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }

                            break;

                        case 3:
                            System.out.print("Enter the contact's email:");
                            String email1 = input.nextLine();
                            email1 = input.nextLine();
                            linkedlist<Contact> con1 = contacts.SearchByEmail(email1);
                            if (!con1.isEmpty()) {
                                con1.findfirst();
                                while (!con1.last()) {
                                    con1.retrieve().display();
                                    con1.findnext();
                                }
                                con1.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;
                        case 4:
                            System.out.print("Enter the contact's Address");
                            String address2 = input.nextLine();
                            address2 = input.nextLine();
                            linkedlist<Contact> con3 = contacts.SearchByAddress(address2);
                            if (!con3.isEmpty()) {
                                con3.findfirst();
                                while (!con3.last()) {
                                    con3.retrieve().display();
                                    con3.findnext();
                                }
                                con3.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;
                        case 5:
                            System.out.print("Enter the contact's Birthday:");
                            String bday = input.nextLine();
                            bday = input.nextLine();
                            linkedlist<Contact> con4 = contacts.SearchByBirthday(bday);
                            if (!con4.isEmpty()) {
                                con4.findfirst();
                                while (!con4.last()) {
                                    con4.retrieve().display();
                                    con4.findnext();
                                }
                                con4.retrieve().display();
                            } else {
                                System.out.println("There are no contacts to print");
                            }
                            break;

                    }

                    break;

                case 3:
                    System.out.print("Enter contact name:");
                    String deleteName = input.nextLine();
                    deleteName = input.nextLine();

                    DeleteContact(deleteName);

                    break;

                case 4:
                    System.out.print("Enter event title:");
                    String title = input.nextLine();
                    title = input.nextLine();
                    System.out.print("Enter contact name:");
                    String name = input.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY:MM):");
                    String date = input.next();
                    String time = input.next();
                    System.out.print("Enter event location:");
                    String location = input.nextLine();
                    location = input.nextLine();

                    Event eventt = new Event(title, date, time, location);

                    schedulingEvent(eventt, name);//5

                    break;

                case 5:
                    int pick = searchCriteria();
                    switch (pick) {
                        case 1:
                            System.out.print("Enter the contact name:");
                            String Cname = input.nextLine();
                            Cname = input.nextLine();
                            searchEventByContact(Cname);
                            break;

                        case 2:
                            System.out.print("Enter the event title:");
                            String title1 = input.nextLine();
                            title1 = input.nextLine();
                            Event event3 = searchEventByTitle(title1);
                            if (event3 != null) {
                                System.out.println("Event found!");
                                event3.display();

                            } else {
                                System.out.println("Event not found!");

                            }

                            break;

                    }
                    break;

                case 6:
                    System.out.print("Enter the contact's first name:");
                    String firstname = input.next();

                    linkedlist<Contact> contactList = searchByFirstName(firstname);

                    if (contactList == null) {
                        break;
                    }
                    contactList.findfirst();
                    while (!contactList.last()) {
                        contactList.retrieve().display();
                        contactList.findnext();

                    }

                    contactList.retrieve().display();

                    break;

                case 7:
                    PrintAllEvents();
                    break;

                case 8:
                    System.out.println("Goodbye!");
                    break;
                default:
                    System.out.println("Bad choice! Try again");
            }
            System.out.println("\n\n");
        } while (choice != 8);
    }

}
