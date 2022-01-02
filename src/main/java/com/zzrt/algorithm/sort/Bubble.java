package com.zzrt.algorithm.sort;

/**
 * 冒泡排序
 * 排序原理：
 * 1. 比较相邻的元素。如果前一个元素比后一个元素大，就交换这两个元素的位置。
 * 2. 对每一对相邻元素做同样的工作，从开始第一对元素到结尾的最后一对元素。
 *    最终最后位置的元素就是最大值。
 */
public class Bubble {

    /**
     * 对数组a中的元素进行排序。
     * @param a
     */
    public static void sort(Comparable[] a){
        /**代码实现思路：
         * 两个for循环，一个控制冒泡次数，一个控制每次冒泡的比较和交换
         */
        //外层控制冒泡次数，为n-1,因为当剩余最后一个元素时，不需要再比较，它就是最小的
        for(int i = 0 ; i < a.length-1 ; i++){
            //内层控制每次冒泡，从第一个一次往后比较，每次参与冒泡的元素个数依次减少，因为冒泡一次，就会有一个元素定下来，不需要参与下面的运算。
            //a.length-1-i，是每次冒泡参与元素的个数，
            for(int j = 0;j < a.length-1-i;j++){
                //比较索引j和索引j+1处的值，符合条件就进行交换
                //这里是j+1,注意索引越界
                if (exch(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }

        //稍作修改
    /*
        //i做了两件事，1.决定冒泡次数，2.决定每次参与冒泡的元素个数
        for(int i = a.length-1;i > 0;i--){
            for(int j = 0;j < i;j++){
                if (compare(a[j],a[j+1])){
                    exch(a,j,j+1);
                }
            }
        }
    */
    }

    /**
     * 比较v元素是否大于w元素
     * @param v
     * @param w
     * @return v>m  true
     */
    private static  boolean exch(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }

    /**
     * 数组元素i和j交换位置
     * @param a
     * @param i
     * @param j
     */
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
