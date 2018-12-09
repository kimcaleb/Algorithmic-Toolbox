
/*
import java.util.*;
public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();  // Bug: TreeMap cannot have duplicate keys, so this won't work for all test cases. 
        Map<Double,Integer> treeMap = new TreeMap<>((d1,d2) -> (int)(d2.doubleValue() - d1.doubleValue()));//Need to make sure to sort in descending order.
        Double[] valuePerWeight = new Double[x];
        for (int i=0; i<x;i++) {
            double c = scn.nextDouble();
            int d = scn.nextInt();
            treeMap.put((c/d), d);
            valuePerWeight[i] = c/d;
        }
        Arrays.sort(valuePerWeight,(d1,d2) -> (int)(d2.doubleValue() - d1.doubleValue())); //Need to make sure to sort in descending order.
        System.out.printf("%.4f",maxValue(treeMap,y,valuePerWeight));

    }

    public static double maxValue(Map<? super Double,? super Integer> treeMap,
                                  int c, Double[] valuePerWeight){
        double runningValue = 0;
        int Capacity = c;
        Integer[] weights = treeMap.values().toArray(new Integer[0]);
        for (int x=0; x<valuePerWeight.length; x++) {
            if (Capacity <= 0) {break;} // If Capacity is already 0, no need to go through the other items.
            while (weights[x] > 0 && Capacity > 0) { // Need to check Capacity here in case we reach 0 Capacity while weights[x] is still greater than 0.
                int min = Math.min(weights[x],Capacity);
                Capacity = Capacity - min;
                runningValue += valuePerWeight[x]*min;
                weights[x] = weights[x] - min;
            }
        }
        return runningValue;
    }
} */

 
/*Failed case #6/13: Wrong answer
got: 3032.1773 expected: 7777.731
 (Time used: 0.82/1.50, memory used: 34521088/671088640.)
// Bug: TreeMap cannot have duplicate keys, so this won't work for all test cases. Need another way to sort value//weight values and match their respective weight values in a separate array.  

<--Attempt 2-->*/
 /*
import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        List<Containers> containers = new ArrayList<>(); // Got rid of treeMap and used personal container class object that stores weightPerValue and weight and implements the comparable interface. Each object was then stored in an ArrayList and sorted. 
        for (int i = 0; i < x; i++) {
            double c = scn.nextDouble();
            int d = scn.nextInt();
            containers.add(new Containers((c/d),d));
        }
        Collections.sort(containers);
        System.out.printf("%.4f", maxValue(containers, y));

    }

    public static double maxValue(List<Containers> a, int c) {
        double runningValue = 0;
        int Capacity = c;
        for (int x = 0; x < a.size(); x++) {
            if (Capacity <= 0) {
                break;
            } 
            while (a.get(x).getWeight() > 0 && Capacity > 0) { 
                int min = Math.min(a.get(x).getWeight(),Capacity);
                Capacity = Capacity - min;
                runningValue += a.get(x).getWeightPerValue()*min;
                a.get(x).setWeight(a.get(x).getWeight() - min);
            }

        }
        return runningValue;
    }

}



class Containers implements Comparable<Containers> {

    private double weightPerValue;
    private int weight;

    public Containers(double wpv, int w) {
        weightPerValue = wpv;
        weight = w;
    }

    public double getWeightPerValue() {
        return weightPerValue;
    }

    public void setWeightPerValue(double weightPerValue) {
        this.weightPerValue = weightPerValue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public int compareTo(Containers o) {
        return (int)(o.weightPerValue - this.weightPerValue);
    }
}
*/
/*
/*Failed case #6/13: Wrong answer
got: 3032.1773 expected: 7777.731
 (Time used: 0.82/1.50, memory used: 34521088/671088640.)
Failed the following test case:
3 10
1 9
2 9
1 9
Ans: 1.2222  Expected: 2.1111
Issue appears to be related to the sorting and rounding of the decimal values of my valuePerWeight.
 
 <--Attempt 3-->*/
 
 import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int x = scn.nextInt();
        int y = scn.nextInt();
        List<Containers> containers = new ArrayList<>();
        for (int i = 0; i < x; i++) {
            double c = (double)scn.nextInt();
            int d = scn.nextInt();
            containers.add(new Containers((c/d),d));
        }
        Collections.sort(containers);
        System.out.printf("%.3f", maxValue(containers, y));

    }


    public static double maxValue(List<Containers> a, int c) {
        double runningValue = 0;
        double Capacity = c;
        for (int x = 0; x < a.size(); x++) {
            if (Capacity <= 0) {
                break;
            }
            double min = Math.min(a.get(x).getWeight(),Capacity);
            Capacity = Capacity - min;
            runningValue += a.get(x).getWeightPerValue()*min;

        }
        return runningValue;
    }

}



class Containers implements Comparable<Containers> {

    private double weightPerValue;
    private int weight;

    public Containers(double wpv, int w) {
        weightPerValue = wpv;
        weight = w;
    }

    public double getWeightPerValue() {
        return weightPerValue;
    }

    public void setWeightPerValue(double weightPerValue) {
        this.weightPerValue = weightPerValue;
    }

    public int getWeight() {
        return weight;
    }

    public void setWeight(int weight) {
        this.weight = weight;
    }
	// Refactored compareToMethod so that decimal values can be properly handled in returning the correct return value.
    @Override
    public int compareTo(Containers o) {
        if (o.weightPerValue - weightPerValue < 0) {
            return (int)Math.floor(o.weightPerValue - weightPerValue);
        } else if (o.weightPerValue - weightPerValue == 0) {
            return 0;
        }
        return (int)(Math.ceil(o.weightPerValue - this.weightPerValue));
	}
}


 
