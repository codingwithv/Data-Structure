class Solution {
    public String breakPalindrome(String palindrome) {
        int n = palindrome.length();
        char[] pal = palindrome.toCharArray();
        if(n <= 1) return "";
        for(int i = 0; i < pal.length; i++){
            if(pal[i] != 'a'){
                pal[i] = 'a';
                return new String(pal);
            }
        }
        pal[pal.length-1] = 'b';
        return new String(pal);
    }
}
