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
public t data;
public node <t> next;
public node<t> prev;

    public node(t d) {
        this.data = d;
        next=null;
        prev=null;
        
        
    }

}
