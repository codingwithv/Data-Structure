class Solution {
    public int maximumDetonation(int[][] bombs) {
        int n = bombs.length;
        int ans = 0;
        List<Integer>[] adj = new List[n];

        for(int i = 0; i < n; i++){
            adj[i] = new ArrayList<>();
        }

        for(int i = 0; i < n; i++){
            for(int j = 0; j < n; j++){
                if(i == j) continue;
                long rd = bombs[i][2];
                if(rd * rd >= squareDist(bombs, i , j)){
                    adj[i].add(j);
                }
            }
        }

        for(int i = 0; i < n; i++){
            Set<Integer> seen = new HashSet<>(Arrays.asList(i));
            dfs(adj, i , seen);
            ans = Math.max(ans, seen.size());
        }
        return ans;
    }

    private void dfs(List<Integer>[] adj, int u, Set<Integer> seen){
        for(int v : adj[u]){
            if(seen.contains(v)) continue;
            seen.add(v);
            dfs(adj, v, seen);
        }
    }

    private long squareDist(int[][] bombs, int i, int j){
        return (long) (bombs[i][0] - bombs[j][0]) * (bombs[i][0] - bombs[j][0]) + (long) (bombs[i][1] - bombs[j][1]) * (bombs[i][1] - bombs[j][1]);
    }
}
