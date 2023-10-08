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
    String title;
    Date date;
    String time;
    String location;
    linkedlist <String> contactName;

    public Event() {
        this.title = "";
        this.date = null;
        this.time = "";
        this.location = "";
        this.contactName = new linkedlist<String> ();
        
    }  

    @Override
    public int CompareTo(String second) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }

    @Override
    public void display() {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
