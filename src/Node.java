
package project;



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
