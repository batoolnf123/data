package javaapplication1;



import javaapplication1.Comparable;
import java.util.Scanner;

public class Contact implements Comparable<Contact>
{
 private String contactName;
 private String phoneNumber;
 private String emailAddress;
 private String address;
 private String  birthday;
 private String notes;

    public Contact() //costructor
    {
    }

    public Contact(String contactName, String phoneNumber, String emailAddress, String address, String birthday, String notes) //copy costructor
    {    
        this.contactName = contactName;
        this.phoneNumber = phoneNumber;
        this.emailAddress = emailAddress;
        this.address = address;
        this.birthday = birthday;
        this.notes = notes;
    }

    public void Contact(Contact contact)
    {
        contactName = contact.getContactName();
        phoneNumber = contact.getPhoneNumber();
        emailAddress = contact.getEmailAddress();
        address = contact.getAddress();
        birthday = contact.getBirthday();
        notes = contact.getNotes();    
    }
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setEmailAddress(String emailAddress) {
        this.emailAddress = emailAddress;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public void setNotes(String notes) {
        this.notes = notes;
    }
  
 public String getContactName() {
        return contactName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getEmailAddress() {
        return emailAddress;
    }

    public String getAddress() {
        return address;
    }

    public String getBirthday() {
        return birthday;
    }

    public String getNotes() {
        return notes;
    }
    
   
    public void read_contact(){
      Scanner read=new Scanner(System.in);
      System.out.println("Enter the contact's name:");
      contactName=read.nextLine();
      System.out.println("Enter the contact's phone number:");
      phoneNumber =read.nextLine();
      System.out.println("Enter the contact's email address:");
      emailAddress=read.nextLine();
      System.out.println("Enter the contact's address: ");
      address=read.nextLine();
      System.out.println("Enter the contact's birthday:");
      birthday=read.nextLine();
      System.out.println("Enter any notes for the contact:");
      notes=read.nextLine();
  }  
 @Override
     public void display(){
     System.out.println("Contact: "+contactName+ " phone number: "+phoneNumber+ "email address: "+ emailAddress+"address: "
             +address+"birthday: "+birthday+"notes: "+notes);
 }

    @Override
    public int CompareTo(String second) {
   if (getContactName().compareTo(second)==0)
            return 0;
        else   if (getContactName().compareTo(second)>0)
            return 1;
         else return -1;
                }
}
