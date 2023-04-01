package queue;

/**
 * @author yuanyu
 * @version 1.0
 */
public class CircleArrayQueue {
    private int maxSize;//队列最大长度
    private int front;//对头
    private int rear;//队尾 指向队列最后一个元素的后一个位置 因为希望空出一个空间
    private int[] arr;//用于存放数据 模拟队列

    public CircleArrayQueue(int maxSize) {//构造器 创建queue 初始化
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = 0;
        rear = 0;
    }
    //队满
    public boolean isFull(){
        return (((rear+1) % maxSize )==front);
    }
    //队空
    public boolean isEmpty(){
        return (front == rear);
    }
    //添加数据
    public void addQueue(int n){
        if(!isFull()){
            arr[rear] = n;
            rear = (rear+1) % maxSize;
            System.out.println("添加成功！！！");
        }else{
            System.out.println("队列已满，添加数据失败！！！");
        }
    }

    //出队
    public int getQueue(){
        if(isEmpty()){
            System.out.println("队列为空，取数据失败！！！");
            throw new RuntimeException("队列为空，取数据失败！！！");
        }
        int temp = arr[front];
        arr[front] = 0;
        front = (front + 1 ) % maxSize;
        return temp ;
    }
    //显示队列数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空！！！");
            return;
        }
        //现在应该从front 开始遍历
        for(int i = front; i < front + significanceSize(); i++){
            System.out.printf("%d\t" , arr[i % maxSize]);
        }
        System.out.println();
    }
    //显示队头
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队空！！！");
            throw new RuntimeException("队空！！！");
        }
        return arr[front];
    }
    //显示循环队列有效数据个数
    public int significanceSize(){
        return (rear + maxSize - front) % maxSize;
    }
}
