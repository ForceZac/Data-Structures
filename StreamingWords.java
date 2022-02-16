/*Zach Force
  CSC241
  Assignment 3
  */
import java.util.*;

//Queue class
class Queue
{
   //member variables
   int front, back;
   String q[];
  
   //constructor
   public Queue()
   {
       front = -1;
       back = -1;
       q = new String[20];
   }
  
   //method to count number of words
   private int numWords(String str)
   {
       int count = 1;
      
       for(int i=0; i<str.length()-1; i++)
       {
           if(str.charAt(i)==' ' && str.charAt(i+1)!=' ')
               count++;
       }
      
       return count;
   }
  
   //enqueue method
   public void add(String word)
   {
       //when queue is empty
       if(isEmpty())
       {
           back++;
           q[back] = word;
           return;
       }
       int i;
       back++;
       //insert into the queue according to the number of words
       //in such a way that after insert the queue remains sorted
       for(i = back-1; i>front && numWords(word) < numWords(q[i]); i--)
       {
           q[i+1] = q[i];
       }
      
       q[i+1] = word;
   }
  
   //remove method
   public String remove()
   {
       front++;
       return q[front];
   }
  
   //isEmpty method
   public boolean isEmpty()
   {
       return front==back;
   }
}

//StreamingWords class
public class StreamingWords
{
   //main method
   public static void main (String[] args)
   {
       //create instance of Scanner class
       Scanner sc = new Scanner(System.in);
      
       //create instance of Queue class
       Queue q = new Queue();
      
       while(true)
       {
           //read a line
           String str = sc.nextLine();
          
           //stop inputting data, user will enter END
           if(str.equalsIgnoreCase("END")) break;
          
           //inputs store into a queue data structure
           q.add(str);
       }
      
       //printing out the data elements in the queue
       while(!q.isEmpty())
       {
           //remove the queue from the front
           String str = q.remove();
      
           //printing out the data elements
           System.out.println(str);
       }
      
   }
}