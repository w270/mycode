package com.zbinyun.algorithm.sort;

public class QuickSort {
    public static void quickSort(int[] list){
        quickSort(list,0,list.length-1);
    }

    /** 快速排序
     *  如果first < last，就一直分下去，分成两部分，前一部分比pivot小，后一部分比pivot大
     *  pivot选取，本例中选取了第一个为例
     * @param list
     * @param first 下标
     * @param last 下标
     */
    public static void quickSort(int[] list,int first,int last){
        if (first < last){
            int pivotIndex = partition(list,first,last);
            quickSort(list,first,pivotIndex-1);
            quickSort(list,pivotIndex+1,last);
        }
    }

    /**
     *
     * @param list
     * @param first
     * @param last
     * @return
     */
    private static int partition(int[] list, int first, int last) {
        int pivot = list[first];  //取第一个元素作为pivot
        int low = first + 1; //从第二个元素开始比较
        int high = last; //最后一个元素
        //循环所有元素，找出一个pivot点的index
        while (high > low){
            while (low <= high && list[low] <= pivot)
                low++;
            while (low <= high && list[high] > pivot)
                high--;
            //从前往后，从后往前找出low以前的都小于pivot，high以后都大于pivot，然后交换两个元素后，继续下一次
            if (high > low){
                int temp = list[high];
                list[high] = list[low];
                list[low] = temp;
            }
        }
        //循环结束后，如果high > first,并且与pivot相比较，如果如果大于或等于 ，high位置继续前移，找到合适位置，
        //high前的元素小于pivot，high后元素大于或等于pivot
        //选取第一个元素，所以要用high与第一个元素的位置进行比较
        while (high > first && list[high] >= pivot)
            high--;
        //如果pivot 大于 high的数值，则交换，然后返回high,就是pivot插入的位置
        if (pivot > list[high]){
            list[first] = list[high];
            list[high] = pivot;
            return high;
        }else {
            return first;
        }
    }
    public static void main(String[] args) {
        int[] arr = {3,2,1,8,2,9};
        quickSort(arr);

        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
