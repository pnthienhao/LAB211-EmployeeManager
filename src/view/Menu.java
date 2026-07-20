/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package view;

import tools.Inputter;

/**
 *
 * @author Thien Hao
 */
public class Menu {
    public int showMainMenu() {
    System.out.println("\n============= EMPLOYEE MANAGEMENT =============");
    System.out.println("1. Load employee data from file");
    System.out.println("2. Add a new employee");
    System.out.println("3. Update employee");
    System.out.println("4. Remove employee");
    System.out.println("5. Search employee");
    System.out.println("6. Calculate payroll");
    System.out.println("7. Display employee list");
    System.out.println("8. Save employee data to file");
    System.out.println("9. Quit");
    System.out.println("===============================================");
    return Inputter.getIntInRange("Enter your choice: ", 1, 9);
}
    public int showSearchMenu() {
    System.out.println("========== SEARCH MENU ==========");
    System.out.println("1. Search by ID");
    System.out.println("2. Search by Name");
    System.out.println("3. Search by Role");
    System.out.println("4. Search by Status");
    System.out.println("=================================");
    return Inputter.getIntInRange("Enter your choice: ", 1, 4);
}
    public int showRoleMenu() {
    System.out.println("=========== ROLE MENU ===========");
    System.out.println("1. Developer");
    System.out.println("2. Tester");
    System.out.println("3. Manager");
    System.out.println("4. HR");
    System.out.println("=================================");
    return Inputter.getIntInRange("Enter your choice: ", 1, 4);
}
    public int showUpdateRoleMenu() {
    System.out.println("=========== ROLE MENU ===========");
    System.out.println("0. Skip");
    System.out.println("1. Developer");
    System.out.println("2. Tester");
    System.out.println("3. Manager");
    System.out.println("4. HR");
    System.out.println("=================================");
    return Inputter.getIntInRange("Enter your choice: ", 0, 4);
}
}
