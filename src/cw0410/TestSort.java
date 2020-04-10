package cw0410;

import java.util.Arrays;

public class TestSort {
    public static void insertSort(int [] array){   //选择排序
        //通过bound分成两个区间
        for (int bound = 1; bound <array.length ; bound++) {       //O(N^2),空间 O（1），稳定
            int v =  array[bound];
            int cur =  bound -1;
            for(;cur>=0;cur--){
                if(array[cur] > v){
                    array[cur+1] = array[cur];    //在这里进行搬运
                }else {
                    break;
                }
            }
            array[cur+1] = v;  //这里不用交换
        }
    }
    public static void shellSort(int array[]){    //希尔排序理论o（n^1.3)
            int gap = array.length/2;
            while (gap>1){
                insertSortGap(array,gap);   //
                gap/=2;   //更新Gap
            }
            insertSortGap(array,1);
    }
    private static void insertSortGap(int[] array, int gap) {
        for (int bound = gap; bound <array.length ; bound++) {       //O(N^2),空间 O（1），稳定
            int v =  array[bound];
            int cur =  bound -gap ;   //这里是表示同一组相邻的进行比较
            for(;cur>=0;cur--){
                if(array[cur] > v){
                    array[cur+gap] = array[cur];    //在这里进行搬运
                }else {
                    break;
                }
            }
            array[cur+gap] = v;  //这里不用交换
        }
    }
//    public static void bubbleSort(int []array){
//        for (int i = 0; i <array.length ; i++) {
//            for(int cur = array.length-1;cur>i;cur--){
//                if(array[cur] > array[cur+1]){
//                    int temp =  array[cur];
//                    array[cur] = array[cur+1];
//                    array[cur+1] = temp;
//                }
//            }
//        }
//    }
    public static void selectSort(int array[]){   //选择排序    O(N^2) O(1) 不稳定排序
        for (int bound = 0; bound <array.length ; bound++) {
            // 和boung 位置的元素进行比较,就相当于打擂台
            for (int cur =  bound+1;cur < array.length;cur++){
                if(array[bound]> array[cur]){
                    int temp =  array[cur];
                   array[cur] = array[bound];
                  array[bound] = temp;
                }
            }
        }
    }
    public static void heapSort(int array[]){
        createHeap(array);
        //取到对顶元素
        for (int i = 0; i <array.length-1 ; i++) {     //最后一个元素和对顶元素进行交换，然后再向下调整
            swap(array,0,array.length-1-i);
            shiftDown(array,array.length-i-1,0);//最后一个元素在变
        }
    }

    private static void shiftDown(int[] array, int heapLength, int index) {
        int parent = index;    //数组的下标
        int child =  2*parent +1;
        while (child< heapLength){
            if(array[child+1] > array[child] && child + 1<heapLength){
                child = child +1;
            }
            if(array[child] > array[parent]){
                swap(array,child,parent);
            }else {
                break;
            }
            parent = child;
            child = 2 * parent +1;

        }
    }

    private static void createHeap(int[] array) {
          //找到最后一个非叶子节点
        for(int i = (array.length-1-1)/2;i>=0;i--){
            shiftDown(array,array.length,i);
        }
    }
    private  static  void swap(int[] array,int i ,int k){
        int temp =  array[i];
        array[i] =array[k];
        array[k] = temp;

    }

    public static void main(String[] args) {
        int [] array = {23,4,43,12,34,15,89,77};
        insertSort(array);
        System.out.println(Arrays.toString(array));
        shellSort(array);
        System.out.println(Arrays.toString(array));
        selectSort(array);
        System.out.println(Arrays.toString(array));
        heapSort(array);
        System.out.println(Arrays.toString(array));
    }
}
