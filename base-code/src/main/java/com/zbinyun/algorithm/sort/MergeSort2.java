package com.zbinyun.algorithm.sort;

/**
 * 数据结构与算法分析-归并排序
 */
public class MergeSort2 {

    //归并排序开始
    public static void mergeSort(int[] a){
        //临时数组
        int[] tmpArray = new int[a.length];
        //排序
        mergeSort(a,tmpArray,0,a.length-1);
    }

    private static void mergeSort(int[] a, int[] tmpArray, int left, int right) {
        //当left<right,递归拆，分左右两部分
        if(left < right ){
            int center = (left + right) / 2;
            //左边递归调用
            mergeSort(a,tmpArray,left,center);
            //右边递归调用，left，right都是下标
            mergeSort(a,tmpArray,center+1,right);
            //左右递归完成后，合并两部分
            merge(a,tmpArray,left,center+1,right);
        }
    }

    /**
     * 合并，主要方法
     *
     * @param a 需要排序的方法
     * @param tmpArray  临时数组
     * @param leftPos   左侧的位置
     * @param rightPos  右侧位置
     * @param rightEnd  右侧的结束位置
     */
    private static void merge(int[] a, int[] tmpArray, int leftPos, int rightPos, int rightEnd) {
        //左侧结束位置，右侧的开始位置-1就是左侧开始位置
        int leftEnd = rightPos - 1;
        //临时数组的位置，从左侧开始位置算起
        int tmpPos = leftPos;
        //元素的个数，右侧位置减左侧位置+1
        int numElements = rightEnd - leftPos + 1;
        //左侧和右侧进行填充临时数组
        while(leftPos <= leftEnd && rightPos <= rightEnd){
            if(a[leftPos] < a[rightPos]){
                tmpArray[tmpPos++] = a[leftPos++];
            }else{
                tmpArray[tmpPos++] = a[rightPos++];
            }
        }
        //左侧或右侧的数组还没有遍历完的直接放到临时数组里
        while (leftPos <= leftEnd){
            tmpArray[tmpPos++] = a[leftPos++];
        }
        while (rightPos <= rightEnd){
            tmpArray[tmpPos++] = a[rightPos++];
        }
        //把临时数组的数据放回原始数组
        for (int i = 0; i < numElements; i++,rightEnd--) {
            a[rightEnd] = tmpArray[rightEnd];
        }
    }

    public static void main(String[] args) {
        int[] arr = {3,2,1,8,2,9};
        mergeSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
