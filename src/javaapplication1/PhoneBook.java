package javaapplication1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

import java.util.Scanner;
public class PhoneBook {
 static linkedlist<Contact>contacts;

    public PhoneBook() {
        contacts=new linkedlist<Contact>();
    }
public PhoneBook(linkedlist<Contact>contacts){
    this.contacts=contacts;
}
public void AddSortedUser(Contact d){
    if(contacts.isEmpty()){
        contacts.insert(d);
        return;
    }else
    {contacts.findfirst();
    if(d.CompareTo(contacts.retrieve().getContactName())<0){
        Contact c=new Contact(contacts.retrieve());
        contacts.update(d);
        contacts.insert(c);
        return;
    }else{
        while(!contacts.last()&&(contacts.retrieve().CompareTo(d.getContactName())<=0)){
            contacts.findnext();
        }
        
        
        if(contacts.retrieve().CompareTo(d.getContactName())>0)
        {
        Contact c=new Contact(contacts.retrieve());
        contacts.update(d);
        contacts.insert(c);
        }else
        { d.display();
        contacts.insert(d);
        }
    }
    }
}
public boolean search(Contact c){
        if(contacts.isEmpty())
            return false;
        contacts.findfirst();
        while(!contacts.last()){
            if(contacts.retrieve().getContactName().equals(c.getContactName())
                ||contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber()))
                return true;
            contacts.findnext();}
        if(contacts.retrieve().getContactName().equals(c.getContactName())
                ||contacts.retrieve().getPhoneNumber().equals(c.getPhoneNumber()))
                return true;
            else 
                return false;       
        
}
public void AddContact(Contact c)
{
    boolean found=search(c);
    if(!found)
    {
       AddSortedUser(c);
    }
}
public void DeleteContact(String m){
    if(contacts.isEmpty()){
        System.out.println("Can't delete an empty list");
        return;
    }
    contacts.findfirst();
    while(!contacts.last()){
        if(contacts.retrieve().getContactName().equals(m)){
            contacts.remove();
            System.out.println(m+" This contact has been deleted");
            return;
        }
        contacts.findnext();
    }
    if(contacts.retrieve().getContactName().equals(m)){
        contacts.remove();
        System.out.println(m+" This contact has been deleted");
    }
    
}
  public Contact searchbyName(String name) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getContactName().equals(name)) {
                return (Contact) current.getData();
            } else {
                current = current.next;
            }
        }
        return null;
    }

    public Contact searchbyemail(String email) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getEmailAddress().equals(email)) {
                return (Contact) current.getData();
            } else {
                current = current.next;
            }

        }
        return null;
    }

    public Contact searchbyphonenum(String num) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getPhoneNumber().equals(num)) {
                return (Contact) current.getData();
            } else {
                current = current.next;
            }
        }

        return null;
    }

    public Contact searchbyaddress(String add) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getAddress().equals(add)) {
                return (Contact) current.getData();
            } else {
                current = current.next;
            }
        }

        return null;
    }

    public Contact searchbybirthday(String birth) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getBirthday().equals(birth)) {
                return (Contact) current.getData();
            } else {
                current = current.next;
            }
        }
        return null;
    }
}
