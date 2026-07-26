package com.codespace;

import com.codespace.infrastructure.persistent.dao.IEmployeeDao;
import com.codespace.infrastructure.persistent.po.Employee;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import jakarta.annotation.Resource;
import java.time.LocalDateTime;

import static org.junit.Assert.*;

/**
 * Employee 表数据库写入测试
 * <p>
 * 验证 MyBatis 能否正常连接数据库并写入 employee 表。
 * 数据源配置见 application-local.yaml。
 * </p>
 */
@Slf4j
@RunWith(SpringRunner.class)
@SpringBootTest
public class EmployeeDaoTest {

    @Resource
    private IEmployeeDao employeeDao;

    @Test
    public void test_insert() {
        // given：构造一条雇员数据
        Employee employee = Employee.builder()
                .employeeNumber("10000099")
                .employeeName("测试雇员")
                .employeeLevel("T2")
                .employeeTitle("中级工程师")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();

        // when：执行插入
        int rows = employeeDao.insert(employee);

        // then：断言影响行数为 1
        assertEquals("应插入 1 行", 1, rows);
        assertNotNull("数据库应自动回填主键 id", employee.getId());
        log.info("插入成功，自动生成 id: {}, 影响行数: {}", employee.getId(), rows);
    }

    @Test
    public void test_insertAndQuery() {
        // given：插入一条数据
        Employee employee = Employee.builder()
                .employeeNumber("10000088")
                .employeeName("回调查询测试")
                .employeeLevel("T-3")
                .employeeTitle("高级工程师")
                .createTime(LocalDateTime.now())
                .updateTime(LocalDateTime.now())
                .build();
        employeeDao.insert(employee);

        // when：按 employee_number 回调查询
        Employee result = employeeDao.queryByEmployeeNumber("10000088");

        // then：验证数据完整写入
        assertNotNull("查询结果不应为 null", result);
        assertEquals("employeeNumber 应匹配", "10000088", result.getEmployeeNumber());
        assertEquals("employeeName 应匹配", "回调查询测试", result.getEmployeeName());
        assertEquals("employeeLevel 应匹配", "T-3", result.getEmployeeLevel());
        assertEquals("employeeTitle 应匹配", "高级工程师", result.getEmployeeTitle());
        log.info("写入并回调查询成功: {}", result);
    }

}
