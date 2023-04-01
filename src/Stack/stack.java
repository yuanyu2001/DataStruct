package Stack;

/**
 * @author yuanyu
 * @version 1.0
 */
public class stack {
    private int length;//栈长
    private int[] stackArr;
    private int buttom;//栈底指针
    private int top;//栈顶指针
    public stack(int length) {
        this.length = length;
        this.stackArr = new int[this.length];
        this.buttom = 0;
        this.top = 0;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int[] getStackArr() {
        return stackArr;
    }

    public void setStackArr(int[] stackArr) {
        this.stackArr = stackArr;
    }

    public int getButtom() {
        return buttom;
    }

    public void setButtom(int buttom) {
        this.buttom = buttom;
    }

    public int getTop() {
        return top;
    }

    public void setTop(int top) {
        this.top = top;
    }
    //栈空
    public boolean isEmpty(){
        return buttom == top;//2个指针相同表示栈空
    }
    //栈满
    public boolean isFull(){
        return top == this.length ;
    }
    //进栈
    public void push(int data){
        if(isFull()){
            System.out.println("栈已经满了！！！");
            return;
        }
        stackArr[top++] = data;
        //top++;
        System.out.println("进栈成功！！！");
    }
    //出栈
    public int pop(){
        if(isEmpty()){
            System.out.println("栈是空的！！！");
            new RuntimeException("StackNullException");
        }
        return stackArr[--top];
    }
    //显示栈元素
    public void show(){
        System.out.println("栈元素为：");
        for (int i = 0; i < this.getLength()  ; i++) {
            System.out.print(stackArr[i]+" \t");
        }
        System.out.println();
    }

}
