

import java.util.*;

public class Main {

    public static void main(String[] args) {

        LinkedList<Employee> employees = new LinkedList<>();
        employees.add(new Employee("Jane", "Jones", 123));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Mike", "Wilson", 45));
        employees.add(new Employee("Mary", "Smith", 5555));
        employees.add(new Employee("John", "Doe", 5678));
        employees.add(new Employee("Bill", "End", 3948));
        employees.add(new Employee("Jane", "Jones", 123));
		
        employees.forEach(e -> System.out.println(e));
		
		
		//My Solution - This algorithm takes advantage of the hashMap's characteristics to remove duplicate items from the LinkedList. Because the hashMap cannot contain duplicate keys, we can traverse the elements in the LinkedList, check to see if the element's id(key) is already in the hashMap, and add it to the elements to be removed if the key aleady exists. Othereise, we insert it into the hashMap. 
		Map<Integer, Employee> hashMap = new HashMap<>();
		List<Employee> toRemoveList = new ArrayList<>(); 
		for (int x=0; x<employees.size(); x++) {
			if (hashMap.containsKey(employees.get(x).getId())) {
				toRemoveList.add(employees.get(x));
			} else {
				hashMap.put(employees.get(x).getId(),employees.get(x));
			}
		}
		System.out.println("--------------------------------------------------");
		for (int x=0;x<toRemoveList.size();x++){
			employees.remove(toRemoveList.get(x));
		}
		employees.forEach(a->System.out.println(a));	
		//My Solution End
	}		
}
