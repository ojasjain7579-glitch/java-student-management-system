import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        ArrayList<Student> students = new ArrayList<>();
        Scanner sc = new Scanner(System.in);

        while (true) {

            System.out.println("\n===== Student Management System =====");
            System.out.println("1. Add Student");
            System.out.println("2. View Students");
            System.out.println("3. Search Student");
            System.out.println("4. Delete Student");
            System.out.println("5. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    System.out.print("Enter Student ID: ");
                    int id = sc.nextInt();
                    sc.nextLine();

                    System.out.print("Enter Student Name: ");
                    String name = sc.nextLine();

                    System.out.print("Enter Course: ");
                    String course = sc.nextLine();

                    students.add(new Student(id, name, course));

                    System.out.println("Student Added Successfully!");
                    break;
                    case 2:
                    if (students.isEmpty()) {
                        System.out.println("No students found.");
                    } else {
                        for (Student s : students) {
                            s.displayStudent();
                        }
                    }
                    break;

                case 3:
                    System.out.print("Enter Student ID to Search: ");
                    int searchId = sc.nextInt();

                    boolean found = false;

                    for (Student s : students) {
                        if (s.id == searchId) {
                            s.displayStudent();
                            found = true;
                        }
                    }
if (!found) {
                        System.out.println("Student not found.");
                    }
                    break;

                case 4:
                    System.out.print("Enter Student ID to Delete: ");
                    int deleteId = sc.nextInt();

                    boolean removed = students.removeIf(s -> s.id == deleteId);

                    if (removed) {
                        System.out.println("Student deleted successfully.");
                    } else {
                        System.out.println("Student not found.");
                    }
                    break;

                case 5:
                    System.out.println("Exiting Program...");
                    sc.close();
                    System.exit(0);
                    break;

                default:
                    System.out.println("Invalid Choice!");
            }
        }
    }
}
