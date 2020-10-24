package com.zbinyun.springboot.demo.mapper;


import com.zbinyun.springboot.demo.bean.Employee;

//@Mapper或者@MapperScan将接口扫描装配到容器中
public interface EmployeeMapper {

    public Employee getEmpById(Integer id);

    public void insertEmp(Employee employee);
}
