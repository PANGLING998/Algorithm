package com.zzrt.sort;

import com.zzrt.algorithm.sort.*;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;

public class TestSort {
    @Test
    public void Bubble(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Bubble.sort(a);
        System.out.println(Arrays.toString(a));

    }
    @Test
    public void Selection(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Selection.sort(a);
        System.out.println(Arrays.toString(a));
    }
    @Test
    public void Insertion(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Insertion.sort(a);
        System.out.println(Arrays.toString(a));
    }

    @Test
    public void Shell(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Shell.sort(a);
        System.out.println(Arrays.toString(a));
    }

    /**
     * 测试以下希尔排序的速度，排序100000个逆序数，对比插入排序
     * @throws IOException
     */
    @Test
    public void ShellAndInsertion() throws IOException {

        ArrayList<Integer> list = new ArrayList<>();
        //读取reverse_arr.txt文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/reverse_arr.txt")));
        String line=null;
        while((line=reader.readLine())!=null){
        //把每一个数字存入到集合中
        list.add(Integer.valueOf(line));
        }
        reader.close();
        //把集合转换成数组
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        testInsertion(arr);
        testShell(arr);
        //使用插入排序耗时：23610
        //使用希尔排序耗时：16
    }
    public  void testInsertion(Integer[] arr) {
        //使用插入排序完成测试
        long start = System.currentTimeMillis();
        Insertion.sort(arr);
        long end= System.currentTimeMillis();
        System.out.println("使用插入排序耗时："+(end-start));
    }
    public  void testShell(Integer[] arr) {
        //使用插入排序完成测试
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end= System.currentTimeMillis();
        System.out.println("使用希尔排序耗时："+(end-start));
    }
    @Test
    public void Merge(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Merge.sort(a);
        System.out.println(Arrays.toString(a));
    }

    public void testMerge(Integer[] arr){
        //使用插入排序完成测试
        long start = System.currentTimeMillis();
        Shell.sort(arr);
        long end= System.currentTimeMillis();
        System.out.println("使用归并排序耗时："+(end-start));
    }
    @Test
    public void ShellAndMerge() throws IOException {

        ArrayList<Integer> list = new ArrayList<>();
        //读取reverse_arr.txt文件
        BufferedReader reader = new BufferedReader(new InputStreamReader(new FileInputStream("src/main/resources/reverse_arr.txt")));
        String line=null;
        while((line=reader.readLine())!=null){
            //把每一个数字存入到集合中
            list.add(Integer.valueOf(line));
        }
        reader.close();
        //把集合转换成数组
        Integer[] arr = new Integer[list.size()];
        list.toArray(arr);
        testMerge(arr);
        testShell(arr);
//        使用归并排序耗时：22
//        使用希尔排序耗时：8

    }
    @Test
    public void Quick(){
        Integer[] a={1,96,36,65,52,100,1200,25,2,250,85,5246};
        Quick.sort(a);
        System.out.println(Arrays.toString(a));
    }


}
