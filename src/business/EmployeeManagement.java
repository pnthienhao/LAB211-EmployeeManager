package business;
import fileio.EmployeeFileManagement;
import java.util.ArrayList;
import java.util.List;
import model.Employee;
import tools.Acceptable;
import tools.Inputter;
import tools.Role;
import view.EmployeeView;
import view.Menu;

/**
 *
 * @author Thien Hao
 */
public class EmployeeManagement {

    private List<Employee> employeeList = new ArrayList<>();
    private boolean isEmployeeSaved = false;
    private EmployeeFileManagement employeeFile = new EmployeeFileManagement();

    public List<Employee> getEmployeeList() {
        return employeeList;
    }

    public boolean isEmployeeSaved() {
        return isEmployeeSaved;
    }

    public void setEmployeeSaved(boolean isEmployeeSaved) {
        this.isEmployeeSaved = isEmployeeSaved;
    }

    public void saveEmployeeData() {
        boolean check = employeeFile.saveToFile("employees.txt", employeeList);
        if (check) {
            isEmployeeSaved = true;
            System.out.println("Saving data successfully.");
        } else {
            System.out.println("Saving data failed!");
        }
    }

    public void loadEmployeeData() {
        isEmployeeSaved = true;
        boolean check = employeeFile.loadFromFile("employees.txt", employeeList);
        if (!check) {
            System.out.println("No data found. Data loaded failed!");
            return;
        }
        System.out.println("Data loaded successfully.");
    }

    public void addEmployee(Menu menu) {
        boolean choice;
        do {
            String id;
            do {
                id = Inputter.inputAndLoop("Enter Employee ID: ", Acceptable.EMPLOYEE_ID_VALID, "Invalid Employee ID. Please try again.");
                if (findEmployeeById(id) != null) {
                    System.out.println("This Employee ID already exists!");
                }
            } while (findEmployeeById(id) != null);
            String employeeName = Inputter.inputAndLoop("Enter Employee Name: ", Acceptable.NAME_VALID, "Invalid Employee Name. Please try again.");
            int roleChoice = menu.showRoleMenu();
            Role role = Role.getRoleFromChoice(roleChoice);
            double baseSalary = Inputter.getDouble("Enter Base salary: ");
            int workingDays = Inputter.getIntInRange("Enter Working days: ", Acceptable.MIN_WORKINGDAY, Acceptable.MAX_WORKINGDAY);
            double bonus = Inputter.getBonusDouble("Enter Bonus: ");
            Employee e = new Employee(id, employeeName, role, baseSalary, workingDays, bonus);
            employeeList.add(e);
            System.out.println("Add employee successfully.");
            choice = Inputter.confirmOption("Add new employee? 1. Yes, 0. No");
            isEmployeeSaved = false;
        } while (choice);
    }

    public Employee findEmployeeById(String id) {
        for (Employee e : employeeList) {
            if (e.getEmployeeId().equalsIgnoreCase(id)) {
                return e;
            }
        }
        return null;
    }

    public void updateEmployee(EmployeeView view, Menu menu) {
        String id = Inputter.inputAndLoop("Enter Employee ID: ", Acceptable.EMPLOYEE_ID_VALID, "Invalid Employee ID. Please try again.");
        Employee e = findEmployeeById(id);
        if (e == null) {
            System.out.println("This employee does not exist!");
            return;
        }
        view.displayEmployeeInfo(e);
        int roleChoice = menu.showUpdateRoleMenu();
        if (roleChoice != 0) {
            Role updateRole = Role.getRoleFromChoice(roleChoice);
            e.setRole(updateRole);
        }
        double baseSalary = Inputter.getUpdateDouble("Enter new Basic Salary (Press Enter to skip): ", e.getBaseSalary());
        e.setBaseSalary(baseSalary);
        double bonus = Inputter.getUpdateBonusDouble("Enter new Bonus (Press Enter to skip): ", e.getBonus());
        e.setBonus(bonus);
        String status = Inputter.inputOptional("Enter new Status (Press Enter to skip): ", Acceptable.STATUS_VALID, "Invalid Employee Status. Please try again.");
        if (!status.isEmpty()) {
            e.setStatus(status.toUpperCase());
        }
        System.out.println("This employee has been updated successfully!");
        isEmployeeSaved = false;
    }

    public void deleteEmployee(EmployeeView view) {
        String id = Inputter.inputAndLoop("Enter Employee ID: ", Acceptable.EMPLOYEE_ID_VALID, "Invalid Employee ID. Please try again.");
        Employee e = findEmployeeById(id);
        if (e == null) {
            System.out.println("This employee does not exist!");
            return;
        }
        if (e.getStatus().equalsIgnoreCase(Acceptable.INACTIVE_STATUS)) {
            System.out.println("This employee has already been deleted.");
            return;
        }
        view.displayEmployeeInfo(e);
        boolean choice = Inputter.confirmOption("Are you sure you want to delete this employee? 1.Yes, 0. No");
        if (choice) {
            e.setStatus(Acceptable.INACTIVE_STATUS);
            System.out.println("The employee has been successfully deleted.");
            isEmployeeSaved = false;
        } else {
            System.out.println("Deletion cancelled.");
        }
    }

    public Employee getEmployeeById() {
        String id = Inputter.inputAndLoop("Enter Employee ID: ", Acceptable.EMPLOYEE_ID_VALID, "Invalid Employee ID. Please try again.");
        return findEmployeeById(id);
    }

    public List<Employee> findEmployeesByName(String name) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getName().toLowerCase().contains(name.toLowerCase())) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesByName() {
        String name = Inputter.getRequiredString("Enter Employee Name: ");
        return findEmployeesByName(name);
    }

    public List<Employee> getEmployeesByRole(Menu menu) {
        List<Employee> result = new ArrayList<>();
        int choice = menu.showRoleMenu();
        Role role = Role.getRoleFromChoice(choice);
        for (Employee employee : employeeList) {
            if (employee.getRole() == role) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> findEmployeesByStatus(String status) {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getStatus().equalsIgnoreCase(status)) {
                result.add(employee);
            }
        }
        return result;
    }

    public List<Employee> getEmployeesByStatus() {
        String status = Inputter.inputAndLoop("Enter Employee Status: ", Acceptable.STATUS_VALID, "Invalid Employee Status. Please try again.");
        return findEmployeesByStatus(status);
    }

    public List<Employee> getActiveEmployees() {
        List<Employee> result = new ArrayList<>();
        for (Employee employee : employeeList) {
            if (employee.getStatus().equalsIgnoreCase(Acceptable.ACTIVE_STATUS)) {
                result.add(employee);
            }
        }
        return result;
    }

}
