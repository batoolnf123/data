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

    static linkedlist<Contact> contacts;
public static Scanner input = new Scanner (System.in);
    public PhoneBook() {
        contacts = new linkedlist<Contact>();
    }

    public PhoneBook(linkedlist<Contact> contacts) {
        this.contacts = contacts;
    }

    public static void AddSortedUser(Contact d) {
        if (contacts.isEmpty()) {
            contacts.insert(d);
            System.out.println("contact added successfully");
            return;
        } else {
            contacts.findfirst();
            if (d.CompareTo(contacts.retrieve().getContactName()) < 0) {
                Contact c = new Contact(contacts.retrieve());
                contacts.update(d);
                contacts.insert(c);
                System.out.println("contact added successfully");
                return;
            } else {
                while (!contacts.last() && (contacts.retrieve().CompareTo(d.getContactName()) <= 0)) {
                    contacts.findnext();
                }

                if (contacts.retrieve().CompareTo(d.getContactName()) > 0) {
                    Contact c = new Contact(contacts.retrieve());
                    contacts.update(d);
                    contacts.insert(c);
                    System.out.println("contact added successfully");
                } else {
                    d.display();
                    contacts.insert(d);
                }
            }
        }
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

    public static void AddContact(Contact c) {
        boolean found = search(c);
        if (!found) {
            AddSortedUser(c);
        }
        else
            System.out.println("contact couldn't be added");
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
    public static int menu ()
    {
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
    public static int submenu2()
    {
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
    public static int submenu5()
    {
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
            switch (choice)
            {
                case 1:
                     c.read_contact();
                    AddContact(c);
                    break;
                
                case 2:
                   int choice2 = submenu2();
                   switch (choice2){
                       case 1:
                            System.out.println("Enter the contact's name:");
        String name = input.nextLine();
        c.setContactName(name);
                           searchbyName(c.getContactName());
                           break;
                       case 2:
                                 System.out.println("Enter the contact's Phone Number:");
        String phonNumber = input.nextLine();
        c.setPhoneNumber(phonNumber);
                           searchbyphonenum(c.getPhoneNumber());
                           break;
                       case 3:
                            System.out.println("Enter the contact's email:");
        String email1 = input.nextLine();
        c.setEmailAddress(email1);
                           searchbyemail(c.getEmailAddress());
                           break;
                       case 4:
                            System.out.println("Enter the contact's Address");
        String address1 = input.nextLine();
        c.setAddress(address1);
                           searchbyaddress(c.getAddress());
                           break;
                       case 5:
                            System.out.println("Enter the contact'sBirthday:");
        String bday = input.nextLine();
        c.setBirthday(bday);
                           searchbybirthday(c.getBirthday());
                           break;
                   }
                    ;
                    break;
                
                case 3:
                    DeleteContact(c.getContactName());
                    break;
                
                case 4:
                    ScheduleEvent();
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
                default :
                    System.out.println("Bad choice! Try again");
            }
            System.out.println("\n\n");
        }while (choice != 8);
    }
       
}
