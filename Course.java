package LAB.Sixth;

import java.util.ArrayList;

public class Course {

    private String courseId;
    private String courseTitle;
    private double credit;
    //private Student[] studentList;
    private ArrayList<Student> studentList;
    private int numberOfStudent;
    private Faculty faculty;


    public Course() {
        //this.faculty = null;
        this.studentList = new ArrayList<Student>();
    }

    public Course(String courseId, String courseTitle, double credit) {
        this.courseId = courseId;
        this.courseTitle = courseTitle;
        this.credit = credit;
        //this.faculty = null;
        this.studentList = new ArrayList<Student>();
    }

    public String getCourseId() {
        return courseId;
    }

    public void setCourseId(String courseId) {
        this.courseId = courseId;
    }

    public String getCourseTitle() {
        return courseTitle;
    }

    public void setCourseTitle(String courseTitle) {
        this.courseTitle = courseTitle;
    }

    public double getCredit() {
        return credit;
    }

    public void setCredit(double credit) {
        this.credit = credit;
    }

    public ArrayList<Student> getStudentList() {
        return studentList;
    }

    public void setStudentList(ArrayList<Student> studentList) {
        this.studentList = studentList;
    }

    public int getNumberOfStudent() {
        return numberOfStudent;
    }

//    public void setNumberOfStudent(int numberOfStudent) {
//        this.numberOfStudent = numberOfStudent;
//    }

    public Faculty getFaculty() {
        return faculty;
    }

    public void setFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    @Override
    public String toString() {
        return  "\n Course ID : " + courseId +
                " || Course Title : " + courseTitle +
                " || Credit : " + credit +
                " || Number Of Student : " + numberOfStudent +
                "\n Faculty Info : " + faculty + "\n";
    }


    public void addStudent(Student student) {
        this.studentList.add(student);
        this.numberOfStudent++;
    }

    public void dropStudent(int studentId) {

        for (Student student : studentList) {
            if (student.getStudentId()==studentId) {
                studentList.remove(student);
                this.numberOfStudent--;
            }

        }

    }

    public void addFaculty(Faculty faculty) {
        this.faculty = faculty;
    }

    public void dropFaculty() {
        this.faculty = null;

    }

    public String printStudentList() {
        String msg = "";
        for (Student s : studentList) {
           msg += "\n  [Student ID : " + s.getStudentId() +
                    "    ||     Student Name : " + s.getStudentName() +
                    "    ||     Student CGPA : " + s.getStudentCGPA() + "]";
        }
        return msg;
    }




}
