// Using DFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];  // to store the distance between two nodes
        int[] dist2 = new int[n];  // to store the distance between two nodes

        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        // boolean arrays to mark our visits at each node
        boolean[] vis1 = new boolean[n];
        boolean[] vis2 = new boolean[n];
        
        // distance beetween node1 and node is 0, and same for node 2
        dist1[node1] = 0;
        dist2[node2] = 0;

        // call dfs
        dfs(edges, node1, dist1, vis1);
        dfs(edges, node2, dist2, vis2);

        int minDistNode = -1; // to store answer node
        int minDistTillNow = Integer.MAX_VALUE; // variable to store the min distance of our answer node from node1 & node2

        for(int i = 0; i < n; i++){
            // take the max between the two distances
            int maxD = Math.max(dist1[i], dist2[i]);
            // if that max is lesser than minDistSoFar
            if(minDistTillNow > maxD){
                minDistTillNow = maxD; // that max becomes a candidate min distance
                minDistNode = i; // that node becomes a candidate answer node
            }
        }
        return minDistNode;
    }

    private void dfs(int[] edges, int currNode, int[] dist, boolean[] vis){
        vis[currNode] = true;
        int nextNode = edges[currNode];
        if(nextNode != -1 && !vis[nextNode]){
            vis[nextNode] = true;
            dist[nextNode] = 1 + dist[currNode];
            dfs(edges, nextNode, dist, vis);
        }
    } 
}

// TC: O(2n), SC: O(n)

// Using BFS

class Solution {
    public int closestMeetingNode(int[] edges, int node1, int node2) {
        int n = edges.length;
        int[] dist1 = new int[n];
        int[] dist2 = new int[n];
        
        Arrays.fill(dist1, Integer.MAX_VALUE);
        Arrays.fill(dist2, Integer.MAX_VALUE);

        bfs(edges, node1, dist1);
        bfs(edges, node2, dist2);

        int minDisNode = -1;
        int minDisTillNow = Integer.MAX_VALUE;

        for(int i = 0; i < n; i++){
            int maxD = Math.max(dist1[i], dist2[i]);
            if(minDisTillNow > maxD){
                minDisTillNow = maxD;
                minDisNode = i;
            }
        }
        return minDisNode;
    }

    private void bfs(int[] edges, int currNode, int[] dist){
        Queue<Integer> que = new LinkedList<>();
        que.offer(currNode);

        boolean[] vis = new boolean[edges.length];
        vis[currNode] = true;

        dist[currNode] = 0;

        while(!que.isEmpty()){
            int curr = que.poll();
            int nextNode = edges[curr];
            if(nextNode != -1 && !vis[nextNode]){
                vis[nextNode] = true;
                dist[nextNode] = 1 + dist[curr];
                que.offer(nextNode);
            }
        }
    }
}
