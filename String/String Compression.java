class Solution {
    public int compress(char[] chars) {
        int n = chars.length;
        int i = 0; 
        int index = 0;

        while(i < n){
            char curr = chars[i];

            int count = 0;
            
            // find the duplicates
            while(i < n && chars[i] == curr){
                i++;
                count++;
            }

            // Assign it to chars and move index ahead to add the count
            chars[index++] = curr;

            // Add the count
            if(count > 1){
                String countStr = Integer.toString(count);
                for(char ch : countStr.toCharArray()){
                    chars[index++] = ch;
                }
            }
        }
        return index;
    }
}
