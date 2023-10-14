package javaapplication1;



public class linkedlist<T> {

    private node<T> head;
    private node<T> current;

    public linkedlist() {

    }

    public linkedlist(node<T> h) //joury
    {
        head =current = h;

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
        }
    }

    public Contact searchByName(String name) //joury
    {
        if (head == null) {
            return null;
        } 
         
            current = head;
    
        while (current != null) {
            
            
            if (((Contact) current.getData()).getContactName().equals(name)) {
                return (Contact) current.getData();
            }
            current = current.next;
        }

        return null;
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

    /*public boolean search(T x) {
        node<T> temp = head;
        while (temp != null) {
            if (temp.data.equals(x)) {
                return true;
            } else {
                temp = temp.next;
            }
        }
        return false;
    }*/
//    batool wrote insert and search, Joury wrote the rest

    
 




    public void addSortedContact(T d) //joury 
    {
        node<T> p = new node<T>(d);
        //case1
        if (head == null) {
            head = p;
            current = p;
        } //case2
        else {//if smaller than first
            if (((Contact) d).CompareTo((Contact) head.data) < 0) {
                p.next = head;
                head = p;
                return;
            } else {
                node<T> r = head, q = null;
                while (r != null && (((Contact) r.data).CompareTo((Contact) d) <= 0)) {
                    q = r;
                    r = r.next;
                }
                q.next = p;
                p.next = r;
            }
        }
    }

    public void addSortedEvent(T d) //anoud
    {
        node<T> p = new node<T>(d);
        //case1
        if (head == null) {
            head = current = p;
        } //case2
        else {//if smaller than first
            if (((Event) d).CompareTo((Event) head.data) < 0) {
                p.next = head;
                head = p;
                return;
            } else {
                node<T> r = head, q = null;
                while (r != null && (((Event) r.data).CompareTo((Event) d) <= 0)) {
                    q = r;
                    r = r.next;
                }
                q.next = p;
                p.next = r;
            }
        }

    }
}
