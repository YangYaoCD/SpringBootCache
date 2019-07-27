package com.yangyao.cache.controller;

import com.yangyao.cache.model.Employee;
import com.yangyao.cache.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;
    @GetMapping("/emp/{id}")
    public String getEmployee(@PathVariable(name = "id")Integer id, Model model){
        Employee empById = employeeService.getEmpById(id);
        System.out.println(empById);
        model.addAttribute("title",empById.getName());
        return "index";
    }

    @GetMapping("emp/toUpdate/{id}")
    public String toUpdate(Model model,@PathVariable(name = "id") Integer id){
        Employee employee = employeeService.getEmpById(id);
        model.addAttribute("employee",employee);
        return "employee/edit";
    }

    @RequestMapping("/emp/update")
    public String updateEmployee(Employee employee,Model model){
        employeeService.update(employee);
        return "redirect:/emp/1";
    }
    
    @GetMapping("/emp/delete/{id}")
    public String deleteEmployee(@PathVariable(name = "id")Integer id){
        Integer result = employeeService.delete(id);
        return "redirect:/emp/2";
    }
}
