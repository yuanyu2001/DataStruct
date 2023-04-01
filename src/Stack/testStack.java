package Stack;

import java.util.Scanner;

/**
 * @author yuanyu
 * @version 1.0
 */
public class testStack {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int button ;
        boolean loop = true;
        stack stack01 = null;
        do{
            manus();
            button = sc.nextInt();
            switch(button){
                case 1:
                    System.out.println("请输入栈的长度");
                    int len = sc.nextInt();
                    stack01 = new stack(len);
                    break;
                case 2:
                    System.out.println("请输入你要压栈的元素：");
                    int value = sc.nextInt();
                    stack01.push(value);
                    break;
                case 3:
                    System.out.println(stack01.pop());
                    break;
                case 4:
                    if(stack01.isFull()){
                        System.out.println("栈已经满了！！！");
                    }else {
                        System.out.println("栈未满！！！");
                    }
                    break;
                case 5:
                    if(stack01.isEmpty()){
                        System.out.println("栈空！！！");
                    }else {
                        System.out.println("栈不是空栈！！！");
                    }
                    break;
                case 6:
                    stack01.show();
                    break;
                case 7:
                    System.out.println("是否要退出（请输入Y/N y/n 是/否）");
                    char mark;
                    boolean loop1 = true;
                    while(loop1){
                        mark = sc.next().charAt(0);
                        if(mark == 'Y' || mark == 'y' || mark == '是'){
                            loop = false;
                            loop1 = false;
                            System.out.println("退出成功！！！！");
                        }else if(mark == 'N' || mark == 'n' || mark == '否'){
                            loop1 = false;
                            System.out.println("取消退出！！！");
                        }else{
                            System.out.println("你的输入不正确，请重新输入：");
                        }
                    }
                    break;
                default:
                    System.out.println("你输入不正确！！！请输入1-7");
                    break;

            }

        }while(loop);


    }
    //菜单
    public static void manus(){
        System.out.println("=====================================================================");
        System.out.println("==============================请选择你的操作============================");
        System.out.println("===============================1.初始化栈==============================");
        System.out.println("===============================2.进   栈==============================");
        System.out.println("===============================3.出   栈==============================");
        System.out.println("===============================4.栈是否满==============================");
        System.out.println("===============================5.栈是否空==============================");
        System.out.println("======================6.显示栈元素（从栈底到栈顶显示）=====================");
        System.out.println("===============================7.退   出==============================");
    }
}

