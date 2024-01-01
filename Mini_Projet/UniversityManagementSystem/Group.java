package UniversityManagementSystem;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

class Group {
    private String groupName;
    List<Student> students;

    public String getGroupName() {
        return this.groupName;
    }

    public Group(String groupName) {
        this.groupName = groupName;
        this.students = new ArrayList();
    }

    public void addStudent(Student student) {
        this.students.add(student);
    }

    public void displayStudents() {
        System.out.println(this.groupName + " students are: ");
        Iterator var2 = this.students.iterator();

        while(var2.hasNext()) {
            Person P = (Person)var2.next();
            System.out.println(P.getName());
        }

    }
}

