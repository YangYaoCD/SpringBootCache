package com.yangyao.cache.mapper;

import com.yangyao.cache.model.Employee;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface EmployeeMapper {
    @Select("select * from employee")
    List<Employee> List();

    @Select("select * from employee where id= #{id}")
    Employee finById(Integer id);

    @Update("update employee set name=#{name},create_time=#{createTime},modified_time=#{modifiedTime} where id=#{id}")
    Integer update(Employee employee);

    @Delete("delete from employee where id=#{id}")
    Integer delete(Integer id);

    @Insert("insert into employee(name,createTime,modifiedTime) values(#{name},#{createTime},#{modifiedTime})")
    Integer insert(Employee employee);
}
