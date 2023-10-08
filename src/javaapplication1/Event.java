package javaapplication1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

  public class Event implements Comparable<Event> {

   private String title;
    private Date date; 
    private String time;
    private String location;
    
    linkedlist<String> contactName;
    

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.contactName = new linkedlist<String>();

    }
    //settersgetters?
    

    @Override
    public int CompareTo(String second) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void display() { //anoud
        System.out.println( "title=" + title + ", date=" + date + ", time=" + time + ", location=" + location + ", contact name=" + contactName + '}' );
    }

    
    
}
