// Approach 1

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];

        for(char ch : sentence.toCharArray()){
            int index = ch - 'a';
            arr[index]++;
        }

        for(int count : arr){
            if(count == 0){
                return false;
            }
        }

        return true;
    }
}

// Approach 2  : One iteration Time complexity  : O(n) 
                            // Space complexity : o(1)

class Solution {
    public boolean checkIfPangram(String sentence) {
        int[] arr = new int[26];
        int count = 0;

        for(char ch : sentence.toCharArray()){
            int index = ch - 'a';
            
            if(arr[index] == 0){
                arr[index]++;
                count++;
            }
        }

        return count == 26;
    }
}
