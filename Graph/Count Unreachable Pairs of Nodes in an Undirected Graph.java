class Solution {
    public long countPairs(int n, int[][] edges) {
        long ans = 0;
        List<Integer>[] graph = new List[n];
        boolean[] vis = new boolean[n];
        int unreached = n;

        for(int i = 0; i < n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            int u = edge[0];
            int v = edge[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        for(int i = 0; i < n; i++){
            int reached = dfs(graph, i , vis);
            unreached -= reached;
            ans += (long) unreached * reached;
        }
        return ans;
    }

    private int dfs(List<Integer>[] graph, int u, boolean[] vis){
        if(vis[u]) return 0;

        vis[u] = true;
        int ans = 1;
        for(int v  : graph[u]){
            ans += dfs(graph, v, vis);
        }
        return ans;
    }
}
