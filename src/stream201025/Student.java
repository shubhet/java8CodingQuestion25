package stream201025;


public class Student {

    private int studentId;
    private String studentName;
    private int grade;

    public Student(int studentId, String studentName, int grade) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.grade = grade;
    }
    public int getStudentId() {
        return studentId;
    }
    public String getStudentName() {
        return studentName;
    }
    public int getGrade() {
        return grade;
    }

    public String toString() {
        return "Student [studentId=" + studentId + ", studentName=" + studentName + ", grade=" + grade + "]";
    }
    public void setGrade(int grade) {
        this.grade = grade;
    }
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }
    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

}
