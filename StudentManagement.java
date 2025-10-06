import java.io.*;
import java.util.*;

public class StudentManagement{


    private List<Student> students;
    public String datafile = "data\\students.txt";

    public StudentManagement(){
        students = new ArrayList<>();
        loadStudents();
    }


    public void addStudent(Student student){
	
		//String pad_id = pad_Id(student.getid());
		//student.set
	    students.add(student);
        saveStudents();
    }


    public List<Student> getStudents(){
        return new ArrayList<>(students);
    }

    public Student findStudent(String id){
        for (Student student : students){
            if (student.getid().equals(id)){
                return student;
            }


        }
        return null;
    }
    

    public boolean deleteStudent(String id){

        Student student = findStudent(id);
        if (student != null){
            students.remove(student);
            saveStudents();
            return true;
        }
        return false;

    }


    private void loadStudents(){

        try (BufferedReader br = new BufferedReader(new FileReader(datafile))){
            String line;
            while ((line = br.readLine()) != null) {
                //System.out.println(line);
                String[] data = line.split(",");
                if (data.length == 4){
                    students.add(new Student(data[0], data[1], data[2], data[3]));
                }
            }
        } catch (IOException e){
            System.out.println("Error retrieving file data...");
			e.printStackTrace();
        }
    }

    private void saveStudents(){
        try (PrintWriter output = new PrintWriter(new FileWriter(datafile))){
            for (Student student : students){
                output.println(student.toString());
            }
        } catch (IOException e){

            System.out.println("Error saving data: " + e.getMessage());

        }
    }


	private String pad_Id(String id) {
    // Remove any existing spaces or zeros from the beginning
		id = id.trim();
    
    // Pad with leading zeros to make it 3 digits
    if (id.length() < 3) {
        return String.format("%03d", Integer.parseInt(id));
    }
    return id;
}


}


	


/*
public class Student{

    private String name;
    private String email;
    private String course;
    private String id;


    public Student(String id, String name, String email, String course){

        this.id = id;
        this.name = name;
        this.email = email;
        this.course = course;
        }

    public String getid(){
        return id;
    }
    public String getName(){
        return name;
    }
    public String getEmail(){
        return email;
    }
    public String getCourse(){
        return course;
    }


    @Override
    public String toString(){
        return id + "," + name + "," + email + "," + course;
    }

}




import java.util.Scanner;

public class Main{

private static StudentManagement manager = new StudentManagement();
private static Scanner input = new Scanner(System.in);


public static void main(String[] args) {


    while (true) {

        //showmenu();
        int choice = getIntInput("Choose one from the options below..");
		showmenu();
		
		
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


*/