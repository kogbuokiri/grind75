# Intuition
<!-- Describe your approach to solving the problem. -->

# Approach
<!-- Describe your approach to solving the problem. -->

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
