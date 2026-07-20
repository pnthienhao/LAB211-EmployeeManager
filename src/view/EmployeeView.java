/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import java.util.List;
import model.Employee;

/**
 *
 * @author Thien Hao
 */
public class EmployeeView {
    public void showAllEmployees(List<Employee> employeeList) {
        if (employeeList.isEmpty()) {
            System.out.println("No employee found.");
            return;
        }
        System.out.println(TableFormat.EMPLOYEE_HEADER);
        for (Employee e : employeeList) {
            System.out.println(e);
        }
        System.out.println(TableFormat.EMPLOYEE_LINE);
        System.out.println("Total employees: " + employeeList.size());
    }
    public void displayEmployeeInfo(Employee e) {
        if (e == null) {
            System.out.println("This employee does not exist!");
        } else {
            System.out.println(TableFormat.EMPLOYEE_HEADER);
            System.out.println(e);
            System.out.println(TableFormat.EMPLOYEE_LINE);
        }
    }
    public void showAllSalary(List<Employee> employeeList){
        if (employeeList.isEmpty()) {
            System.out.println("No employee found.");
            return;
        }
        System.out.println(TableFormat.EMPLOYEE_SALARY_HEADER);
        for (Employee e : employeeList) {
            System.out.println(e.toSalaryString());
        }
        System.out.println(TableFormat.EMPLOYEE_SALARY_LINE);
        System.out.println("Total employees: " + employeeList.size());
    }
}
