package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Student extends Person {
    private int studentId;
    List<Course> courses;

    public Student(String name, int age, int studentId) {
        super(name, age);
        this.studentId = studentId;
        this.courses = new ArrayList();
    }

    public void enrollCourse(Course course) {
        this.courses.add(course);
    }

    public void participateInEvent(Event E) {
        E.addParticipant(this);
    }

    public void joinClub(Club C) {
        C.addMember(this);
    }

    public void courseDisplay() {
        System.out.println("Student " + this.getName() + " enrolled in courses: ");
        Iterator var2 = this.courses.iterator();

        while(var2.hasNext()) {
            Course C = (Course)var2.next();
            System.out.println(C.getCode());
        }

    }

    public int getId() {
        return this.studentId;
    }
}

