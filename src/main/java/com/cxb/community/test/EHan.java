package com.cxb.community.test;

public class EHan {
    private static EHan instance = new EHan();

    private EHan(){}

    public static EHan getInstance(){
        return instance;
    }


}
