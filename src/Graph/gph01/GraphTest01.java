package Graph.gph01;

import java.util.HashSet;

/**
 * @author yuanyu
 * @version 1.0
 */
public class GraphTest01 {


    public static void main(String[] args) {
        int V = 6;
        int[][] edges = {{0, 1}, {0, 2}, {0, 5}, {1, 2}, {2, 3}, {2, 4}, {3, 4},  {3, 5}};
        Graph01 g = new Graph01(V, edges);
        System.out.println("顶点数为：" + g.V());
        System.out.println("边数为：" + g.E());
        HashSet<Integer> set = (HashSet<Integer>) g.adj(2);
        System.out.println("顶点2包含的边有：");
        for (Integer v : set) {
            System.out.println(v);
        }
    }


}
