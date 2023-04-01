package Sort.SelectSort;

import org.junit.jupiter.api.Test;

import java.lang.reflect.Array;
import java.util.Date;

/**
 * @author yuanyu
 * @version 1.0
 */
public class SelSort {

    public static void main(String[] args) {
        int[] nums = new int[10000000];
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = (int) (Math.random()*80000000);
        }
//        System.out.println("=============================选择排序====================================");
//        Date date = new Date();
//        System.out.println("当前时间"+date);
//        nums = selectSort01(nums);
//        for (int i = 0 ; i < nums.length ; i++){
//            for (int j = 0; j < 20; j++) {
//                System.out.print(nums[i] + " ");
//            }
//            System.out.println();
//        }
//        Date date01 = new Date();
//        System.out.println("现在时间"+date01);
//        System.out.println("总时间"+ (date01.getTime() - date.getTime()));

//        System.out.println("====================================插入排序=======================================");
//        Date date02 = new Date();
//        System.out.println("当前时间"+date02);
//        nums = insertSort(nums);
//        for (int i = 0 ; i < nums.length ; i++){
//            System.out.print(nums[i] + " ");
//            if(i%10 == 9){
//                System.out.println();
//            }
//
//        }
//        Date date03 = new Date();
//        System.out.println("现在时间"+date03);
//        System.out.println("总时间"+ (date03.getTime() - date02.getTime()));
//        System.out.println("====================================快速排序=======================================");
//        Date date04 = new Date();
//        System.out.println("当前时间"+date04);
//        quickSort01(nums,0, nums.length-1);
//        for (int i = 0 ; i < nums.length ; i++){
//            System.out.print(nums[i] + " ");
//            if(i%10 == 9){
//                System.out.println();
//            }
//
//        }
//        Date date05 = new Date();
//        System.out.println("现在时间"+date05);
//        System.out.println("总时间"+ (date04.getTime() - date05.getTime()));
        int max = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if(max < nums[i]) max = nums[i];
        }
        System.out.println("====================================基数排序=========================================");
        Date date06 = new Date();
        System.out.println(date06);
        radixSort(nums,max);
        Date date07 = new Date();
        System.out.println(date07);
        System.out.println(date07.getTime() - date06.getTime());
    }


    //选择排序
    public static int[] selectSort01(int[] nums){
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int minPoint  = i;
            for (int j = i; j < nums.length; j++) {//找到后面最小的元素
                if(min > nums[j]){
                    min = nums[j];
                    minPoint = j;
                }
            }
            nums[minPoint] = nums[i];//最小的与前面第i个交换值
            nums[i] = min;

        }
        return nums;
    }

    //插入排序（直接插入排序）
    public static int[] insertSort(int[] array){//前面的为有序表 后面的为无序表
        //定义待插入数
        int insertVal ;
        int insertIndex ;
        for (int i = 1; i < array.length; i++) {
            insertVal = array[i];
            insertIndex = i - 1;//即insertVal 对应的下标 - 1
            while(insertIndex >= 0 && insertVal < array[insertIndex]){//不越界  比较
                array[insertIndex+1] = array[insertIndex];//将大于插入值的 后移一个位置   +1 是因为index对应的是插入值的前一个位置
                insertIndex--;//找寻插入的位置  应该插在 小于等于 插入值 的后面一个位置
            }

            array[insertIndex+1] = insertVal;//找到位置并给值
            //优化
            /**
             * if(insertIndex+1 != insertVal){
             *      array[insertIndex] = insertVal
             *   }
             */
        }

        return array;
    }

    //希尔排序（插入排序） 就是先根据步长分组  在在组间进行插入排序
    public static int[] shellSort(int[] array){
        int step = array.length / 2;//也是分组的组数
        int insertVal ;
        int insertIndex ;
        while((step/2) > 0){
            for(int i = 0 ; i < step ; i ++){
                insertVal = array[i+step];
                insertIndex = i ;//即insertVal 对应的下标 - 1
                while(insertIndex >= 0 && insertVal < array[insertIndex]){//不越界  比较
                    array[insertIndex+1] = array[insertIndex];//将大于插入值的 后移一个位置   +1 是因为index对应的是插入值的前一个位置
                    insertIndex--;//找寻插入的位置  应该插在 小于等于 插入值 的后面一个位置
                }

                array[insertIndex+1] = insertVal;//找到位置并给值
            }
        }
        return array;
    }

    //快速排序   给一个基准，分开待排序列，让比基准小的放在基准左边  比基准大的放在基准右边
    public static void quickSort(int[] array,int low,int high){
        int pivot = array[(low + high) / 2]; // 定义基准值
        if(low >= high) return;
        while(low < high){
            if(array[low] < pivot) low++;//如果array[low] >= pivot 说明low的值应该在pivot右边
            if(array[high] > pivot) high --;
            //交换
            int temp = array[low];
            array[low] = array[high];
            array[high] = temp;
        }
        quickSort(array,low,(low + high) / 2);//左递归
        quickSort(array,(low + high) / 2,high);//右递归
    }


    public static void quickSort01(int[] arr,int low,int high){
        int i,j,temp,t;
        if(low>high){
            return;
        }
        i=low;
        j=high;
        //temp就是基准位
        temp = arr[low];

        while (i<j) {
            //先看右边，依次往左递减
            while (temp<=arr[j]&&i<j) {
                j--;
            }
            //再看左边，依次往右递增
            while (temp>=arr[i]&&i<j) {
                i++;
            }
            //如果满足条件则交换
            if (i<j) {
                t = arr[j];
                arr[j] = arr[i];
                arr[i] = t;
            }

        }
        //最后将基准为与i和j相等位置的数字交换
        arr[low] = arr[i];
        arr[i] = temp;
        //递归调用左半数组
        quickSort(arr, low, j-1);
        //递归调用右半数组
        quickSort(arr, j+1, high);
    }

    // 基数排序

    public static void radixSort(int[] array, int d) {
        int n = 1;//代表位数对应的数：个1,十10,百100...
        int k = 0;//保存每一位排序后的结果用于下一位的排序输入
        int length = array.length;//获取形参传入数组的长度
        //这里用的二维数组
        int[][] bucket = new int[10][length];//排序桶用于保存每次排序后的结果，这一位上排序结果相同的数字放在同一个桶里
        int[] order = new int[length];//用于保存每个桶里有多少个数字
        while (n < d) {
            //这里面需要想象力想象存储过程，小伙伴们可以自己在草稿本上画一下
            for (int num : array) //将数组array里的每个数字放在相应的桶里
            {
                int digit = (num / n) % 10; //第一轮获每个数的取个位，第二轮十位数字，第三轮千位数字.....
                bucket[digit][order[digit]] = num;  //digit:横排从左到右，从大到小第几个桶子  order[digit]:列，桶子里存储的数
                order[digit]++;//桶子移到下一个位置为存储下一个数字做准备
            }
            for (int i = 0; i < length; i++)//从第一个桶子开始查找，将前一个循环生成的桶（就是二维数组内对应列里的值）里的数据覆盖到原数组中用于保存这一位的排序结果
            {
                if (order[i] != 0)//这个桶里有数据，从上到下遍历这个桶并将数据保存到原数组中
                {
                    for (int j = 0; j < order[i]; j++) {
                        array[k] = bucket[i][j];//将二维数组里面存放的数值保存到原数组
                        k++;
                    }
                }
                order[i] = 0;//将桶里计数器置0，用于下一次位排序
            }
            n *= 10;
            k = 0;//将k置0，用于下一轮保存位排序结果
        }
    }



    //归并排序
    private static int[] sortArray(int[] nums) {
        int len = nums.length;
        int[] temp = new int[len];
        mergeSort(nums,0,len-1,temp);
        return nums;
    }

    /**
     * 递归函数对nums[left...right]进行归并排序
     * @param nums 原数组
     * @param left 左边的索引
     * @param right 右边记录索引位置
     * @param temp
     */
    private static void mergeSort(int[] nums, int left, int right, int[] temp) {
        if (left == right){//当拆分到数组当中只要一个值的时候，结束递归
            return;
        }
        int mid = (left+right)/2;   //找到下次要拆分的中间值
        mergeSort(nums,left,mid,temp);//记录树左边的
        mergeSort(nums,mid+1,right,temp);//记录树右边的

        //合并两个区间
        for (int i = left; i <= right; i++) {
            temp[i] = nums[i];
//temp就是辅助列表，新列表的需要排序的值就是从辅助列表中拿到的
        }
        int i = left;       //给辅助数组里面的值标点
        int j = mid +1;
        for (int k = left; k <= right ; k++) {//k 就为当前要插入的位置
            if (i == mid + 1){
                nums[k] = temp[j];
                j++;
            }else if (j == right+1){
                nums[k] = temp[i];
                i++;
            }
            else if (temp[i] <= temp[j]){
                nums[k] = temp[i];
                i++;
            }else {
                nums[k] = temp[j];
                j++;
            }
        }
    }
}
