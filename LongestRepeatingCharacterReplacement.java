class Solution {
    public int characterReplacement(String s, int k) {
        int[] viv = new int[26];
        int res = 0;
        int maxLen = 0;
        int l = 0 , r = 0;
        while(r < s.length()){
            viv[s.charAt(r) - 'A']++;
            maxLen = Math.max(maxLen, viv[s.charAt(r) - 'A']);
            if((r -l + 1 )- maxLen > k){
                viv[s.charAt(l) - 'A']--;
                l++;
            }
            res = Math.max(res, r -l + 1);
            r++;
        }
        return res;
    }
}
