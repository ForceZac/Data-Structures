import java.util.*;
import java.io.*;
public class Merge {
   public static void main(String[] args) throws Exception
   {
      String filePath = args[0];
      String filePath2 = args[1];
      
      File file = new File(filePath);//Recieving input from cmd
      File file2 = new File(filePath2);
      
      Scanner sc = new Scanner(file);
      Scanner sc2 = new Scanner(file2);//Scanners to read the files
      
      ArrayList<Integer> temp1 = new ArrayList<Integer>();//arraylist to dynamically add elements
      ArrayList<Integer> temp2 = new ArrayList<Integer>();
      
      while(sc.hasNext())
      {
         temp1.add(sc.nextInt());//populate first arraylist
      }
      
      while(sc2.hasNext())
      {
         temp2.add(sc2.nextInt());//pop second arraylist
      }
      
      int[] arrayOne = new int[temp1.size()];
      int[] arrayTwo = new int[temp2.size()];
      
      for(int i=0;i<temp1.size();i++) //storing values from arraylist into regular array
      {
         arrayOne[i]=temp1.get(i);
      }
      
      for(int j=0;j<temp2.size();j++)//populating the second array
      {
         arrayTwo[j]=temp2.get(j);
      }
      
      ascendingSort(arrayOne);//passing to sorting methods
      descendingSort(arrayTwo);
 
      for(int i=0;i<arrayOne.length;i++)//printing first array sorted
      {
        if(i!=arrayOne.length-1)
        {
            System.out.print(arrayOne[i]+ " ");//Submitty wouldnt accept file with a white space at the end of the line
        }
         if(i==arrayOne.length-1)
         {
            System.out.print(arrayOne[i]);
         }
      }
      System.out.println();//next line
      for(int i=0;i<arrayTwo.length;i++)//printing second array sorted
      {
         if(i!=arrayTwo.length-1)
         {
            System.out.print(arrayTwo[i]+ " ");
         }
         if(i==arrayTwo.length-1)
         {
            System.out.print(arrayTwo[i]);
         }
      }
      int[] sorted = Merge(arrayOne,arrayTwo);    
      System.out.println();//nextline    
      
      for(int i=0;i<sorted.length;i++)//final sorted array
      {
         if(i!=sorted.length-1)
         {
         System.out.print(sorted[i]+ " ");
         }
         if(i==sorted.length-1)
         {
            System.out.print(sorted[i]);
         }
      }  
            
  }//end of main method 
  
  
  
  
 public static void ascendingSort(int[] firstArray)//Insertion sort in ascendingorder
 {
    for(int i=1;i<firstArray.length;++i)
    {
      int key =firstArray[i];
      int j=i-1;
      while(j>=0 && firstArray[j]>key)
      {
         firstArray[j+1]=firstArray[j];
         j=j-1;
      }
      firstArray[j+1]=key;
     }
  
  }//End of ascendingSort method
  
  
  public static void descendingSort(int[] secondArray) //Insertion sort in descending order
 {
    for(int i=1;i<secondArray.length;++i)
    {
      int key =secondArray[i];
      int j=i-1;
      while(j>=0 && secondArray[j]<key)
      {
         secondArray[j+1]=secondArray[j];
         j=j-1;
      }
      secondArray[j+1]=key;
     }
    
  }//End of ascendingSort method
  
 
 public static int[] Merge(int[] firstArray, int[] secondArray)
 {
 
  ArrayList<Integer> temp3 = new ArrayList<Integer>();
  for(int i=0;i<firstArray.length;i++)
      {
         temp3.add(firstArray[i]);
      }
      for(int j=0;j<secondArray.length;j++)
         {
            temp3.add(secondArray[j]);
         }
   int[] sorted = new int[temp3.size()];
   for(int x=0;x<sorted.length;x++)
   {
      sorted[x]=temp3.get(x); //populate merged
   }
    
    for(int a=1;a<sorted.length;++a)//sort merged
    {
      int key =sorted[a];
      int b=a-1;
      while(b>=0 && sorted[b]<key)
      {
         sorted[b+1]=sorted[b];
         b=b-1;
      }
      sorted[b+1]=key;
     }
    
   return sorted;   
  }//end of merge method
  
  
}//end of class  