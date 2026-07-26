package com.codespace.infrastructure.persistent.dao;

import com.codespace.infrastructure.persistent.po.Employee;
import org.apache.ibatis.annotations.Mapper;

/**
 * 雇员表 DAO 接口
 */
@Mapper
public interface IEmployeeDao {

    /**
     * 插入一条雇员记录
     */
    int insert(Employee employee);

    /**
     * 按雇员编号查询
     */
    Employee queryByEmployeeNumber(String employeeNumber);

}
