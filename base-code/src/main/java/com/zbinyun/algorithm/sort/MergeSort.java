package com.zbinyun.algorithm.sort;

/**
 * 归并排序，分治思想
 * 两个数组归并算法 list1，list2
 *  1. 需要一个空数组  list3.lenth = list1+list2
 *  2. 比较list1,与list2的数据，小的填充list3，其中list1，或list2没有数据，另一个全部拷贝到list3中即可
 *
 */
public class MergeSort {
    //排序方法
    public static void mergeSort(int[] list){
        if(list.length > 1){
            //先进行拆分
            //左侧
            int[] firstHalf = new int[list.length/2];
            //System.arraycopy(源数组，开始位置，目标数组，开始位置，复制长度）
            System.arraycopy(list,0,firstHalf,0,list.length/2);
            //针对左边递归
            mergeSort(firstHalf);

            //右侧
            int secondHalfLength = list.length - list.length/2;
            int[] secondHalf = new int[secondHalfLength];
            System.arraycopy(list,list.length/2,secondHalf,0,secondHalfLength);
            mergeSort(secondHalf);

            //归并两部分
            int[] temp = merge(firstHalf,secondHalf);
            //归并好的重新赋值到list中
            System.arraycopy(temp,0,list,0,temp.length);
        }
    }
    //归并
    private static int[] merge(int[] list1, int[] list2) {
        int[] temp = new int[list1.length+list2.length];

        int current1 = 0;  //list1的下标
        int current2 = 0;  //list2的下标
        int current3 = 0;  //temp的下标

        //把小的拷贝到temp中
        while(current1 < list1.length && current2 < list2.length){
            if(list1[current1] < list2[current2]){
                temp[current3++] = list1[current1++];
            }else{
                temp[current3++] = list2[current2++];
            }
        }

        //list1还有剩余
        while (current1 < list1.length){
            temp[current3++] = list1[current1++];
        }

        //list2还有剩余
        while (current2 < list2.length){
            temp[current3++] = list2[current2++];
        }

        return temp;
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,8,2,9};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
