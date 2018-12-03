import java.util.*;

public class LCM {

	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		long a = scn.nextInt();
		long b = scn.nextInt();
		System.out.println(LCM(a,b));
		
	}
	public static long LCM(long a, long b) {
		long larger = Math.max(a,b);
		long LCM = a*b;
		long potentialLCM = LCM;
		while (potentialLCM >= larger) {
			potentialLCM--;
			if (potentialLCM % a == 0 && potentialLCM % b == 0) {
				LCM = potentialLCM;
			}
		}
		return LCM;
	} 
}