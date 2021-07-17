import java.io.*;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Assessment2 
{
	public static int findlargestofanarray(int[] a, int size)
	{
		Arrays.sort(a);
		return a[size-1];
		}
	
		public static void main(String args[])throws ArrayIndexOutOfBoundsException
		{
			int n;  
			int[] arr= {};
			Scanner sc =new Scanner(System.in);  
			System.out.print("Enter the number of elements you want to store: "); 
			
			try
			{ 
			n=sc.nextInt();
			arr = new int[n]; 
			System.out.println("Enter the elements of the array: "); 
			for(int i=0; i<n;i++)  
			{  
			   
			arr[i]=sc.nextInt(); 
			}   
			System.out.println("Largest: "+findlargestofanarray(arr,n));
			}
			catch(NegativeArraySizeException e)
			{
				System.out.print("Dont enter a negative number as size"); 
				
			}
			catch(InputMismatchException e)
			{
				System.out.print("Invalid inputs ");  	
			}
			  
		}

}
