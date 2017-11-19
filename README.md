Computer Programming II				    Instructor: Greg Shaw
COP 3337							    


	Programming Assignment #6

"A Generic Ordered List Class"


Write a Java Class to Implement a Generic Ordered List

An ordered list is one in which the objects on the list appear in order.  When a new object is added, it is inserted into the list in its proper position, so there is never a need to “sort” the list.  Your list will be in ascending order initially.
To receive credit, your list must be implemented as a singly-linked list of generic nodes, where each node has two instance variables: an object of the “type variable” class, and a pointer to the next node on the list
To receive credit, no data structures may be used other than your own OrderedList class

Your class will have a proper constructor and these methods:

an overridden toString method that returns the objects on the list in the order in which they appear, or null if the list is empty

an insert method that inserts a new node containing its parameter in its proper place in the list

a boolean delete method that searches the list for a node containing its parameter.  If found, the node is removed from the list and true is returned; else, false is returned

a boolean isEmpty method

a method to clear the list

a method to reverse the order of the objects on the list. I.e. after the first reversal the list will be in descending order. To receive credit for this method, you must implement this algorithm:
Traversing the list sequentially, remove each node and insert it as the new first node. Do not merely “swap” the objects stored in the nodes or create any new nodes - remove each node from the list and reinsert it in its new position 		




Write a Test Class for Your Ordered List Class

Your main method will read and execute list operation instructions from a data file, until end-of-file.  Each operation is to be implemented by calling a method of your list class.  
After each operation is executed, print the instruction and the updated list.  If an operation cannot be done or is unnecessary because the list is empty, say so 

The data file to be used is available on the class web site and the instructions are:

INSERT X - 	Insert a new node with info x in its proper place in the list

DELETE X -	Remove the node that contains x from the list. (If x does not appear on the list, say so)

CLEAR - Clear the list 

REVERSE - 	Reverse the order of the objects on the list (using the algorithm specified above)


 Due Date: Tuesday, November 21st


What to Upload

Upload a .zip file containing your NetBeans project folder and the output



Hopefully Helpful Hints

Because an ordered list intrinsically involves comparisons, it will be necessary to constrain (i.e. “limit”) the type parameter to those classes that implement Java’s Comparable interface
See the “Generic Classes” document online

It is not necessary to create an iterator for your class, although one is shown in our demo program, MyLinkedList.java
An iterator allows the user of a collection to access each object stored without having to know anything about how the collection is implemented.  For this assignment, the client doesn’t require that capability



Begin by creating the skeleton of your OrderedList class, with just the method “stubs” (i.e. method declaration with an empty body and bogus return value if the method returns a value).  That way your program will compile and run and you can code the method bodies separately

To insert a new object in its proper place, we need to know whether the list is in ascending or descending order.  This cries out for a boolean instance variable to so indicate. Design your insert method to call private utility methods insertAscending or insertDescending to handle the insertion






