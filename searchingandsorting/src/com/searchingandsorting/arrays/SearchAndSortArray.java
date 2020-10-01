package com.searchingandsorting.arrays;

import java.util.Scanner;

//using arrays
public class SearchAndSortArray {
	
	
	int arr[];
	int i,j;
	
	void insert(int array[],int size)
	{
		arr = new int[size];
		for(i=0;i<array.length;i++)
		{
			
			arr[i] = array[i];
		}
		
		
	}
	
	void display()
	{
		System.out.println("Values are ");
		for(int i=0;i<arr.length;i++)
		{
			System.out.println(arr[i]);
		}
	}
	
	void bubbleSort(int arr[])
	{
		int temp;
		for(i=0;i<arr.length;i++)
		{
			for(j=i+1;j<arr.length;j++)
			{
			if(arr[i] > arr[j])
{
	temp = arr[i];
	arr[i] =arr[j];
	arr[j] = temp;
}
			}
		}
	}
	
	//insertionsort1
	
	void insertionSort(int arra[])
	{
		for(i =1 ; i<arra.length;++i)
		{
			int key = arra[i];
			
			j=i-1;
			
			while(j>=0 && arra[j]>key)
			{
				arra[j+1] = arra[j];
				j=j-1;
				
			}
			arra[j+1] = key;
		}
	}
	//shell sort
	/*
	 * void shellSort(int arry[]) { int h = 4; int temp;
	 * 
	 * for(i=0;i<(arry.length-h);i++) { if(arry[i] > arry[i+h]) { temp = arry[i];
	 * arry[i] = arry[i+h]; arry[i+h] = temp; }
	 * 
	 * 
	 * } System.out.println("array values after h=4 val "); for (int i = 0; i <
	 * arry.length; i++) { System.out.println(arry[i]); } h=2;
	 * for(i=0;i<(arry.length-h);i++) { if(arry[i] > arry[i+h]) { temp = arry[i];
	 * arry[i] = arry[i+h]; arry[i+h] = temp; }
	 * 
	 * 
	 * } System.out.println("array values after h=2 val "); for (int i = 0; i <
	 * arry.length; i++) { System.out.println(arry[i]); }
	 * 
	 * insertionSort(arry); }
	 */
	
	//shell sort
	
	void shellSort(int ar[])
	{
		int size = ar.length;
		int temp;
		for( i=size/2;i>0;i=i/2)
		{
			for(j=i;j<size;j++)
			{
				for(int k=j-i ; k>=0;k=k-i)
				{
					if(ar[k] >= ar[k+i])
				{
					temp = ar[k];
					ar[k] = ar[k+i];
					ar[k+i] = temp;
				}
					
				}
			}
		}
	}
	
//merge sort
	
	void merge(int arr[], int beg, int mid, int end)  
	{  
	  
	int left = mid - beg + 1;  
	int right = end - mid;  
	  
	int LeftArray[] = new int [left];  
	int RightArray[] = new int [right];  
	  
	for (int i=0; i<left; ++i)  
	LeftArray[i] = arr[beg + i];  
	  
	for (int j=0; j<right; ++j)  
	RightArray[j] = arr[mid + 1+ j];  
	  
	  
	int i = 0, j = 0;  
	int k = beg;  
	while (i<left&&j<right)  
	{  
	if (LeftArray[i] <= RightArray[j])  
	{  
	arr[k] = LeftArray[i];  
	i++;  
	}  
	else  
	{  
	arr[k] = RightArray[j];  
	j++;  
	}  
	k++;  
	}  
	while (i<left)  
	{  
	arr[k] = LeftArray[i];  
	i++;  
	k++;  
	}  
	  
	while (j<right)  
	{  
	arr[k] = RightArray[j];  
	j++;  
	k++;  
	}  
	}  
	  
