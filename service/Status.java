package com.liuchang.Project3.service;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午12:46
 */
public class Status {
    private final String NAME;
    public static final Status FREE = new Status("FREE");
    public static final Status BUSY = new Status("BUSY");
    public static final Status VOCATION = new Status("VOCATION");

    private Status(String name) {
        this.NAME = name;
    }

    public String getNAME(){
        return NAME;
    }

    @Override
    public String toString() {
        return NAME;
    }
}
