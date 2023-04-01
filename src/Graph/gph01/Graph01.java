package Graph.gph01;

import java.util.*;

/**
 * @author yuanyu
 * @version 1.0
 */
class Graph01{
    private final int V;         //顶点数目
    private int E;               //边的数目
    private Set<Integer>[] adj;  //邻接表

    public Graph01(int V, int[][] edges) {
        this.V = V;
        adj = (HashSet<Integer>[]) new HashSet[V];
        for (int v = 0; v < V; v++) {
            adj[v] = new HashSet<Integer>();
        }
        for (int[] edge : edges) {
            int w = edge[0];   //第一个顶点
            int v = edge[1];   //第二个顶点
            addEdge(w, v);
        }
    }

    Graph01(int v) {
        V = v;
    }

    public void addEdge(int w, int v) {
        adj[w].add(v);
        adj[v].add(w);
        E++;
    }

    public int V() {
        return V;
    }

    public int E() {
        return E;
    }

    public Set<Integer> adj(int v) {
        return adj[v];
    }
}

class DepthFirstPaths{
    private boolean[] marked;
    private int[] edgeTo;     //从起点到一个顶点的已知路径上的最后一个顶点（父链接数组）
    private final int s;      //起点

    public DepthFirstPaths(Graph01 G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        dfs(G, s);
    }

    private void dfs(Graph01 G, int v) {
        marked[v] = true;
        for (int w : G.adj(v)) {
            if (!marked[w]) {
                edgeTo[w] = v;
                dfs(G, w);
            }
        }
    }

    public boolean hasPathTo(int v) {
        return  marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}

class BreadthFirstPaths{
    private boolean[] marked;
    private int[] edgeTo;      //父链接数组
    private final int s;       //起点

    public BreadthFirstPaths(Graph01 G, int s) {
        marked = new boolean[G.V()];
        edgeTo = new int[G.V()];
        this.s = s;
        bfs(G, s);
    }

    private void bfs(Graph01 G, int s) {
        Queue<Integer> queue = new ArrayDeque<>();
        marked[s] = true;   //标记起点
        queue.offer(s);
        while (!queue.isEmpty()) {
            int v = queue.poll();
            for (int w : G.adj(v)) {
                if (!marked[w]) {
                    edgeTo[w] = v;
                    marked[w] = true;
                    queue.offer(w);
                }
            }
        }
    }

    public boolean hasPathTo(int v) {
        return  marked[v];
    }

    public Stack<Integer> pathTo(int v) {
        if (!hasPathTo(v)) return null;
        Stack<Integer> path = new Stack<Integer>();
        for (int x = v; x != s; x = edgeTo[x]) {
            path.push(x);
        }
        path.push(s);
        return path;
    }

}

