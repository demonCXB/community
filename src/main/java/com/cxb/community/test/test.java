package com.cxb.community.test;

import java.util.Scanner;

public class test {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        String[] strs = str.split(" ");
        if(strs.length > 100){
            System.out.println(-1);
            return;
        }

        int [] arr = new int[strs.length];   //输入的数字数组
        int [] count = new int[strs.length]; //记录到达该位置的最小次数
        for (int i = 0; i < strs.length; i++) {
            arr[i] = Integer.valueOf(strs[i]);
        }
        for (int i = 0; i < count.length; i++) {
            count[i] = 0;   //初始化  默认全为0
        }
        if(arr.length <= 2){
            System.out.println(1);
            return;
        }
        if(arr.length == 3){
            if(arr[1]  == 1){
                System.out.println(1);
            }else{
                System.out.println(-1);
            }
            return;
        }
        for (int i = 1; i < (arr.length)/2; i++) {
            arr[i] = arr[i] + i ; //将要到达的位置
            count[i] ++;
        }
        for (int i = arr.length/2; i < arr.length; i++) {
            arr[i] = arr[i] + i ;
        }


        for (int i = 2; i < arr.length; i++) {
            for (int j = 1; j < i; j++) {
                if(i == arr[j]){
                    if(count[i]>0){
                        count[i] = Math.min(count[i],count[j]+1);
                    }else{
                        count[i] = count[j]+1;
                    }
                }
            }
        }
        if(count[arr.length-1] ==0){
            System.out.println(-1);
        }else{
            System.out.println(count[arr.length-1]);
        }
    }
}
