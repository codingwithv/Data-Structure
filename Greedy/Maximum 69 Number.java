class Solution {
    public int maximum69Number (int num) {

        // Approach 1
        char[] arr = String.valueOf(num).toCharArray();

        for(int i = 0 ; i < arr.length; i++){
            if(arr[i] == '6'){
                arr[i] = '9';
                break;
            }
        }
        return Integer.parseInt(new String(arr));

        // Approach 2

        int place = 0;
        int index = -1;
        int temp = num;
        
        while(temp > 0){
            int rem = temp % 10;
            if(rem == 6){
                index = place;
            }
            temp = temp / 10;
            place++;
        }
        if(index == -1) return num;

        return num + 3 * (int) Math.pow(10,index);
    }
}
