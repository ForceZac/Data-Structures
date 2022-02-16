/*Zachary Force
  CSC 241-01
  2/20/20
  Create a program called distributioncounting sort that implements the distribution counting sorting algorithm
 */
import java.util.*;
import java.io.*;
public class DistributionCountingSort {
    public static void main(String[] args) throws Exception {
        //creating scanner
        Scanner kb = new Scanner(System.in);

        //Creating parameters for later method
        int numElements=0;
        String filePath;
        int maxInt=0;
        int minInt=0;

        //Receive user input
        System.out.println("What is the path to the file we will be reading?");
        filePath = kb.nextLine();
        System.out.println("How many integers will we be reading from this file?");
        numElements=kb.nextInt();

        //Receiving input file and putting input into an array
        File file = new File(filePath);
        Scanner sc = new Scanner(file);

        //creating and populating the original array
        int[] firstArray = new int[numElements];
        int holder=0;
        for(int i =0;i<firstArray.length;i++)
        {
                holder = sc.nextInt();
                firstArray[i] = holder;
        }

        //GETTING MIN AND MAX VALUES
        minInt=firstArray[0];
        for(int x =0;x<firstArray.length;x++)
        {
            if (firstArray[x] > maxInt) {
                maxInt = firstArray[x];

            } else if (firstArray[x] < minInt) {
                minInt = firstArray[x];
            }
        }

        //Calling method
        countingSort(firstArray, filePath,numElements,maxInt,minInt);


    }

    public static void countingSort(int[] fa, String fp, int numE, int maxE, int minE)
    {         //Copying original array into counter and setting it to 0
        int [] sorted = new int[numE];
        int[] counter = new int[maxE + minE ];
        for(int x=0;x<counter.length;x++)
        {
            counter[x]=0;
        }

        //store count of occurrences of each element into array at index of it's value
        int count=0;
        for(int a =0; a<fa.length;a++)
        {
          ++counter[fa[a]];
            }

        //GETTING THE SUM OF THE INDEXES
        for(int i=minE;i<=maxE;i++)
        {
            counter[i] += counter[i - 1];
        }
        //MOVING ELEMENTS INTO CORRECT POSITION
        for(int i =0; i<fa.length;i++)
        {
            sorted[counter[fa[i]] - 1] = fa[i];
            --counter[fa[i]];
        }
        //PRINTING FINAL ARRAY
        for(int i=0;i<sorted.length;i++)
        {
            System.out.println(sorted[i]);
        }
        }
        }




