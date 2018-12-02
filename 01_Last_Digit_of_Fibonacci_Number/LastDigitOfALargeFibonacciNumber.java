import java.util.Scanner;

public class LastDigitOfALargeFibonacciNumber {

  public static void main(String args[]) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();

    System.out.println(nthFibFast(n));
  }
  public static long nthFibFast(int n) {

    if (n == 0 || n == 1) {
        return n;
    }
    long[] array = new long[n];
    array[0] = 1;
    array[1] = 1;
    for (int x=2; x<array.length; x++) {
         array[x] = (array[x-1] + array[x-2]) % 10;
    }
    return array[n-1];
  }
}
