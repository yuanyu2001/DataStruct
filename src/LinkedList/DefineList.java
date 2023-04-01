package LinkedList;

import java.awt.*;

/**
 * @author yuanyu
 * @version 1.0
 */
public class DefineList {
    private Node head = new Node();//头节点 不能动 不存放具体的数据

    //找到尾节点
    public Node findLast(){
        Node temp = head;
        while (true){
            if(temp.next == null){
                return temp;
            }
            temp =  temp.next;
        }
    }
    //空链表
    public boolean isEmpty(){
        return head.next == null;//头节点后没有就为空
    }
    //添加节点 在尾节点添加新的节点
    public void add(Node node){
        node = findLast().next;
    }

    //显示链表
    public void show(){
        if(isEmpty()){
            new RuntimeException("链表为空！！！");
        }
        Node temp = head.next;

        while (true){
            if (temp == null){
                break;
            }
            System.out.println(temp);
            temp = temp.next;
        }
    }


}
