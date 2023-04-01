package Tree.HaffmanTree;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * @author yuanyu
 * @version 1.0
 */
public class haffmanTree {
    @SuppressWarnings("all")
    public static void main(String[] args) {
        int arr[] = {13,7,8,3,29,6,1};
        Node haffmanTree = createHaffmanTree(arr);
        //System.out.println(haffmanTree.left);
        preOrder(haffmanTree);

    }

    //构建赫夫曼树
    public static Node createHaffmanTree(int[] arr){
        //第一步 遍历arr 数组
        //2 将arr 每个元素构建成一个Node
        //3 将Node 放进ArrayList中
        List<Node> nodes = new ArrayList<>();
        for (int value:arr) {
            nodes.add(new Node(value));
        }
        Collections.sort(nodes);//集合元素排序
        //System.out.println(nodes);
        while(nodes.size() > 1){
            Node leftnode = nodes.get(0);
            Node rightnode = nodes.get(1);
            Node paarentNode = new Node(leftnode.value + rightnode.value);
            paarentNode.left = leftnode;
            paarentNode.right = rightnode;
            nodes.remove(leftnode);
            nodes.remove(rightnode);
            nodes.add(paarentNode);
            Collections.sort(nodes);
        }
        return nodes.get(0);
    }

    //编写一个前序遍历的方法
    public static void preOrder(Node root){
        if(root != null){
            root.preOrder();
        }
    }
}

/**
 * 创建节点类
 * 为了让Node类 对象实现自然排序 实现collection集合排序
 * 实现conmparable接口
 */
class Node implements Comparable<Node>{
    int value;//节点权值
    Node left;
    Node right;

    public Node(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                '}';
    }

    @Override
    public int compareTo(Node o) {
        return this.value - o.value;//表示从小到大排序
    }

    //写1个前序遍历
    public void preOrder(){
        System.out.println(this);
        if(this.left != null){
            this.left.preOrder();
        }
        if(this.right != null){
            this.right.preOrder();
        }
    }
}