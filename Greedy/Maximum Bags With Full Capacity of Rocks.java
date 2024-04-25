class Solution {
    public int maximumBags(int[] capacity, int[] rocks, int additionalRocks) {
        int n = capacity.length;
        int count = 0; 
        int[] viv = new int[n];

        for(int i = 0 ; i < n; i++){
            viv[i] = capacity[i] - rocks[i];
        }

        Arrays.sort(viv);

        for(int i = 0; i< n; i++){
            if(additionalRocks >= viv[i]){
                additionalRocks -= viv[i];
                count++;
            }
            else{
                break;
            }
        }
        return count;
    }
}
