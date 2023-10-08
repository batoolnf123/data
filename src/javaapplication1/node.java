package javaapplication1;






public class node<T> //joury
  {
public T data;
public node <T> next;
public node<T> prev;

    public node(T d) //joury
    {
        this.data = d;
        next=null;
        prev=null;
        
        
    }

    public T getData() //joury
    {
        return data;
    }
    

}
