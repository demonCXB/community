package com.cxb.community.test;

import java.util.Arrays;

public class Sort {

    public static void main(String[] args) {
        int[] a = {1,5,7,3,0,11,2,8,1};
        int[] b = {1,5,7,3,0,11,2,8,1};
        int[] c = {1,5,7,3,0,11,2,8,1};
        int[] d = {1,5,7,3,0,11,2,8,1};
        int[] e = {1,5,7,3,0,11,2,8,1};
        int[] f = {1,5,7,3,0,11,2,8,1};
        int[] g = {1,5,7,3,0,11,2,8,1};

        print(a);
        bubble(b);
        insert(c);
        choose(d);
        shell(e);
        kuaipai(f);
        guibing(g);
    }


    //冒泡
    public static void bubble(int []arr){
        int temp ;
        for (int i = 0; i < arr.length; i++) {
            for (int j = arr.length-1; j > i;j--) {
                if(arr[i]>arr[j]){
                    temp = arr[i];
                    arr[i] = arr[j];
                    arr[j] = temp;
                }
            }
        }
        print(arr);
    }

    //插入
    //从第二个开始     查到前面已经排好序的中间，
    public static void insert(int[] a){
        for (int i = 1; i < a.length; i++) {
            int temp = a[i];
            for (int j = i-1; j >=0 ; j--) {
                if(a[j] > temp){  //即 temp要插到 j前面
                    a[j+1] = a[j];
                    if(j==0){ //J 为第一个
                        a[0] = temp;
                    }
                }else{
                    a[j+1] = temp; //插入  确定位置后 break
                    break;
                }
            }
        }
        print(a);
    }

    //选择排序
//从左到右选择一个最小值 与当前 交换    1-n 取最小和1交换  2-n ...
    public static void choose(int[] a){
        int temp;
        int min;
        for (int i = 0; i < a.length; i++) {
            min = i;
            for (int j = i; j < a.length; j++) {
                if(a[j]<a[min]){
                    min = j;
                }
            }
            temp = a[min];
            a[min] = a[i];
            a[i] =temp;
        }
        print(a);

    }

    //以length/2 作为间距  做插入排序    length每次/2
    public static void shell(int[] a){
        int half = a.length/2;
        int temp ;
        int count = 0;
        while(half > 0){
            for (int i = 0; i < half; i++) {

                //插入排序  间隔为half
                for (int j = i+half; j <a.length ; j+=half) {
                    temp = a[j];
                    for (int k = j-half; k >=0 ; k-=half) {
                        count++;
                        if(a[k]>temp){
                            a[k+half] = a[k];
                            if(k<half){
                                a[k] = temp;
                            }
                        }else{
                            a[k+half] = temp;
                            break;
                        }
                    }
                }
            }
            half/=2;
        }
        print(a);
    }

    //快排
    public static void kuaipai(int[] a){
        quick(a,0,a.length-1);
        print(a);
    }
// 先从右向左找小的， 再从左（第二个开始）往右找大的。 交换位置。   直到l==r 停，交换原先的l 和最后的l
    public static void quick(int[] a,int l,int r){
        if(l>=r){
            return;
        }
        int temp = a[l];
        int st = l;
        int ed = r;
        while(l<r){
            while (l<r){
                if(a[r]>=temp){
                    r--;
                }else{
                    break;
                }
            }
            while(l<r){
                if(a[l]<=temp){
                    l++;
                }else{
                    break;
                }
            }
            if(l<r){
                swap(a,l,r);
            }
        }
        swap(a,st,l);
        if(l-st>1){ //左边还有
            quick(a,st,l-1);
        }
        if(ed-r>1){
            quick(a,r+1,ed);
        }
    }

    //归并
    public  static void guibing(int[] a){
        print(merge(a));
    }

    public static int[] merge(int[] a){
        int t = a.length/2;
        if(t==0){
            return a;
        }
        int[] left = Arrays.copyOfRange(a,0,t);
        int[] right = Arrays.copyOfRange(a,t,a.length);
        return merge2(merge(left),merge(right));
    }

    public static int[] merge2(int[]a,int[]b){
        int[] ab = new int[a.length+b.length];
        int l = 0;
        int r = 0;
        int m = 0;
        while(l<a.length && r<b.length){
            if(a[l]<=b[r]){
                ab[m] = a[l];
                l++;
                m++;
            }else{
                ab[m] = b[r];
                r++;
                m++;
            }
        }
        if(l==a.length){
            while (m<ab.length){
                ab[m] = b[r];
                r++;
                m++;
            }
        }else if(r==b.length){
            while (m<ab.length){
                ab[m] = a[l];
                l++;
                m++;
            }
        }
        return ab;
    }

    public static void swap(int[]a ,int l,int r){
        int temp = a[l];
        a[l] = a[r];
        a[r] = temp;
    }

    public static void print(int [] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
        System.out.println();
    }


}
