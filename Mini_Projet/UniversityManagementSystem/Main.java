package UniversityManagementSystem;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Main {
    public Main() {
    }

    public static void main(String[] args) {
        System.out.println("--------------------University Management System-------------------");
        Subject java = new Subject("JAVA1", "Java");
        Subject python = new Subject("PYTHON2", "Python");
        Teacher javaTeacher = new Teacher("Issam Allani", 28, 1);
        javaTeacher.assignSubject(java);
        System.out.println("------------------------------------------");
        Teacher pythonTeacher = new Teacher("Ghada Guesmi", 40, 2);
        pythonTeacher.assignSubject(python);
        System.out.println("------------------------------------------");
        Student student1 = new Student("Yassine Youssfi", 20, 1001);
        Student student2 = new Student("Rami Gharbi", 20, 1002);
        Course javaCourse = new Course("JAVA1");
        javaCourse.addSubject(java);
        javaCourse.setTeacher(javaTeacher);
        Course pythonCourse = new Course("PYTHON2");
        pythonCourse.addSubject(python);
        pythonCourse.setTeacher(pythonTeacher);
        student1.enrollCourse(javaCourse);
        student1.enrollCourse(pythonCourse);
        student2.enrollCourse(javaCourse);
        student1.courseDisplay();
        System.out.println("------------------------------------------");
        student2.courseDisplay();
        System.out.println("------------------------------------------");
        Club JavaClub = new Club("ACM");
        JavaClub.addMember(student1);
        JavaClub.addMember(javaTeacher);
        Club PythonClub = new Club("IEEE SC CHAPTER");
        PythonClub.addMember(student2);
        PythonClub.addMember(pythonTeacher);
        Group javaGroup = new Group("Java Class");
        javaGroup.addStudent(student1);
        Group pythonGroup = new Group("Python Class");
        pythonGroup.addStudent(student2);
        javaGroup.displayStudents();
        System.out.println("------------------------------------------");
        pythonGroup.displayStudents();
        System.out.println("------------------------------------------");
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");

        try {
            Date eventDate = dateFormat.parse("2022-12-06");
            Event javaEvent = new Event("Code Quest", eventDate, 20.0, JavaClub);
            javaEvent.addParticipant(student1);
            javaEvent.addParticipant(student2);
            javaEvent.displayParticipants();
        } catch (ParseException var17) {
            var17.printStackTrace();
        }

    }
}

