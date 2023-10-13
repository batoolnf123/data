package javaapplication1;

 public class Event implements Comparable<Event> {

   private String title;
    private String date; 
    private String time;
    private String location;
    
    linkedlist<Contact> contactsinEvent; //change name
    linkedlist<Event> eventsinEvent; //check?
    
   Contact involvedContact ;
   String contactName; 

    public Event(String title, String date, String time, String location) {
        this.title = title;
        this.date = date;
        this.time = time;
        this.location = location;
    }
    
 
    public Event() {
        this.title = "";
        this.date = "";
        this.time = "";
        this.location = "";
        this.contactName = "";

    }
    //settersgetters?
    

   public void setContactName(String contactName) {
        this.contactName = contactName;
    }


    public void setInvolvedContact(Contact involvedContact) {
        this.involvedContact = involvedContact;
    }

    public String getDate() {
        return date;
    }
    

    public String getTitle() {
        return title;
    }

    public String getTime() {
        return time;
    }

    public String getLocation() {
        return location;
    }

    public String getContactName() {
        return contactName;
    }

   @Override
     public int CompareTo(String second) //anoud
    {
        if (getTitle().compareTo(second) == 0) {
            return 0;
        } else if (getTitle().compareTo(second) > 0) {
            return 1;
        } else {
            return -1;
        }
    }
    

    
    
    public void display() { //anoud
        System.out.println("Event title:" + title);
        System.out.println("Contact name:" + contactName );
        System.out.println("Event date and time (MM/DD/YYYY HH:MM):" + date + time);
        System.out.println("Event location:" + location);
    }
    
}
