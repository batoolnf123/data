/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

package project;

public abstract class Contact implements Comparable
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
    
    public int ComparTo(String first, String second)
    {
        if (first.compareTo(second)==0)
            return 0;
         if (first.compareTo(second)>0)
            return 1;
         else return -1;
            
    }
    
 @Override
     public void display(){
     System.out.println("Contact: "+contactName+ " phone number: "+phoneNumber+ "email address: "+ emailAddress+"address: "
             +address+"birthday: "+birthday+"notes: "+notes);
 }
}