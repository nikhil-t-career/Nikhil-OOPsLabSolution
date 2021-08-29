package com.lab.mail.entities;

public enum Department {

	TECH("Technical"), ADMIN("Admin"), HR("Human Resources"), LEGAL("Legal");

	String departmentName;

	private Department(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getDepartmentName() {
		return departmentName;
	}

//	public static void main(String...strings)
//	{
//		System.out.println(Arrays.asList(Department.values()).contains("TECH"));
//		System.out.println(Department.valueOf("TECH"));
////		System.out.println(Department.valueOf("TECHNO"));
//		System.out.println();
//		
//		System.out.println("Department and Department ID - Please choose one of the following :");
//		System.out.printf( "%-15s %15s %n", "Department name", "Department Id");
//		System.out.println("===============================================");
//		EnumSet.allOf(Department.class).forEach(dept -> System.out.printf( "%-15s -%10s %n", dept.getDepartmentName(), dept.toString()) );
//	
//		EnumSet.allOf(Department.class).forEach(dept -> System.out.println(dept.getDepartmentName()+ "\t\t - " + dept.toString()));
//		
//		
//
//		
//	}

}
