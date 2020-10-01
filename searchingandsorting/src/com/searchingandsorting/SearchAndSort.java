package com.searchingandsorting;

import java.util.Scanner;

//using linked list
public class SearchAndSort {
	
	class Node
	{
		int data;
		Node next;
		public Node(int data) {
		
			this.data = data;
			this.next = null;
		}
		
	}
	
	private Node head =null;
	private Node tail = null;
	
	void insert(int data)
	{
		Node node = new Node(data);
		if(head == null)
		{
			head = node;
			tail = node;
		}else
		{
			tail.next= node;
			tail=node;
		}
	}
	
	void linearSearch(int value)
	{
		boolean check = false;
	int i=1;
		if(head == null)
		{
			System.out.println("List is empty");
			
			
		}else
		{
			Node temp = head;
		
			
			while(temp != null)
			{
				if(temp.data == value)
				{
					check = true;
					break;
				}temp = temp.next;
				i++;
			}
		}
		
		if(check)
			
		{
			System.out.println("Element "+value+" is found at position " + i);
		}else
		{
			System.out.println("Element is not found");
		}
	}
	
	Node binarySearch(Node head ,int value)
	{
		
		Node start = head; 
        Node last = null; 
  
        do
        { 
            // Find Middle 
            Node mid = middleNode(start, last); 
  System.out.println("\nmid element "+mid.data +" start "+start.data  );
            // If middle is empty 
            if (mid == null) 
                return null; 
  
            // If value is present at middle 
            if (mid.data == value) 
                return mid; 
  
            // If value is more than mid 
            else if (mid.data < value)  
            { 
                start = mid.next; 
            } 
  
            // If the value is less than mid. 
            else
           last=mid;
            
          
        } while (last == null || last != start); 
  
        // value not present 
        return null; 
    
		
		
	}
	
	 Node middleNode(Node start, Node last) {
		if (start == null) 
            return null; 
  
        Node slow = start; 
        Node fast = start.next; 
  
        while (fast != last) 
        { 
            fast = fast.next; 
            if (fast != last)  
            { 
                slow = slow.next; 
                fast = fast.next; 
            } 
        } 
        return slow; 
	
	}
	 
	 //bubble sort
	 
	 void bubbleSort()
	 {
		 if(head == null)
		 {
			 System.out.println("List is empty");
		 }else
		 {
			 Node current = head;
			 Node nextNode =null;
			 int temp;
			 while(current !=null)
			 {
				 nextNode = current.next;
				 while(nextNode != null)
				 {
				 if(current.data >nextNode.data)
				 {
					 temp = current.data;
					 current.data = nextNode.data;
					 nextNode.data = temp;
				 }nextNode = nextNode.next;
			 }current = current.next;
		 }
		 }
	 }
	 
	 //selection sort
	 
	 
	 void selectionSort(Node head) 
	 { 
	     Node temp = head; 
	   
	     // Traverse the List 
	     while (temp != null) { 
	         Node min = temp; 
	         Node current = temp.next; 
	         if(current !=null)
	         System.out.println("current val"+current.data);
	   
	         // Traverse the unsorted sublist 
	         while (current != null) { 
	             if (min.data > current.data) 
	                 min = current; 
	   
	             current = current.next; 
	         } 
	   
	         // Swap Data 
	         int x = temp.data; 
	         temp.data = min.data; 
	         min.data = x; 
	         temp = temp.next;
	     }
	     } 
	 
	 //insertion sort
	    Node    sorted = null; 
	 void insertionSort(Node headref)  
	    { 
	        // Initialize sorted linked list 

	        Node current = headref; 
	        // Traverse the given linked list and insert every 
	        // node to sorted 
	        while (current != null)  
	        { 
	            // Store next for next iteration 
	            Node next = current.next; 
	            // insert current in sorted linked list 
	            sortedInsert(current); 
	            // Update current 
	            current = next; 
	        } 
	        // Update head_ref to point to sorted linked list 
	        head = sorted; 
	    } 
	  
	    /* 
	     * function to insert a new_node in a list. Note that  
	     * this function expects a pointer to head_ref as this 
	     * can modify the head of the input linked list  
	     * (similar to push()) 
	     */
	    void sortedInsert(Node newnode)  
	    { 
	    	
	        /* Special case for the head end */
	        if (sorted == null || sorted.data >= newnode.data)  
	        { 
	            newnode.next = sorted; 
	            sorted = newnode; 
	        } 
	        else 
	        { 
	            Node current = sorted; 
	            /* Locate the node before the point of insertion */
	            while (current.next != null && current.next.data < newnode.data)  
	            { 
	                current = current.next; 
	            } 
	            newnode.next = current.next; 
	            current.next = newnode; 
	        } 
	    } 
	 
