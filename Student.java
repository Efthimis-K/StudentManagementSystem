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