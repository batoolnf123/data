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

    public PhoneBook(linkedlist<Contact> contactlist) { //check?
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

    public static linkedlist<Contact> searchByFirstName(String name) //joury
    {

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

    //new? add ev/search t and cn ev/sched/ printallev / dis ev done. +wtvr m did? 
    public static Event searchEventTitle(String n) { //anoud check after bool
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

    public static Event searchEventContact(String n) { //anoud check after bool
        if (events.isEmpty()) {
            return null;
        }
        events.findfirst();
        while (!events.last()) {
            if (events.retrieve().getContactName().equals(n)) {
                return events.retrieve();
            }

            events.findnext();
        }

        if (events.retrieve().getContactName().equals(n)) {
            return events.retrieve();
        } else {
            return null;
        }

    }

    public void PrintEventContacts(Event e) {

        e.contactsinEvent.findfirst();
        while (!e.contactsinEvent.last()) {
            System.out.println(e.contactsinEvent.retrieve().getContactName());
            e.contactsinEvent.findnext();
        }

        System.out.println(e.contactsinEvent.retrieve().getContactName());

    }

    public void AddContact(Contact c) {
        Contact cfound = contacts.searchByName(c.getContactName());
        if (cfound!=null) {
            System.out.println("contact couldn't be added");
        } else {
            contacts.addSortedContact(c);
            System.out.println("contact added");
        }
    }

    public static void AddEvent(Event e) {//check
        Event found = searchEventTitle(e.getTitle());
        if (found == null) {
            events.addSortedEvent(e);
        }

    }

    public static void DeleteContact(String m) {
        if (contacts.isEmpty()) {
            System.out.println("Can't delete an empty list");
            return;
        }
        contacts.findfirst();
        while (!contacts.last()) {
            if (contacts.retrieve().getContactName().equals(m)) {
                contacts.remove();
                System.out.println(m + " This contact has been deleted");
                return;
            }
            contacts.findnext();
        }
        if (contacts.retrieve().getContactName().equals(m)) {
            contacts.remove();
            System.out.println(m + " This contact has been deleted");
        }
    }

    //event new methods
    public static void PrintAllEvents() { //is this o of n??? +only title or all data?
        if (!events.isEmpty()) {
            events.findfirst();
            while (!events.last()) {
                // for (int i = 0 ; i < events.size  ; i++) and del the rep

                System.out.println(events.retrieve().getTitle());
                events.findnext();
            }
            System.out.println(events.retrieve().getTitle());

        } else {
            System.out.println("There are no events to print");
        }
    }

    public static void schedulingEvent(Event event1, String name) { //anoud

        Contact contact1 = contacts.searchByName(name);

        if (contact1 != null && !hasConflict(event1, contact1)) {

            contact1.contactEvents.addSortedEvent(event1); //imp?

            event1.contactsinEvent.addSortedContact(contact1);

            event1.eventsinEvent.addSortedEvent(event1);

            event1.setInvolvedContact(contact1);
            event1.setContactName(name);

            System.out.println("Event scheduled successfully!");
            AddEvent(event1); //is this correct?

        } else if (contact1 == null) {
            System.out.println("Can't schedule event, because this contact doesn't exist ");

        } else if (hasConflict(event1, contact1)) {
            System.out.println("Can't schedule event, because this contact has a conflict with a scheduled event");

        }

    }

    public static boolean hasConflict(Event e1, Contact c1) {
        if (c1.contactEvents.isEmpty()) {
            return false;
        }

        c1.contactEvents.findfirst();

        while (!c1.contactEvents.last()) {
            if (c1.contactEvents.retrieve().getDate().equals(e1.getDate()) && c1.contactEvents.retrieve().getTime().equals(e1.getTime())) {
                return true; //same date and time in both events so there is a conflict
            }
            c1.contactEvents.findnext();
        }

        if (c1.contactEvents.retrieve().getDate().equals(e1.getDate()) && c1.contactEvents.retrieve().getTime().equals(e1.getTime())) {
            return true; //check for the last event in list
        } 
            return false;
        

    }

    //end of new eventm
    public static int menu() {
        System.out.println("Please choose an option:");
        System.out.println("1. Add a contact");
        System.out.println("2. Search for a contact");
        System.out.println("3. Delete a contact");
        System.out.println("4. Schedule an event");
        System.out.println("5. Print event details");
        System.out.println("6. Print contacts by first name");
        System.out.println("7. Print all events alphabetically");
        System.out.println("8. Exit");
        System.out.println("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int submenu2() {
        System.out.println("Enter search criteria:");
        System.out.println("1. Name");
        System.out.println("2. Phone Number");
        System.out.println("3. Email Address");
        System.out.println("4. Address");
        System.out.println("5. Birthday");
        System.out.println("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static int searchCriteria() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.println("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Linked List Phonebook!");
        PhoneBook p = new PhoneBook();

        int choice;

        do {
            choice = menu();
            switch (choice) {
                case 1:

                    System.out.print("Enter the contact's name:");
                    String contactName1 = input.nextLine();
                    contactName1 = input.nextLine();
                    System.out.print("Enter the contact's phone number:");
                    String phoneNumber1 = input.nextLine();
                    System.out.print("Enter the contact's email address:");
                    String emailAddress1 = input.nextLine();
                    System.out.print("Enter the contact's address: ");
                    String address1 = input.nextLine();
                    System.out.print("Enter the contact's birthday:");
                    String birthday1 = input.nextLine();
                    System.out.print("Enter any notes for the contact:");
                    String notes1 = input.nextLine();
                    Contact c = new Contact(contactName1, phoneNumber1, emailAddress1, address1, birthday1, notes1);
                    p.AddContact(c);

                    break;

                case 2:
                    int choice2 = submenu2();
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
                            System.out.println("Enter the contact's Phone Number:");
                            String phonNumber = input.nextLine();
                            phonNumber =input.nextLine();

                            if (contacts.SearchByPhoneNumber(phonNumber) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByPhoneNumber(phonNumber)).display();
                            }
                            break;
                        case 3:
                            System.out.println("Enter the contact's email:");
                            String email1 = input.nextLine();
                            email1 =input.nextLine();
                            if ((contacts.SearchByEmail(email1)) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByEmail(email1)).display();
                            }
                            break;
                        case 4:
                            System.out.println("Enter the contact's Address");
                            String address2 = input.nextLine();
                            address2 =input.nextLine();
                            if ((contacts.SearchByAddress(address2)) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByAddress(address2)).display();
                            }
                            break;
                        case 5:
                            System.out.println("Enter the contact's Birthday:");
                            String bday = input.nextLine();
                            bday =input.nextLine();
                            if ((contacts.SearchByBirthday(bday)) == null) {
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByBirthday(bday)).display();
                            }
                            break;

                    }

                    break;

                case 3://ma yktb r8m 3 nfs 7
                    System.out.println("Enter cotact name:");

                    DeleteContact(input.nextLine());
                    System.out.println("contact deleted");
                    break;

                case 4:
                    System.out.print("Enter event title:");
                    String title = input.nextLine();
                     title =input.nextLine();
                    System.out.print("Enter contact name:");
                    String name = input.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY:MM):");
                    String date = input.next();
                    String time = input.nextLine();
                    System.out.print("Enter event location:");
                    String location = input.nextLine();

                    Event eventt = new Event(title, date, time, location);
                    schedulingEvent(eventt, name);

                    break;// anouddddddddd helppppp

                case 5:
                    int pick = searchCriteria();
                    switch (pick) {
                        case 1:
                            System.out.println("Enter the contact name:");
                            String Cname = input.nextLine();
                            Cname = input.nextLine();
                            Event event2 = searchEventContact(Cname);
                            if (event2 != null) {
                                System.out.println("Event found!");
                                event2.display();
                            } else {
                                System.out.println("Event not found!");
                            }

                            break;
                        case 2:
                            System.out.print("Enter the event title:");
                            String title1 = input.nextLine();
                            title1 = input.nextLine();
                            Event event3 = searchEventTitle(title1);
                            if (event3 != null) {
                                System.out.println("Event found!");
                                event3.display();
                                break;
                            } else {
                                System.out.println("Event not found!");
                                
                            }

                            break;
                            
                            
                    }

                case 6://error
                    System.out.println("Enter the contact's first name:");
                    String firstname=input.next();
                    //firstname=input.nextLine();
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

                case 7://ma yktb r8m 7 nfs 3
                    PrintAllEvents();
                    break; // anouddd helpp

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
