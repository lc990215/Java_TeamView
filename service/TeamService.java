package com.liuchang.Project3.service;

import com.liuchang.Project3.domain.Architect;
import com.liuchang.Project3.domain.Designer;
import com.liuchang.Project3.domain.Employee;
import com.liuchang.Project3.domain.Programmer;

/**
 * @author liuchang Email:645272107@qq.com
 * @Description
 * @date 26/7/2022下午3:51
 */
public class TeamService {
    private static int counter = 1; // 给团队成员memeberId去赋值
    private final int MAX_MEMBER = 5; //来限制开发团队的人数
    private Programmer[] team = new Programmer[MAX_MEMBER];
    private int total = 0;

    /**
     * @param
     * @return com.liuchang.Project3.domain.Programmer[]
     * @Description 返回已有的成员
     * @author Cc
     * @date 26/7/2022 下午4:21
     */
    public Programmer[] getTeam() {
        Programmer[] team = new Programmer[total];
        for (int i = 0; i < team.length; i++) {
            team[i] = this.team[i];
        }
        return team;
    }

    public void addMember(Employee e) throws TeamException {
        int architect = 0, designer = 0, programmer = 0;

        if (total >= MAX_MEMBER) {
            throw new TeamException("团队成员已满");
        }
        if (!(e instanceof Programmer)) {
            throw new TeamException("该成员不是开发人员，无法添加");
        }
        Programmer p = (Programmer) e;
        if (isExist(e)) {
            throw new TeamException("该成员已在本开发团队中");
        }

        if ("BUSY".equals(p.getStatus())) {
            throw new TeamException("该员工已是某团队成员");

        } else if ("VOCATION".equals(p.getStatus())) {
            throw new TeamException("该员工正在休假，无法添加");
        }

        for (int i = 0; i < total; i++) {
            if (team[i] instanceof Architect) {
                architect++;
            } else if (team[i] instanceof Designer) {
                designer++;
            } else if (team[i] instanceof Programmer) {
                programmer++;
            }
        }

        if (p instanceof Architect) {
            if (architect >= 1) throw new TeamException("团队中至多只能有一名架构师");
        } else if (p instanceof Designer) {
            if (designer >= 2) throw new TeamException("团队中至多只能有两名设计师");
        } else if (p instanceof Programmer) {
            if (programmer >= 3) throw new TeamException("团队中至多只能有三名程序员");
        }
        team[total++] = p;
        p.setStatus(Status.BUSY);
        p.setMemberId(counter++);

    }

    private boolean isExist(Employee e) {
        for (int i = 0; i < total; i++) {
            return ((Programmer) e).getMemberId() == team[i].getMemberId();
        }
        return false;
    }

    public void removeMember(int memberId) throws TeamException {
        int i = 0;
        for (; i < total; i++) {
            if (team[i].getMemberId() == memberId) {
                team[i].setStatus(Status.FREE);
                break;
            }
        }
        if (i == total) {
            throw new TeamException("找不到指定memberId的员工，删除失败");
        }

        //开始删除成员
        for (int j = i; i < total - 1; i++) {
            team[j] = team[j + 1];
        }
        team[--total] = null;
    }
}
