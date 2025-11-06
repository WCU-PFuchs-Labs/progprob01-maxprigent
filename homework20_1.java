/*
Given a sorted linked list, delete all nodes that have duplicate
numbers, leaving only distinct numbers from the original list.In this 
program, you need to 
(1) read 5 numbers and set them in a linkedlist in order
(2) delete duplicate

Example 1:
input: 1,2,3,3,5
output: head-->1-->2-->3-->5-->null

Example 2:
input: 1,1,1,2,3
output: head-->1-->2-->3-->null

Please complete the following program to fullfil the function.
*/
import java.util.Scanner;

public class homework20_1
{
   public static void main(String[] args)
   {
      //add your code here
      LinkedList llist1 = new LinkedList();
      LinkedList llist2 = new LinkedList();

      /*
      ListNode first = new ListNode(1);
      ListNode second = new ListNode(2);
      ListNode third = new ListNode(3);
      ListNode fourth = new ListNode(4);
      ListNode fifth = new ListNode(5);
      */

      
      Scanner scanner = new Scanner(System.in);
      System.out.println("List1 ints");

      int number;
      for (int i=0;i<5;i++) {
         System.out.printf("Enter integer %d: ",i+1);
         ListNode newNode = new ListNode(-1);
         if (scanner.hasNext()) {
            number = scanner.nextInt();
            newNode = new ListNode(number);
         }
         llist1.add(newNode);
      }
      System.out.println(llist1);
      /*
      System.out.println("List2 ints");

      for (int i=0;i<5;i++) {
         System.out.printf("Enter integer %d: ",i+1);
         ListNode newNode = new ListNode(-1);
         if (scanner.hasNext()) {
            number = scanner.nextInt();
            newNode = new ListNode(number);
         }
         llist2.add(newNode);
      }
      System.out.println(llist2);
      */
      scanner.close();
   
      

      
      //System.out.println("Unmodified list:");
      //System.out.println(llist1);   

      llist1.deleteDuplicates();
      System.out.println("\nList with duplicates removed:");
      System.out.println(llist1);
      /*
      llist.insert(new ListNode(4));
      System.out.println("\nList with node \"4\" added:");
      System.out.println(llist);

      llist.insert(new ListNode(888),3);
      System.out.println("\nList with node \"888\" added in position 3:");
      System.out.println(llist);
      */
      
   }
}

class ListNode
{
   int value;
   ListNode next;
   ListNode(int v){value = v;}
}

class LinkedList
{
   ListNode head;
   public String toString()
   {
      String nodeData = "";
      ListNode ref = head;
      while(ref != null)
      {
         nodeData += ref.value + "-->";
         ref = ref.next;
      }
      return "head-->"+nodeData+"null";
   }

   //method appends to end of list
   public void add(ListNode newNode) {
      if (head == null) {
         head = newNode;
      }
      else {
         ListNode current = head;
         while (current.next != null) {
            current = current.next;
         }
         current.next = newNode;
      }
   }

   //method removes any duplicate values from list
   public void deleteDuplicates() {
      //add your code here
      ListNode current = head;
      while (current != null && current.next != null) {
         if (current.value == current.next.value) {
            current.next = current.next.next;
         }
         else {
            current = current.next;
         }
      }
   }

   //method inserts node based on value
   public void insert(ListNode newNode) {
      if (head == null) {
         head = newNode;
      }
      else {
         ListNode current = head;
         if (current.next == null) {
            newNode.next = current.next;
            current.next = newNode;
         } else {
            while (current.next.value < newNode.value) {
               current = current.next;
            }
            newNode.next = current.next;
            current.next = newNode;
         }
      }
   }
   
   //OPTIONAL: method inserts node at certain "index"
   public void insert(ListNode newNode, int index) {
      if (index < 1) {
         add(newNode);
      }
      else if (index == 1 ) {
         newNode.next = head.next;
         head = newNode;
      }
      else {
         ListNode ref = head;
         int current = 2;
         while (current < index) {
            if (ref.next == null) {
               add(newNode);
            }
            ref = ref.next;
            current ++;
         }
         newNode.next = ref.next;
         ref.next = newNode;
      }
   }
}