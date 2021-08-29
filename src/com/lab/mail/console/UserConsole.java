package com.lab.mail.console;

import java.util.EnumSet;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lab.mail.entities.Department;
import com.lab.mail.entities.Employee;
import com.lab.mail.service.CredentialsService;

/**
 * User console to provide Employee details and get the Email Id generated
 * 
 * @author fullstack8
 *
 */
public final class UserConsole {

	private static final String PLEASE_TYPE_DEPARTMENT_ID = "\nPlease type Department ID as in Menu: ";
	private static final String PLEASE_ENTER_LAST_NAME = "\nPlease enter Last name without spaces: ";
	private static final String PLS_ENTER_FIRST_NAME = "\nPlease enter First name without spaces: ";
	static final Scanner userIn = new Scanner(System.in);
	static char dept = 0;
	static final String ALPHABETS = "^[a-zA-Z]+$"; // NAME Alphabets only

	public static void main(String[] args) {

		System.out.println("Please Enter Employee details and get Email Id generated :");
		String firstName, lastName;

		firstName = acceptAndValidateName(PLS_ENTER_FIRST_NAME, ALPHABETS);

		lastName = acceptAndValidateName(PLEASE_ENTER_LAST_NAME, ALPHABETS);

		Employee emp = new Employee(firstName, lastName);

		// Accept Department from user
		emp.setDepartment(acceptEmployeeDepartment());

		// Generate and Set Email Id
		emp.setEmailAddress(CredentialsService.generateEmailAddress(emp));
		
		//generate password
		emp.setPassword(CredentialsService.generatePassword());

		// Show credentials of the user
		CredentialsService.showCredentials(emp);

	}

	/**
	 * Util method for accepting Names and validating them for alphabets
	 * 
	 * @param msg
	 * @param REGEX
	 * @return
	 */
	private static String acceptAndValidateName(String msg, final String REGEX) {
		boolean askDetails = true;
		String input = "";

		while (askDetails) {
			System.out.print(msg);
			try {
				input = userIn.next();
				System.out.println(input);
				if (!Pattern.matches(REGEX, input)) {
					throw new Exception(" Please enter Alphabets only");
				}
				askDetails = false;

			} catch (Exception e) {
				System.out.println("error in input - " + e.getMessage());
			}
		}

		return input;
	}

	/**
	 * Util method to get Department ID for Employee
	 * 
	 * @param emp
	 */
	private static Department acceptEmployeeDepartment() {

		System.out.println("\n\nPlease Type your department ID as below :");
		System.out.printf("%-15s %15s %n", "Department name", "Department Id");
		System.out.println("===============================================");
		EnumSet.allOf(Department.class)
				.forEach(dept -> System.out.printf("%-15s -%10s %n", dept.getDepartmentName(), dept.toString()));

		boolean askDeptId = true;
		String deptId = "";
		Department dept = null;

		while (askDeptId) {
			try {
				System.out.print(PLEASE_TYPE_DEPARTMENT_ID);
				deptId = userIn.next();
				System.out.println(deptId);
				if (!Pattern.matches(ALPHABETS, deptId)) {
					throw new Exception(" Please enter Alphabets only");
				}
				dept = Department.valueOf(deptId.toUpperCase());
				askDeptId = false;
			} catch (Exception e) {
				System.out.println("Error in department name.");
			}
		}

		return dept;
	}

}
