package com.zzrt.algorithm.sort;

/**
 * 希尔排序
 * 插入排序的进阶版本
 */
public class Shell {
    /*
       对数组a中的元素进行排序
    */
    public static void sort(Comparable[] a){
        // 根据数组a的长度，确定增长量h的初始值；
        int gap = 1;
        while(gap<a.length/2){
            //修正h的初始值
            gap=2*gap+1;
        }
        //增长量小于1结束，
        while(gap>=1){
            /**
             * 在希尔排序的理解时，我们倾向于对于每一个分组，逐组进行处理，
             * 但在代码实现中，我们可以不用这么按部就班地处理完一组再调转回来处理下一组（这样还得加个for循环去处理分组）
             * 比如[8,9,1,7,2,3,5,4,6,0] ，增量设gap=5时,则为5组[8,3] [9,5] [1,4] [7,6] [2,0]实现时不用循环按组处理，
             * 我们可以从第gap个元素开始，依次往后，逐个跨组处理。
             */
            //分好组后，我们会对其进行插入排序，对于每组，首位默认已经排好，从本组第二个及后面开始。
            //对于第一组代插入的元素，位置就是gap索引处，gap+1处就是下一组的待插入元素
            for (int i=gap;i<a.length;i++){
                //把待插入的元素插入到有序数列中.就是插入到所在组前面合适的位置
                //索引j处前面的元素为a[j-gap],a[j-2gap],a[j-3gap]...进行插入排序
                for (int j=i;j>=gap;j-=gap){
                    //比较a[j]和a[j-gap]
                    if (greater(a[j-gap],a[j])){
                        //交换元素
                        exch(a,j-gap,j);
                    }else{
                        //待插入元素已经找到了合适的位置，结束循环；
                        break;
                    }
                }
            }
            //减小h的值
            gap= gap/2;
        }



    }

    /*
        比较v元素是否大于w元素
     */
    private static  boolean greater(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /*
    数组元素i和j交换位置
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
