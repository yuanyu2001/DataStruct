package queue;

import java.util.Scanner;

/**
 * @author yuanyu
 * @version 1.0
 */
public class doQueue01 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayQueue queue = null;
        int maxSize = 0;
        char c;
        boolean loop = true;
        do{
            manu();
            c = sc.next().charAt(0);
            switch (c){
                case '1':
                    System.out.println("请输入队列最大长度：");
                    maxSize = sc.nextInt();
                    queue = new ArrayQueue(maxSize);
                    break;
                case '2':
                    queue.showQueue();
                    break;
                case '3':
                    System.out.println("请输入所添加的值");
                    int data = sc.nextInt();
                    queue.addQueue(data);
                    break;
                case '4':
                    int head = queue.getQueue();
                    System.out.println(head + "出队！");
                    break;
                case '5':
                    System.out.print("队头为：");
                    System.out.println(queue.headQueue());
                    break;

                case'6':
                    System.out.println("是否确认退出（Y/N 是/否 y/n）");

                    boolean loop01 = true;
                    while (loop01){
                        char n = sc.next().charAt(0);
                        if(n == 'Y' || n == '是' || n == 'y'){
                            loop = false;
                            System.out.println("退出成功！！！");
                            break;
                        }else if(n == 'N' || n == '否' || n == 'n'){
                           loop = true;
                        }else {
                            System.out.println("请重新输入");
                        }
                    }

            }
        }while (loop);
        //System.out.println("");

    }
    public static void manu(){
        System.out.println("===============================================================");
        System.out.println("请选择你的操作：输入（1-6）");
        System.out.println("=========================1.创建队列==============================");
        System.out.println("=========================2.显示队列==============================");
        System.out.println("=========================3.添加队列==============================");
        System.out.println("=========================4.取出队列==============================");
        System.out.println("=========================5.显示队头==============================");
        System.out.println("=========================6.退出==============================");
    }
}
