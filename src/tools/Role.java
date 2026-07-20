/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Enum.java to edit this template
 */
package tools;

/**
 *
 * @author Thien Hao
 */
public enum Role {
    DEVELOPER("Developer"),
    TESTER("Tester"),
    MANAGER("Manager"),
    HR("HR");

    private final String displayName;

    private Role(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

    public static Role getRoleFromChoice(int choice) {
        if (choice >= 1 && choice <= Role.values().length) {
            return values()[choice - 1];
        }
        return null;
    }

    public static boolean isValidRole(String input) {
        for (Role r : Role.values()) {
            if (r.displayName.equalsIgnoreCase(input)) {
                return true;
            }
        }
        return false;
    }

    public static Role getRoleFromString(String input) {
        for (Role r : Role.values()) {
            if (r.displayName.equalsIgnoreCase(input)) {
                return r;
            }
        }
        return null;
    }
}
