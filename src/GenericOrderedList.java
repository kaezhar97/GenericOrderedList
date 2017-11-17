/**
 *
 * @author Octavio
 */
public class GenericOrderedList <E>
{
    public GenericOrderedList(E x)
    {
        Node list = new Node(x);
    }
    
    class Node
    {
        E info;
        Node next;
        
        Node (E x)
        {
            info = x;
            next = null;
        }
    }
}

