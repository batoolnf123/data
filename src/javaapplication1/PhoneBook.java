package javaapplication1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
/**
 *
 * @author batoolalfouzan
 */
import java.util.Date;

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
        }
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
        } else {
            return false;
        }

    }

    //new? add ev/search t and cn ev/sched/ printallev / dis ev done. +wtvr m did? 
    public static Event searchEventTitle(String n) { //anoud check after bool
        if (events.isEmpty()) {
            return null;
        }
            events.findfirst();
            while (!events.last()) {
                if (events.retrieve().getTitle().equals(n)) 
                    return events.retrieve();
              
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
                if (events.retrieve().getContactName().equals(n)) 
                    return events.retrieve();
              
                events.findnext();
            }

            if (events.retrieve().getContactName().equals(n)) {
                return events.retrieve();
        } else {
            return null;
        }
       
    }
    
    
    
    
    
    

    public static void AddContact(Contact c) {
        boolean found = search(c);
        if (!found) {
            contacts.addSortedContact(c);
        } else {
            System.out.println("contact couldn't be added");
        }
    }

    public static void AddEvent(Event e) {//check
        Event found = searchEventTitle(e.getTitle());
        if (found==null) {
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
    
    

    public void schedulingEvent(Event event1, String name) { //anoud

        Contact contact1 = contacts.searchByName(name);//search in all contacts or in ev contact?

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

    public boolean hasConflict(Event e1, Contact c1) {
        Linkedlist<>
    
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

    public static int submenu5() {
        System.out.println("Enter search criteria:");
        System.out.println("1. contact name");
        System.out.println("2. Event tittle");
        System.out.println("\nEnter your choice: ");
        int choice = input.nextInt();
        return choice;
    }

    public static void main(String[] args) {

        System.out.println("Welcome to the Linked List Phonebook!");
        int choice;
        Contact c = new Contact();

        do {
            choice = menu();
            switch (choice) {
                case 1:
                    c.read_contact();
                    AddContact(c);
                    break;

                case 2:
                    int choice2 = submenu2();
                    switch (choice2) {
                        case 1:   
                            System.out.println("Enter the contact's name:");
                            String name = input.nextLine();
                           
                          
                            if(contacts.searchByName(name)==null)
                                  System.out.println("Contact not found!");
                            else{System.out.println("Contact found!");
                                
                            (contacts.searchByName(name)).displayContact();
                            }
                                
                            break;
                        case 2:
                            System.out.println("Enter the contact's Phone Number:");
                            String phonNumber = input.nextLine();
                            
                            if(contacts.SearchByPhoneNumber(phonNumber)==null)
                                  System.out.println("Contact not found!");
                            else{System.out.println("Contact found!");
                                
                            (contacts.SearchByPhoneNumber(phonNumber)).displayContact();
                            }
                            break;
                        case 3:
                            System.out.println("Enter the contact's email:");
                            String email1 = input.nextLine();
                            if((contacts.SearchByEmail(email1))==null)
                                System.out.println("Contact not found!");
                            else{System.out.println("Contact found!");
                                
                            (contacts.SearchByEmail(email1)).displayContact();
                            }
                            break;
                        case 4:
                            System.out.println("Enter the contact's Address");
                            String address1 = input.nextLine();
                            if((contacts.SearchByAddress(address1))==null)
                                System.out.println("Contact not found!");
                            else{System.out.println("Contact found!");
                                
                            (contacts.SearchByAddress(address1)).displayContact();
                            }
                            break;
                        case 5:
                            System.out.println("Enter the contact's Birthday:");
                            String bday = input.nextLine();
                            if((contacts.SearchByBirthday(bday))==null)
                                System.out.println("Contact not found!");
                            else{System.out.println("Contact found!");
                                
                            (contacts.SearchByBirthday(bday)).displayContact();
                            }
                            break;
                        
                    }
                    ;
                    break;

                case 3:
                    DeleteContact(c.getContactName());
                    break;

                case 4:
                    schedulingEvent();
                    break;// anouddddddddd helppppp

                case 5:
                    PrintEvent();
                    break;

                case 6:
                    System.out.println("Enter the contact's first name:");
                    String name = input.nextLine();
                    c.setContactName(name);
                    display();
                    break;

                case 7:
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
