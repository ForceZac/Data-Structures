/*Zach Force
  CSC241
  Assignment 3
  */
import java.util.*;
public class StreamingIntegers
{
   public static void main(String[] args)
   {
    Scanner kb= new Scanner(System.in);  //Scanner for input
    PriorityQueue<Integer> qu = new PriorityQueue<>(); //Creating the queue
    
   String Hotword="END";
   String current;
   int flag=1;
   
   while(flag!=0)
   {
      current=kb.nextLine();
      if(current.equalsIgnoreCase(Hotword))//done if end is typed
         {
            flag=0;
            break;
         }
          else if(current.contains(" "))//checks for multiple numbers on one line
         { 
            String[] temp= current.split(" ");
            for(int x=0;x<temp.length;x++)
            {
              qu.add(Integer.parseInt(temp[x]));//delimit and add one line ints
            }
         }
         else
         {
         qu.add(Integer.parseInt(current));
         }
    }//end of while loop
  

   Iterator<Integer> it = qu.iterator();
   while(it.hasNext() && qu.size()>1)
   {
      System.out.print(qu.poll()+ " ");
      
        
      
   }
   System.out.println(qu.poll());

}}
   
      
      
   