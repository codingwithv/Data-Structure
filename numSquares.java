class Solution {
    private int[] dp = new int[10001];
    public int numSquares(int n) {
        Arrays.fill(dp,-1);
        return minSquares(n);
        // int[] dp = new int[n+1];
        // Arrays.fill(dp, Integer.MAX_VALUE);
        // dp[0] = 0;

        // for(int i=1 ;i <= n; i++){
        //     for(int j = 1; j*j <= i; j++){
        //         int remain = i - j*j;
        //         dp[i] = Math.min(dp[i], 1 + dp[remain]);
        //     }
        // }
        // return dp[n];
    }

    private int minSquares(int n){
         if(n == 0){
            return 0;
        }

        if(dp[n] != -1){
            return dp[n];
        }

        int minCount = Integer.MAX_VALUE;

        for(int i = 1; i*i <= n; i++){
            minCount = Math.min(minCount, 1 + numSquares(n - i*i));
        }

        return dp[n] = minCount;
    }
}