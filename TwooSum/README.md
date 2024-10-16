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
*In this approach, we use a nested for loop to go through each combination of two values that add up 
(e.g. list = [1,2,3] & target = 4)
- [x] Start with index @ 0. This is 1.
- [x] Nested loop starts with the next index @ 1. This is 2
- [ ] Does $$1 +2 = 4$$?. No
- [x] Still in the nested loop we stay with index @ 0. We move to index @ 2 for the second number. That is 3.
- [x] Does $$1 +3 = 4$$?. Yes
- [x] Return the index of the first number and the index of the second in a list


# Approach
*In the approach (Seen in _Code_ Section) we use a single for loop
- Let's first think about this mathematically:
    -  Let x = first input, Let y = second input, Let target = sum of x & y
    -  Consider: Let list = $$[x_1,y_2,z_3]$$
    -  Equation: $$x + y = target$$
    -  Calculate Compliment:
        - Think! _how can we find what value added with x equals target?_
        - Equation: $$target - y = x$$
    - Check:
        - To answer the question, we need to save $$x_1$$.
        - Calculate $$target - y$$ to ensure it is x
    - Verify:
        -  x_1 and y_2 are the values that get the target   
- Let's use a code example
(e.g. list = [1,2,3] & target = 4)
- [x] We need to save the index and value at index, so we use a HashMap (named _A_) to store key - denoted k - (index value) value (index)
- [x] Loop starts with the next index @ 0. This is 1
- [ ] If-statement to check if the HashMap contains a key equal to the current value. $$ (4-1 = 3) ∈ A_k $$ is false
- [x] We save the current value and the index 0. $$ A = {(1,0)} $$
- [x] Move to the next value @ index 1. This is 2.
- [ ] If-statement to check if the HashMap contains a key equal to the current value.  $$ (4-2 = 2) ∈ A_k $$ is false
- [x] We save the current value and the index 1. $$ A = {(1,0), (2,1)} $$
- [x] Move to the next value @ index 2. This is 3.
- [x] If-statement to check if the HashMap contains a key equal to the current value.  $$ (4-3 = 1) ∈ A_k $$ is true
- [x] Return the index of the saved value and the index of the current value


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
