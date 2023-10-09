package javaapplication1;



import java.util.Scanner;

public class Contact implements Comparable<Contact> {

    public String contactName;
    public String phoneNumber;
    public String emailAddress;
    public String address;
    public String birthday;
    public String notes;
    
    //might add attribute
    //public linkedlist<Event> contactEvent = new linkedlist<Event>(); //anoud

    public Contact() //  costructor joury
    {
    }

    public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday, String notes) //copy costructor joury
    {
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    public Contact(Contact contact1) //joury 
    {
        contactName = contact1.getContactName();
        phoneNumber = contact1.getPhoneNumber();
        emailAddress = contact1.getEmailAddress();
        address = contact1.getAddress();
        birthday = contact1.getBirthday();
        notes = contact1.getNotes();
    }

    public void setContactName(String contactName) //joury
    {
        this.contactName = contactName;
    }

    public void setPhoneNumber(String phoneNumber) //joury
    {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) //joury
    {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) //joury
    {
        this.address = address;
    }

    public void setBirthday(String birthday) //joury
    {
        this.birthday = birthday;
    }

    public void setNotes(String notes) //joury
    {
        this.notes = notes;
    }

    public String getContactName() //joury
    {
        return contactName;
    }

    public String getPhoneNumber() //joury
    {
        return phoneNumber;
    }

    public String getEmailAddress() //joury
    {
        return emailAddress;
    }

    public String getAddress() //joury
    {
        return address;
    }

    public String getBirthday() //joury
    {
        return birthday;
    }

    public String getNotes() //joury
    {
        return notes;
    }

    public void read_contact() { //Batool
        Scanner read = new Scanner(System.in);
        System.out.println("Enter the contact's name:");
        contactName = read.nextLine();
        System.out.println("Enter the contact's phone number:");
        phoneNumber = read.nextLine();
        System.out.println("Enter the contact's email address:");
        emailAddress = read.nextLine();
        System.out.println("Enter the contact's address: ");
        address = read.nextLine();
        System.out.println("Enter the contact's birthday:");
        birthday = read.nextLine();
        System.out.println("Enter any notes for the contact:");
        notes = read.nextLine();
    }

    @Override
    public void display() //joury
    {
        System.out.println("Contact: " + contactName + " phone number: " + phoneNumber + "email address: " + emailAddress + "address: "
                + address + "birthday: " + birthday + "notes: " + notes);
    }

    @Override
    public int CompareTo(String second) //joury
    {
        if (getContactName().compareTo(second) == 0) {
            return 0;
        } else if (getContactName().compareTo(second) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
}
