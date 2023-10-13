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

    public static boolean search1(Contact c) {

        if (contacts.isEmpty()) 
            return false;
        
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
        }  else{ 
            return false;
        }

    }

    public static linkedlist<Contact> searchByFirstName(String name) //joury
    {

        if (contacts.isEmpty()) {
            System.out.println("No contacts with this first name!");
            return null;
        }

        contacts.findfirst();

        linkedlist<Contact> ContactsList = new linkedlist<Contact>();

        while (!contacts.last()) {
            int fName = name.indexOf(" ");
            if (((Contact) contacts.retrieve()).getContactName().substring(0, fName).equals(name)) {
                ContactsList.addSortedContact(contacts.retrieve());
            }

            contacts.findnext();
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

    public static Event searchEventContact(String n) { //anoud check after bool//total=3n+4
        if (events.isEmpty()) {//1
            return null;//1
        }//tot=1
        events.findfirst();//1 
        while (!events.last()) {//n+1
            if (events.retrieve().getContactName().equals(n)) {//n(1)=n//not sure
                return events.retrieve();//n*1+1=n//not sure
            }

            events.findnext();//n
        }//3n+2=n

        if (events.retrieve().getContactName().equals(n)) {//1
            return events.retrieve();//1
        } else {
            return null;//1
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
        boolean found = search1(c);
        if (!found) {
            contacts.addSortedContact(c);
            
        } else {
            System.out.println("contact couldn't be added");
        }
    }

    public static void AddEvent(Event e) {//check
        Event found = searchEventTitle(e.getTitle());
        if (found == null) {
            events.addSortedEvent(e);
        }

    }
/*public static void deletevent(Contact con){
        con.contactEvents.findfirst();
        while(!con.contactEvents.last())
        {
      if(con.contactEvents.retrieve().contactsinEvent.isEmpty())
          
          
          
          
        }
    
} */
    public static void DeleteContact(String m) {
        Contact con;
        if (contacts.isEmpty()) {
            System.out.println("Can't delete an empty list");
            return;
        }
        contacts.findfirst();
        while (!contacts.last()) {
            if (contacts.retrieve().getContactName().equals(m)) {
                con=contacts.retrieve();
               // deletevent(con);
                contacts.remove();
                System.out.println(m + " This contact has been deleted");// check 
                
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
        if (!events.isEmpty()) {  //1
            events.findfirst();//1
            while (!events.last()) {//n+1
                // for (int i = 0 ; i < events.size  ; i++) and del the rep 

                System.out.println(events.retrieve().getTitle());//n not sure
                events.findnext();//n*1
            }
            System.out.println(events.retrieve().getTitle());//1 

        }//tot 4+3n 
        else {
            System.out.println("There are no events to print");//2
        }
    }//o(n)

    public static void schedulingEvent(Event event1, String name) { //anoud

        Contact contact1 = contacts.searchByName(name);//search in all contacts or in ev contact?//1

        if (contact1 != null && !hasConflict(event1, contact1)) {//1

            contact1.contactEvents.addSortedEvent(event1); //imp? //

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
        } else {
            return false;
        }

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
                    input.nextLine();
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
                    p.AddContact(c);//first big o
                    break;

                case 2:
                    int choice2 = submenu2();
                    switch (choice2) {
                        case 1:
                            System.out.print("Enter the contact's name:");
                            String name = input.nextLine();
                            input.nextLine();
                            if (contacts.searchByName(name) == null) {//second big o
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.searchByName(name)).display();//second big o
                            }

                            break;
                        case 2:
                            System.out.println("Enter the contact's Phone Number:");
                            String phonNumber = input.nextLine();
                            input.nextLine();

                            if (contacts.SearchByPhoneNumber(phonNumber) == null) {//second big o
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByPhoneNumber(phonNumber)).display();//second big o
                            }
                            break;
                        case 3:
                            System.out.println("Enter the contact's email:");
                            String email1 = input.nextLine();
                            input.nextLine();
                            if ((contacts.SearchByEmail(email1)) == null) {//second big o
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByEmail(email1)).display();//second big o
                            }
                            break;
                        case 4:
                            System.out.println("Enter the contact's Address");
                            String address2 = input.nextLine();
                            input.nextLine();
                            
                            if ((contacts.SearchByAddress(address2)) == null) {//second big o
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByAddress(address2)).display();//second big o
                            }
                            break;
                        case 5:
                            System.out.println("Enter the contact's Birthday:");
                            String bday = input.nextLine();
                            input.nextLine();
                            if ((contacts.SearchByBirthday(bday)) == null) {//second big o
                                System.out.println("Contact not found!");
                            } else {
                                System.out.println("Contact found!");

                                (contacts.SearchByBirthday(bday)).display();//second big o
                            }
                            break;

                    }

                    break;

                case 3:
                    input.nextLine();
                    System.out.println("Enter cotact name:");
                    
                   p.DeleteContact(input.nextLine());//second big o
                    break;

                case 4:
                    System.out.print("Enter event title:");
                    String title = input.nextLine();
                    input.nextLine();
                    System.out.print("Enter contact name:");
                    String name = input.nextLine();
                    System.out.print("Enter event date and time (MM/DD/YYYY:MM):");
                    String date = input.next();
                    String time = input.nextLine();
                    System.out.print("Enter event location:");
                    String location = input.nextLine();

                    Event eventt = new Event(title, date, time, location);
                    schedulingEvent(eventt, name);//second big o

                    break;// anouddddddddd helppppp

                case 5:
                    int pick = searchCriteria();
                    switch (pick) {
                        case 1:
                            System.out.println("Enter the contact name:");
                            String Cname = input.nextLine();
                            Event event2 = searchEventContact(Cname);//second big o
                            if (event2 != null) {
                                System.out.println("Event found!");
                                event2.display();//second big o
                            } else {
                                System.out.println("Event not found!");
                            }

                            break;
                        case 2:
                            System.out.print("Enter the event title:");
                            String title1 = input.nextLine();
                            Event event3 = searchEventTitle(title1);//second big o
                            if (event3 != null) {
                                System.out.println("Event found!");
                                event3.display();//second big o
                            } else {
                                System.out.println("Event not found!");
                            }

                            break;
                    }

                case 6:
                    System.out.println("Enter the contact's first name:");
                    linkedlist<Contact> contactList = searchByFirstName(input.nextLine());//second big o

                    if (contactList == null) {//1
                        break;//1 not sure
                    }
                    contactList.findfirst();//second big o ,o(1)
                    while (!contactList.last()) {//second big o, n+1
                        contactList.retrieve().display();//second big o,n*1+5
                        contactList.findnext();//second big o, n+1

                    }

                    contactList.retrieve().display();//second big o , 1+5

                    break;

                case 7:
                    PrintAllEvents();//second big o 
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
