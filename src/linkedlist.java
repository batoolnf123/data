package project;

public class linkedlist<T> 
{
 private node<T> head;
 private node<T> current;


    public linkedlist(node<T> h) {
        head = h;
        
    }


public void add(T nweContact) 
{
        if (head == null) 
            head = new node<T> (nweContact);
       
        else
          current.next=new node<T>(nweContact);
        System.out.println("Contact added successfully!");
        
}

public Contact searchbyName(String name)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if (((Contact)current.getData()).getContactName().equals(name))
             return (Contact)current.getData();
         else 
           current=current.next;
     }
    return null; 
}

public Contact searchbyemail(String email)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if (((Contact)current.getData()).getEmailAddress().equals(email))
             return (Contact)current.getData();

         else 
             current=current.next;

             }
    return null; 
}
public Contact searchbyphonenum(String num)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if (((Contact)current.getData()).getPhoneNumber().equals(num))
             
             return (Contact)current.getData();
         else 
           current=current.next;
     }
    return null; 
}

public Contact searchbyaddress(String add)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if (((Contact)current.getData()).getAddress().equals(add))
             
             return (Contact)current.getData();
         else 
           current=current.next;
     }
    return null; 
}

public Contact searchbybirthday(String birth)
{
 if (head==null)
     return null;
 else
     current=head;
     while(current!=null)
     {
         if (((Contact)current.getData()).getBirthday().equals(birth))
             
           return (Contact)current.getData();

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
