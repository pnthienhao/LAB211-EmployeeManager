/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import tools.Acceptable;
import tools.Role;

/**
 *
 * @author Thien Hao
 */
public class Employee {

    private String employeeId;
    private String name;
    private Role role;
    private double baseSalary;
    private int workingDays;
    private double bonus;
    private String status;

    public Employee(String employeeId, String name, Role role, double baseSalary, int workingDays, double bonus) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.workingDays = workingDays;
        this.status = Acceptable.ACTIVE_STATUS;
        this.bonus = bonus;
    }

    public Employee(String employeeId, String name, Role role, double baseSalary, int workingDays, double bonus, String status) {
        this.employeeId = employeeId;
        this.name = name;
        this.role = role;
        this.baseSalary = baseSalary;
        this.workingDays = workingDays;
        this.bonus = bonus;
        this.status = status;
    }

    public String getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

    public int getWorkingDays() {
        return workingDays;
    }

    public void setWorkingDays(int workingDays) {
        this.workingDays = workingDays;
    }

    public double getBonus() {
        return bonus;
    }

    public void setBonus(double bonus) {
        this.bonus = bonus;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return String.format(
                "%-10s| %-25s| %-12s| %,15.0f| %,12.0f| %10d| %-10s",
                employeeId,
                name,
                role,
                baseSalary,
                bonus,
                workingDays,
                status
        );
    }
    public double calculateSalary(){
        return (baseSalary / Acceptable.MAX_WORKINGDAY * workingDays) + bonus;
    }
    public String toSalaryString(){
        return String.format(
            "%-10s| %-25s| %-12s| %10d| %,15.0f",
            employeeId,
            name,
            role,
            workingDays,
            calculateSalary());
    }
}
