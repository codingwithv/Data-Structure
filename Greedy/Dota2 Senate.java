// Approach - 1 

class Solution {
    int n;

    void removeSenator(char[] senate, boolean[] removed, char c, int idx){
        while(true){
            if(senate[idx] == c && !removed[idx]){
                removed[idx] = true;
                break;
            }
            idx = (idx + 1) % n;
        }
    }
    public String predictPartyVictory(String senate) {
        n = senate.length();

        int rCount = (int) senate.chars().filter(c -> c == 'R').count();
        int dCount = n - rCount;

        int idx = 0;

        // Initially no one removed
        boolean[] removed = new boolean[n];
        Arrays.fill(removed, false);

        while(rCount > 0 && dCount > 0){
            if(!removed[idx]){
                if(senate.charAt(idx) == 'R'){
                    removeSenator(senate.toCharArray(), removed, 'D', (idx+1)%n);
                    dCount--;
                }
                else{
                    removeSenator(senate.toCharArray(), removed, 'R', (idx+1)%n);
                    rCount--;
                }
            }
            idx = (idx + 1) % n;
        }
        return rCount == 0 ? "Dire" : "Radiant";
    }
}

// Approach - 2 Using Queue 

class Solution {
    public String predictPartyVictory(String senate) {
        int n = senate.length();

        Queue<Integer> rIdx = new LinkedList<>();
        Queue<Integer> dIdx = new LinkedList<>();

        for(int i = 0 ; i < n ; i++){
            if(senate.charAt(i) == 'R'){
                rIdx.add(i);
            }
            else{
                dIdx.add(i);
            }
        }

        while(!rIdx.isEmpty() && !dIdx.isEmpty()){
            int i = rIdx.poll();
            int j = dIdx.poll();

            if(i < j){
                rIdx.add(i+n);
            }
            else{
                dIdx.add(j+n);
            }
        }
        return rIdx.isEmpty() ? "Dire" : "Radiant";
    }
}
