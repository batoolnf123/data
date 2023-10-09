package javaapplication1;



public class linkedlist<T> {

    private node<T> head;
    private node<T> current;

    public linkedlist() {
    }

    
    public linkedlist(node<T> h) //joury
    {
        head = h;

    }

public void add(T nweContact) //joury
{
     if (search(nweContact)) {
             System.out.println("this contact is already exist");
     return;}
        if (head == null) 
            head = new node<T> (nweContact);
       
        else
          current.next=new node<T>(nweContact);
        current = current.next;
        System.out.println("Contact added successfully!");
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

     public void searchbyName(String name) //joury
    {
        if (head == null) {
            System.out.println("no contact");
            return;
        } else {
            current = head;

            while (current != null) {
                if (((Contact) current.getData()).getContactName().equals(name)) {
                    System.out.println((Contact) current.getData());
                    return ;}
                    current = current.next;
                }
            }
        }
    
    public void searchbyemail(String email) //joury
    {
        if (head == null) {
            System.out.println("no contact");
            return;
        } else {
            current = head;
            while (current != null) {
                if (((Contact) current.getData()).getEmailAddress().equals(email)) {
                    System.out.println((Contact) current.getData());
                    return;}
                                current = current.next;

                }

            }
        }

    

    public void searchbyphonenum(String num) //joury
    {
        if (head == null) {
            System.out.println("no contact");

            return;
        } else {
            current = head;
            while (current != null) {
                if (((Contact) current.getData()).getPhoneNumber().equals(num)) {
                    System.out.println((Contact) current.getData());

                    return;}

                 
                    current = current.next;
                
            }

        }
    }

    public void searchbyaddress(String add) //joury
    {
        if (head == null) {

            return;
        } else {
            current = head;

            while (current != null) {
                if (((Contact) current.getData()).getAddress().equals(add)) {
                    System.out.println((Contact) current.getData());

                    return;
                }  
                    current = current.next;
                
            }

        }
    }

    public void searchbybirthday(String birth) //joury
    {
        if (head == null) {
            System.out.println("no contact");

            return;
        } else {
            current = head;

            while (current != null) {
                if (((Contact) current.getData()).getBirthday().equals(birth)) {
                    System.out.println((Contact) current.getData());

                    return;
                } 
                    current = current.next;
                
            }
        }
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

}





