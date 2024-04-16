package ktragiuaki;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class main {
    public static void main(String[] args) {
        List<Employee> employee2List = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        EmployeeManagementSystem ems = new EmployeeManagementSystem();

        while (true) {
            System.out.println("=== Employee Management System ===");
            System.out.println("1. Add Employee");
            System.out.println("2. Remove Employee");
            System.out.println("3. Display All Employees");
            System.out.println("4. Exit");
            System.out.println("5. Save");
            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine();
            Employee employee = new Employee();
            int count = Employee.getEmployeeCount();
            System.out.println("Số lượng nhân viên: " + count);

            switch (choice) {
                case 1:
                    System.out.println("=== Add  ===");
                    System.out.print("Enter Employee Type (Experience/Fresher/Intern): ");
                    String type = scanner.nextLine();
                    System.out.print("Enter Employee ID: ");
                    String ID = scanner.nextLine();
                    System.out.print("Enter Full Name: ");
                    String fullName = scanner.nextLine();
                    System.out.print("Enter Birthday: ");
                    String birthDay = scanner.nextLine();
                    System.out.print("EnterPhone: ");
                    String phone = scanner.nextLine();
                    System.out.print("Enter Email: ");
                    String email = scanner.nextLine();

                    if (type.equalsIgnoreCase("Experience")) {
                        System.out.print("Enter Years of Experience: ");
                        int expInYear = scanner.nextInt();
                        scanner.nextLine();
                        System.out.print("Enter Professional Skill: ");
                        String proSkill = scanner.nextLine();
                        Experience experience = new Experience(ID, fullName, birthDay, phone, email, expInYear, proSkill);
                        ems.addEmployee(experience);
                    } else if (type.equalsIgnoreCase("Fresher")) {
                        System.out.print("Enter Graduation Date: ");
                        String graduationDate = scanner.nextLine();
                        System.out.print("Enter Graduation Rank: ");
                        String graduationRank = scanner.nextLine();
                        System.out.print("Enter Education: ");
                        String education = scanner.nextLine();
                        Fresher fresher = new Fresher(ID, fullName, birthDay, phone, email, graduationDate, graduationRank, education);
                        ems.addEmployee(fresher);
                    } else if (type.equalsIgnoreCase("Intern")) {
                        System.out.print("Enter Majors: ");
                        String majors = scanner.nextLine();
                        System.out.print("Enter Semester: ");
                        String semester = scanner.nextLine();
                        System.out.print("Enter University Name: ");
                        String universityName = scanner.nextLine();
                        Intern intern = new Intern(ID, fullName, birthDay, phone, email, majors, semester, universityName);
                        ems.addEmployee(intern);
                    } else {
                        System.out.println("Không tìm thấy bậc Nhân viên!");
                        System.out.println("Không thể thêm nhân viên!");
                        break;
                    }


                    System.out.println("Thêm Nhân viên thành công!");
                    break;
                case 2:
                    System.out.println("=== DELETE ===");
                    System.out.print("Enter Employee ID: ");
                    String removeID = scanner.nextLine();

                    List<Employee> employeeList = ems.getEmployees();
                    boolean found = false;


                    for (Employee employee1 : employeeList) {
                        if (employee1 instanceof Experience || employee1 instanceof Fresher || employee1 instanceof Intern) {
                            String employeeID = employee1.getID();
                            if (employeeID != null && employeeID.equals(removeID)) {
                                ems.removeEmployee(employee1);
                                found = true;
                                break;
                            }
                        }
                    }

                    if (found) {
                        System.out.println("Xóa Nhân viên thành công!");
                    } else {
                        System.out.println("Không hợp lệ!");
                    }
                    break;
                case 3:
                    System.out.println("=== Display All Employees ===");
                    List<Employee> allEmployees = ems.getEmployees();

                    if (allEmployees.isEmpty()) {
                        System.out.println("No employees found!");
                    } else {
                        for (Employee Employee : allEmployees) {
                            Employee.showInfo();
                            System.out.println("ID: " + Employee.getID());
                            System.out.println("Full Name: " + Employee.getFullName());
                            System.out.println("Birthday: " + Employee.getBirthDay());
                            System.out.println("Phone: " + Employee.getPhone());
                            System.out.println("Email: " + Employee.getEmail());


                        }
                    }
                    break;
                case 4:
                    System.out.println("Exiting...");
                    scanner.close();
                    System.exit(0);
                case 5:
                    System.out.println("=== Save Employees to File ===");
                    System.out.print("Enter the file name: ");
                    String fileName = scanner.nextLine();

                    try (PrintWriter writer = new PrintWriter(new FileWriter(fileName))) {
                        List<Employee> allEmployee = ems.getEmployees();
                        for (Employee employee2 : allEmployee) {
                            writer.println("ID: " + employee.getID());
                            writer.println("Full Name: " + employee.getFullName());
                            writer.println("Birthday: " + employee.getBirthDay());
                            writer.println("Phone: " + employee.getPhone());
                            writer.println("Email: " + employee.getEmail());
                            writer.println("type: " + employee.getType());

                            writer.println();
                        }

                        System.out.println("Employees saved to file successfully!");
                    } catch (IOException e) {
                        System.out.println("An error occurred while saving employees to file.");
                    }
                    break;

                 default:
                    System.out.println("Invalid choice. Please try again.");
            }

                 System.out.println();
            }
        }
    }


