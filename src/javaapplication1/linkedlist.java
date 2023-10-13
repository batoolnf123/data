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
        head=current= h;

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
        if (head == null) { //1 s
            return null;  //1
        } else {
            current = head;//1
        }// 2

        while (current != null) { //n+1
        
            if (((Contact) current.getData()).getContactName().equals(name)) {//n(1)
                return (Contact) current.getData();//1(n)
            } 
                current = current.next;//1
            }
        
        return null;//1
    }

    public linkedlist<Contact> SearchByEmail(String email) //joury //0
    {
                        linkedlist<Contact> list=new linkedlist<Contact>();

        if (head == null) { //1
            return null; //1
        } else {
            current = head;//1
        }

        while (current != null) {//n+1
            if (((Contact) current.getData()).getEmailAddress().equals(email)) {//{n(1)
                 list.insert((  Contact)current.getData());
            } 
                current = current.next;// n*1
    }

        
        return list;
    }

    public linkedlist<Contact> SearchByPhoneNumber(String num) //joury 
    {
      linkedlist<Contact> list=new linkedlist<Contact>();

        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getPhoneNumber().equals(num)) {
                 list.insert((  Contact)current.getData());
            }
                current = current.next;
            
        }

        return list;
    }

    public linkedlist<Contact> SearchByAddress(String add) //joury
    {
                linkedlist<Contact> list=new linkedlist<Contact>();

        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getAddress().equals(add)) {
                 list.insert((  Contact)current.getData());
            } 
                current = current.next;
            
        }

        return list;
    }

    public linkedlist<Contact> SearchByBirthday(String birth) //joury
    {
        linkedlist<Contact> list=new linkedlist<Contact>();
        if (head == null) {
            return null;
        } else {
            current = head;
        

        while (current != null) {
            if (((Contact) current.getData()).getBirthday().equals(birth)) 
                 list.insert((  Contact)current.getData());
                current = current.next;
        }
      
        return list;
    }}
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
    
    public void addSortedContact(T d) //joury 
    { 
        node<T> p=new node<T>(d);
        //case1
     if (head == null) 
            head = current=p;
            //case2
   else
     {//if smaller than first
         if(((Contact)d).compareTo((Contact)head.data<0)
            {p.next=head;
             head=p
                 return;
            }
         else{
             node<T>r=head,q=null;
             while(r!=null&&(((Contact)r.data).compareTo((Contact)d)<=0)){
                 q=r;
                 r=r.next;
             }
             q.next=p;
             p.next=r;}}
         
    
    
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
