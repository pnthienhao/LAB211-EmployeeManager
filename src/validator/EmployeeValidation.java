/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package validator;
import tools.Acceptable;
import tools.Inputter;
import tools.Role;

/**
 *
 * @author Thien Hao
 */
public class EmployeeValidation {
    public static boolean isEmployeeIdValid(String input){
        return Inputter.isValidString(input)
                    && Inputter.isValid(input, Acceptable.EMPLOYEE_ID_VALID);
               
    }
    public static boolean isNameValid(String input){
        return Inputter.isValidString(input) && Inputter.isValid(input, Acceptable.NAME_VALID);
    }
    public static boolean checkRoleValid(Role r){
        if(r==null) return false;
        return Role.isValidRole(r.toString());
    }
    public static boolean isBaseSalaryValid(double input){
        return input > 0;
    }
    public static boolean isBonusValid(double input){
        return input >= 0;
    }
    public static boolean isWorkingDaysValid(int workingDays){
        return workingDays>=Acceptable.MIN_WORKINGDAY && workingDays<=Acceptable.MAX_WORKINGDAY;
    }
    public static boolean isStatusValid(String input){
        return Inputter.isValidString(input) && input.matches(Acceptable.STATUS_VALID);
    }
}
