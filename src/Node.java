
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

    public t getData() {
        return data;
    }
}
