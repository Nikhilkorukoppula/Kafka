package com.kafka.entity;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class Employee {

    private int empId;
    private String empName;
    private String designation;
    private long salary;

}
