import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @author yuanyu
 * @version 1.0
 */
public class graph {//无向图
    private List<String> vertexList;//用于存储顶点集合
    private int[][] edges;//用户保存图的对应边
    private int edgeOfNum;//显示边的条数
    private boolean[] isVisited;//记录顶点是否被访问，数组大小和顶点个数一致

    //图的构造器
    public graph(int n) {
        this.vertexList = new ArrayList<String>(n);
        this.edges = new int[n][n];
    }

    //插入顶点方法
    public void addVertex(String vertex){
        vertexList.add(vertex);
    }
    //添加边的方法
    public void insertEdge(int v1 , int v2 , int weight){
        edges[v1][v2] = weight;
        edges[v2][v1] = weight;
        edgeOfNum++;
    }

    //图的常用API
    //1.获取2个顶点之间的权值
    public int getWeight(int v1 , int v2){
        return edges[v1][v2];
    }
    //2获取边的长度
    public int getEdgeOfNums(){
        return edgeOfNum;
    }
    //3通过下标返回节点对应的数据
    public String getVertexByIndex(int index){
        return vertexList.get(index);
    }
    //4获取顶点个数
    public int getVertexNum(){
        return vertexList.size();
    }
    //5 图的显示邻接矩阵显示方法
    public void showGraph(){
        for(int[] edge:edges){
            System.out.println(Arrays.toString(edge));
        }
    }
    //==================================深度优先遍历方法============================================
    //获取第一个邻接顶点的下标（不存在返回-1   否则返回下标）
    public int getFirstNeighbor(int index){
        for(int i = 0 ; i < vertexList.size() ; i ++){
            if(edges[index][i] == 1)
                return i;
        }
        return -1;
    }
    //根据当前节点和当前节点的第一个邻接节点返回第一个邻接节点的下一个邻接节点
    public int getnNextNeighbor(int v1 , int v2){
        for(int i = v2 + 1 ; i < vertexList.size() ; i ++){
            if(edges[v1][i] == 1)
                return i;
        }
        return -1;
    }
    //一个点的深度优先
    private void DFS(boolean[] isVisited , int index){//传入是否访问的数组，传入顶点下标
        System.out.print(getVertexByIndex(index));
        isVisited[index] = true;//表示被访问
        int w  = getFirstNeighbor(index);//获取顶点第一个邻接点
        while (w != -1){
            if(!isVisited[w]){
                System.out.print("-->");
                DFS(isVisited,w);
            }
            w = getnNextNeighbor(index,w);
        }
    }

    public void DFS(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getVertexNum(); i++) {
            if(!isVisited[i]){
                DFS(isVisited,i);
            }
        }
    }

    //===========================广度优先===========================
    //对一个节点进行广度优先遍历
    private void BFS(boolean[] isVisited , int index){//传入是否访问的数组，传入顶点下标
        int u ;//表示队列头节点对应下标
        int w ;//表示邻接节点的下标
        LinkedList queue = new LinkedList();//队列 记录节点访问的顺序
        System.out.print(getVertexByIndex(index));
        isVisited[index] = true;
        //下标入队
        queue.addLast(index);
        while(!queue.isEmpty()){
            //获取当前节点的第一个邻接点
             u = (Integer) queue.removeFirst();
             w = getFirstNeighbor(u);
             while (w != -1){//找到第一邻接点
                 if(!isVisited[w]){//没访问过的
                     System.out.print("-->");
                     System.out.print(getVertexByIndex(w));
                     isVisited[w] = true;//标记已访问
                     queue.addLast(w);//入队
                 }
                 w = getnNextNeighbor(u,w);
             }
        }

    }
    //多个节点
    public void BFS(){
        isVisited = new boolean[vertexList.size()];
        for (int i = 0; i < getVertexNum(); i++) {
            if(!isVisited[i]){
                BFS(isVisited,i);
            }
        }
    }

}
