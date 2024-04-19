class Solution {
    public int maxSubarrayLength(int[] nums, int k) {

        int n = nums.length;
        int i = 0, j = 0;
        int res = 0;

        Map<Integer,Integer> map = new HashMap<>();
     
        while(j < n){
            map.put(nums[j], map.getOrDefault(nums[j],0)+1);

            while(i < j && map.getOrDefault(nums[j],0) > k){
                map.put(nums[i], map.getOrDefault(nums[i],0)-1);
                if(map.get(nums[i]) == 0){
                    map.remove(nums[i]);
                }
                i++;
            }
            res = Math.max(res, j - i + 1);
            j++;
        }
        return res;
    }
}
