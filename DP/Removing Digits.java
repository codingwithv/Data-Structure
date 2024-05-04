// Question :- https://cses.fi/problemset/task/1637/
// Input N = 27 
// Output = 5

import java.util.*;

public class RemovingDigits {
     static long removeDigits(long n){
        long[] dp = new long[(int) n+1];
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        for(int i = 1; i <= n; i++){
            long temp = i;
            while(temp > 0){
                long x = temp % 10;
                dp[i] = Math.min(dp[i], dp[(int)(i-x)]+1);
                temp /= 10;
            }
        }
        return dp[(int)n];
    }
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        long n = sc.nextLong();
        System.out.println(removeDigits(n));
    }
}
