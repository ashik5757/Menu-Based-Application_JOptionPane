package LAB.Sixth;

public class Faculty {

    private int facultyId;
    private String facultyName;
    private String facultyPosition;

    public Faculty() {

    }

    public Faculty(int facultyId, String facultyName, String facultyPosition) {
        this.facultyId = facultyId;
        this.facultyName = facultyName;
        this.facultyPosition = facultyPosition;
    }

    public int getFacultyId() {
        return facultyId;
    }

    public void setFacultyId(int facultyId) {
        this.facultyId = facultyId;
    }

    public String getFacultyName() {
        return facultyName;
    }

    public void setFacultyName(String facultyName) {
        this.facultyName = facultyName;
    }

    public String getFacultyPosition() {
        return facultyPosition;
    }

    public void setFacultyPosition(String facultyPosition) {
        this.facultyPosition = facultyPosition;
    }

    @Override
    public String toString() {
        return  "\n [Faculty ID : " + facultyId +
                " || Faculty Name : " + facultyName +
                " || Faculty Position : " + facultyPosition + "]";
    }
}
