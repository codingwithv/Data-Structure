class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int n = nums.length;
        if(k <= 1){
            return 0;
        }
        int i = 0, j = 0, cnt = 0, prod = 1;
        while(j < n){
            prod *= nums[j];
            while(prod >= k){
                prod /= nums[i];
                i++;
            }
            cnt += (j - i) + 1;
            j++;
        }
        return cnt;
    }
}
