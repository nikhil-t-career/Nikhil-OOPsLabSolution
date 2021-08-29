package com.lab.mail.service;

import java.security.SecureRandom;

import com.lab.mail.entities.Employee;

/**
 * Utility class to generate credentials
 * 
 * generatePassword, generateEmailAddress showCredentials method
 * 
 * @author fullstack8
 *
 */
public final class CredentialsService {

	static int len = 10, randNumOrigin = 48, randNumBound = 122;

	
	
	/**
	 * a) Generate an email with the following syntax
	 * firstNamelastName.department@company.com
	 * 
	 * @param emp
	 * @return
	 */
	public static String generateEmailAddress(Employee emp) {
		String emailId = emp.getFirstName().toLowerCase() + emp.getLastName() + "."
				+ emp.getDepartment().toString().toLowerCase() + "@abc.com";

		return emailId;
	}

	/**
	 * Method to generate a random alphanumeric password using Java Secure Random
	 * 
	 * @param randNumOrigin
	 * @param randNumBound
	 * @param len
	 * @return
	 */
	public static String generatePassword() {

		SecureRandom random = new SecureRandom();
		return random.ints(randNumOrigin, randNumBound + 1)
				.filter(i -> Character.isAlphabetic(i) || Character.isDigit(i)).limit(len)
				.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append).toString();
	}

	/**
	 * Utility method to display credentials
	 * 
	 * @param emp
	 */
	public static void showCredentials(Employee emp) {
		System.out.println("\n\nDear " + emp.getFirstName() + " " + emp.getLastName()
				+ "\nYour generated credentials are as follows : ");
		System.out.println("Email Id --> " + emp.getEmailAddress());
		System.out.println("Auto Password --> " + emp.getPassword());
	}
}
