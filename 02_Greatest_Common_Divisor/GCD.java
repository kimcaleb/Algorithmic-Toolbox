import java.util.*;

public class GCD {
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int a = scn.nextInt();
		int b = scn.nextInt();
		System.out.println(GCDFast(a,b));
		
	}
	
	public static int GCDFast(int a, int b) {
		int larger;
		int smaller;
		int mod = 1;
		int modPrev = 1;
		if (a>b) {
			larger = a;
			smaller = b;
		} else {
			larger = b;
			smaller = a;
		}
		if (larger % smaller == 0) {
			return smaller;
		}
		mod = larger % smaller;
		while(true) {
			if (mod == 0) {break;}
			modPrev = mod;
			mod = smaller % mod;
			smaller = modPrev;
		}
		return modPrev;		
	}
}

