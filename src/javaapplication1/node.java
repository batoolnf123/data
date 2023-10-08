package javaapplication1;


  /* Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
  * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
  */

 /**
  *
  * @author batoolalfouzan
  */




public class node<T> {
public T data;
public node <T> next;
public node<T> prev;

    public node(T d) {
        this.data = d;
        next=null;
        prev=null;
        
        
    }

    public T getData() {
        return data;
    }
    

}