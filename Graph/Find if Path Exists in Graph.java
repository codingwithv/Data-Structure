// Using DFS

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        int[] vis = new int[n];

        return solve(graph, source, destination, vis);
    }

    public boolean solve(List<List<Integer>> graph, int source, int destination, int[] vis){
        if(source == destination){
            return true;
        }

        vis[source] = 1;

        for(int node : graph.get(source)){
            if(vis[node] == 0){
                if(solve(graph, node, destination, vis)){
                    return true;
                }
            }
        }
        return false;
    }
}

// Using BFS

class Solution {
    public boolean validPath(int n, int[][] edges, int source, int destination) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            graph.get(edge[0]).add(edge[1]);
            graph.get(edge[1]).add(edge[0]);
        }

        Queue<Integer> que = new LinkedList<>();
        int[] vis = new int[n];
        vis[source] = 1;
        que.add(source);

        while(!que.isEmpty()){
            int curr = que.poll();
            if(curr == destination) return true;
            for(int node : graph.get(curr)){
                if(vis[node] == 0){
                    vis[node] = 1;
                    que.add(node);
                }
            }
        }
        return false;
    }
}
