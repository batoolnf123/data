package javaapplication1;



public class linkedlist<T> {

    private node<T> head;
    private node<T> current;

    public linkedlist() //joury
    {
        
        current = null;
       head= null;
    
    }

    
    public linkedlist(node<T> h) //joury
    {
        head = h;

    }



   

    public void deletContact(node<Contact> delet) //joury
    {
        if (head == null) {
            return;
        } else {
            current = head;
        }
        while (current != null) {
            if (current.data == delet.data) {
                current.prev.next = current.next;
            }

            current = current.next;
        }}

         public Contact searchByName(String name) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getContactName().equals(name)) {
                return (Contact) current.getData();
            } 
                current = current.next;
            }
        
        return null;
    }

    public Contact SearchByEmail(String email) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getEmailAddress().equals(email)) {
                return (Contact) current.getData();
            } 
                current = current.next;
            }

        
        return null;
    }

    public Contact SearchByPhoneNumber(String num) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getPhoneNumber().equals(num)) {
                return (Contact) current.getData();
            }
                current = current.next;
            
        }

        return null;
    }

    public Contact SearchByAddress(String add) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getAddress().equals(add)) {
                return (Contact) current.getData();
            } 
                current = current.next;
            
        }

        return null;
    }

    public Contact SearchByBirthday(String birth) //joury
    {
        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getBirthday().equals(birth)) {
                return (Contact) current.getData();
            } 
                current = current.next;
            }
        
        return null;
    }
    public void printList() //joury
    {
        current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    public boolean isEmpty() //joury
    {
        return head == null;
    }

    public boolean last() //joury
    {
        return current.next == null;
    }

    public void findfirst() //joury
    {
        current = head;
    }

    public void findnext() //joury
    {
        current = current.next;
    }

    public T retrieve() //joury
    {
        return current.data;
    }

    public void update(T x) //joury
    {
        current.data = x;
    }

    public boolean full() //joury
    {
        return false;
    }

    public void remove() //joury
    {
        if (current == head) {
            head = head.next;
        } else {
            node<T> extranode = head;

            while (extranode.next != current) {
                extranode = extranode.next;
            }

            extranode.next = current.next;
        }
        if (current.next == null) {
            current = head;
        } else {
            current = current.next;
        }
    }

    public void insert(T d) {
        node<T> p = new node<T>(d);
        if (head == null) {
            head = p;
            current = p;
        } else {
            p.next = current.next;
            current.next = p;
            current = p;
        }
    }

    public boolean search(T x) {
        node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(x)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }
//    batool wrote insert and search, Joury wrote the rest
    
    public void addSortedContact(T x) //joury 
    { 
        node<T> nweContact=new node<T>(x);
        //case1
     if (head == null) 
            head = current=nweContact;
            //case2
   else     if (search(x)) {
            System.out.println("this contact is already exist");
                return; }
            //case3
            else 
            if(((Contact)x).CompareTo(((Contact) head.data).getContactName())==0){
                  current.next=nweContact;
                  current=nweContact;
           } //case4
             else
           if(((Contact)x).CompareTo(((Contact) head.data).getContactName())<0){
              nweContact.next=head;
              head=nweContact;
           }
           //case5 
           else{
            node<T> current2=head;
            node<T> pointer=null;
           
      while(current2!=null && (((Contact)current2.data).CompareTo(((Contact)x).getContactName())<=0))  
      {
          pointer=current2;
          current2=current2.next;
      }
      pointer.next=nweContact;
      nweContact.next=pointer; }  
     
      System.out.println("Contact added successfully!");

      }   
     
    public void addSortedEvent(T x)  
    { 
        node<T> newEvent=new node<T>(x);
        //case1
     if (head == null) 
            head = current=newEvent;
            //case2
   else     if (search(x)) {
            System.out.println("this event already exists");
                return; }
            //case3
            else 
            if(((Event)x).CompareTo(((Event) head.data).getContactName())==0){
                  current.next=newEvent;
                  current=newEvent;
           } //case4
             else
           if(((Event)x).CompareTo(((Event) head.data).getContactName())<0){
             newEvent.next=head;
              head=newEvent;
           }
           //case5 
           else{
            node<T> current2=head;
            node<T> pointer=null;
           
      while(current2!=null && (((Event)current2.data).CompareTo(((Event)x).getContactName())<=0))  
      {
          pointer=current2;
          current2=current2.next;
      }
      pointer.next=newEvent;
      newEvent.next=pointer; }  
     
      System.out.println("Event added successfully!");

      }   
}
