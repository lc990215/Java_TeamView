package com.liuchang.Project3.junit;

import com.liuchang.Project3.domain.Employee;
import com.liuchang.Project3.domain.Programmer;
import com.liuchang.Project3.service.NameListService;
import com.liuchang.Project3.service.TeamException;
import org.junit.jupiter.api.Test;


/**
 * @author liuchang Email:645272107@qq.com
 * @Description 对NameListService 测试
 * @date 26/7/2022下午3:24
 */
public class NameListServiceTest {
    @Test
    public void testGetAllEmployees() {
        NameListService service = new NameListService();
        Employee[] employees = service.getEmployees();
        for (int i = 0; i < employees.length; i++) {
            System.out.println(employees[i]);
        }
    }

    @Test
    public void testGetEmployee(){
        NameListService service = new NameListService();

        int id = 100;
        try {
            System.out.println(service.getEmployee(id));
        } catch (TeamException e) {
            System.out.println(e.getMessage());
        }

    }
}
