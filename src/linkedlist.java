/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

package project;

public class linkedlist<Contact> 
{
 private node<Contact> head;
 private node<Contact> current;
 node<Contact> next;

    public linkedlist(node<Contact> h) {
        head = h;
        next = null;
    }


public void add(Contact nweContact) 
{
        if (head == null) 
            head = new node<Contact>(nweContact);
       
        else
          current.next=nweContact;
        System.out.println("Contact added successfully!");
        
}

public node<Contact> searchbyName(String name)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<Contact>)current.getData().getContactName()==(node<t>)search.getData().getContactName())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<Contact> searchbyemail(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<Contact>)current.getData().getEmailAddress()==(node<Contact>)search.getData().getEmailAddress())
             return current;
         else 
           current=current.next;
     }
    return null; 
}
public node<Contact> searchbphonenum(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<Contact>)current.getData().getPhoneNumber()==(node<Contact>)search.getData().getPhoneNumber())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<Contact> searchbyaddress(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<Contact>)current.getData().getAddress()==(node<Contact>)search.getData().getAddress())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<Contact> searchbybirthday(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<Contact>)current.getData().getBirthday()==(node<Contact>)search.getData().getBirthday())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public void deletContact(node<Contact> delet)
{
 if (head==null)
     return;
 else current=head;
 while(current!=null)
 {
     if(current.data==delet.data)
         current.prev.next=current.next;
     current=current.next;
 }
     
}

    public void printList()
    {
        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }
   
}

