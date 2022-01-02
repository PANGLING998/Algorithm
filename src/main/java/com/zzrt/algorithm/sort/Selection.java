package com.zzrt.algorithm.sort;

/**
 *选择排序<br>
 *排序原理：<br>
 *  1.每一次遍历的过程中，都假定第一个索引处的元素是最小值，和其他索引处的值依次进行比较，如果当前索引处
 *    的值大于其他某个索引处的值，则假定其他某个索引出的值为最小值，最后可以找到最小值所在的索引<br>
 *  2.交换第一个索引处和最小值所在的索引处的值
 */
public class Selection {
    /**
     * 对数组a中的元素进行排序
     * 每次找一个最小值，放在这些元素的首位
     * @param a
     */
    public static void sort(Comparable[] a){
        /**
         * 代码实现思路:使用双循环
         */
        //外层控制一共排多少趟（n-1）。因为每次都会找到一个最小值，并且需要放到合适位置，当剩余最后一个时，不用再比较，
        //每循环一次，要让找到的最小值放到合适的位置
        //i控制一共排多少趟，还控制了每趟找到最小值后所插入的位置，
        for(int i=0;i <= a.length-2 ; i++){
            //定义一个变量，记录最小元素所在的索引，先默认为参与选择排序的第一个元素所在的位置
            int minIndex = i;
            //每趟从j开始往后比较，每趟比较结束后要让minIndex处的值为最小，
            //j还表示参与每趟选择排序元素的个数
            for(int j=i+1;j<a.length;j++){
                //需要比较最小索引minIndex处的值和j索引处的值，保证minIndex处的值为小
                if (exch(a[minIndex],a[j])){
                    minIndex=j;
                }
            }
            //交换最小元素所在索引minIndex处的值和索引i处的值
            exch(a,i,minIndex);
        }
    }
   //比较v元素是否大于w元素
    private static  boolean exch(Comparable v,Comparable w){
        return v.compareTo(w)>0;
    }
    //数组元素i和j交换位置
    private static void exch(Comparable[] a,int i,int j){
        Comparable temp;
        temp = a[i];
        a[i]=a[j];
        a[j]=temp;
    }
}
