package queue;

/**
 * @author yuanyu
 * @version 1.0
 */
class ArrayQueue {
    private int maxSize;//队列最大长度
    private int front;//对头
    private int rear;//队尾
    private int[] arr;//用于存放数据 模拟队列

    public ArrayQueue(int maxSize) {//构造器 创建queue 初始化
        this.maxSize = maxSize;
        arr = new int[maxSize];
        front = -1;
        rear = -1;
    }
    //队满
    public boolean isFull(){
        return (rear == maxSize-1);
    }
    //队空
    public boolean isEmpty(){
        return (front == rear);
    }
    //添加数据
    public void addQueue(int n){
        if(!isFull()){
            arr[++rear] = n;
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
        int temp = arr[++front];
        arr[front] = 0;
        return temp ;
    }
    //显示队列数据
    public void showQueue(){
        if(isEmpty()){
            System.out.println("队列为空！！！");
            return;
        }
        for(int i = 0; i < arr.length; i++){
            System.out.printf("%d\t" , arr[i]);
        }
        System.out.println();
    }
    //显示队头
    public int headQueue(){
        if(isEmpty()){
            System.out.println("队空！！！");
            throw new RuntimeException("队空！！！");
        }
        return arr[front+1];
    }


}
