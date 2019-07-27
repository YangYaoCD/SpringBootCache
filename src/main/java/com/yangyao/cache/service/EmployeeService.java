package com.yangyao.cache.service;

import com.yangyao.cache.mapper.EmployeeMapper;
import com.yangyao.cache.model.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@CacheConfig(cacheNames ="employee" )//抽取缓存公共配置
@Service
public class EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;
    private Integer result;

    /**
     * @Cacheable讲方法运行结果进行缓存，以后需要相同数据直接从缓存中获取。
     *
     * CacheManager管理多个Cache组件，对缓存的真正crud操作在Cache组件中，每一个缓存组件有自己唯一的一个名字；
     * 几个属性：
     *      cacheNames/value：指定缓存组件的名字；
     *      key：缓存数据使用的key；默认时使用方法参数的值
     *      编写SpEL#root.args[0]
     *      KeyGenerator：key的生成器，可以自己指定key的生成器的组件id。和key二选一
     *      KeyManager：指定缓存管理器，或者cacheResolver,二选一。
     *      condition：指定符合条件的情况下才缓存；
     *      unless:否定缓存：当unless指定的条件为true，就不缓存。可以获取到结果进行判断。
     *      sync：是否使用异步模式。
     * @param id
     * @return
     */
    @Cacheable(cacheNames ="employee",key = "#id")
    public Employee getEmpById(int id){
        System.out.println("查询"+id+"号员工");
        Employee employee = employeeMapper.finById(id);
        return employee;
    }

    /**
     * @CachePut：即调用方法，有更新缓存数据
     * 要求key的数据类型也要相同
     * 修改了数据库的某个数据，同事更新缓存
     * 1.默认的key是employee对象，值也是employee对象
     *      key="#employee.id",传入的id
     *      key="#result.id"，使用返回的id
     */
    @CachePut(cacheNames = "employee",key = "#employee.id")
    public Employee update(Employee employee){
        Integer result = employeeMapper.update(employee);
        return employee;
    }

    /**
     * @CacheEvict：缓存清除
     *  allEntries：是否清除所有缓存
     *  beforeInvocation：缓存的清除是否在方法之前执行，默认在方法执行之后执行。
     */
    @CacheEvict(cacheNames = "employee",key = "#id")
    public Integer delete(Integer id){
        Integer result = employeeMapper.delete(id);
        return result;
    }

    /**
     * caching：定义复杂的缓存规则
     */
}
