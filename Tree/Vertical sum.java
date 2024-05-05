// Question - https://www.geeksforgeeks.org/problems/vertical-sum/1

/*Complete the function below
Node is as follows:
class Node{
int data;
Node left, right;
Node(int item)
{
    data = item;
    left = right = null
}
}
*/
class Solution{
    ArrayList<Integer> res;
    public ArrayList <Integer> verticalSum(Node root) {
        // add your code here
        res = new ArrayList<Integer>();
        TreeMap<Integer,Integer> map = new TreeMap<>();
        verticalSum(root, 0 , map);
        
        for(int val : map.values()){
            res.add(val);
        }
        return res;
    }
    void verticalSum(Node root, int horD, TreeMap<Integer,Integer> map){
        if(root == null){
            return;
        }
        verticalSum(root.left, horD-1, map);
        map.put(horD, map.getOrDefault(horD,0)+root.data);
        verticalSum(root.right, horD+1, map);
    }
}
