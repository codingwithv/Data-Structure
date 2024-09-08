/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode[] splitListToParts(ListNode head, int k) {
        // Step 1 : find the length of list
        ListNode curr = head;
        int l = 0;
        while(curr != null){
            l++;
            curr = curr.next;
        }
        // Step 2 : Calculate the base size of each part and the remainder
        int eachBucketN = l / k;
        int remNodes = l % k;

        // Step 3 : Create ans array to hold the resulting listNode parts
        ListNode[] res = new ListNode[k];

        // Step 4 : Reintilize 'curr' node to head of the list
        curr = head;
        ListNode prev = null;

        // Step 5 : Loop over k parts
        for(int i  = 0; curr != null && i < k; i++){
            res[i] = curr;
            // Step 6 : Loop over the nodes in the current part
            for(int count = 1; count <= eachBucketN + (remNodes > 0 ? 1 : 0); count++){
                prev = curr;
                curr = curr.next; 
            }
            // Step 7 : Break the connection after the current part
            if(prev != null){
                prev.next = null;
            }
            // Step 8 : Decrease the remainder count
            remNodes--;
        }
        return res;
    }
}
