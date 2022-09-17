import java.util.Scanner;
public class PrimeNegative {
	public static void main(String args[])throws Exception {
	int found = 0;
	Scanner s = new Scanner(System.in);
	System.out.println("enter the number");
	int num = s.nextInt();
	try {
		if (num < 0) {
		throw new NegativeNumberNotAllowedException();
		}
		else {
			try {
				if (num == 0 || num == 1) {
				throw new NumberNotPrimeException();
				} 
				else {
					for (int i = 2; i <= num / 2; i++) {
					if (num % i == 0) {
					found = 1;
					}
				}
				if (found == 1) {
					throw new NumberNotPrimeException();
					}
				else
				System.out.println("the given number is prime");
			}
		} catch (NumberNotPrimeException a) {
			System.out.println(a);
			}
			}
		} catch (NegativeNumberNotAllowedException e) {
			System.out.println(e);
		}
	}
}

class NumberNotPrimeException extends Exception {
	NumberNotPrimeException() {
	}
	public String toString() {
	return super.toString() + " : The given number is not prime";
	}
}

class NegativeNumberNotAllowedException extends Exception {
	NegativeNumberNotAllowedException() {
	}
	public String toString() {
	return super.toString() + " : The given number is negative";
	}
}
