package Search;

import Sort.SelectSort.SelSort;

import java.util.Arrays;
import java.util.Date;

/**
 * @author yuanyu
 * @version 1.0
 */
public class testSearch {
    public static void main(String[] args) {
        int[] nums = new int[8000];
        for (int i = 0 ; i < nums.length ; i++){
            nums[i] = (int) (Math.random()*8000);
        }
        Date date01 = new Date();
        System.out.println(date01);
        //int index = seqSearch(nums,1008611);
        //先排序在二分查找
        SelSort Sort = new SelSort();
        Sort.radixSort(nums,8000);
        //int index = insertValueSearch(nums,50211,0,nums.length-1);//插入查找
        int index = fibonacciSearch(nums,50211);
        if(index != -1){
            System.out.println("找到了，是第" + (index+1) + "位" );
        }
        Date date02 = new Date();
        System.out.println(date02);
        System.out.println(date02.getTime() - date01.getTime());
    }

    //线性查找 可有序可无序
    public static int seqSearch(int[] array,int seqValue){
        //逐一比对，返回下标
        for (int i = 0; i < array.length; i++) {
            if(array[i] == seqValue){
                return i;
            }
        }
        return -1;//未找到，返回-1
    }

    //二分查找  只能是有序表  所以在使用前必须排序
    //递归二分查找
    public static int binarySearch(int[] array,int needFindValue, int left,int right){
       int mid = (left + right) / 2;
       if(needFindValue < array[left] || needFindValue > array[right] || left > right){
           return -1;
       }else if(needFindValue == array[mid]){
           return mid;
       }else if(needFindValue < array[mid]) {
           return binarySearch(array,needFindValue,left,mid - 1);
       }else {//(needFindValue > array[mid])
          return binarySearch(array, needFindValue, mid + 1, right);
       }
    }

    //插值排序 将二分的mid = (left + right) / 2 -> mid = left + (right - left) * (key - arr[left])/(arr[right] - arr[left])  其中key = needFindValue 即需要查询的值
    public static int insertValueSearch(int[] array,int needFindValue, int left,int right){
        int mid = left + (right - left) * (needFindValue - array[left])/(array[right] - array[left]);
        if(needFindValue < array[left] || needFindValue > array[right] || left > right){
            return -1;
        }else if(needFindValue == array[mid]){
            return mid;
        }else if(needFindValue < array[mid]) {
            return insertValueSearch(array,needFindValue,left,mid - 1);
        }else {//(needFindValue > array[mid])
            return insertValueSearch(array, needFindValue, mid + 1, right);
        }
    }

    //斐波那契查询
    public static int fibonacciSearch(int a[], int findVal) {
        int low = 0;
        int high = a.length - 1;
        int k = 0;
        int mid = 0; //
        int f[] = fib(20);

        //获取到斐波那契数值的下标
        while (high > f[k] - 1) {
            k++;
        }
        //因为f[k] 值可能大于数组的长度，因此使用Arrays类构造一个新的数组，并指向a[]
        //不足的部分使用0填充
        int[] tmp = Arrays.copyOf(a, f[k]);
        //需要使用a数组最后的数填充tmp
        for (int i =  high+1; i < tmp.length; i++) {
            tmp[i] = a[high];
        }

        //循环查找，直到找到目标数
        while (low <= high) {
            mid = low + f[k-1] -1;
            if (findVal < tmp[mid]) { //向数组前面查找
                high = mid-1;
                k--; //全部元素 = 前面的元素 + 后面的元素。 f[k] = f[k-1] + f[k-2]
                //前面有f[k-1]个元素，所以可以继续拆分 f[k-1] = f[k-2] + f[k-3],即在f[k-1]的前面继续查找
            } else if (findVal > tmp[mid]) { //想数组后面查找
                low = mid+1;
                k -= 2; //全部元素 = 前面元素 + 后面元素
                //f[k] = f[k-1]+ f[k-2], 因为f
            } else {
                //需要确定返回的是哪一个坐标
                if (mid <= high) {
                    return mid;
                } else {
                    return high;
                }


            }
        }

        return  -1;
    }

    //非递归方法获取斐波那契数列
    public static int[] fib(int maxSize) {
        int[] f = new int[maxSize];
        if (maxSize < 2) {
            f = new int[2];
        }

        f[0]= 1;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = f[i-1]+f[i-2];
        }

        return f;
    }
}
