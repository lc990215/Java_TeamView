package com.liuchang.Project3.domain;

import com.liuchang.Project3.service.Status;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午12:40
 */
public class Programmer extends Employee {
    private int memberId; //开发团队中的ID
    private Status status = Status.FREE;
    private Equipment equipment;
    public Programmer(){}
    public Programmer(int id, String name, int age, double salary, Equipment equipment) {
        super(id, name, age, salary);
        this.equipment = equipment;
    }
    public Programmer(int id, String name, int age, double salary, int memberId,Equipment equipment) {
        super(id, name, age, salary);
        this.memberId = memberId;
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }

    public void setEquipment(Equipment equipment) {
        this.equipment = equipment;
    }

    public int getMemberId() {
        return memberId;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public void setMemberId(int memberId) {
        this.memberId = memberId;
    }

    public String getStatus() {
        return status.getNAME();
    }

    @Override
    public String toString() {
        return getDetails() + "\t程序员\t\t" + status.getNAME() + "\t\t\t\t\t" + equipment.getDescription();
    }

    public String getDetailsForTeam() {
        return getMemberId() + "/" + getId() + "\t" + getName() + "\t" + getAge() + "\t" + getSalary() + "\t" + "程序员";
    }
}