		/*
		 * void insertionSort() { if(head == null) {
		 * System.out.println("List is empty"); }else { Node current = head; Node
		 * nextNode =null; Node left = null; int temp;
		 * 
		 * while(current !=null) { nextNode = nextNode.next;
		 * 
		 * while(nextNode != null) { if(current.data > nextNode.data) { temp =
		 * current.data; current.data = nextNode.data; nextNode.data = temp; left =
		 * nextNode; } } } } }
		 */
//quicksort
	    
	 // takes first and last node, 
	 // but do not break any links in 
	 // the whole linked list 
	 Node paritionLast(Node start, Node end) 
	 { 
	 	if(start == end || 
	 	start == null || end == null) 
	 		return start; 

	 	Node pivot_prev = start; 
	 	Node curr = start; 
	 	int pivot = end.data; 
	 	
	 	// iterate till one before the end, 
	 	// no need to iterate till the end 
	 	// because end is pivot 
	 	while(start != end ) 
	 	{ 
	 		if(start.data < pivot) 
	 		{ 
	 			// keep tracks of last modified item 
	 			pivot_prev = curr; 
	 			int temp = curr.data; 
	 			curr.data = start.data; 
	 			start.data = temp; 
	 			curr = curr.next; 
	 		} 
	 		start = start.next; 
	 	} 
	 	
	 	// swap the position of curr i.e. 
	 	// next suitable index and pivot 
	 	int temp = curr.data; 
	 	curr.data = pivot; 
	 	end.data = temp; 

	 	// return one previous to current 
	 	// because current is now pointing to pivot 
	 	return pivot_prev; 
	 } 

	 void quickSort(Node start, Node end) 
	 { 
	 	if(start == end ) 
	 		return; 
	 		
	 	// split list and partion recurse 
	 	System.out.println("start and end values "+start.data + " "+end.data);
	 	Node pivot_prev = paritionLast(start, end); 
	 	quickSort(start, pivot_prev); 
	 	
	 	// if pivot is picked and moved to the start, 
	 	// that means start and pivot is same 
	 	// so pick from next of pivot 
	 	if( pivot_prev != null && 
	 		pivot_prev == start ) 
	 		quickSort(pivot_prev.next, end); 
	 		
	 	// if pivot is in between of the list, 
	 	// start from next of pivot, 
	 	// since we have pivot_prev, so we move two nodes 
	 	else if(pivot_prev != null && 
	 			pivot_prev.next != null) 
	 		quickSort(pivot_prev.next, end); 
	 } 

	void display()
	{
		if(head == null)
		{
			System.out.println("List is empty");
		}else
		{
			Node temp = head;
			System.out.println("values are");
			while(temp != null)
			{
				System.out.print(temp.data + " --> ");
				temp=temp.next;
			}
		}
	}
	public static void main(String[] args)
	{
		SearchAndSort searSort = new SearchAndSort();
		SearchAndSort searSort1 = new SearchAndSort();
		SearchAndSort seaSort2 = new SearchAndSort();
		
		
		
		char ch;
		int choice;
		do {
		System.out.println("\n...................Searching and sorting ...................");
		System.out.println(" 1.Insert \n2.Linearsearch \n3.BinarySearch \n4.show"
				+ "\n5.Bubblesort \n6.selectionsort\n7insertion sort\n8.Quicksort");
		System.out.println("Enter the key to choose the functionality");
		Scanner sc = new Scanner(System.in);
		choice = sc.nextInt();
		switch(choice)
		{
		
		case 1 :
			
			System.out.println("Enter the element to insert ");
			searSort.insert(sc.nextInt());
			break;
		case 2 :
			System.out.println("Enter the e;ement to search");
			searSort.linearSearch(sc.nextInt());
			break;
		case 3 : 
			System.out.println("enter element to search for binary search ");
			searSort1.head =searSort.binarySearch(searSort.head, sc.nextInt());
			
		
			if(searSort1.head == null)
			{
				System.out.println("value not present");
			}
			else
			{
				System.out.println("Value present");
			}
			break;
		case 4:
			searSort.display();
			break;
			
		case 5:
			searSort.bubbleSort();
			searSort.display();break;
			
		case 6: 
			 searSort.selectionSort(searSort.head);break;
		case 7 : searSort.insertionSort(searSort.head);
		           searSort.display();break;
		           
		case 8 :
			Node last =searSort.head;
			while(last.next != null)
				last = last.next;
			searSort.quickSort(searSort.head, last);
		           searSort.display();
		default : 
			
			System.out.println("Enter valid numbers");
		}
			
			System.out.println("Do you want to continue ? (Y/N)");
			Scanner acb = new Scanner(System.in);
			ch = acb.next().charAt(0);
		
    }while (ch == 'y' || ch == 'Y');
	}
		
	
}
