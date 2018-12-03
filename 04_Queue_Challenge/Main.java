
import java.util.LinkedList;

public class Main {

    public static void main(String[] args) {
        // should return true
        System.out.println(checkForPalindrome("abccba"));
        // should return true
        System.out.println(checkForPalindrome("Was it a car or a cat I saw?"));
        // should return true
        System.out.println(checkForPalindrome("I did, did I?"));
        // should return false
        System.out.println(checkForPalindrome("hello"));
        // should return true
        System.out.println(checkForPalindrome("Don't nod"));
		System.out.println(checkForPalindrome("mike"));
		System.out.println(checkForPalindrome("abcdeedcba"));
    }

    public static boolean checkForPalindrome(String string) {
		String input = string.replaceAll("[^a-zA-Z]","").replaceAll("\\s","").toLowerCase();
		char[] charArray = input.toCharArray();
		LinkedList<Character> stack = new LinkedList();
		LinkedList<Character> queue = new LinkedList();
		for (int i=0; i< charArray.length; i++) {
			stack.push(charArray[i]);
		}
		for (int i=0; i<charArray.length; i++) {
			queue.addLast(charArray[i]);
		}
		while (stack.size()>0) {
			if (stack.pop() == queue.removeFirst()) {
				continue;
			} else {
				return false;
			}
		}
		return true;
    }
}
