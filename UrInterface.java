import java.util.Scanner;

public class UrInterface 
{
    private static Scanner sc = new Scanner(System.in);
    private static StudentManagementSystem studentManagementSystem = new StudentManagementSystem();

    public static void main(String[] args)
    {
        int choice;
        do 
        {
            System.out.println("\n--Student Management System--");
            System.out.println("1) Add a student");
            System.out.println("2) Remove a student");
            System.out.println("3) Search for a student");
            System.out.println("4) Display all students");
            System.out.println("5) Edit student information");
            System.out.println("6) Save student data to file");
            System.out.println("7) Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            switch (choice) 
            {
                case 1:
                    addStudent();
                    break;
                case 2:
                    removeStudent();
                    break;
                case 3:
                    searchStudent();
                    break;
                case 4:
                    displayAllStudents();
                    break;
                case 5:
                    editStudent();
                    break;
                case 6:
                    saveStudentDataToFile();
                    break;
                case 7:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 7);
    }

    private static void addStudent() 
    {
        System.out.print("Enter name: ");
        String name = sc.next();
        System.out.print("Enter roll number: ");
        int rollNumber = sc.nextInt();
        System.out.print("Enter grade: ");
        String grade = sc.next();

        if (name.isEmpty() || grade.isEmpty()) 
        {
            System.out.println("Name and grade cannot be empty. Please try again.");
            return;
        }
        Student student = new Student(name, rollNumber, grade);
        if (!student.isGradeValid(grade))
        {
            System.out.println("Invalid grade format. Grades should be in the format A, B+, C-, etc.");
            return;
        }
        studentManagementSystem.addStudent(student);
        System.out.println("Student added successfully.");
    }

    private static void removeStudent() 
    {
        System.out.print("Enter roll number of the student to remove: ");
        int rollNumber = sc.nextInt();
        studentManagementSystem.removeStudent(rollNumber);
        System.out.println("Student removed successfully.");
    }
    private static void searchStudent()
    {
        System.out.print("Enter roll number of the student to search: ");
        int rollNumber = sc.nextInt();
        Student student = studentManagementSystem.searchStudent(rollNumber);
        if (student != null) 
        {
            System.out.println("Student found: " + student);
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    private static void displayAllStudents() 
    {
        studentManagementSystem.displayAllStudents();
    }

    private static void editStudent()
    {
        System.out.print("Enter roll number of the student to edit: ");
        int rollNumber = sc.nextInt();
        Student student = studentManagementSystem.searchStudent(rollNumber);
        if (student != null) {
            System.out.println("Student found: " + student);
            System.out.println("Enter updated name: ");
            String name = sc.next();
            System.out.println("Enter updated grade: ");
            String grade = sc.next();

            if (name.isEmpty() || grade.isEmpty())
            {
                System.out.println("Name and grade cannot be empty.Student data not updated.");
                return;
            }

            if (!student.isGradeValid(grade)) 
            {
                System.out.println("Invalid grade format.Grades should be in the format A, B+, C-, etc.");
                return;
            }

            student.setName(name);
            student.setGrade(grade);
            System.out.println("Student data updated successfully.");
        } 
        else 
        {
            System.out.println("Student not found.");
        }
    }

    private static void saveStudentDataToFile() 
    {
        studentManagementSystem.saveStudentDataToFile();
    }
}