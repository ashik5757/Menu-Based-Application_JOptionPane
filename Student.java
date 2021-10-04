package LAB.Sixth;

public class Student {

    private int studentId;
    private String studentName;
    private double studentCGPA;

    public Student() {

    }

    public Student(int studentId, String studentName, double studentCGPA) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentCGPA = studentCGPA;
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public double getStudentCGPA() {
        return studentCGPA;
    }

    public void setStudentCGPA(double studentCGPA) {
        this.studentCGPA = studentCGPA;
    }

    @Override
    public String toString() {
        return  "\n  [Student ID : " + studentId +
                "    ||     Student Name : " + studentName +
                "    ||     Student CGPA : " + studentCGPA + "]";
    }
}
