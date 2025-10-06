import java.util.Scanner;
import java.io.*;
public class Main{

private static StudentManagement manager = new StudentManagement();
private static Scanner input = new Scanner(System.in);


public static void main(String[] args) {

	/*System.out.println("Current working directory: " + System.getProperty("user.dir"));
    
    // Check if file exists
    File testFile = new File("data/students.txt");
    System.out.println("File exists: " + testFile.exists());
    System.out.println("Absolute path: " + testFile.getAbsolutePath());
	*/

    while (true) {

        showmenu();
        int choice = getIntInput("Choose one from the options available...");
		//showmenu();
		
		
        switch (choice) {
                case 1 -> addStudent();
                case 2 -> viewStudents();
                case 3 -> findStudent();
                case 4 -> deleteStudent();
                case 5 -> {
                    System.out.println("Goodbye!");
                    return;
                }
                default -> System.out.println("Invalid option!");
            }

        
    }
}



    private static void addStudent() {
        System.out.println("\n--- Add New Student ---");
        String id = getStringInput("Enter student ID: ");
        String name = getStringInput("Enter student name: ");
        String email = getStringInput("Enter student email: ");
        String course = getStringInput("Enter student course: ");

        if (manager.findStudent(id) != null) {
            System.out.println("Error: Student with ID " + id + " already exists!");
           return;
        }


        Student student = new Student(id, name, email, course);
        manager.addStudent(student);
        System.out.println("Student added successfully!");
    }
    
    private static void viewStudents() {
        System.out.println("\n All Students ");
        for (Student student : manager.getStudents()) {
            System.out.println("ID: " + student.getid() + 
                             ", Name: " + student.getName() +
                             ", Email: " + student.getEmail() +
                             ", Course: " + student.getCourse());
        }
    }



    private static void findStudent(){

        System.out.println("\n Find student ");
        String id = getStringInput("Enter student ID: ");
        //String name = getStringInput("Enter student name: ");
        //String email = getStringInput("Enter student email: ");
        //String course = getStringInput("Enter student course: ");
        Student student = manager.findStudent(id);


        if (student != null){
            System.out.println("ID: " + student.getid() + 
                             ", Name: " + student.getName() +
                             ", Email: " + student.getEmail() +
                             ", Course: " + student.getCourse());
        }
        else{
            System.out.println("Error, student with id" + id + "not found");
        }
    }


    private static void deleteStudent() {

        System.out.println("Delete student.");

        viewStudents();

        String id = getStringInput("Enter student ID to delete: ");

        Student student = manager.findStudent(id);

        if (student == null) {
            System.out.println("Student with ID '" + id + "' not found.");
            return;
        }
        System.out.println("\nStudent to be deleted:");
        System.out.println("ID: " + student.getid() + 
                             ", Name: " + student.getName() +
                             ", Email: " + student.getEmail() +
                             ", Course: " + student.getCourse());

        boolean success = manager.deleteStudent(id);
            if (success) {
                System.out.println("Student deleted successfully!");
            } else {
                System.out.println("Error: Failed to delete student.");
            }
        


    }



    private static void showmenu()  {

        //System.out.println("Welcome! Please select one of the functions below.");
        System.out.println("1. Add student");
        System.out.println("2. View students");
        System.out.println("3. Search student by id");
        System.out.println("4. Delete student");
        System.out.println("5. Exit program");
       
    }




    private static String getStringInput(String prompt) {
        System.out.print(prompt);
        return input.nextLine();
    }
    
    private static int getIntInput(String prompt) {
        System.out.print(prompt);
        try {
            return Integer.parseInt(input.nextLine());
        } catch (NumberFormatException e) {
            return -1;
        }
    }








}