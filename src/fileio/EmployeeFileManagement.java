package fileio;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import model.Employee;
import tools.Role;
import static validator.EmployeeValidation.checkRoleValid;
import static validator.EmployeeValidation.isBaseSalaryValid;
import static validator.EmployeeValidation.isBonusValid;
import static validator.EmployeeValidation.isEmployeeIdValid;
import static validator.EmployeeValidation.isNameValid;
import static validator.EmployeeValidation.isStatusValid;
import static validator.EmployeeValidation.isWorkingDaysValid;

/**
 *
 * @author Thien Hao
 */
public class EmployeeFileManagement {

    public boolean loadFromFile(String fileName, List<Employee> employeeList) {
        employeeList.clear();
        List<String> lines = FileUtils.readAllLines(fileName);
        Set<String> ids = new HashSet<>();
        for (String line : lines) {
            Employee employee = dataToObject(line);
            if (employee == null) {
                continue;
            }
            if(!ids.add(employee.getEmployeeId().toUpperCase())
                    || !isEmployeeIdValid(employee.getEmployeeId()) 
                    || !isNameValid(employee.getName()) 
                    || !checkRoleValid(employee.getRole())
                    || !isBaseSalaryValid(employee.getBaseSalary()) 
                    || !isBonusValid(employee.getBonus()) 
                    || !isWorkingDaysValid(employee.getWorkingDays())
                    || !isStatusValid(employee.getStatus())){
                System.out.println("Data failed at: " + line);
                continue;
            }
            employeeList.add(employee);
        }
        return !employeeList.isEmpty();
    }

    public boolean saveToFile(String fileName, List<Employee> employeeList) {
        List<String> lines = new ArrayList<>();
        for (Employee e : employeeList) {
            lines.add(objectToData(e));
        }
        return FileUtils.writeAllLines(fileName, lines);
    }

    public Employee dataToObject(String line) {
        String[] data = line.split(",");
        if (data.length != 7) {
            System.out.println("Data failed at: " + line);
            return null;
        }
        try {
            Role r = Role.getRoleFromString(data[2].trim());
            if (r == null) {
                return null;
            }
            return new Employee(data[0].trim(), data[1].trim(), r, Double.parseDouble(data[3].trim()), Integer.parseInt(data[4].trim()), Double.parseDouble(data[5].trim()), data[6].trim().toUpperCase());
        } catch (Exception e) {
            return null;
        }
    }

    public String objectToData(Employee e) {
        return e.getEmployeeId() + ", " + e.getName() + ", " + e.getRole() + ", "
                + e.getBaseSalary() + ", " + e.getWorkingDays() + ", " + e.getBonus() + ", " + e.getStatus();
    }

}
