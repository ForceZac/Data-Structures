/*Zachary Force
  CSC 241-01
  2/20/20
  Create a program that utilizes the Insertion sort algorithm
 */
import java.util.*;
import java.io.*;
public class InsertionSort {
    public static void main(String[] args) throws Exception {
        Scanner kb = new Scanner(System.in); //Creating Scanner object
        int numStrings = 0;
        String filePath;         //Variables to hold the parameters

        System.out.println("What is the path leading to the file you will be using?");
        filePath = kb.nextLine();
        System.out.println("How many inputs will be sorted?");
        numStrings = kb.nextInt();          //Receiving input for number of strings and from the file
        String[] numbers = new String[numStrings];

        File file = new File(filePath);
        Scanner sc = new Scanner(file);         //Reading file
        for (int x = 0; x < numbers.length; x++)
        {
            numbers[x]=sc.nextLine();       //populating the array
            if(sc.hasNext()==false)
            {
                break;
            }
        }

        insertionSort(filePath,numStrings,numbers); //Running insertion sort function

        //Printing out finished array
        for(int i=0;i<numbers.length;i++)
        {
            System.out.println(numbers[i]);
        }
    }


    public static void insertionSort(String path, int numElements, String[] array) // insertion Sort function
    {
        for(int i =1; i<array.length;i++)
        {
            int key = Integer.parseInt(array[i]); //must parse data type to compare strings like integers
            int j = i-1;
            while(j>=0 && Integer.parseInt(array[j]) > key)
            {
                (array[j+1])=(array[j]);
                j = j-1;
            }
            String a = String.valueOf(key); //parsing key instead of whats in the array
            array[j+1] = a;
        }

    }
}


