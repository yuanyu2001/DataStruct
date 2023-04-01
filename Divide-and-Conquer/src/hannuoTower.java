import java.util.Scanner;

/**
 * @author yuanyu
 * @version 1.0
 */
public class hannuoTower {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("请输入有几个盘子：");
        int num = sc.nextInt();
        hannuoTower(num,'A' , 'B' , 'C');
    }
    /**
     *将盘子看做 只有最下面的一个盘子 和 上面的盘子
     * @param num 表示一共有几个盘子
     * @param a  表示A 柱
     * @param b  表示B 柱
     * @param c  表示C 柱
     */
    public static void hannuoTower(int num , char a , char b , char c){
        if(num == 1){
            System.out.println(a + " -> " + c);
        }else {
            hannuoTower(num - 1 , a , c , b);//上面盘看成一个盘  全部移到b 柱
            //下面只有一个盘 移到c柱
            System.out.println(a + " -> " + c);
            //再将B柱移动到C柱
            hannuoTower(num-1, b , a , c);
        }
    }
}
