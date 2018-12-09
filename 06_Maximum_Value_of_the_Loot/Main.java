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
}

 
/*Failed case #6/13: Wrong answer
got: 3032.1773 expected: 7777.731
 (Time used: 0.82/1.50, memory used: 34521088/671088640.) */
 
