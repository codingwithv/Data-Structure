// Approach 1 

class Solution {
    public String countAndSay(int n) {
        // Start with the base case
        String res = "1";

        // Iterate through from  2 to n
        for(int i = 2; i <= n; i++){
            StringBuilder current = new StringBuilder();
            int count = 1;
            for(int j = 1; j < res.length() ; j++){
                if(res.charAt(j) == res.charAt(j-1)){
                    count++;
                }
                else{
                    current.append(count).append(res.charAt(j-1));
                    count = 1;
                }
            }

            current.append(count).append(res.charAt(res.length()-1));
            res = current.toString();
        }
        return res;
    }
}


// Appraoch 2 : Recursive approach

class Solution {
    public String countAndSay(int n) {
        if(n == 1){
            return  "1";
        }
        String say = countAndSay(n-1);
        StringBuilder result = new StringBuilder();
        int count = 1;

        for(int i = 0; i < say.length(); i++){
            while(i < say.length()-1 && say.charAt(i) == say.charAt(i+1)){
                count++;
                i++;
            }
            result.append(count).append(say.charAt(i));
            count = 1;
        }
        return  result.toString();
    }
}

// Dry Run for n = 5:
// Let's walk through the code for n = 5.

// Initial Call:
// countAndSay(5) is called, but it first recursively calls countAndSay(4).

// 1st Recursive Call (n = 4):
// countAndSay(4) is called, but first it calls countAndSay(3).

// 2nd Recursive Call (n = 3):
// countAndSay(3) is called, but first it calls countAndSay(2).

// 3rd Recursive Call (n = 2):
// countAndSay(2) is called, but first it calls countAndSay(1).

// 4th Recursive Call (n = 1):
// Base case reached: countAndSay(1) returns "1".
// Backtracking Begins:
// Back to 3rd Recursive Call (n = 2):
// say = "1" (from countAndSay(1))
// We now count and say:
// There's one '1', so result = "11"
// Return "11" to the previous call (countAndSay(3)).
// Back to 2nd Recursive Call (n = 3):
// say = "11" (from countAndSay(2))
// We now count and say:
// There are two '1's, so result = "21"
// Return "21" to the previous call (countAndSay(4)).
// Back to 1st Recursive Call (n = 4):
// say = "21" (from countAndSay(3))
// We now count and say:
// One '2'
// One '1' → result = "1211"
// Return "1211" to the previous call (countAndSay(5)).
// Back to Initial Call (n = 5):
// say = "1211" (from countAndSay(4))
// We now count and say:
// One '1'
// One '2'
// Two '1's → result = "111221"
// Return "111221".
// Final Output:
// The final result for countAndSay(5) is "111221".

// Summary of Recursive Steps:
// n = 1: "1"
// n = 2: "11" (one 1)
// n = 3: "21" (two 1s)
// n = 4: "1211" (one 2, one 1)
// n = 5: "111221" (one 1, one 2, two 1s)
// Thus, the recursive approach correctly returns "111221" for n = 5.

