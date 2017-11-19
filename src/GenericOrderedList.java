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
        
        Node first = head;
        Node removed;
        
        while (first.next!=null)
        {
           removed = first.next;
           delete(first.next.info);
           removed.next=head;
           head=removed;
            
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
    
    /**
     * Inserts an object into a list in ascending order
     * 
     * @param n the object to be inserted
     */
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
             
           }
           else
           {
               ahead = ahead.next;
               behind = behind.next; 
               
           }
       }
       
        if (ahead == null)
       {
           if ((n.info.compareTo(behind.info)==-1) || (n.info.compareTo(behind.info)==0))
           {
               head = n;
               n.next = behind;
               inserted = true;
               
           }
           else
           {
               behind.next = n;
               n.next = null;
               inserted = true;
               
           }
       }
       
      
    }
    
    /**
     * Inserts an object into a list in descending order
     * 
     * @param n the object to be inserted
     */
    private void insertDescending(Node n)
    {
        Node preHead = new Node (null);
        Node trailing = preHead;
        trailing.next = head;
        Node mover = head;
        boolean inserted = false;
        
        
        if ((trailing.info==null) && (n.info.compareTo(mover.info)==1))
        {
            head = n;
            n.next = mover;
            inserted = true;
        }
        
        trailing = trailing.next;
        mover = mover.next;
        
        
        
        while(mover!=null&& !inserted)
        {
            if ((n.info.compareTo(mover.info)==1) || (n.info.compareTo(mover.info)==0))
            {
                trailing.next = n;
                n.next = mover;
                inserted = true;
            }
            else
            {
                trailing = trailing.next;
                mover = mover.next;
            }
        }
        
        if (mover == null)
        {
            trailing.next = n;
            n.next = null;
            inserted = true;
        }
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
     * A class to simulate a node on a list. A node contains information and can point to another node
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

