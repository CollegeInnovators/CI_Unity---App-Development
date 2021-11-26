import java.util.*;
public class Calculator {
	public static void main(String[] args) {
		float n1,n2;
		int ch;
		float r;
		System.out.println("\n Enter the 2 numbers");
		Scanner s1=new Scanner(System.in);
		n1=s1.nextFloat();
		n2=s1.nextFloat();
		System.out.println("\nMENU \n1.ADDITION \n2.SUBTRACTION \n3. MULTIPLICATION \n4.DIVISION");
		System.out.println("ENTER YOUR CHOICE (1-4)");
		ch=s1.nextInt();
		
		switch(ch)
		{
		case 1: r=n1+n2;
				System.out.println("The sum of the 2 numbers is "+ r);
				break;
		
		case 2: r=n1-n2;
				System.out.println("The difference of the 2 numbers is "+ r);
				break;
		
		case 3: r=n1*n2;
				System.out.println("The multiplication of the 2 numbers is "+ r);
				break;
				
		case 4: r=n1/n2;
				System.out.println("The division of the 2 numbers is "+ r);
				break;
				
		default: System.out.println("Sorry, you have entered a wrong choice");
		}

	}

}
