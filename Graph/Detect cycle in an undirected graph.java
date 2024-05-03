// Using DFS

class Solution {
    // Function to detect cycle in an undirected graph.
    public boolean dfs(int v, ArrayList<ArrayList<Integer>> adj, boolean[] vis, int parent){
        vis[v] = true;
        
        for(int neigh : adj.get(v)){
            if(!vis[neigh]){
                if(dfs(neigh, adj, vis, v)){
                    return true;
                }
            }
            else if(parent != neigh){
                return true;
            }
        }
        return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(dfs(i, adj, vis, -1)) return true;
            }
        }
        return false;
    }
}

// using BFS

class Pair<X, Y> {
    X first;
    Y second;

    public Pair(X first, Y second) {
        this.first = first;
        this.second = second;
    }

    public X getKey() {
        return first;
    }

    public Y getValue() {
        return second;
    }
}

class Solution {
    
    // Function to detect cycle in an undirected graph.
    public boolean bfs(int start, ArrayList<ArrayList<Integer>> adj, boolean[] vis){
       Queue<Pair<Integer,Integer>> que = new LinkedList<>();
       que.add(new Pair<>(start,-1));
       vis[start] = true;
       
       while(!que.isEmpty()){
           int curr = que.peek().getKey();
           int parent = que.peek().getValue();
           que.poll();
           
           for(int x : adj.get(curr)){
               if(!vis[x]){
                   que.add(new Pair<>(x, curr));
                   vis[x] = true;
               }
               else if(x != parent){
                   return true;
               }
           }
       }
       return false;
    }
    
    public boolean isCycle(int V, ArrayList<ArrayList<Integer>> adj) {
        // Code here
        boolean[] vis = new boolean[V];
        
        for(int i = 0; i < V; i++){
            if(!vis[i]){
                if(bfs(i, adj, vis)) return true;
            }
        }
        return false;
    }
}
