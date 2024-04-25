class Solution {
    public int partitionString(String s) {
        // Approach 1

        HashSet<Character> set = new HashSet<>();
        int count = 1;
        int i = 0;
        while(i < s.length()){
            if(!set.add(s.charAt(i))){
                count++;
                set.clear();
            }
            else{
                i++;
            }
        }
        return count;

        // Approach 2

        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);

        int count = 0;
        int substringStart = 0;

        for(int i = 0; i < s.length(); i++){
            if(lastSeen[s.charAt(i) - 'a'] >= substringStart){
                count++;
                substringStart = i;
            }
            lastSeen[s.charAt(i) - 'a'] = i;
        }
        return count + 1;
    }
}
