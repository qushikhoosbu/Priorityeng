import java.io.*;
import java.util.Scanner;


public class Assessment{
	public double FindX(Double A, Double B)
    {
        double ans = 0.0;
        try
        {
        ans=(Math.sqrt((3*A)+1) )/B;
        }
        catch (ArithmeticException e)
        {
         System.out.println("Oops, you can’t "
          + "divide by zero.");
         return 0;
        }
        return (double)ans;
    }
	public double FindXint(int A, int B)
    {
        int ans = 0;
        try
        {
        ans=(int)((Math.sqrt((3*A)+1) )/B);
        }
        catch (ArithmeticException e)
        {
         System.out.println("Oops, you can’t "
          + "divide by zero.");
         return 0;
        }
        return ans;
    }
 
    public static void main(String[] args)
    {
    	Scanner sc = new Scanner(System.in);
    	System.out.println("Enter the two numbers\n");
        Double A   = sc.nextDouble();
        Double B   = sc.nextDouble();
        int a = sc.nextInt();
        int b = sc.nextInt();
        System.out.println("the first number"+A);
        System.out.println("the first number"+B);
        System.out.println("the first number"+a);
        System.out.println("the first number"+b);
        Assessment ass = new Assessment();
  
        System.out.println("The calculated value is"+ ass.FindX(A,B));
        System.out.println("The calculated value is"+ ass.FindXint(a,b));
    }

}
