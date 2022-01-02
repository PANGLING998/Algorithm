package com.zzrt.algorithm.sort;

/**
 * 插入排序<br>
 * 排序原理：<br>
 * 1.把所有的元素分为两组，已经排序的和未排序的；<br>
 * 2.找到未排序的组中的第一个元素，向已经排序的组中进行插入；<br>
 * 3.倒叙遍历已经排序的元素，依次和待插入的元素进行比较，直到找到一个元素小于等于待插入元素，那么就把待
 *   插入元素放到这个位置，其他的元素向后移动一位；<br>
 * 4.如图：insertion.jpg
 */
public class Insertion {
    /*
       对数组a中的元素进行排序
       代码实现思路：
       依次拿起每个元素，将其插入到合适位置，第一个元素前面没有元素，不用管，从第二个开始。
       将待插入元素向前比较，保证 前 < 待插入元素 < 后 ，

    */
    public static void sort(Comparable[] a){
        //从第二个元素开始，依次进行
        for(int i=1;i<a.length;i++){
            //j表示每次开始时所在位置，先前比较，所以--，
            for(int j=i;j>0;j--){
                //比较索引j处的值和索引j-1处的值，如果索引j-1处的值比索引j处的值大，则交换数据，
                //如果不大，那么就找到合适的位置了，退出循环即可
                if (exch(a[j-1],a[j])){
                    //比较一次满足条件就交换，逐步向后移，
                    exch(a,j-1,j);
                }else{
                    break;
                }
            }
        }
    }

    /*
        比较v元素是否大于w元素
     */
    private static  boolean exch(Comparable v,Comparable w){
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
