package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.List;

class Teacher extends Person {
    private int teacherId;
    List<Subject> subjects;

    public Teacher(String name, int age, int teacherId) {
        super(name, age);
        this.teacherId = teacherId;
        this.subjects = new ArrayList();
    }

    public void assignSubject(Subject subject) {

        this.subjects.add(subject);
        System.out.println("Subject " + subject.getSubjectName() + " assigned to teacher " + this.getName());
    }

    public int getId() {
        return this.teacherId;
    }
}

