import java.util.*;

public class LCM3 {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long a = scn.nextInt();
		long b = scn.nextInt();
		System.out.println(LCM(a,b));
		
	}
	public static long LCM(long a, long b) {
		long larger = (long)Math.max(a,b);
		long smaller = (long)Math.min(a,b);
		long LCM = 1;
		long GCF = GCFFast(a,b);
		long x = larger / GCF;
		return x * smaller;
	}
	public static long GCFFast(long a, long b) {
		long larger;
		long smaller;
		long mod = 1;
		long modPrev = 1;
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