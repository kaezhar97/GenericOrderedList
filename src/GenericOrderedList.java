/**
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
     * A class to simulate a node on a list
     * 
     * 
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

