class Main {
	
	// Brute Force. 
    public static int[] twoSum(int[] nums, int target) {
        int[] twoSums = new int[2];
        boolean found = false;
        for (int x=0; x<nums.length; x++) {
			// y = x+1 because we always want to check combinations, not permutations. Because everything at and before x have been already checked
            for (int y=x+1; y<nums.length; y++) {
                if (nums[x] + nums[y] == target) {
                    twoSums[0] = x;
                    twoSums[1] = y;
                    found = true;
                }
                if (found) {break;}
            }
            if (found) {break;}
        }
        return twoSums;
    }
	// Cleaner code. Still Bruite Force. 
	public static int[] twoSum2(int[] nums, int target) {
		for (int i = 0; i < nums.length; i++) {
			for (int j = i + 1; j < nums.length; j++) {
				if (nums[j] == target - nums[i]) {
					return new int[] { i, j };
				}
			}
		}
    throw new IllegalArgumentException("No two sum solution");
	}
	// Time complexity: 0(n2). For each element we try to find its complement by looping through the rest of the array which takes O(n) time. Space complexity: O(1).
	
	
	// NOT MY SOLUTION BUT FOUND ON LEETCODE
	//To improve our run time complexity, we need a more efficient way to check if the complement exists in the array. If the complement exists, we need to look up its index. The best way to do this is using a hash table or hash map. We reduce teh look up time from 0(n) to O(1) by trading space for speed. A hash table is built exactly for this purpose, it supports fast look up in near constant time. Near because if a collition occurred, a look up could degenerate to O(n) time. We should be fine as long as the hash function was chosen carefully. A simple implementation uses two iterations. In the first iteration, we add each element's value and its index to the table. Then, in the second iteration we check if each element's complement (target - nums[i]) exists in the table. Time complexity : O(n). We traverse the list containing n elements exactly twice. Since the hash table reduces the look up time to O(1), the time complexity is O(n). Space complexity : O(n). The extra space required depends on the number of items stored in the hash table, which stores exactly n elements. 
	public int[] twoSumsFast(int[] nums, int targeet) {
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < nums.length; i++) {
			map.put(nums[i], i);
		}
		for (int i = 0; i < nums.length; i++) {
			int complement = target - nums[i];
			if (map.containsKey(complement) && map.get(complement) != i) {
				return new int[] { i, map.get(complement) };
			}
		}
		throw new IllegalArgumentException("No two sum solution");
		}
}

public int[] twoSum(int[] nums, int target) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < nums.length; i++) {
        int complement = target - nums[i];
        if (map.containsKey(complement)) {
            return new int[] { map.get(complement), i };
        }
        map.put(nums[i], i);
    }
    throw new IllegalArgumentException("No two sum solution");
}