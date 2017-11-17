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
public class GenericOrderedList <E>
{
    
    
    /**
     * Creates an instance of the generic ordered list
     * 
     * @param x the information to be contained inside the node
     */
    public GenericOrderedList(E x)
    {
        Node list = new Node(x);
    }
    
    /**
     * A method that inserts a new node containing its parameter in its proper place in the list
     * 
     * @param x the information contained inside the node to be inserted
     */
    public void insert(E x)
    {
        
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
        
        return listIsEmpty;
    }
    
    /**
     * Deletes all nodes in the list
     */
    public void clear()
    {
        
    }
    
    /**
     * Reverses the order of the nodes in the list
     */
    public void reverse()
    {
        
    }
    
    /**
     * Displays the generic ordered list in textually
     * 
     * @return the final string with the information of each node on the list in order
     */
    public String toString()
    {
        String finalString="";
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

