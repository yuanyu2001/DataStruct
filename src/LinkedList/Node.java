package LinkedList;

import java.util.HashMap;

/**
 * @author yuanyu
 * @version 1.0
 */
public class Node <T>{
    Node<T> data ;
    Node<T> next;

    public Node() {

    }

    public Node(Node<T> data) {
        this.data = data;
        this.next = next;
    }

    @Override
    public String toString() {
        return "Node{" +
                "data=" + data +
                ", next=" + next +
                '}';
    }
}
