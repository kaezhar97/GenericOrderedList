
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
                    info = fileScan.nextInt();
                    list.delete(info);
                    operationDone="DELETE "+info;
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
                System.out.println("Operation cannot be done because the list is empty");
            }
          
            System.out.println("Instruction executed: "+operationDone+"\n"+"List status: "+list.toString());     
        }
         
    }
    
}
