package BinarySearch;

import java.util.Date;

/**
 * @author yuanyu
 * @version 1.0
 */
public class BinarySearch {
    public static void main(String[] args) {
        int[] ints = new int[300000000];
        for (int i = 0; i < ints.length; i++) {
            ints[i] = i;
        }
        Date date01 = new Date();
        System.out.println(date01);
        int index = binarySearch(ints,-1);
        Date date02 = new Date();
        System.out.println(date02);
        if(index != -1){
            System.out.println("找到了，下标是：" + index );
        }
        System.out.println(date02.getTime() - date01.getTime());

    }
    //非递归实现

    /**
     *
     * @param array
     * @param target
     * @return 返回对应下标  -1表示没有找到
     */
    public static int binarySearch(int[] array , int target){
        int left = 0 ;
        int right = array.length-1 ;
        int mid ;
        if(array[left] <= target && array[right] >= target){
            while (left <= right){
                mid = (left + right) / 2 ;
                if(array[mid] == target){
                    return mid;
                } else if (array[mid] > target) {
                    right = mid;
                } else if (array[mid] < target) {
                    left = mid ;
                }
            }
        }
        return -1;
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


}
