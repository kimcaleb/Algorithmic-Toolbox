import java.util.*;

public class LCM2 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long a = scn.nextInt();
		long b = scn.nextInt();
		System.out.println(LCM(a,b));
		
	}
	public static long LCM(long a, long b) {
		long larger = (long)Math.max(a,b);
		long largerValue = larger;
		long smaller = (long)Math.min(a,b);
		long LCM = 1;
		boolean isPrime = checkIfPrime(smaller);
		while (true) {
			if (larger%smaller == 0) {
				LCM = larger;
				break;
			} else if (isPrime == true) {
				LCM = larger * smaller;
				break;
			} else {
				larger = larger + largerValue;
			}
		}
		return LCM;
	}

	public static boolean checkIfPrime(long a) {
		boolean flag = true;
		for (int i=2; i<=a/2; i++) {
			if (a % i == 0) {
				flag = false;
				break;
			}
		}
		return flag;
	}
}

