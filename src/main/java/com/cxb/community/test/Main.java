package com.cxb.community.test;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] arr = new int[10];

        for (int i = 0; i < 10; i++) {
            arr[i] = scanner.nextInt();
        }

        Double min = Math.pow(arr[0],2) + arr[0]*arr[1] - Math.pow(arr[1],2) + arr[2]; //记录最小值
        int x,y,z;
        double temp;
        for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10; j++) {
                if(i==j)continue;

                for (int k = 0; k < 10; k++) {
                    if(i==k||j==k)continue;
                    x = arr[i];
                    y = arr[j];
                    z = arr[k];
                    temp = Math.pow(x,2) + x*y - Math.pow(y,2) + z;
                    min = Math.min(temp,min);
                }
            }
        }
        String minstr = min.toString();
        System.out.println(minstr.substring(0,minstr.length()-2));
    }
}
