import java.util.HashMap;

public class TwoSum {
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
