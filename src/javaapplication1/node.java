package javaapplication1;






public class node<T> 
{

    public T data;
    public node<T> next;

    public node(T d) 
    {
        this.data = d;
        next = null;

    }

    public T getData() 
    {
        return data;
    }

}
