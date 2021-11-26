import java.util.*;
public class Largest {

	public static void main(String[] args) {
		int a,b;
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the 1st number");
		a=s1.nextInt();
		System.out.println("Enter the 2nd number");
		b=s1.nextInt();
		
		if(a>b) {
			
				System.out.println(a + "is the largest number");
			}
			
		
		else {
				System.out.println(b + "is the largest number");
			}
		
		}
	}
