import java.util.*;
public class LargestThree {

	public static void main(String[] args) {
		int a,b,c;
		Scanner s1=new Scanner(System.in);
		System.out.println("Enter the 1st number");
		a=s1.nextInt();
		System.out.println("Enter the 2nd number");
		b=s1.nextInt();
		System.out.println("Enter the 3rd number");
		c=s1.nextInt();
		
		if(a>b) {
			if(a>c) {
				System.out.println(a + "is the largest number");
			}
			else {
				System.out.println(c + "is the largest number");
			}
		}
		else {
			if(b>c) {
				System.out.println(b + "is the largest number");
			}
			else {
				System.out.println(c + "is the largest number");
			}
		}
	}

}
