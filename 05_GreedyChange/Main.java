import java.util.*;

public class Main{
	public static void main(String[] args) {
		Scanner scn = new Scanner(System.in);
		int x = scn.nextInt();
		System.out.println(makeChange(x));
	}
	
	public static int makeChange(int c) {
		int[] coins = {10,5,1};
		int change = c;
		int count = 0;
		for (int i=0; i<coins.length; i++) {
			while (change >= coins[i]) {
				change -= coins[i];
				count++;
			}			
		}
		return count;
	}
}