// Approach - 1

class Solution {
    public String reversePrefix(String word, char ch) {
        int firstOccur = word.indexOf(ch);
        if(firstOccur == -1){
            return word;
        } 
        StringBuilder sb = new StringBuilder(word.substring(0, firstOccur + 1)).reverse();
        if(firstOccur < word.length()){
            sb.append(word.substring(firstOccur + 1));
        }
        return sb.toString();
    }
}

// Approach - 2

class Solution {
    public String reversePrefix(String word, char ch) {
        StringBuilder sb = new StringBuilder(word);
        int firstOccur = word.indexOf(ch);
        int k = 0; 
        int l = firstOccur;
        while(k < l){
            swap(sb, k , l);
            k++;
            l--;
        }
        return sb.toString();
    }
    void swap(StringBuilder sb, int i, int j){
        char temp = sb.charAt(i);
        sb.replace(i, i+1, "" + sb.charAt(j));
        sb.replace(j, j+1, "" + temp);
    }
}
