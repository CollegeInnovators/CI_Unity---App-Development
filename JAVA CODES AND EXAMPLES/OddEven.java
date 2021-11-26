import java.util.*;
import java.io.*;

public class OddEven {
	
	public static void main(String[] args) {
		int a;
		System.out.println("\n Enter the number");
		Scanner s1=new Scanner(System.in);
		a=s1.nextInt();
		
		if(a%2==0) {
			System.out.println("\n The number "+a+" is even");
		}
		else {
			System.out.println("\n The number "+a+" is odd");
		}

	}

}
