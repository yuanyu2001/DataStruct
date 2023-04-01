package 测试实验01;

import org.junit.jupiter.api.Test;

/**
 * @author yuanyu
 * @version 1.0
 */
public class test {

    @Test
    //语句覆盖
    public void yuju(){
        System.out.println(test.LogicExample(1,1));//测试用例 1 ， 1
        System.out.println(LogicExample(1,-1));//测试用例 1， —1
    }
    @Test
    //判定覆盖
    public void pandin(){
        System.out.println(LogicExample(-15,1));
        System.out.println(test.LogicExample(10,101));//测试用例 10 ， 101
        System.out.println(LogicExample(6,-10));//测试用例 6， —10
    }

    @Test
    //条件判定
    //判断-条件覆盖
    public void tiaojian(){
        System.out.println(test.LogicExample(10,101));//测试用例 10 ， 101
        System.out.println(LogicExample(6,-10));//测试用例 6， —10
    }

    @Test
    //条件组合覆盖
    public void tianjianzuhe(){
        System.out.println(test.LogicExample(10,101));//测试用例 10 ， 101
        System.out.println(LogicExample(6,-10));//测试用例 6， —10
        System.out.println(LogicExample(6,-10));//测试用例 6， —10
        System.out.println(LogicExample(15,-1));//测试用例 15， —1
    }
    @Test
    //条件组合覆盖
    public void load() {
        System.out.println(test.LogicExample(10, 101));//测试用例 10 ， 101
        System.out.println(LogicExample(6, -10));//测试用例 6， —10
        System.out.println(LogicExample(15, -1));//测试用例 15， —1
    }

        public static int LogicExample(int x,int y){
        int magic = 0;
        if(x > 0 && y > 0){
            magic = x + y + 10;
        }else{
            magic = x + y - 10;
        }
        if(magic < 0){
            magic = 0;
        }

        return magic;
    }
}


