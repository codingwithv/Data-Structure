class Solution {
    // Function to return a list containing the DFS traversal of the graph.
    public ArrayList<Integer> dfsOfGraph(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        ArrayList<Integer> list  = new ArrayList<>();
        boolean vis[] = new boolean[V];
        dfs(0,adj,list,vis);
        return list;
    }
    
    public void dfs(int s,ArrayList<ArrayList<Integer>> adj,ArrayList<Integer> list,boolean vis[]){
        list.add(s);
        vis[s] = true;
        for(int u: adj.get(s)){
            if(vis[u]==false){
                dfs(u,adj,list,vis);
            }
        }
    }
}
