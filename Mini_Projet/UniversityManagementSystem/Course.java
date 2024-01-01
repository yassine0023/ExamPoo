package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Course {
    private String courseCode;
    List<Subject> subjects;
    private Teacher teacher;
    private Classroom classroom;
    private Group group;

    public Course(String courseCode) {
        this.courseCode = courseCode;
        this.subjects = new ArrayList();
    }

    public void addSubject(Subject subject) {
        this.subjects.add(subject);
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
    }

    public void setClassroom(Classroom classroom) {
        this.classroom = classroom;
    }

    public void setGroup(Group group) {
        this.group = group;
    }

    public void courseDetails() {
        System.out.println("Course code: " + this.courseCode);
        System.out.println("Subjects: ");
        Iterator var2 = this.subjects.iterator();

        while(var2.hasNext()) {
            Subject S = (Subject)var2.next();
            System.out.println(S.getSubjectName());
        }

        System.out.println("Teacher : " + this.teacher.getName());
        System.out.println("Classroom: " + this.classroom.roomNumber);
        System.out.println("Group: " + this.group.getGroupName());
    }

    public String getCode() {
        return this.courseCode;
    }

    public Teacher getTeacher() {
        return this.teacher;
    }

    public Classroom getClassroom() {
        return this.classroom;
    }

    public Group getGroup() {
        return this.group;
    }
}
