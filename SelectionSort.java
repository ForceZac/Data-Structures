import java.util.*;
import java.io.*;
public class SelectionSort {
   public static void main(String[] args) throws Exception
   {
      String filePath = args[0]; //Filepath from cmd 
     
      File file = new File(filePath);
      Scanner sc = new Scanner(file);//
     
     ArrayList<Integer> numbers = new ArrayList<Integer>();//temporary arraylist to dynamically get size and elements
      while(sc.hasNext())
      {
        numbers.add(sc.nextInt());//populate ArrayList
      }
      
      
      int[] scrambledArray = new int[numbers.size()];
      
      for(int i=0;i<numbers.size();i++)//Populating regular array with ints from file through ArrayList
      {
         scrambledArray[i] = numbers.get(i);
      }
      
      sort(scrambledArray);//Pass unsorted array to function that will use Selection sort
      
      for(int i=0;i<numbers.size();i++)
      {
         System.out.println(scrambledArray[i]);         
      }
      
  }//End of main method    
      
    public static void sort(int[] sortMe)
    {
      for(int i=0;i<sortMe.length;i++)//Outer loop to compare each value of array to next beginning with index 0
      {
         int key = sortMe[i];
        
         for(int x=i+1;x<sortMe.length;x++)//iterate through array for each element i+1
         {
            if(sortMe[x]<sortMe[i])//check too see if an element is smaller than i
            {
               int holder = sortMe[x];//if smaller store that element in a temp int and then switch the i value to the x index and vice versa
               sortMe[x]=sortMe[i];
               sortMe[i]=holder;
            }
            
          }
          
        }   
         
      }//End function         
              
          
             
    
    
}//ends the class