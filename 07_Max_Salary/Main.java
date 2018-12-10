/*import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        String[] values = new String[a];
        for (int i=0; i<values.length; i++) {
            values[i] = String.valueOf(scn.nextInt());
        }
		System.out.println(largestNumber(values));
    }

    public static String largestNumber(String[] stringArray) {
		String newString = "";
		List<String> newArrayList = new ArrayList<>();
		for (int a=0;a<stringArray.length;a++) {
			if (stringArray[a].length() > 0) {
	
				String[] tempArray = stringArray[a].split("");
				for (int b=0; b<tempArray.length; b++) {
					newArrayList.add(tempArray[b]);
				}
			} else {
				newArrayList.add(stringArray[a]);
			}
		}
		Collections.sort(newArrayList,(a,b)-> b.hashCode()-a.hashCode());
		for (int c=0; c< newArrayList.size(); c++) {
			newString += newArrayList.get(c);
		}
		return newString;
    }
}/*
/*Failed case #1/11: (Wrong answer)

Input:
3
23 39 92

Your output:
993322

Correct output:
923923
 (Time used: 0.67/1.50, memory used: 32645120/536870912.)
 Misunderstood question. We do not have to dissect values that have more than 1 digit. We just need to see if the first digit in the value is greater 
 than or less than the other values. 
 
 <--Attempt 2-->*/
 /*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        List<String> values = new ArrayList<>(a);
        for (int i=0; i<a; i++) {
            values.add(String.valueOf(scn.nextInt()));
        }
        System.out.println(largestNumber(values));
    }

    public static String largestNumber(List<String> stringList) {
        String newString = "";
        while (stringList.size() > 0) {
            String maxDigit = "0";
            for (int i=0; i<stringList.size(); i++) {
                if (isGreaterThanOrEqual(stringList.get(i),maxDigit)) {
                    maxDigit = stringList.get(i);
                }
            }
            newString += maxDigit;
            stringList.remove(maxDigit);
        }
        return newString;
    }

    public static boolean isGreaterThanOrEqual(String a, String b) {
        String[] digit = a.split("");
        String[] maxDigit = b.split("");
        boolean greaterOrEqual = false;
        int i=0, x=0;
        while (i<digit.length && x<maxDigit.length) {
            if (Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[x])) {
                greaterOrEqual = true;
                break;
            }
            else if (Integer.valueOf(digit[i]) == Integer.valueOf(maxDigit[x])) {
                if (i != digit.length - 1 && x != maxDigit.length - 1) {
                    greaterOrEqual = true;
                    i++;
                    x++;
                }
                else if (x == maxDigit.length - 1 && i == digit.length - 1 ) {
                        greaterOrEqual = true;
                        break;
                }
                 else if (x == maxDigit.length - 1 && greaterOrEqual == true) {
                    break;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) >= Integer.valueOf(digit[++i])) {
                    greaterOrEqual = false;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) < Integer.valueOf(digit[++i])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[++x])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) <= Integer.valueOf(maxDigit[++x])) {
                    greaterOrEqual = false;

                }

            } else {
                greaterOrEqual = false;
                break;
            }
        }
        return greaterOrEqual;
    }
}
Failed case #6/11: Wrong answer

 (Time used: 0.53/1.50, memory used: 34668544/536870912.) 
Recived the following error for the following test case:
2
1011 101
Exception in thread "main" java.lang.ArrayIndexOutOfBoundsException: 4
	at Main.isGreaterThanOrEqual(Main.java:57)
	at Main.largestNumber(Main.java:19)
	at Main.main(Main.java:11)

Process finished with exit code 1
 
 <--Attempt 3-->*/
 /*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        List<String> values = new ArrayList<>(a);
        for (int i=0; i<a; i++) {
            values.add(String.valueOf(scn.nextInt()));
        }
        System.out.println(largestNumber(values));
    }

    public static String largestNumber(List<String> stringList) {
        String newString = "";
        while (stringList.size() > 0) {
            String maxDigit = "0";
            for (int i=0; i<stringList.size(); i++) {
                if (isGreaterThanOrEqual(stringList.get(i),maxDigit)) {
                    maxDigit = stringList.get(i);
                }
            }
            newString += maxDigit;
            stringList.remove(maxDigit);
        }
        return newString;
    }

    public static boolean isGreaterThanOrEqual(String a, String b) {
        String[] digit = a.split("");
        String[] maxDigit = b.split("");
        boolean greaterOrEqual = false;
        int i=0, x=0;
        while (i<digit.length && x<maxDigit.length) {
            if (Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[x])) {
                greaterOrEqual = true;
                break;
            }
            else if (Integer.valueOf(digit[i]) == Integer.valueOf(maxDigit[x])) {
                if (i != digit.length - 1 && x != maxDigit.length - 1) {
                    greaterOrEqual = true;
                    i++;
                    x++;
                }
                else if (x == maxDigit.length - 1 && i == digit.length - 1 ) {
                        greaterOrEqual = true;
                        break;
                }
                 else if (x == maxDigit.length - 1 && greaterOrEqual == true) {
                    break;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) >= Integer.valueOf(digit[++i])) {
                    greaterOrEqual = false;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) < Integer.valueOf(digit[++i])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[++x])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) <= Integer.valueOf(maxDigit[x++])) {
                    greaterOrEqual = false;

                }

            } else {
                greaterOrEqual = false;
                break;
            }
        }
        return greaterOrEqual;
    }
}

Failed case #6/11: Wrong answer

 (Time used: 0.58/1.50, memory used: 34418688/536870912.)
 Failed test case:
 4
1000 100 899 89
expected: 899891001000 got: 899891000100

<--Attempt 4-->*/
 
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int a = scn.nextInt();
        List<String> values = new ArrayList<>(a);
        for (int i=0; i<a; i++) {
            values.add(String.valueOf(scn.nextInt()));
        }
        System.out.println(largestNumber(values));
    }

    public static String largestNumber(List<String> stringList) {
        String newString = "";
        while (stringList.size() > 0) {
            String maxDigit = "0";
            for (int i=0; i<stringList.size(); i++) {
                if (isGreaterThanOrEqual(stringList.get(i),maxDigit)) {
                    maxDigit = stringList.get(i);
                }
            }
            newString += maxDigit;
            stringList.remove(maxDigit);
        }
        return newString;
    }

    public static boolean isGreaterThanOrEqual(String a, String b) {
        String[] digit = a.split("");
        String[] maxDigit = b.split("");
        boolean greaterOrEqual = false;
        int i=0, x=0;
        while (i<digit.length && x<maxDigit.length) {
            if (Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[x])) {
                greaterOrEqual = true;
                break;
            }
            else if (Integer.valueOf(digit[i]) == Integer.valueOf(maxDigit[x])) {
                if (i != digit.length - 1 && x != maxDigit.length - 1) {
                    greaterOrEqual = true;
                    i++;
                    x++;
                } else if (x == maxDigit.length - 1 && i == digit.length - 1) {
                    greaterOrEqual = true;
                    break;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x++]) == 0 && Integer.valueOf(digit[++i]) == 0) {
                    greaterOrEqual = false;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) >= Integer.valueOf(digit[++i])) {
                    greaterOrEqual = false;
                } else if (x == maxDigit.length - 1 && Integer.valueOf(maxDigit[x]) < Integer.valueOf(digit[++i])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) == 0 && Integer.valueOf(maxDigit[++x]) == 0) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) > Integer.valueOf(maxDigit[++x])) {
                    greaterOrEqual = true;
                } else if (i == digit.length - 1 && Integer.valueOf(digit[i]) <= Integer.valueOf(maxDigit[x++])) {
                    greaterOrEqual = false;

                }
            }
            else {
                greaterOrEqual = false;
                break;
            }
        }
        return greaterOrEqual;
    }
}




 
