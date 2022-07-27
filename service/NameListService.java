package com.liuchang.Project3.service;

import com.liuchang.Project3.domain.*;

import static com.liuchang.Project3.service.Data.*;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午2:22
 */
public class NameListService {
    private Employee[] employees;

    public NameListService() {
        employees = new Employee[EMPLOYEES.length];
        for (int i = 0; i < EMPLOYEES.length; i++) {
            //成员类型
            int type = Integer.parseInt(EMPLOYEES[i][0]);
            //四大基本属性
            int id = Integer.parseInt(EMPLOYEES[i][1]);
            String name = EMPLOYEES[i][2];
            int age = Integer.parseInt(EMPLOYEES[i][3]);
            double salary = Double.parseDouble(EMPLOYEES[i][4]);
            Equipment equipment;
            double bonus;
            int stock;
            switch (type) {
                case EMPLOYEE:
                    employees[i] = new Employee(id, name, age, salary);
                    break;
                case PROGRAMMER:
                    equipment = createEquipment(i);
                    employees[i] = new Programmer(id, name, age, salary, equipment);
                    break;
                case DESIGNER:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    employees[i] = new Designer(id, name, age, salary, equipment, bonus);
                    break;
                case ARCHITECT:
                    equipment = createEquipment(i);
                    bonus = Double.parseDouble(EMPLOYEES[i][5]);
                    stock = Integer.parseInt(EMPLOYEES[i][6]);
                    employees[i] = new Architect(id, name, age, salary, equipment, bonus, stock);
                    break;
            }

        }
    }

    /**
     * @param index
     * @return com.liuchang.Project3.domain.Equipment
     * @Description 创建设备对象 并且返回一个设备的对象
     * @author Cc
     * @date 26/7/2022 下午2:53
     */
    private Equipment createEquipment(int index) {
        //机器类型
        int key = Integer.parseInt(EQUIPMENTS[index][0]);
        String name = EQUIPMENTS[index][1];
        Equipment equipment = null;
        switch (key) {
            case PC:
                String display = EQUIPMENTS[index][2];
                equipment = new PC(name, display);
                break;
            case NOTEBOOK:
                double price = Double.parseDouble(EQUIPMENTS[index][2]);
                equipment = new NoteBook(name, price);
                break;
            case PRINTER:
                String type = EQUIPMENTS[index][2];
                equipment = new Printer(name, type);
                break;
        }
        return equipment;
    }

    public Employee[] getEmployees() {
        return employees;
    }

    public Employee getEmployee(int id) throws TeamException {
        for (int i = 0; i < employees.length; i++) {
            if (employees[i].getId() == id) {
                return employees[i];
            }
        }
        throw new TeamException("找不到指定的员工");
    }
}
