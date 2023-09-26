package com.kafka.entity;

import lombok.Data;

@Data
public class Employee {

    private int empId;
    private String empName;
    private String designation;
    private long salary;

}
