/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Interface.java to edit this template
 */
package tools;

/**
 *
 * @author Thien Hao
 */
public interface Acceptable {
    public final String EMPLOYEE_ID_VALID = "(?i)^E\\d{3}$";
    public final String NAME_VALID  = "^.{2,50}$";
    public final int MIN_WORKINGDAY = 0;
    public final int MAX_WORKINGDAY = 26;
    public final String STATUS_VALID = "(?i)^(active|inactive)$";
    public final String ACTIVE_STATUS = "ACTIVE";
    public final String INACTIVE_STATUS = "INACTIVE";
}
