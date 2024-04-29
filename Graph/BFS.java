class Solution {
    // Function to return Breadth First Traversal of given graph.
    public ArrayList<Integer> bfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean []vis = new boolean[V];
        LinkedList<Integer> q = new LinkedList<>();
        ArrayList<Integer> arr = new ArrayList<>();
        
        vis[0] = true;
        q.add(0);
        
        while(!q.isEmpty()){
            int x = q.poll();
            arr.add(x);
            
        
            for(int y: adj.get(x)){
                if(!vis[y]){
                vis[y] = true;
                q.add(y);
                }
            }
        }
        
        return arr;
    }
}
