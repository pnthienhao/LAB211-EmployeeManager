/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tools;

import java.util.Scanner;

/**
 *
 * @author Thien Hao
 */
public class Inputter {

    public static String getString(String prompt) {
        Scanner sc = new Scanner(System.in);
        System.out.println(prompt);
        return sc.nextLine().trim();
    }

    public static boolean isValid(String input, String pattern) {
        return input.matches(pattern);
    }

    public static boolean isValidString(String input) {
        return input != null && !input.trim().isEmpty();
    }

    public static String inputAndLoop(String mess, String pattern, String error) {
        String result;
        while (true) {
            result = getString(mess);
            if (isValid(result, pattern)) {
                return result;
            } else {
                System.out.println(error);
            }
        }
    }

    public static int getInt(String mess) {
        int n;
        while (true) {
            try {
                n = Integer.parseInt(getString(mess));
                if (n >= 0) {
                    return n;
                }
                System.out.println("Number cannot be negative!");
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static String inputOptional(String mess, String pattern, String error) {
        while (true) {
            String input = getString(mess);
            if (input.isEmpty()) {
                return "";
            }
            if (isValid(input, pattern)) {
                return input;
            } else {
                System.out.println(error);
            }
        }
    }

    public static boolean confirmOption(String prompt) {
        int choice;
        do {
            choice = Inputter.getInt(prompt);
            if (choice != 0 && choice != 1) {
                System.out.println("Invalid choice. You must press 0 or 1.");
            }
        } while (choice != 0 && choice != 1);
        if (choice == 1) {
            return true;
        }
        return false;
    }

    public static double getDouble(String mess) {
        double n;
        while (true) {
            try {
                n = Double.parseDouble(getString(mess));
                if (n > 0) {
                    return n;
                }
                System.out.println("Number must be positive.");
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static double getBonusDouble(String mess) {
        double n;
        while (true) {
            try {
                n = Double.parseDouble(getString(mess));
                if (n >= 0) {
                    return n;
                }
                System.out.println("Number cannot be negative.");
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static double getUpdateDouble(String mess, double oldDouble) {
        double n;
        while (true) {
            try {
                String a = getString(mess);
                if (a.isEmpty()) {
                    return oldDouble;
                } else {
                    n = Double.parseDouble(a);
                }
                if (n > 0) {
                    return n;
                }
                System.out.println("Number must be positive.");
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static double getUpdateBonusDouble(String mess, double oldDouble) {
        double n;
        while (true) {
            try {
                String a = getString(mess);
                if (a.isEmpty()) {
                    return oldDouble;
                } else {
                    n = Double.parseDouble(a);
                }
                if (n >= 0) {
                    return n;
                }
                System.out.println("Number cannot be negative.");
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static int getIntInRange(String mess, int min, int max) {
        while (true) {
            try {
                int n = Integer.parseInt(getString(mess));
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.println("Please enter between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static int getIntUpdateInRange(String mess, int min, int max, int oldInt) {
        while (true) {
            try {
                String input = getString(mess);
                if (input.isEmpty()) {
                    return oldInt;
                }
                int n = Integer.parseInt(input);
                if (n >= min && n <= max) {
                    return n;
                }
                System.out.println("Please enter between " + min + " and " + max);
            } catch (Exception e) {
                System.out.println("Invalid number. Please check again.");
            }
        }
    }

    public static String getRequiredString(String mess) {
        String input;
        do {
            input = getString(mess);
            if (!isValidString(input)) {
                System.out.println("Input cannot be empty!");
            }
        } while (!isValidString(input));
        return input;
    }
}
