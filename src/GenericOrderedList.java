/*
File: GenericOrderedList.java
Purpose:
    Creates an ordered list with the specified objects in ascending order initially. New additions are included in the right order.
This class implements a singly linked list.
*/



/**
 * 
 * A class that simulates an ordered list of any object. New objects added to the list are inserted in order (ascending or descending)
 * 
 * @author Octavio Avila-Cardet
 */
public class GenericOrderedList <E extends Comparable<E>>
{
    private Node head; // pointer to first Node on the list
    private Node iterator; // used to iterate through the list
    private boolean isAscending; //stores whether or not the list is in ascending order
    
    /**
     * Creates an instance of the generic ordered list
     * 
     * @param x the information to be contained inside the node
     */
    public GenericOrderedList()
    {
        head = null;  
        isAscending = true;
        
    }
    
    /**
     * A method that inserts a new node containing its parameter in its proper place in the list
     * 
     * @param x the information contained inside the node to be inserted
     */
    public void insert(E x)
    {
        Node n = new Node (x);
        
        if (isEmpty())
        {
            head = n;
        }
        
        else if (this.isAscending)
        {
            insertAscending(n);
        }
        
        else
        {
            insertDescending(n);
        }
    }
    
    
    /**
     * Searches the list for a node containing its parameter
     * 
     * @param x the information contained inside the node to be deleted
     * @return true is returned if node is found; else, false is returned
     */
    public boolean delete(E x)
    {
        boolean found = false;
        
        
        Node finderAhead = head.next;
        Node finderBehind = head;
        Node temp;
        
        if (finderBehind.info == x)
        {  
                head = finderAhead;
                finderBehind.next=null;
                found=true;
        }
        
        while (finderAhead!=null && !found)
        {
            if (finderAhead.info==x)
            {
                temp = finderAhead.next;
                finderAhead.next = null;
                finderBehind.next = temp;
                found=true;
            }
            else
            {
                finderAhead = finderAhead.next;
                finderBehind = finderBehind.next;
            }
        }
        
        
        
        
        return found;
    }
    
    /**
     * Checks whether or not the list is empty
     * 
     * @return true if list is empty; false otherwise
     */
    public boolean isEmpty()
    {
        boolean listIsEmpty = false;
        
        listIsEmpty = head == null;
        
        return listIsEmpty;
    }
    
    /**
     * Deletes all nodes in the list
     */
    public void clear()
    {
        head = null;
    }
    
    /**
     * Reverses the order of the nodes in the list
     */
    public void reverse()
    {
        
        Node mover = head.next;
        Node last = lastNode();
        Node temp;
        
        while (mover!=last)
        {
            temp = mover.next;
            head = temp;
            mover.next = head;
        }
       
        
        if (isAscending)
        {
            isAscending = false;
        }
        else
        {
            isAscending = true;
        }
            
    }
    
    private void insertAscending(Node n)
    {
       Node ahead = head.next;
       Node behind = head;
       Node temp;
       boolean inserted = false;
       
       
       while (ahead!=null && !inserted)
       {
           if ((n.info.compareTo(ahead.info)==-1) || (n.info.compareTo(ahead.info)==0))
           {
               temp = behind.next;
               behind.next = n;
               n.next = temp;
               inserted = true;
               System.out.println("Ahead is NOT null, number inserted in list");
           }
           else
           {
               ahead = ahead.next;
               behind = behind.next; 
               System.out.println("Ahead is NOT null, moving on to next set of values");
           }
       }
       
        if (ahead == null)
       {
           if ((n.info.compareTo(behind.info)==-1) || (n.info.compareTo(behind.info)==0))
           {
               head = n;
               n.next = behind;
               inserted = true;
               System.out.println("Ahead is null, number inserted before before behind");
           }
           else
           {
               behind.next = n;
               n.next = null;
               inserted = true;
               System.out.println("Ahead is null, number inserted at the end of list");
           }
       }
       
      
    }
    
    private void insertDescending(Node n)
    {
        
    }
    
    /**
     * Returns the last node in the list
     * 
     * @return null if list is empty, otherwise, returns the last node in the list
     */
    private Node lastNode()
    {
        if (head == null)       
        {
            return null;       
        } 
        else                   
        {
            Node temp = head;          
            while (temp.next != null)   
            {
                temp = temp.next;	
            }
            return temp;		
        }
    }
    
    
    /**
     * Displays the generic ordered list in textually
     * 
     * @return the final string with the information of each node on the list in order
     */
    public String toString()
    {
        String finalString="";
        
        Node temp = head;
        
        while (temp.next!=null)
        {
            finalString+=temp.info + "->";
            temp = temp.next;
           
        }
        
        if (temp.next==null)
        {
            finalString += temp.info;
        }
        
        return finalString;
    }
    
    /**
     * A class to simulate a node on a list
     */
    class Node
    {
        E info; // The information contained inside the node. It could be of any type
        Node next; //A the next node on the list
        
        /**
         * Creates a node with information and a pointer to the next node on the list
         * 
         * @param x the information contained inside the node
         */
        Node (E x)
        {
            info = x;
            next = null;
        }
    }
}

