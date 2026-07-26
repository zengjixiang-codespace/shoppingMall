package com.codespace.infrastructure.persistent.po;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDateTime;

/**
 * 雇员表 PO 类
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee implements Serializable {

    private static final long serialVersionUID = 1L;

    /** 主键 */
    private Long id;

    /** 雇员编号 */
    private String employeeNumber;

    /** 雇员姓名 */
    private String employeeName;

    /** 雇员级别 */
    private String employeeLevel;

    /** 雇员岗位 title */
    private String employeeTitle;

    /** 创建时间 */
    private LocalDateTime createTime;

    /** 更新时间 */
    private LocalDateTime updateTime;

}
