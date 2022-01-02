package com.zzrt.algorithm.sort;

/**
 * 快速排序
 */
public class Quick {
    /*
      比较v元素是否小于w元素
   */
    private static boolean less(Comparable v, Comparable w) {
        return v.compareTo(w) < 0;
    }



    /*
   数组元素i和j交换位置
    */
    private static void exch(Comparable[] a, int i, int j) {
        Comparable t = a[i];
        a[i] = a[j];
        a[j] = t;
    }

    //对数组内的元素进行排序
    public static void sort(Comparable[] a) {
        int lo = 0;
        int hi = a.length-1;
        sort(a,lo,hi);
    }

    //对数组a中从索引lo到索引hi之间的元素进行排序
    private static void sort(Comparable[] a, int lo, int hi) {
        if (hi<=lo){
            return;
        }
        //需要对数组中lo索引到hi索引处的元素进行分组（左子组和右子组）；
        //返回的是分组的分界值所在的索引，分界值位置变换后的索引，
        int partition = partition(a, lo, hi);


        //让左子组有序
        sort(a,lo,partition-1);

        //让右子组有序
        sort(a,partition+1,hi);

    }

    //对数组a中，从索引 lo到索引 hi之间的元素进行分组，并返回分组界限对应的索引
    public static int partition(Comparable[] a, int lo, int hi) {
        //确定分界值，切分元素
        Comparable key = a[lo];//把最左边的元素当做基准值

        //定义两个指针，分别指向待切分元素的最小索引处 和 最大索引处的下一个位置
        int left=lo;
        int right=hi+1;

        //切分
        while(true){
            //先从右往左扫描，移动right指针，找到一个比分界值小的元素，停止
            while(less(key,a[--right])){
                //防止一直向左越界
                if (right == lo){
                    break;
                }
            }

            //再从左往右扫描，移动left指针，找到一个比分界值大的元素，停止
            while(less(a[++left],key)){
                //防止一直向右越界
                if (left==hi){
                    break;
                }
            }

            //如果满足，则证明元素扫描完毕，结束循环，
            if (left >= right){
                break;
            }else{
                //如果不满足，则交换元素即可
                exch(a,left,right);

            }
        }

        //交换分界值，把key放入正确位置
        exch(a,lo,right);

        //此时a[lo..right-1]  <= a[right] <= a[right+1..hi]
       return right;
    }

}

