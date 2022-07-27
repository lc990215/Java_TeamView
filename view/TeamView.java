package com.liuchang.Project3.view;

import com.liuchang.Project3.domain.Architect;
import com.liuchang.Project3.domain.Designer;
import com.liuchang.Project3.domain.Employee;
import com.liuchang.Project3.domain.Programmer;
import com.liuchang.Project3.service.NameListService;
import com.liuchang.Project3.service.TeamException;
import com.liuchang.Project3.service.TeamService;
import com.liuchang.Project3.util.TSUtility;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 27/7/2022下午1:04
 */
public class TeamView {
    private NameListService listSvc = new NameListService();
    private TeamService teamSvc = new TeamService();

    public void enterMainMenu() {
        boolean loopFlag = true;
        char menu = 0;
        while (loopFlag) {

            if (menu != '1') {
                listAllEmployees();
            }

            System.out.print("\n1-团队列表 2-添加团队成员 3-删除团队成员 4-退出 请选择（1-4）：\n");
            menu = TSUtility.readMenuSelection();
            switch (menu) {

                case '1':
                    getTeam();
                    break;
                case '2':
                    addMember();
                    break;
                case '3':
                    deleteMember();
                    break;
                case '4':
                    System.out.println("确认是否退出（Y/N）：");
                    char isExit = TSUtility.readConfirmSelection();
                    if (isExit == 'Y') {
                        loopFlag = false;
                    }
                    break;
            }
        }

    }

    /**
     * @param
     * @return void
     * @Description 显示所有的员工信息
     * @author Cc
     * @date 27/7/2022 下午1:07
     */
    private void listAllEmployees() {
        System.out.println("\n----------------------------------------开发调度软件---------------------------------------\n");
        Employee[] employees = listSvc.getEmployees();
        if (employees == null || employees.length == 0) {
            System.out.println("公司中没有任何员工信息！");
        } else {
            System.out.println("ID\t\t姓名\t\t年龄\t\t工资\t职位\t\t状态\t奖金\t股票\t领用设备");
            for (int i = 0; i < employees.length; i++) {
                System.out.println(employees[i]);
            }
        }
        System.out.println("\n------------------------------------------------------------------------------------------\n");
    }

    private void getTeam() {
        System.out.println("\n----------------------------------------团队成员列表---------------------------------------\n");
        Programmer[] team = teamSvc.getTeam();
        if (team == null || team.length == 0) {
            System.out.println("开发团队中没有成员");
        } else {
            String detailOfArchitect = null, detailOfDesigner = null, detailOfProgrammer = null;
            System.out.println("TID/ID\t姓名\t年龄\t工资\t职位\t奖金\t\t股票\n");
            for (int i = 0; i < team.length; i++) {
                System.out.println(team[i].getDetailsForTeam());
            }
        }
        System.out.println("\n-----------------------------------------------------------------------------------------\n");
    }


    private void addMember() {
        System.out.println("\n-----------------------------------------添加成员-----------------------------------------\n");
        System.out.println("请输入要添加的员工ID：");
        int id = TSUtility.readInt();
        try {
            Employee employee = listSvc.getEmployee(id);
            teamSvc.addMember(employee);
            System.out.println("添加成功");
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        } finally {
            //按回车键继续。
            TSUtility.readReturn();
        }
    }

    private void deleteMember() {
        System.out.println("\n-----------------------------------------添加成员-----------------------------------------\n");
        System.out.println("请输入要删除的团队成员ID：");
        int id = TSUtility.readInt();
        try {
            teamSvc.removeMember(id);
            System.out.println("删除成功");
        } catch (TeamException e) {
            System.out.println("删除失败，原因：" + e.getMessage());
        } finally {
            //按回车键继续。
            TSUtility.readReturn();
        }

    }

    public static void main(String[] args) {
        TeamView view = new TeamView();
        view.enterMainMenu();
    }
}
