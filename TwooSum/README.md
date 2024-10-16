# Intuition
Brute Force:
``` java []
class Solution {
    public int[] twoSum(int[] nums, int target) {
        for(int i = 0 ; i<nums.length ; i++){
            for(int j = i+1 ; j<nums.length;j++){
                if(nums[i]+nums[j]==target){
                    return new int[] {i,j};
                }
            }
        }
        return new int[] {};
    }
}
```
*In this approach we use a nested for loop to go through each combination of two values that add up 
(e.g. list = [1,2,3] & target = 4)
- [x] Start with index @ 0. This is 1.
- [x] Nested loop starts with the next index @ 1. This is 2
- [ ] Does $$1 +2 = 4$$?. No
- [x] Still in the nested loop we stay with index @ 0. We move to index @ 2 for the second number. That is 3.
- [x] Does $$1 +3 = 4$$?. Yes
- [x] Return the index of the first number and the index of the second in a list


# Approach
*In the approach (Seen in _Code_ Section) we use a single for loop

(e.g. list = [1,2,3] & target = 4)
- [x] Start with index @ 0. This is 1.
- [x] Nested loop starts with the next index @ 1. This is 2
- [ ] Does $$1 +2 = 4$$?. No
- [x] Still in the nested loop we stay with index @ 0. We move to index @ 2 for the second number. That is 3.
- [x] Does $$1 +3 = 4$$?. Yes
- [x] Return the index of the first number and the index of the second in a list


# Complexity
- Time complexity:
$$O(n)$$

- Space complexity:
$$O(n)$$ 

# Code
```java []
class Solution {
    public int[] twoSum(int[] nums, int target) {
        //add value at index to an array
        //check it against target-1
        HashMap<Integer,Integer> map = new HashMap<>();

        for(int i = 0; i< nums.length; i++){
            if(map.containsKey(target - nums[i])){
                return new int[]{map.get(target - nums[i]),i};
            }
            else{
                map.put(nums[i],i);
            }
        }
        return null;
        
    }
}
```
