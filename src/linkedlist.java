/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

package project;

public class linkedlist<t> 
{
 private node<t> head;
 private node<t> current;
 node<t> next;

    public linkedlist(node<t> h) {
        head = h;
        next = null;
    }


public void add(t nweContact) 
{
        if (head == null) 
            head = new node<t>(nweContact);
       
        else
          current.next=nweContact;
        System.out.println("Contact added successfully!");
        
}

public node<t> searchbyName(String name)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<t>)current.getData().getContactName()==(node<t>)search.getData().getContactName())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<t> searchbyemail(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<t>)current.getData().getEmailAddress()==(node<t>)search.getData().getEmailAddress())
             return current;
         else 
           current=current.next;
     }
    return null; 
}
public node<t> searchbphonenum(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<t>)current.getData().getPhoneNumber()==(node<t>)search.getData().getPhoneNumber())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<t> searchbyaddress(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<t>)current.getData().getAddress()==(node<t>)search.getData().getAddress())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public node<t> searchbybirthday(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if ((node<t>)current.getData().getBirthday()==(node<t>)search.getData().getBirthday())
             return current;
         else 
           current=current.next;
     }
    return null; 
}

public void deletContact(node<t> delet)
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

