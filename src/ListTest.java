
import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/*
File: ListTest.java
 * Purpose:
    Tests the GenericOrderedList.java
 */

/**
 *
 * @author Octavio Avila-Cardet
 */
public class ListTest
{
    public static void main(String args[]) throws IOException
    {
        Scanner fileScan = new Scanner( new File ( "ordlist.txt" ) );
        String instruction = "";
        int info=0;
        GenericOrderedList list = new GenericOrderedList();
        
        while (fileScan.hasNext())
        {
            String operationDone="";
            instruction = fileScan.next();
            
            if (instruction.equals("INSERT"))
            {
                info = fileScan.nextInt();
                list.insert(info);
                operationDone="INSERT "+info;
            }
            
            else if (!list.isEmpty())
            {
                if (instruction.equals("DELETE"))
                {
                    boolean numberFound=false;
                    info = fileScan.nextInt();
                    numberFound=list.delete(info);
                    operationDone="DELETE "+info;
                    if (!numberFound)
                    {
                        operationDone+=". Could not delete (object not found)";
                    }
                    
                }
            
                else if (instruction.equals("REVERSE"))
                {
                    list.reverse();
                    operationDone="REVERSE";
                }
            
                else
                {
                    list.clear();
                    operationDone="CLEAR";
                }
            }
            
            else
            {
                operationDone+="Operation cannot be done because the list is empty";
            }
          
            if (list.isEmpty())
            {
               System.out.println("Instruction executed: "+operationDone+ "\nList status: empty\n");  
            }
            else
            {
                System.out.println("Instruction executed: "+operationDone+"\n"+"List status: "+list.toString()+"\n");     
            }
        }
         
    }
    
}
