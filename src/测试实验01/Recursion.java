package 测试实验01;

/**
 * @author yuanyu
 * @version 1.0
 */
public class Recursion {

    public static void jicheng(int n){
        if(n > 2){
            jicheng(n-1);
        }
        System.out.println("n = " + n);
    }

    public static void main(String[] args) {
        //jicheng(9);
        System.out.println("");
    }
}
