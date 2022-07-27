package com.liuchang.Project3.domain;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午12:36
 */
public class Printer implements Equipment {
    private String name; //机器型号
    private String type; //机器类型

    public Printer(String name, String type) {
        this.name = name;
        this.type = type;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getDescription() {
        return name + "(" + type + ")";
    }
}
