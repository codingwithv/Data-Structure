// Appraoch - 1 Using Stack

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
    public ListNode removeNodes(ListNode head) {
        Stack<ListNode> st = new Stack<>();
        ListNode curr = head;

        while(curr != null){
            st.push(curr);
            curr = curr.next;
        }

        curr = st.pop();
        int maxVal = curr.val;
        ListNode resH = new ListNode(maxVal);

        while(!st.empty()){
            curr = st.pop();
            if(curr.val < maxVal){
                continue;
            }
            else{
                ListNode newNode = new ListNode(curr.val);
                newNode.next = resH;
                resH = newNode;
                maxVal = curr.val;
            }
        }
        return resH;
    }
}

// Approach - 2 

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
    public ListNode removeNodes(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode nextNode = removeNodes(head.next);

        if (head.val < nextNode.val) {
            head = null;
            return nextNode;
        }

        head.next = nextNode;
        return head;
    }
}

// Appraoch - 3

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
    private ListNode reverseList(ListNode head){
        if(head == null || head.next == null){
            return head;
        }
        ListNode last = reverseList(head.next);
        head.next.next = head;
        head.next = null;

        return last;
    }
    public ListNode removeNodes(ListNode head) {
        head = reverseList(head);

        int maximum = 0;
        ListNode prev = null;
        ListNode curr = head;

        while(curr != null){
            maximum = Math.max(maximum, curr.val);

            if(curr.val < maximum){
                prev.next = curr.next;
                ListNode del = curr;
                curr = curr.next;
                del.next = null;
            }
            else{
                prev = curr;
                curr = curr.next;
            }
        }
        return reverseList(head);
    }
}
