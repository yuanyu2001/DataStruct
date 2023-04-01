package Tree.AVL;

/**
 * @author yuanyu
 * @version 1.0
 */
public class AVL_Tree {
    public static void main(String[] args) {

    }
}

class Node{
    int value;
    Node left;
    Node right;
    public Node(int value) {
        this.value = value;
    }

    //计算左子树的高度
    public int leftHeigh() {
        if(left==null) {
            return 0;
        }
        return left.height();
    }
    //计算右子树的高度
    public int rightHeigh() {
        if(right==null) {
            return 0;
        }
        return right.height();
    }
    //计算结点的树高度
    public int height() {
        return Math.max(left==null ? 0 : left.height(), right==null?0:right.height())+1;
    }

    //左旋
    public void leftRotate() {
        //创建新节点
        Node node=new Node(this.value);
        //对新结点进行操作
        node.left=this.left;
        node.right=this.right.left;
        //修改当前节点
        this.value=this.right.value;
        this.right=this.right.right;
        this.left=node;
    }

    //右旋
    //右旋转
    public void rightRotate() {
        //创建新节点
        Node node = new Node(this.value);
        //操作新节点
        node.left=this.left.right;
        node.right=this.right;
        //修改当前节点
        this.value=this.right.value;
        this.left=this.left.left;
        this.right=node;
    }

    //添加结点
    public void add(Node node) {
        if(node==null) {
            System.out.println("此结点为空，不可添加");
            return;
        }
        if(this.value>node.value) {
            if(this.left==null) {
                this.left=node;
            }else {
                this.left.add(node);
            }
        }else {
            if(this.right==null) {
                this.right=node;
            }else {
                this.right.add(node);
            }
        }
//        //左旋
//        if(this.rightHeigh()-this.leftHeigh()>1) {
//            this.leftRotate();
//        }
//        //右旋
//        if(this.leftHeigh()-this.rightHeigh()>1) {
//            this.rightRotate();
//        }

        //左子树高>右子树高===>右旋转
        if(this.leftHeigh()-this.rightHeigh()>1) {
            if(this.left!=null&&this.left.leftHeigh()<this.left.rightHeigh()) {
                this.left.leftRotate();
            }
            this.rightRotate();
        }
        //右子树高》左子树高---》左旋转
        if(this.rightHeigh()-this.leftHeigh()>1) {
            if(this.right!=null&&this.right.leftHeigh()>this.right.rightHeigh()) {
                this.right.rightRotate();
            }
            this.leftRotate();
        }


    }
    @Override
    public String toString() {
        return "Node [value=" + value + "]";
    }
    //中序遍历
    public void infixOrder() {
        if(this.left!=null) {
            this.left.infixOrder();
        }
        System.out.println(this);
        if(this.right!=null) {
            this.right.infixOrder();
        }
    }
}

