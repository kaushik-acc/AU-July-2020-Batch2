import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Enter 2 numbers");
		Scanner s = new Scanner(System.in);

        int a = s.nextInt();
        int b = s.nextInt();
        Operations obj = new Operations();

        System.out.println("Sum of " + a + " and " + b + " is " + obj.add(a,b));
        System.out.println("Difference of " + a + " and " + b + " is " + obj.sub(a,b));
        System.out.println("Product of " + a + " and " + b + " is " + obj.prod(a,b));
        System.out.println("Quotient of " + a + " and " + b + " is " + obj.div(a,b));

	}

}
