class Solution {
    public int totalFruit(int[] fruits) {
        int n = fruits.length;
        int l = 0, r = 0, maxLen = 0;
        HashMap<Integer,Integer> viv = new HashMap<>();
        while(r < n){
            viv.put(fruits[r], viv.getOrDefault(fruits[r],0)+1);
            if(viv.size() > 2){
                viv.put(fruits[l],viv.get(fruits[l])-1);
                if(viv.get(fruits[l]) == 0){
                    viv.remove(fruits[l]);
                }
                l++;
            }
            maxLen = Math.max(maxLen, r - l + 1);
            r++;
        }
        return maxLen;
    }
}
