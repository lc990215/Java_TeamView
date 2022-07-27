package com.liuchang.Project3.domain;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午12:34
 */
public class NoteBook implements Equipment {
    private String model;
    private double price;

    public NoteBook(String model, double price) {
        this.model = model;
        this.price = price;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String getDescription() {
        return model + "(" + price + ")";
    }
}
