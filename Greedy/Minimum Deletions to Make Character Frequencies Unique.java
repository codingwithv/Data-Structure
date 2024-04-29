// Approach 1 Using HashSet

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int result = 0;

        Set<Integer> st = new HashSet<>();

        for(int i = 0; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        for(int i = 0; i < 26; i++){
            while(freq[i] > 0 && st.contains(freq[i])){
                freq[i]--;
                result++;
            }
            st.add(freq[i]);
        }
        return result;
    }
}

// Approach 2 Not Using HashSet

class Solution {
    public int minDeletions(String s) {
        int[] freq = new int[26];
        int res = 0;

        for(int i = 0 ; i < s.length(); i++){
            freq[s.charAt(i) - 'a']++;
        }

        Arrays.sort(freq);

        for(int i = 24; i >= 0 && freq[i] > 0; i--){
            if(freq[i] >= freq[i+1]){
                int prev = freq[i];
                freq[i] = Math.max(0, freq[i+1]-1);
                res += (prev - freq[i]);
            }
        }
        return res;
    }
}
