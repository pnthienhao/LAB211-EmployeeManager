package control;

import business.EmployeeManagement;
import tools.Inputter;
import view.EmployeeView;
import view.Menu;

/**
 *
 * @author Thien Hao
 */
public class Main {

    public static void main(String[] args) {
        Menu menu = new Menu();
        EmployeeManagement employees = new EmployeeManagement();
        EmployeeView view = new EmployeeView();
        employees.loadEmployeeData();
        int choice;
        do {
            choice = menu.showMainMenu();
            switch (choice) {
                case 1:
                    employees.loadEmployeeData();
                    break;

                case 2:
                    employees.addEmployee(menu);
                    break;

                case 3:
                    employees.updateEmployee(view, menu);
                    break;

                case 4:
                    employees.deleteEmployee(view);
                    break;

                case 5:
                    int findChoice = menu.showSearchMenu();
                    switch (findChoice) {
                        case 1:
                            view.displayEmployeeInfo(employees.getEmployeeById());
                            break;
                        case 2:
                            view.showAllEmployees(employees.getEmployeesByName());
                            break;
                        case 3:
                            view.showAllEmployees(employees.getEmployeesByRole(menu));
                            break;
                        case 4:
                            view.showAllEmployees(employees.getEmployeesByStatus());
                            break;
                    }
                    break;

                case 6:
                    view.showAllSalary(employees.getActiveEmployees());
                    break;

                case 7:
                    view.showAllEmployees(employees.getEmployeeList());
                    break;

                case 8:
                    employees.saveEmployeeData();
                    break;

                case 9:
                    if (!employees.isEmployeeSaved()) {
                        boolean confirm = Inputter.confirmOption(
                                "Do you want to save data before exiting? 1. Yes, 0. No");
                        if (confirm) {
                            employees.saveEmployeeData();

                            if (employees.isEmployeeSaved()) {
                                System.out.println("Good bye!");
                                return;
                            }

                            System.out.println(
                                    "Save failed. Please check again. Program was not closed.");
                            choice = 0;
                        } else {
                            boolean confirm2 = Inputter.confirmOption(
                                    "Are you sure you want to exit without saving data? 1. Yes, 0. No");
                            if (confirm2) {
                                System.out.println("Good bye!");
                                return;
                            }
                            choice = 0;
                        }
                    } else {
                        System.out.println("Good bye!");
                    }
                    break;
            }
        } while (choice != 9);
    }
}
