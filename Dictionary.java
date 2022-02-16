/*Zach Force
 CSC241 Assignment 3
 4/26/20*/
import java.util.*;
import java.io.*;
//Node class
class Node
{
   String word;
   int element;
   int height;
   Node left;
   Node right;
   Vector v;
   
   public Node(String w, String meaning, int key)
   {
      element = key;
      height=1;
      left=null;
      v = new Vector();
   }
 }
 
class Tree
{
   Node root;
   
   public Tree()
   {
      root=null;
   }
   
   public int getHeight(Node k) //Method to get hieght
   {
      if(k==null)
      {
         return 0;
      }
      else
      {
        return k.height;
      }
   } 
   
   public int compareHeight(int a, int b) //Method that compares the heights
   {
      if(a>b)
      {
         return a;
      }
      else
      {
         return b;
      }
    }
    
   public int getBalance(Node k)//Method that gets balance of the tree
   {
      if(k==null)
      {
         return 0;
      }
      else
      {
         return getHeight(k.left) - getHeight(k.right);
      }
   }
   
   public Node rotateRight(Node y)
   {
      Node x =y.left;
      Node z= x.right;
      x.right=y;
      y.left=z;  //Perform rotations
      
      y.height=compareHeight(getHeight(y.left), getHeight(y.right))+1;//Update the heights
      x.height = compareHeight(getHeight(x.left), getHeight(x.right))+1; 
      
      //return root Node
      return x;
   }
   
   public Node rotateLeft(Node x)
   {
      Node y = x.right;
      Node z = y.left;
      y.left=x;
      x.right=z;  //perform rotations
      
      //update heights
       x.height = compareHeight(getHeight(x.left), getHeight(x.right))+1; 
       y.height = compareHeight(getHeight(y.left), getHeight(y.right))+1; 
       
       //return root node
       return y;
   }
   
   public Node insert(Node node, String word, String meaning, int key)
   {
       //Insert nodes into tree
        if (node == null) 
            return (new Node(key)); 
     
        if (key < node.element) 
            node.left = insert(node.left, key); //Check whether to insert on left or right
        else if (key > node.element) 
            node.right = insert(node.right, key); 
        else 
            return node;//append definition if word exist
  
        //Update height of parent node
        node.height = 1 + compareHeight(getHeight(node.left), 
                              getHeight(node.right)); 
  
     
        //Check balance of parent node
        int balance = getBalance(node); 
  
        // If this node becomes unbalanced, Left Left Case 
        if (balance > 1 && key < node.left.element) 
            return rotateRight(node); 
  
        // Right Right Case 
        if (balance < -1 && key > node.right.element) 
            return rotateLeft(node); 
  
        // Left Right Case 
        if (balance > 1 && key > node.left.element) { 
            node.left = rotateLeft(node.left); 
            return rotateRight(node); 
        } 
  
        // Right Left Case 
        if (balance < -1 && key < node.right.element) { 
            node.right = rotateRight(node.right); 
            return rotateLeft(node); 
        } 
  
       //return the node pointer
        return node; 
  } 
   
   
    public void printHeight(Node node) //prints height of root, left child, then right child
    {
      if(node != null)
      {
         System.out.println(node.element);
         printHeight(node.left);
         printHeight(node.right);
      }
    }
    
    public void printDef(Node node, String w)
    {
      if(node != null)
      {
         if(w.equalsIgnoreCase(node.word))
         {
         int flag=1;
         System.out.println(node.word);
         System.out.println(node.pronounce);
         System.out.println(node.definition);
         System.out.println();
         }
       printDef(node.left, w);
       printDef(node.right,w);


      }
     }   
} 
 
public class Dictionary  //Main method
{
   public static void main(String[] args) throws Exception
   {
      String inputFile= args[0];  //recieve filepath from cmd
      File file = new File(inputFile);
      Scanner sc = new Scanner(file);//Read file
      
      Tree avlTree = new Tree(); //Creating AVL Tree
      
      
      
while(true)
{
System.out.print("$");
String command = scan.next();
if(command.equals("SEARCH")){
String word = scan.next();
int flag = 0;
avlTree.search(avlTree.Root,word);
if(flag == 0)
System.out.println("Word does not exist");
}
else if(command.equals("EXIT"))
break;
else
System.out.println("Invalid Command");
}
}}

   
   
   