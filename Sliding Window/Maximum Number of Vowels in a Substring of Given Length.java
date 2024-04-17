class Solution {
    private boolean isVowel(char ch){
        return ch == 'a' || ch == 'e' || ch == 'i' || ch == 'o' || ch =='u';
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int i = 0, j = 0;
        int cnt = 0, maxV = 0;
        while(j< n){
            if(isVowel(s.charAt(j))){
                cnt++;
            }
            if(j - i + 1 == k){
                maxV = Math.max(maxV, cnt);
                if(isVowel(s.charAt(i))){
                    cnt--;
                }
                i++;
            }
            j++;
        }
        return maxV;
    }
}
