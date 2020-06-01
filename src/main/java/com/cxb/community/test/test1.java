package com.cxb.community.test;

public class test1 {
    public static void main(String[] args) {
        int[] a = {1,5,7,3,0,11,2,8,1};
        kuaipai(a);
    }
    public static void kuaipai(int[] a){
        quick(a,0,a.length-1);
        print(a);
    }

    public static void quick(int[]a,int l,int r){
        int temp = a[l];
        int st = l;
        int ed = r;
        while (l<r){
            while (l<r){
                if(a[r]>=temp){
                    r--;
                }else{
                    break;
                }
            }
            while (l<r){
                if (a[l]<=temp){
                    l++;
                }else {
                    break;
                }
            }
            if(l<r){
                swap(a,l,r);
            }
        }
        swap(a,st,l);
        if(l-st>1){
            quick(a,st,l-1);
        }
        if (ed-r>1){
            quick(a,r+1,ed);
        }
    }





    public static void swap(int[]a,int l,int r){
        int t = a[l];
        a[l] = a[r];
        a[r] = t;
    }

    public static void print(int[] a){
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i]+" ");
        }
    }
}

