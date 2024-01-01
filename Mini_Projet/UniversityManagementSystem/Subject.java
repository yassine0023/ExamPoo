package UniversityManagementSystem;

class Subject {
    private String subjectCode;
    private String subjectName;

    public Subject(String subjectCode, String subjectName) {
        this.subjectCode = subjectCode;
        this.subjectName = subjectName;
    }

    public String getSubjectCode() {
        return this.subjectCode;
    }

    public String getSubjectName() {
        return this.subjectName;
    }
}
