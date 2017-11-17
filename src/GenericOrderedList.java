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
        Node preHead = new Node (null);
        preHead.next=head;
        iterator = preHead;
        
        
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
       
        
           while (iterator!=null)
           {
               if ( (iterator.next.info.compareTo(n.info)) == 1 || (iterator.next.info.compareTo(n.info)) == 0 )
               {
                   iterator.next=n;
                   n.next=iterator.next.next;
               }
               else
               {
                   iterator = iterator.next;
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
        finalString += head.info;
        Node n = head.next;
        
        while (n!=null)
        {
          
                finalString += "->" + n.info ;
            
            
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

