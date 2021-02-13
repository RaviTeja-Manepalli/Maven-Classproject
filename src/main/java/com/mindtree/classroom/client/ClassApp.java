package com.mindtree.classroom.client;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.mindtree.classroom.Exceptions.NoStudentIdException;
import com.mindtree.classroom.Exceptions.StudentException;
import com.mindtree.classroom.Exceptions.ServiceException.ServiceException;
import com.mindtree.classroom.entity.Classroom;
import com.mindtree.classroom.entity.Student;
import com.mindtree.classroom.service.Service;
import com.mindtree.classroom.service.ServiceImpl;

public class ClassApp {
	static Scanner sc = new Scanner(System.in);
	static Service service = new ServiceImpl();

	public static void main(String[] args) throws StudentException, NoStudentIdException {

		List<Classroom> cl = new ArrayList<Classroom>();
		int choice = 0;
		do {
			System.out.println("-------------------------------------------\n" + "1-->create class \n"
					+ "2-->create student\n" + "3-->display details of a student \n" + "4--> Update student age \n"
					+ "5-->exit\n" + "-------------------------------------------");
			System.out.println("Enter ur choice");
			choice = sc.nextInt();
			switch (choice) {
			case 1:
				sc.nextLine();
				System.out.println("enter class Id");
				String classId = sc.nextLine();
				boolean check;
				try {
					check = service.checkIdPresent(classId);
				} catch (ServiceException e1) {
					// TODO Auto-generated catch block
					throw new NoStudentIdException("No student is present");
				}
				boolean res = false;
				if (check == false) {
					try {
						cl.add(createClass(classId));
					} catch (Exception e) {
						// TODO Auto-generated catch block
						throw new StudentException("Database error");
					}
				}

				break;
			case 2:
				System.out.println("Enter classId");
				sc.nextLine();
				String classId1 = sc.nextLine();
				boolean check1 = service.checkClass(classId1);
				System.out.println(check1);
				if (check1 == true) {
					for (Classroom val : cl) {
						if (val.getClassId().equals(classId1)) {
							Student st = null;
							try {
								st = createStudent(classId1);
							} catch (Exception e) {
								// TODO Auto-generated catch block
								throw new StudentException("Database error");
							}
							List<Student> s = val.getSt();
							s.add(st);
							val.setSt(s);
							break;
						}
					}
				}
				break;
			case 3:
				boolean res2 = false;
				sc.nextLine();
				System.out.println("Enter student id");
				String studentId = sc.nextLine();
				try {
					res2 = service.getDetails(studentId);
				} catch (NoStudentIdException e) {
					throw new NoStudentIdException("No student is present");				}
				if (res2 == false) {
					System.out.println("No Details in  DB");
				}

				break;
			case 4:
				sc.nextLine();
				System.out.println("Enter student id to update age");
				String id = sc.nextLine();
				System.out.println("Enter new age");
				int age = sc.nextInt();
				boolean res1 = service.updateAge(id, age);
				if (res1 == true) {
					System.out.println("No Details in  DB");
				}
				break;
			case 5:
				System.out.println("Thank you");
				break;
			default:
				System.out.println("Invalid input");
			}
		} while (choice != 5);
	}

	private static Classroom createClass(String classId) throws Exception {
		// TODO Auto-generated method stub
		System.out.println("Enter name");
		String className = sc.nextLine();
		System.out.println("Enter count");
		int count = sc.nextInt();
		Classroom cla = service.insertClass(classId, className, count);
		System.out.println("Class inserted");
		return cla;

	}

	private static Student createStudent(String classId) throws StudentException {
		// TODO Auto-generated method stub
		System.out.println("Enter student name");
		String name = sc.nextLine();
		System.out.println("Enter student Id");
		String studentId = sc.nextLine();
		System.out.println("Enter age");
		int age = sc.nextInt();
		Student st = null;
		try {
			st = service.insertStudent(classId, name, studentId, age);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			System.out.println("Failed to insert");
		}
		System.out.println("student inserted");

		return st;
	}

}
