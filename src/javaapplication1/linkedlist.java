package javaapplication1;



public class linkedlist<T> {

    private node<T> head;
    private node<T> current;

    public linkedlist() {

    }

    public linkedlist(node<T> h) //joury
    {
        head = current = h;

    }

    /* public void deletContact(node<Contact> delet) //joury
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
    }*/
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

    public linkedlist<Contact> SearchByEmail(String email) //joury //
    {
        linkedlist<Contact> list = new linkedlist<Contact>();

        if (head == null) { //1
            return null; //1
        } else {
            current = head;//1
        }

        while (current != null) {//n+1
            if (((Contact) current.getData()).getEmailAddress().equals(email)) {//{n(1)
                list.insert((Contact) current.getData());
            }
            current = current.next;// n*1
        }

        return list;
    }

    public linkedlist<Contact> SearchByPhoneNumber(String num) //joury 
    {
        linkedlist<Contact> list = new linkedlist<Contact>();

        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getPhoneNumber().equals(num)) {
                list.insert((Contact) current.getData());
            }
            current = current.next;

        }

        return list;
    }

    public linkedlist<Contact> SearchByAddress(String add) //joury
    {
        linkedlist<Contact> list = new linkedlist<Contact>();

        if (head == null) {
            return null;
        } else {
            current = head;
        }

        while (current != null) {
            if (((Contact) current.getData()).getAddress().equals(add)) {
                list.insert((Contact) current.getData());
            }
            current = current.next;

        }

        return list;
    }

    public linkedlist<Contact> SearchByBirthday(String birth) //joury
    {
        linkedlist<Contact> list = new linkedlist<Contact>();
        if (head == null) {
            return null;
        } else {
            current = head;

            while (current != null) {
                if (((Contact) current.getData()).getBirthday().equals(birth)) {
                    list.insert((Contact) current.getData());
                }

                current = current.next;
            }

            return list;
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
    /*public void addSortedPOEA(T data) {//another one check tab
        Node<T> newNode = new Node<>(data);

        if (head == null || data.compareTo(head.data) < 0) {
            newNode.next = head;
            head = newNode;
        } else {
            Node<T> current = head;
            while (current.next != null && data.compareTo(current.next.data) >= 0) { //to move until finding 
                current = current.next;
            }

            newNode.next = current.next;
            current.next = newNode;
        }
    }*/

    
    
    public void addSortedContact(T d) //joury 
    {
        node<T> newContact = new node<T>(d);
        //case1 if empty
        if (head == null) {
            head = newContact;
            current = newContact;
        } //case2 if smaller than first
        else {
            if (((Contact) d).CompareTo((Contact) head.data) < 0) {
                newContact.next = head;
                head = newContact;
                return;

            } else {
                node<T> temp = head;
                while (temp.next != null && (((Contact) d).CompareTo((Contact) temp.data) >= 0)) {
                    temp = temp.next;
                }
                newContact.next = temp.next;
                temp.next = newContact;

            }
        }
    }

    public void addSortedEvent(T e) //anoud
    {
        node<T> newEvent = new node<T>(e);
        //case1 if empty
        if (head == null) {
            head = newEvent;
            current = newEvent;
        
        } //case2 if smaller than first
        else {
            if (((Event) e).CompareTo((Event) head.data) < 0) {
                newEvent.next = head;
                head = newEvent;
                return;

            } else {
                node<T> temp = head;
                while (temp.next != null && (((Event) e).CompareTo((Event) temp.data) >= 0)) {// search for position of the new node 
                    temp = temp.next;
                }
                newEvent.next = temp.next;
                temp.next = newEvent;

            }
        }
    }
    
    
    
    

}
