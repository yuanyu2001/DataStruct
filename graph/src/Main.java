import sun.reflect.generics.tree.Tree;

import java.util.Date;

/**
 * @author yuanyu
 * @version 1.0
 */
public class Main {
    public static void main(String[] args) {

        String[] vertexs = {"A","B","C","D","E","F"};
        graph graph = new graph(vertexs.length);
        for (String vertex : vertexs) {
            graph.addVertex(vertex);
        }
        //添加边a-b  a-c  b-c  b-d  b-e  c-f
        graph.insertEdge(0,1,1);
        graph.insertEdge(0,2,1);
        graph.insertEdge(1,2,1);
        graph.insertEdge(1,3,1);
        graph.insertEdge(1,4,1);
        graph.insertEdge(2,5,1);

        graph.showGraph();
        System.out.println("==============深度优先============");
        Date date = new Date();
        graph.DFS();
        Date date1 = new Date();
        System.out.println();
        System.out.println(date1);
        System.out.println(date1.getTime()-date.getTime());
        System.out.println("==============广度优先============");
        graph.BFS();
        System.out.println();
    }
}