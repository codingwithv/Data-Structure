// Link - https://www.geeksforgeeks.org/problems/arrange-consonants-and-vowels/1

// Given a singly linked list having n nodes containing english alphabets ('a'-'z'). Rearrange the linked list in such a way that all the vowels come before the consonants while maintaining the order of their arrival. 


// Input:
// n = 9
// linked list: a -> b -> c -> d -> e -> f -> g -> h -> i 
// Output: 
// a -> e -> i -> b -> c -> d -> f -> g -> h
// Explanation: 
// After rearranging the input linked list according to the condition the resultant linked list will be as shown in output.

class Solution {
    
    public Node arrangeCV(Node head){
        //write code here and return the head of changed linked list
        Node vowel = new Node('a');
        Node cont = new Node('b');
        
        Node vowelH = vowel;
        Node contH = cont;
        
        while(head != null){
            char temp = head.data;
            if(temp == 'a' || temp == 'e' || temp == 'i' || temp == 'o' || temp == 'u'){
                vowel.next = head;
                vowel = vowel.next;
            }
            else{
                cont.next = head;
                cont = cont.next;
            }
            head = head.next;
        }
        
        cont.next = null;
        vowel.next = contH.next;
        return vowelH.next;
    }
}