	void mergeSort(int arr[], int beg, int end)  
	{  
	if (beg<end)  
	{  
	int mid = (beg+end)/2;  
	System.out.println("mid val"+mid);
	mergeSort(arr, beg, mid);  
	System.out.println("mid val rec 2 "+mid);
	mergeSort(arr , mid+1, end);  
	
	System.out.println("mid val rec 3 "+mid);
	merge(arr, beg, mid, end);  
	System.out.println("mid "+mid);
	}  
	}  
	//Quicksort
	
	int partition(int arr[], int low, int high) 
	{ 
		int pivot = arr[high]; 
		int i = (low-1); // index of smaller element 
		for (int j=low; j<high; j++) 
		{ 
			// If current element is smaller than the pivot 
			if (arr[j] < pivot) 
			{ 
				i++; 

				// swap arr[i] and arr[j] 
				int temp = arr[i]; 
				arr[i] = arr[j]; 
				arr[j] = temp; 
			} 
		} 

		// swap arr[i+1] and arr[high] (or pivot) 
		int temp = arr[i+1]; 
		arr[i+1] = arr[high]; 
		arr[high] = temp; 

		return i+1; 
	} 


	/* The main function that implements QuickSort() 
	arr[] --> Array to be sorted, 
	low --> Starting index, 
	high --> Ending index */
	void quicksort(int arr[], int low, int high) 
	{ 
		if (low < high) 
		{ 
			/* pi is partitioning index, arr[pi] is 
			now at right place */
			int pi = partition(arr, low, high); 
System.out.println("pi val is "+pi + "vaall"+arr[pi]);
			// Recursively sort elements before 
			// partition and after partition 
quicksort(arr, low, pi-1); 
quicksort(arr, pi+1, high); 
		} 
	} 
	
	//radix sort
	
	  int largest(int a[],int size)  
	    {     
	        int larger=a[0], i;   
	        System.out.println("a[0]"+a[0]);
	        for(i=1;i<size;i++)  
	        {  
	            if(a[i]>larger)  
	            larger = a[i];  
	        }  
	        return larger;  
	    }  
	     void radixSort(int a[],int size)  
	    {  
	        int bucket[][]=new int[10][10];  
	        int bucket_count[]=new int[10];  
	        int i, j, k, remainder, NOP=0, divisor=1, larger, pass;  
	        larger = largest(a,size); 
	        while(larger>0)  
	        {  
	            NOP++;  
	            larger/=10;  
	        }  
	        for(pass=0;pass<NOP;pass++) // Initialize the buckets  
	        {  
	            for(i=0;i<size;i++)  
	            bucket_count[i]=0;  
	            for(i=0;i<size;i++)  
	            {  
	                // sort the numbers according to the digit at passth place            
	                remainder = (a[i]/divisor)%10;  
	                bucket[remainder][bucket_count[remainder]] = a[i];  
	                bucket_count[remainder] += 1;  
	            }  
	            // collect the numbers after PASS pass  
	            i=0;  
	            for(k=0;k<size;k++)  
	            {  
	                for(j=0;j<bucket_count[k];j++)  
	                {  
	                    a[i] = bucket[k][j];  
	                    i++;  
	                }  
	            }  
	            divisor *= 10;  
	        }  
	    }  
//heapsort
	     
	     void heapify(int arr[], int size, int i)  
	     {  
	     int largest = i;    
	     int left = 2*i + 1;    
	     int right = 2*i + 2;    
	       int temp;
	     if (left < size && arr[left] >arr[largest])  
	     largest = left;  
	       
	     if (right < size && arr[right] > arr[largest])  
	     largest = right;  
	       
	     if (largest != i)  
	     {  
	    temp = arr[i];  
	         arr[i]= arr[largest];   
	         arr[largest] = temp;  
	     heapify(arr, size, largest);  
	     }  
	     }  
	       
	     void heapSort(int arr[], int size)  
	     {  
	     int i,temp;  
	     for (i = size / 2 - 1; i >= 0; i--)  
	     heapify(arr, size, i);  
	     for (i=size-1; i>=0; i--)  
	     {  
	     temp = arr[0];  
	         arr[0]= arr[i];   
	         arr[i] = temp;  
	     heapify(arr, i, 0);  
	     }  
	     }  
	     
