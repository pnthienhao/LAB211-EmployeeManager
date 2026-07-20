/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package view;

/**
 *
 * @author Thien Hao
 */
public interface TableFormat {

    public final String EMPLOYEE_LINE
            = "----------------------------------------------------------------------------------------------------------------------------";
    public final String EMPLOYEE_HEADER
            = EMPLOYEE_LINE + "\n"
            + String.format(
                    "%-10s| %-25s| %-12s| %15s| %12s| %10s| %-10s\n",
                    "Emp ID",
                    "Name",
                    "Role",
                    "Base Salary",
                    "Bonus",
                    "Days",
                    "Status")
            + EMPLOYEE_LINE;
    public final String EMPLOYEE_SALARY_LINE
            = "--------------------------------------------------------------------------------";
    public final String EMPLOYEE_SALARY_HEADER
            = EMPLOYEE_SALARY_LINE + "\n"
            + String.format(
                    "%-10s| %-25s| %-12s| %10s| %15s\n",
                    "Emp ID",
                    "Name",
                    "Role",
                    "Days",
                    "Total Salary")
            + EMPLOYEE_SALARY_LINE;

}
