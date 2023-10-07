/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author batoolalfouzan
 */

package project;


public class node<t> {
public Contact data;
public node <Contact> next;
public node<Contact> prev;

    public node(Contact d) {
        this.data = d;
        next=null;
        prev=null;
        
        
    }

}