	     // binary tree sort
	     
	     class Node  
	     { 
	         int key; 
	         Node left, right; 
	   
	         public Node(int item)  
	         { 
	             key = item; 
	             left = right = null; 
	         } 
	     } 
	   
	     // Root of BST 
	     Node root = null; 
	   
	     // Constructor 
	    
	     // This method mainly 
	     // calls insertRec() 
	     void insert(int key) 
	     { 
	         root = insertRec(root, key); 
	     } 
	       
	     /* A recursive function to  
	     insert a new key in BST */
	     Node insertRec(Node root, int key)  
	     { 
	   
	         /* If the tree is empty, 
	         return a new node */
	         if (root == null)  
	         { 
	             root = new Node(key); 
	             return root; 
	         } 
	   
	         /* Otherwise, recur 
	         down the tree */
	         if (key < root.key) 
	             root.left = insertRec(root.left, key); 
	         else if (key > root.key) 
	             root.right = insertRec(root.right, key); 
	   
	         /* return the root */
	         return root; 
	     } 
	       
	     // A function to do  
	     // inorder traversal of BST 
	     void inorderRec(Node root)  
	     { 
	         if (root != null)  
	         { 
	             inorderRec(root.left); 
	             System.out.print(root.key + " "); 
	             inorderRec(root.right); 
	         } 
	     } 
	     void treeins(int arr[]) 
	     { 
	         for(int i = 0; i < arr.length; i++) 
	         { 
	             insert(arr[i]); 
	         } 
	           
	     } 
	     
	     
public static void main(String[] args)
{
	int choice=0;  
	 char ch = ' ';
	    Scanner sc = new Scanner(System.in);  
	    SearchAndSortArray s = new SearchAndSortArray();  
	    System.out.println("*********Stack operations using array*********\n");  
	    System.out.println("\n------------------------------------------------\n");  
	    do
	    {  
	        System.out.println("\nChose one from the below options...\n");  
	        System.out.println("\n1.Push\n2.Pop\n3.Show\n4.Peek\n5shellsort\n6.mergesort\n7.quicksort"
	        		+ "\n8.Radixsort\n9.Heapsort\n10.Binary sort tree");  
	        System.out.println("\n Enter your choice \n");        
	        choice = sc.nextInt();  
	        
	        switch(choice)  
	        {  
	            case 1:  
	            {   
	            	System.out.println("Enter the size of array");
	            	int n = sc.nextInt();
	            	int[] arry = new int[n];
	            	System.out.println("Enter the elements");
	            	for(int i=0;i<n;i++)
	            	{
	            		arry[i] = sc.nextInt();
	            	}
	                s.insert(arry,n);  
	                break;  
	            }  
	            case 2:  
	            {  
	               s.bubbleSort(s.arr); 
	               s.display();
	                break;  
	            }  
	            case 3:  
	            {  
	              s.display();  
	                break;  
	            }  
	            case 4:  
	            {  
	               s.insertionSort(s.arr);s.display();  
	                break;  
	            }  
	            case 5 :
	            	    s.shellSort(s.arr);
	            	 
	            	    s.display();break;
	            case 6 : s.mergeSort(s.arr, 0, s.arr.length-1);
	                     s.display();break;
	                     
	            case 7 : s.quicksort(s.arr, 0, s.arr.length-1);s.display();break;

	            case 8 : s.radixSort(s.arr,s.arr.length);s.display();break;
	            	
	            case 9 : s.heapSort(s.arr, s.arr.length);s.display();break;
	            case 10 : s.treeins(s.arr);s.inorderRec(s.root);break;
	            default:  
	            {  
	                System.out.println("Please Enter valid cho1"
	                		+ "ice ");  
	            }  
	        }
	            System.out.println("Do you want to continue ? (Y/N)");
				Scanner acb = new Scanner(System.in);
				ch = acb.next().charAt(0);
			
	    }while (ch == 'y' || ch == 'Y');
	        
	    
}
	
}

