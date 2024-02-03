import java.util.*;

class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        HashMap<Integer,Integer> map = new HashMap<>();
        for(int i=0;i<n;i++){
            int num = nums[i];
            int moreNedded = target-num;
            if(map.containsKey(moreNedded)){
                return new int[] {i,map.get(moreNedded)};
            }
            map.put(nums[i], i);
        }
        return null;
    }
}