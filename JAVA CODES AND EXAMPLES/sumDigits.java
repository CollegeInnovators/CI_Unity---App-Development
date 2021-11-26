import java.io.*;
import java.util.*;
public class sumDigits {

	public static void main(String[] args) {
		int n,digit, sum=0;
		System.out.println("\n Enter the number");
		Scanner s=new Scanner(System.in);
		n=s.nextInt();
		
		while(n>0) {
			digit=n%10;
			sum=sum+digit;
			n=n/10;
			
		}
		System.out.println("The sum is "+sum);

	}

}
