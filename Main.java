package LAB.Sixth;

import javax.swing.*;
import java.util.*;

public class Main {

    private static ArrayList<Student> allStudentList = new ArrayList<Student>();
    private static ArrayList<Faculty> allFacultyList = new ArrayList<Faculty>();
    private static ArrayList<Course> allCourseList = new ArrayList<Course>();


    public static void startMenu() {

        String title = "Menu-Based Application";

        String msg = "MENU :\n" +
                "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                  Select your Choice\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";


        String[] option = {"Add", "Delete", "Update", "Print", "Search", "EXIT"};
        int select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 7);


        if (select == 0)
            add();
        else if (select == 1)
            delete();
        else if (select == 2)
            update();
        else if (select == 3)
            print();
        else if (select == 4)
            search();
        else if (select == 5)
            System.exit(0);

        else
            JOptionPane.showMessageDialog(null, "Please select 'EXIT' button to exit", title, JOptionPane.ERROR_MESSAGE);

        startMenu();


    }

    public static Student createStudent() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        int studentId;
        String studentName;
        double studentCGPA;


        while (true) {

            String msgID = "Enter the Student's ID";

            String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

            if (idString == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            }

            if (idString != null && idString.isBlank()) {
                JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }

            try {

                if (idString != null) {
                    studentId = Integer.parseInt(idString);
                    break;
                }


            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input correct ID", title, JOptionPane.ERROR_MESSAGE);
            }

        }       // Student ID END


        while (true) {

            String msgName = "Enter the Student's Name";
            studentName = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

            if (studentName == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            } else
                break;


        }

        if (studentName.isBlank()) {
            JOptionPane.showOptionDialog(null, "Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
            startMenu();
        }
        // Student Name END


        while (true) {

            String msgCGPA = "Enter the Student's CGPA ";
            String CGPAString = JOptionPane.showInputDialog(null, msgCGPA, title, JOptionPane.QUESTION_MESSAGE);

            if (CGPAString == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            }

            if (CGPAString != null && CGPAString.isBlank()) {
                JOptionPane.showOptionDialog(null, "Credit iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }

            try {

                if (CGPAString != null && !(Double.parseDouble(CGPAString) > 0 && Double.parseDouble(CGPAString) <= 4)) {
                    JOptionPane.showMessageDialog(null, "Invalid CGPA", title, JOptionPane.ERROR_MESSAGE);
                    continue;
                }

                if (CGPAString != null) {
                    studentCGPA = Double.parseDouble(CGPAString);
                    break;
                }

            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input correct CGPA format", title, JOptionPane.ERROR_MESSAGE);
            }

        }             // Student CGPA END


        return new Student(studentId, studentName, studentCGPA);
    }
    // creating student END


    public static Faculty creatingFaculty() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        int facultyId;
        String facultyName;
        String facultyPosition;


        while (true) {

            String msgID = "Enter the Faculty's ID";

            String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

            if (idString == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            }

            if (idString != null && idString.isBlank()) {
                JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }

            try {
                if (idString != null) {
                    facultyId = Integer.parseInt(idString);
                    break;
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(null, "Please input correct ID", title, JOptionPane.ERROR_MESSAGE);
            }
        }               // Faculty ID END


        while (true) {

            String msgName = "Enter the Faculty's Name";
            facultyName = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

            if (facultyName == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            } else
                break;

        }

        if (facultyName.isBlank()) {
            JOptionPane.showOptionDialog(null, "Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
            startMenu();
        }
        // Faculty Name END


        while (true) {

            String msgName = "Enter the Faculty's Position";
            facultyPosition = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

            if (facultyPosition == null) {
                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();
            } else
                break;


        }

        if (facultyPosition.isBlank()) {
            JOptionPane.showOptionDialog(null, "Position Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
            startMenu();
        }
        // Faculty Position END


        return new Faculty(facultyId, facultyName, facultyPosition);
    }
    // Creating Faculty END


    public static void add() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        String msg = "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                         Add-Option\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";

        String[] option = {"Add a Student", "Add a Course", "Add a Faculty"};
        int select;

        while (true) {

            select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 7);


            if (select != -1)
                break;

            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
            if (exitCheck == 0)
                startMenu();

        }


        if (select == 0) {          // Add a Student

            allStudentList.add(createStudent());

            System.out.println(allStudentList.toString());


        }


        else if (select == 1) {         // Add a Course

            Course course = new Course();

            while (true) {

                String msgID = "Enter the Course ID";
                course.setCourseId(JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE));

                if (course.getCourseId() == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                } else
                    break;

            }

            if (course.getCourseId().isBlank()) {
                JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }
            // Course ID END


            while (true) {

                String msgName = "Enter the name of the course title";
                course.setCourseTitle(JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE));

                if (course.getCourseTitle() == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                } else
                    break;

            }

            if (course.getCourseTitle().isBlank()) {
                JOptionPane.showOptionDialog(null, "Course Title iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }
            // Course Title END


            while (true) {

                String msgCredit = "Enter the credit for " + course.getCourseId();

                String creditString = JOptionPane.showInputDialog(null, msgCredit, title, JOptionPane.QUESTION_MESSAGE);


                if (creditString == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                }

                if (creditString != null && creditString.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course Credit iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }


                try {

                    if (creditString != null && (Double.parseDouble(creditString) != 1 && Double.parseDouble(creditString) != 1.5 && Double.parseDouble(creditString) != 2 && Double.parseDouble(creditString) != 2.5 && Double.parseDouble(creditString) != 3 && Double.parseDouble(creditString) != 3.5 && Double.parseDouble(creditString) != 4 && Double.parseDouble(creditString) != 4.5 && Double.parseDouble(creditString) != 5 && Double.parseDouble(creditString) != 5.5 && Double.parseDouble(creditString) != 6 && Double.parseDouble(creditString) != 6.5 && Double.parseDouble(creditString) != 7 && Double.parseDouble(creditString) != 7.5 && Double.parseDouble(creditString) != 8)) {
                        JOptionPane.showMessageDialog(null, "Invalid Credit", title, JOptionPane.ERROR_MESSAGE);
                    }

                    if (creditString != null && (Double.parseDouble(creditString) == 1 || Double.parseDouble(creditString) == 1.5 || Double.parseDouble(creditString) == 2 || Double.parseDouble(creditString) == 2.5 || Double.parseDouble(creditString) == 3 || Double.parseDouble(creditString) == 3.5 || Double.parseDouble(creditString) == 4 || Double.parseDouble(creditString) == 4.5 || Double.parseDouble(creditString) == 5 || Double.parseDouble(creditString) == 5.5 || Double.parseDouble(creditString) == 6 || Double.parseDouble(creditString) == 6.5 || Double.parseDouble(creditString) == 7 || Double.parseDouble(creditString) == 7.5 || Double.parseDouble(creditString) == 8)) {
                        course.setCredit(Double.parseDouble(creditString));
                        break;
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input correct credit format", title, JOptionPane.ERROR_MESSAGE);
                }

            }
            // Course Credit END


            //course.addFaculty(creatingFaculty());
            int addCheckFt = JOptionPane.showOptionDialog(null, "Want to add a new Faculty..?", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, null, 0);
            if (addCheckFt == 0) {
                Faculty faculty = creatingFaculty();
                course.setFaculty(faculty);
                allFacultyList.add(faculty);
            }


            while (true) {

                if (course.getNumberOfStudent() < 40) {

                    int addCheckSt = JOptionPane.showOptionDialog(null, "Want to add a new student...?", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
                    if (addCheckSt == 0) {
                        Student student = createStudent();
                        course.addStudent(student);
                        allStudentList.add(student);
                    } else
                        break;

                } else {
                    JOptionPane.showOptionDialog(null, "Too Many Students", title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                    allCourseList.add(course);
                    startMenu();
                }

            }

            allCourseList.add(course);

            System.out.println(course.toString());


        } else if (select == 2) {         // Add a Faculty

            //Faculty faculty = creatingFaculty();
            allFacultyList.add(creatingFaculty());

        }


    }               // END of add


    public static void delete() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        String msg = "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                         Delete-Option\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";

        String[] option = {"Delete a Student", "Delete a Course", "Delete a Faculty"};
        int select;

        while (true) {

            select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 7);


            if (select != -1)
                break;

            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
            if (exitCheck == 0)
                startMenu();

        }


        if (select == 0) {


            // enter student id

            int studentId;

            while (true) {

                String msgID = "Enter the Student's ID";

                String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (idString == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                }

                if (idString != null && idString.isBlank()) {
                    JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }

                try {

                    if (idString != null) {
                        studentId = Integer.parseInt(idString);
                        break;
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                }

            }


            int exitSt = 0;
            for (Student student : allStudentList) {
                if (student.getStudentId()==studentId)
                    exitSt++;
            }
            if (exitSt==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }




            String msgSt = "What do you want to delete...?";
            String[] optionSt = {"Student Profile", "From a Course"};
            int selectOp;

            while (true) {

                selectOp = JOptionPane.showOptionDialog(null, msgSt, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionSt, 7);


                if (selectOp != -1)
                    break;

                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();

            }


            if (selectOp == 0) {                        // delete a student profile

                try {
                    for (Student student : allStudentList) {
                        if (student.getStudentId() == studentId) {
                            allStudentList.remove(student);
                            JOptionPane.showMessageDialog(null, "Student Profile deleted", title, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } catch (ConcurrentModificationException ignored) {

                }

                for (Course course : allCourseList) {

                    try {
                        course.dropStudent(studentId);
                    } catch (ConcurrentModificationException ignored) {

                    }

                }


            }


            else if (selectOp == 1) {                       // delete a student from a course

                String courseId;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseId == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseId.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }       // end search ID


                for (Course course : allCourseList) {

                    if (course.getCourseId().equals(courseId)) {

                        try {
                            course.dropStudent(studentId);
                        } catch (ConcurrentModificationException ignored) {

                        }


                    }

                }


            }


        }               // END of delete a student




        else if (select == 1) {                         // delete a course


            String courseId;
            while (true) {

                String msgID = "Enter the Course ID";
                courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (courseId == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                } else
                    break;

            }

            if (courseId.isBlank()) {
                JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }       // END search ID


            int exitCr = 0;
            for (Course course : allCourseList) {
                if (course.getCourseId().equals(courseId))
                    exitCr++;
            }
            if (exitCr==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }


            try {
                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        allCourseList.remove(course);
                        JOptionPane.showMessageDialog(null, "Course deleted", title, JOptionPane.INFORMATION_MESSAGE);
                    }

                }

            } catch (ConcurrentModificationException ignored) {

            }


        }                       // END of a deleted course






        else if (select == 2) {             // delete a faculty


            int facultyId;

            while (true) {

                String msgID = "Enter the Faculty's ID";

                String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (idString == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                }

                if (idString != null && idString.isBlank()) {
                    JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }

                try {

                    if (idString != null) {
                        facultyId = Integer.parseInt(idString);
                        break;
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                }

            }


            int exitFt = 0;
            for (Faculty faculty : allFacultyList) {
                if (faculty.getFacultyId()==facultyId)
                    exitFt++;
            }
            if (exitFt==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }



            String msgSt = "What do you want to delete...?";
            String[] optionSt = {"Faculty Profile", "From a Course"};
            int selectOp;

            while (true) {

                selectOp = JOptionPane.showOptionDialog(null, msgSt, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionSt, 7);


                if (selectOp != -1)
                    break;

                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();

            }


            if (selectOp == 0) {                        // delete a faculty profile

                try {
                    for (Faculty faculty : allFacultyList) {
                        if (faculty.getFacultyId() == facultyId) {
                            allFacultyList.remove(faculty);
                            JOptionPane.showMessageDialog(null, "Faculty Profile deleted", title, JOptionPane.INFORMATION_MESSAGE);
                        }
                    }

                } catch (ConcurrentModificationException ignored) {

                }

                for (Course course : allCourseList) {

                    try {
                        if (course.getFaculty().getFacultyId()==facultyId) {        // BUG HERE
                            course.dropFaculty();
                        }
                    } catch (NullPointerException ignored) {

                    }


                }


            }


            else if (selectOp == 1) {                       // delete a faculty from a course

                String courseId;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseId == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseId.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }       // end OF search course ID


                for (Course course : allCourseList) {

                    if (course.getCourseId().equals(courseId)) {
                        course.dropFaculty();
                    }
                }

            }




        }                                // END of deleted faculty


    }





    public static void update() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        String msg = "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                         Update-Option\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";

        String[] option = {"Update a Student", "Update a Course", "Update a Faculty"};
        int select;

        while (true) {

            select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 7);

            if (select != -1)
                break;

            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
            if (exitCheck == 0)
                startMenu();

        }


        if (select == 0) {                                  //update a student



            int studentId;

            while (true) {

                String msgID = "Enter the Student's ID";

                String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (idString == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                }

                if (idString != null && idString.isBlank()) {
                    JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }

                try {

                    if (idString != null) {
                        studentId = Integer.parseInt(idString);
                        break;
                    }


                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                }

            }           // END of Search Student ID

            int exitSt = 0;
            for (Student student : allStudentList) {
                if (student.getStudentId()==studentId)
                   exitSt++;
            }
            if (exitSt==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }



            String[] optionSt = {"Student ID", "Student Name", "CGPA"};
            int selectSt;

            while (true) {

                selectSt = JOptionPane.showOptionDialog(null, "What do you want to update...?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionSt, 7);

                if (selectSt != -1)
                    break;

                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();

            }

            if (selectSt == 0) {                            // Update ID


                int updateStudentId;

                while (true) {

                    String msgID = "Enter the updated Student's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            updateStudentId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }

                }


                for (Student student : allStudentList) {

                    if (student.getStudentId()==studentId) {
                        student.setStudentId(updateStudentId);
                        JOptionPane.showMessageDialog(null, "Student ID Updated", title, JOptionPane.INFORMATION_MESSAGE);

                    }
                }


            }           // END of update ID


            else if (selectSt == 1) {           // update name

                String updatedStudentName;

                while (true) {

                    String msgName = "Enter the Updated Student's Name";
                    updatedStudentName = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

                    if (updatedStudentName == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;


                }

                if (updatedStudentName.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }




                for (Student student : allStudentList) {

                    if (student.getStudentId()==studentId) {
                        student.setStudentName(updatedStudentName);
                        JOptionPane.showMessageDialog(null, "Student Name Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }



            }                           // END of update name



            else if (selectSt == 2) {                           // Update CGPA

                double updatedStudentCGPA;

                while (true) {

                    String msgCGPA = "Enter the Student's CGPA ";
                    String CGPAString = JOptionPane.showInputDialog(null, msgCGPA, title, JOptionPane.QUESTION_MESSAGE);

                    if (CGPAString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (CGPAString != null && CGPAString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Credit iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (CGPAString != null && !(Double.parseDouble(CGPAString) > 0 && Double.parseDouble(CGPAString) <= 4)) {
                            JOptionPane.showMessageDialog(null, "Invalid CGPA", title, JOptionPane.ERROR_MESSAGE);
                            continue;
                        }

                        if (CGPAString != null) {
                            updatedStudentCGPA = Double.parseDouble(CGPAString);
                            break;
                        }

                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct CGPA format", title, JOptionPane.ERROR_MESSAGE);
                    }

                }


                for (Student student : allStudentList) {

                    if (student.getStudentId()==studentId) {
                        student.setStudentCGPA(updatedStudentCGPA);
                        JOptionPane.showMessageDialog(null, "Student CGPA Updated", title, JOptionPane.INFORMATION_MESSAGE);

                    }
                }


            }                               // END of update CGPA



        }                       // END of update student





        else if (select == 1) {                                 // Update Course


            String courseId;
            while (true) {

                String msgID = "Enter the Course ID";
                courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (courseId == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                } else
                    break;

            }

            if (courseId.isBlank()) {
                JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }       // END search ID


            int exitCr = 0;
            for (Course course : allCourseList) {
                if (course.getCourseId().equals(courseId))
                    exitCr++;
            }
            if (exitCr==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }



            String[] optionCr = {"Course ID", "Course Title", "Credit","Student-List","Faculty"};
            int selectCr;

            while (true) {

                selectCr = JOptionPane.showOptionDialog(null, "What do you want to update...?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionCr, 7);

                if (selectCr != -1)
                    break;

                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();

            }





            if (selectCr == 0) {                    // Course ID update


                String updatedCourseId;
                while (true) {

                    String msgID = "Enter the Updated Course ID";
                    updatedCourseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (updatedCourseId == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (updatedCourseId.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }


                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        course.setCourseId(updatedCourseId);
                        JOptionPane.showMessageDialog(null, "Course ID Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }



            }                                   // END of Course ID update





            else if (selectCr == 1) {



                String updatedCourseTitle;
                while (true) {

                    String msgID = "Enter the Updated Course ID";
                    updatedCourseTitle = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (updatedCourseTitle == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (updatedCourseTitle.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }


                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        course.setCourseTitle(updatedCourseTitle);
                        JOptionPane.showMessageDialog(null, "Course Title Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }
            }


            else if (selectCr == 2) {


                String creditString;
                double updatedCredit;

                while (true) {

                    String msgCredit = "Enter the updated credit";

                   creditString = JOptionPane.showInputDialog(null, msgCredit, title, JOptionPane.QUESTION_MESSAGE);


                    if (creditString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (creditString != null && creditString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Course Credit iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }


                    try {

                        if (creditString != null && (Double.parseDouble(creditString) != 1 && Double.parseDouble(creditString) != 1.5 && Double.parseDouble(creditString) != 2 && Double.parseDouble(creditString) != 2.5 && Double.parseDouble(creditString) != 3 && Double.parseDouble(creditString) != 3.5 && Double.parseDouble(creditString) != 4 && Double.parseDouble(creditString) != 4.5 && Double.parseDouble(creditString) != 5 && Double.parseDouble(creditString) != 5.5 && Double.parseDouble(creditString) != 6 && Double.parseDouble(creditString) != 6.5 && Double.parseDouble(creditString) != 7 && Double.parseDouble(creditString) != 7.5 && Double.parseDouble(creditString) != 8)) {
                            JOptionPane.showMessageDialog(null, "Invalid Credit", title, JOptionPane.ERROR_MESSAGE);
                        }

                        if (creditString != null && (Double.parseDouble(creditString) == 1 || Double.parseDouble(creditString) == 1.5 || Double.parseDouble(creditString) == 2 || Double.parseDouble(creditString) == 2.5 || Double.parseDouble(creditString) == 3 || Double.parseDouble(creditString) == 3.5 || Double.parseDouble(creditString) == 4 || Double.parseDouble(creditString) == 4.5 || Double.parseDouble(creditString) == 5 || Double.parseDouble(creditString) == 5.5 || Double.parseDouble(creditString) == 6 || Double.parseDouble(creditString) == 6.5 || Double.parseDouble(creditString) == 7 || Double.parseDouble(creditString) == 7.5 || Double.parseDouble(creditString) == 8)) {
                            updatedCredit = Double.parseDouble(creditString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct credit format", title, JOptionPane.ERROR_MESSAGE);
                    }

                }



                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        course.setCredit(updatedCredit);
                        JOptionPane.showMessageDialog(null, "Course Credit Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }                           // END of update credit




            else if (selectCr == 3) {           //update student list of a course


                String[] optionStList = {"Update Student", "Add a NEW Student"};
                int selectStList;

                while (true) {

                    selectStList = JOptionPane.showOptionDialog(null, "What do you want to update...?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionStList, 7);

                    if (selectStList != -1)
                        break;

                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();

                }


                if (selectStList == 0) {            // ADD old student

                    boolean addOp;
                    boolean studentLimit = true;

                    while(true) {

                        int studentNumber = 0;
                        String[] tryAgain = {"Search Again"};
                        int studentId;



                        while (true) {

                            addOp = false;

                            String msgID = "Enter the Student's ID";

                            String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                            if (idString == null) {
                                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                                if (exitCheck == 0)
                                    startMenu();
                            }

                            if (idString != null && idString.isBlank()) {
                                JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                                startMenu();
                            }

                            try {

                                if (idString != null) {
                                    studentId = Integer.parseInt(idString);
                                    break;
                                }


                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                            }


                        }           // END of Search Student ID

                        for (Course course : allCourseList) {

                            if (course.getCourseId().equals(courseId)) {

                                studentNumber = course.getNumberOfStudent();
                                if (studentNumber == 40){
                                    studentLimit = false;
                                    JOptionPane.showOptionDialog(null, "Too Many Students", title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                                    startMenu();
                                    break;
                                }
                                int exitSt = 0;

                                for (Student student : course.getStudentList()) {
                                    if (student.getStudentId()==studentId) {
                                        exitSt = 1;
                                        break;
                                    }
                                }
                                if (exitSt == 1) {
                                    JOptionPane.showOptionDialog(null, "Student already enrolled", title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, tryAgain, 0);
                                    addOp = false;
                                    break;
                                }

                                for (Student student : allStudentList) {
                                    if (student.getStudentId() == studentId) {
                                        course.addStudent(student);
                                        exitSt = 2;
                                        addOp = true;
                                        break;
                                    }
                                }

                                if (exitSt == 2 )
                                    break;

                                if (exitSt == 0) {
                                    JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                                    addOp = false;
                                    break;
                                }



                            }
                        }


                        if (studentLimit && addOp) {

                            int addCheckSt = JOptionPane.showOptionDialog(null, "\nStudent added Successfully \n\n Want to add another student...?\n\n", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, null, 0);
                            if (addCheckSt != 0) {
                                break;
                            }
                        }




                    }





                }           // END of add old student




                else if (selectStList == 1) {           // add new student


                    for (Course course : allCourseList) {
                        if (course.getCourseId().equals(courseId)) {

                            while (true) {

                                if (course.getNumberOfStudent() < 40) {

                                    int addCheckSt = JOptionPane.showOptionDialog(null, "Want to add a new student...?", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.QUESTION_MESSAGE, null, null, 0);
                                    if (addCheckSt == 0) {
                                        Student student = createStudent();
                                        course.addStudent(student);
                                        allStudentList.add(student);
                                    } else
                                        break;

                                } else {
                                    JOptionPane.showOptionDialog(null, "Student Limit has been reached", title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                                    startMenu();
                                }

                            }

                        }
                    }



                }




            }                   //END of update student list of a course







            else if (selectCr == 4) {           // Update faculty of a course



                String[] optionFtList = {"Update Faculty", "Add a NEW Faculty"};
                int selectFtList;

                while (true) {

                    selectFtList = JOptionPane.showOptionDialog(null, "What do you want to update...?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionFtList, 7);

                    if (selectFtList != -1)
                        break;

                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();

                }


                if (selectFtList == 0) {            // add old faculty


                    boolean addOp;

                    while(true) {

                        String[] tryAgain = {"Search Again"};
                        int facultyId;



                        while (true) {

                            addOp = false;

                            String msgID = "Enter the Faculty's ID";

                            String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                            if (idString == null) {
                                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                                if (exitCheck == 0)
                                    startMenu();
                            }

                            if (idString != null && idString.isBlank()) {
                                JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                                startMenu();
                            }

                            try {

                                if (idString != null) {
                                    facultyId = Integer.parseInt(idString);
                                    break;
                                }


                            } catch (NumberFormatException e) {
                                JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                            }


                        }           // END of Search Faculty ID

                        for (Course course : allCourseList) {

                            if (course.getCourseId().equals(courseId)) {

                                int exitFt = 0;

                                try {
                                    if (course.getFaculty().getFacultyId()==facultyId) {
                                        JOptionPane.showOptionDialog(null, "Faculty have already enrolled", title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, tryAgain, 0);
                                        addOp = false;
                                        break;
                                    }
                                }
                                catch (NullPointerException ignored) {
                                   //JOptionPane.showOptionDialog(null, "Course doesn't have any faculty \n\nPlease add a faculty first.", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                                 // startMenu();
                                    //break;
                                }



                                for (Faculty faculty : allFacultyList) {
                                    if (faculty.getFacultyId()==facultyId) {
                                        course.addFaculty(faculty);
                                        exitFt = 2;
                                        addOp = true;
                                        break;
                                    }
                                }

                                if (exitFt == 2 )
                                    break;

                                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                                addOp = false;
                                break;


                            }
                        }


                        if (addOp) {

                            JOptionPane.showOptionDialog(null, "\nFaculty added Successfully ", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;

                        }

                    }


                }               //END of add old faculty




                else if (selectFtList == 1) {           // add new faculty

                    for (Course course : allCourseList) {
                        if (course.getCourseId().equals(courseId)) {

                            Faculty faculty = creatingFaculty();
                            course.setFaculty(faculty);
                            allFacultyList.add(faculty);

                            JOptionPane.showOptionDialog(null, "\nFaculty added Successfully ", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();

                        }
                    }



                }       // END of add new faculty



            }                 // END of Update faculty of a course




        }                                                   // END of Update Course






        else if (select == 2) {                             // Update Faculty


            int facultyId;
            while (true) {

                String msgID = "Enter the Faculty's ID";

                String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                if (idString == null) {
                    int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                    if (exitCheck == 0)
                        startMenu();
                }

                if (idString != null && idString.isBlank()) {
                    JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }

                try {
                    if (idString != null) {
                        facultyId = Integer.parseInt(idString);
                        break;
                    }
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null, "Please input correct ID", title, JOptionPane.ERROR_MESSAGE);
                }
            }



            int exitFt = 0;
            for (Faculty faculty : allFacultyList) {
                if (faculty.getFacultyId()==facultyId)
                    exitFt++;
            }
            if (exitFt==0) {
                JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                startMenu();
            }



            String[] optionFt = {"Faculty ID", "Faculty Name", "Position"};
            int selectFt;

            while (true) {

                selectFt = JOptionPane.showOptionDialog(null, "What do you want to update...?", title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, optionFt, 7);

                if (selectFt != -1)
                    break;

                int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                if (exitCheck == 0)
                    startMenu();

            }



            if (selectFt == 0) {

                int updatedFacultyId;

                while (true) {

                    String msgID = "Enter the Updated Faculty's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {
                        if (idString != null) {
                            updatedFacultyId = Integer.parseInt(idString);
                            break;
                        }
                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID", title, JOptionPane.ERROR_MESSAGE);
                    }
                }



                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId) {
                        faculty.setFacultyId(updatedFacultyId);
                        JOptionPane.showMessageDialog(null, "Faculty ID Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }                                       // END of update ID



            else if (selectFt == 1) {               //Update name

                String updatedFacultyName;

                while (true) {

                    String msgName = "Enter the Updated Faculty's Name";
                    updatedFacultyName = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

                    if (updatedFacultyName == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (updatedFacultyName.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }



                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId) {
                        faculty.setFacultyName(updatedFacultyName);
                        JOptionPane.showMessageDialog(null, "Faculty Name Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }                        // END of update Name



            else if (selectFt == 2) {       //Update Position


                String updatedFacultyPosition;

                while (true) {

                    String msgName = "Enter the Updated Faculty's Position";
                    updatedFacultyPosition = JOptionPane.showInputDialog(null, msgName, title, JOptionPane.QUESTION_MESSAGE);

                    if (updatedFacultyPosition == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;


                }

                if (updatedFacultyPosition.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Position Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }


                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId) {
                        faculty.setFacultyPosition(updatedFacultyPosition);
                        JOptionPane.showMessageDialog(null, "Faculty Position Updated", title, JOptionPane.INFORMATION_MESSAGE);
                    }
                }

            }                // END of update Position



        }                                        // END of Update Faculty


    }

    public static void print() {

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        String msg = "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                         Print-Option\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "\n 1. Print all students" +
                "\n 2. Print all course" +
                "\n 3. Print all faculties" +
                "\n 4. Print information of a student" +
                "\n 5. Print information of a course" +
                "\n 6. Print information of a faculty" +
                "\n 7. Print student list and faculty information of a course" +
                "\n 8. Print courses taken by a student" +
                "\n\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";

        String[] option = {"   1   ", "2", "3", "4", "5", "6", "7", "8"};
        int select;

        while (true) {

            select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 11);

            if (select != -1)
                break;

            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
            if (exitCheck == 0)
                startMenu();

        }


        if (select == 0) {

            String msgAllStudentList = "\n" +
                    "----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Student-List\n" +
                    "----------------------------------------------------------------------------------------------------------------------\n";

            for (Student s : allStudentList) {
                msgAllStudentList += s.toString();
                System.out.println(s.toString());
            }

            JOptionPane.showOptionDialog(null, msgAllStudentList, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);


        }

        else if (select == 1) {

            String msgAllCourseList = "\n" +
                    "------------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Course-List\n" +
                    "------------------------------------------------------------------------------------------------------------------------\n";

            for (Course c : allCourseList) {
                msgAllCourseList += c.toString();
                System.out.println(c.toString());
            }

            JOptionPane.showOptionDialog(null, msgAllCourseList, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);


        }

        else if (select == 2) {

            String msgAllFacultyList = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Faculty-List\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            for (Faculty f : allFacultyList) {
                msgAllFacultyList += f.toString();
                System.out.println(f.toString());
            }

            JOptionPane.showOptionDialog(null, msgAllFacultyList, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);


        }

        else if (select == 3) {

            String msgStudentInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Student Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] tryAgain = {"Search Again"};

            while (true) {

                int studentId;

                while (true) {

                    String msgID = "Enter the Student's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            studentId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID

                for (Student student : allStudentList) {
                    if (student.getStudentId()==studentId) {
                        msgStudentInfo +=   " Student ID :" + student.getStudentId() +
                                "\n Student Name : " + student.getStudentName() +
                                "\n Student CGPA : " + student.getStudentCGPA();

                        JOptionPane.showOptionDialog(null, msgStudentInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                        startMenu();
                        break;
                    }
                }


                int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                if (selectEXit!=0)
                    break;


            }


        }           //END of a student info


        else if (select == 4) {

            String msgCourseInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Course Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] tryAgain = {"Search Again"};

            while (true) {
                String courseId;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseId == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseId.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }       // END search ID


                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        msgCourseInfo +=    "\n Course ID : " + course.getCourseId() +
                                            "\n Course Title : " + course.getCourseTitle() +
                                            "\n Credit : " + course.getCredit() +
                                            "\n Number Of Student : " + course.getNumberOfStudent() +
                                            "\n Faculty Info : " + course.getFaculty() ;

                        JOptionPane.showOptionDialog(null, msgCourseInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                        startMenu();
                        break;
                    }
                }


                int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                if (selectEXit != 0)
                    break;



            }




        }           //END of a course info




        else if (select == 5) {

            String msgFacultyInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Faculty Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] tryAgain = {"Search Again"};

            while (true) {

                int facultyId;

                while (true) {

                    String msgID = "Enter the Faculty's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            facultyId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Faculty ID

                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId) {
                        msgFacultyInfo +=   " Faculty ID :" + faculty.getFacultyId() +
                                "\n Faculty Name : " + faculty.getFacultyName() +
                                "\n Faculty Position : " + faculty.getFacultyPosition();

                        JOptionPane.showOptionDialog(null, msgFacultyInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                        startMenu();
                        break;
                    }
                }


                int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                if (selectEXit!=0)
                    break;


            }


        }           //END of a faculty info



        else if (select == 6) {

            String msgCourseInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                  Student-List and Faculty Information of the Course\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] tryAgain = {"Search Again"};

            while (true) {
                String courseId;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseId = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseId == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseId.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }       // END search ID


                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseId)) {
                        msgCourseInfo +=  "\n Faculty Info : " + course.getFaculty() +
                                "\n\n Student List : " + course.printStudentList();


                        JOptionPane.showOptionDialog(null, msgCourseInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                        startMenu();
                        break;
                    }
                }


                int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                if (selectEXit != 0)
                    break;



            }




        }           //END of a course info of student list and faculty


        else if (select == 7) {

            String msgStudentCourseInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                       Information about courses taken by the student\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] tryAgain = {"Search Again"};

            while (true) {

                int studentId;

                while (true) {

                    String msgID = "Enter the Student's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            studentId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID

                int exitSt = 0;
                for (Student student : allStudentList) {
                    if (student.getStudentId()==studentId)
                        exitSt++;
                }
                if (exitSt==0) {
                    JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                for (Course course : allCourseList) {
                    for (Student student : course.getStudentList()) {
                        if (student.getStudentId()==studentId) {
                            msgStudentCourseInfo += course.toString();
                        }
                    }
                }
                JOptionPane.showOptionDialog(null, msgStudentCourseInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                break;


            }


        }           //END of a student info





    }               // END of print Option





    public static void search() {                                       // Search Option

        String title = "Menu-Based Application";
        String[] returnOption = {"Return Home", "Cancel"};
        String[] returnOption2 = {"Return Home"};

        String msg = "\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "                                                         Search-Option\n" +
                "---------------------------------------------------------------------------------------------------------------\n" +
                "\n 1. Search a Student" +
                "\n 2. Search a Course" +
                "\n 3. Search a Faculty" +
                "\n 4. Search whether a student takes a course" +
                "\n 5. Search whether a faculty teaches a course" +
                "\n 6. Search courses taken by a student" +
                "\n 7. Search courses taught by a faculty" +
                "\n\n" +
                "---------------------------------------------------------------------------------------------------------------\n\n";

        String[] option = {"   1   ", "2", "3", "4", "5", "6", "7"};
        int select;

        while (true) {

            select = JOptionPane.showOptionDialog(null, msg, title, JOptionPane.DEFAULT_OPTION, JOptionPane.QUESTION_MESSAGE, null, option, 11);

            if (select != -1)
                break;

            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
            if (exitCheck == 0)
                startMenu();

        }

        if (select == 0) {

            String msgStudentInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Student Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] searchOp = {"Search ID", "Search Name"};
            String msgSearchSt = "What do you want to search?";

            int selectSearch = JOptionPane.showOptionDialog(null,msgSearchSt,title,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,searchOp,1);

            if (selectSearch == 0) {

                String[] tryAgain = {"Search Again"};

                while (true) {

                    int studentId;

                    while (true) {

                        String msgID = "Enter the Student's ID";

                        String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (idString == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        }

                        if (idString != null && idString.isBlank()) {
                            JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                            startMenu();
                        }

                        try {

                            if (idString != null) {
                                studentId = Integer.parseInt(idString);
                                break;
                            }


                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                        }


                    }           // END of Search Student ID

                    for (Student student : allStudentList) {
                        if (student.getStudentId()==studentId) {
                            msgStudentInfo +=   " Student ID :" + student.getStudentId() +
                                    "\n Student Name : " + student.getStudentName() +
                                    "\n Student CGPA : " + student.getStudentCGPA();

                            JOptionPane.showOptionDialog(null, msgStudentInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit!=0)
                        break;


                }

            }           //END of search by ID


            else if (selectSearch == 1) {

                String[] tryAgain = {"Search Again"};

                while (true) {
                    String studentName;
                    while (true) {

                        String msgID = "Enter the Student Name";
                        studentName = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (studentName == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        } else
                            break;

                    }

                    if (studentName.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }       // END search Name


                    for (Student student : allStudentList) {
                        if (student.getStudentName().equals(studentName)) {
                            msgStudentInfo +=   " Student ID :" + student.getStudentId() +
                                    "\n Student Name : " + student.getStudentName() +
                                    "\n Student CGPA : " + student.getStudentCGPA();

                            JOptionPane.showOptionDialog(null, msgStudentInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "Student Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit != 0)
                        break;



                }


            }           // END of search by Name



        }           //END of a student info




        else if (select == 1) {         // Search Course Info


            String msgCourseInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Course Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] searchOp = {"Search ID", "Search Name"};
            String msgSearchCr = "What do you want to search?";

            int selectSearch = JOptionPane.showOptionDialog(null,msgSearchCr,title,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,searchOp,1);

            if (selectSearch == 0) {

                String[] tryAgain = {"Search Again"};

                while (true) {

                    String courseID;
                    while (true) {

                        String msgID = "Enter the Course ID";
                        courseID = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (courseID == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        } else
                            break;

                    }

                    if (courseID.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }       // END search ID

                    for (Course course : allCourseList) {
                        if (course.getCourseId().equals(courseID)) {
                            msgCourseInfo +=    "\n Course ID : " + course.getCourseId() +
                                    "\n Course Title : " + course.getCourseTitle() +
                                    "\n Credit : " + course.getCredit() +
                                    "\n Number Of Student : " + course.getNumberOfStudent() +
                                    "\n Faculty Info : " + course.getFaculty() ;

                            JOptionPane.showOptionDialog(null, msgCourseInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "Course ID Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit!=0)
                        break;


                }

            }           //END of search by ID


            else if (selectSearch == 1) {

                String[] tryAgain = {"Search Again"};

                while (true) {

                    String courseTitle;
                    while (true) {

                        String msgID = "Enter the Course Title";
                        courseTitle = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (courseTitle == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        } else
                            break;

                    }

                    if (courseTitle.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Course Title iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }       // END search ID

                    for (Course course : allCourseList) {
                        if (course.getCourseTitle().equals(courseTitle)) {
                            msgCourseInfo +=    "\n Course ID : " + course.getCourseId() +
                                    "\n Course Title : " + course.getCourseTitle() +
                                    "\n Credit : " + course.getCredit() +
                                    "\n Number Of Student : " + course.getNumberOfStudent() +
                                    "\n Faculty Info : " + course.getFaculty() ;

                            JOptionPane.showOptionDialog(null, msgCourseInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "Course Title Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit!=0)
                        break;


                }



            }           // END of search by Title





        }           // END of Search Course Info






        else if (select == 2) {         // Search Faculty Info


            String msgFacultyInfo = "\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n" +
                    "                                                           Faculty Information\n" +
                    "-----------------------------------------------------------------------------------------------------------------------\n";

            String[] searchOp = {"Search ID", "Search Name"};
            String msgSearchSt = "What do you want to search?";

            int selectSearch = JOptionPane.showOptionDialog(null,msgSearchSt,title,JOptionPane.DEFAULT_OPTION,JOptionPane.QUESTION_MESSAGE,null,searchOp,1);

            if (selectSearch == 0) {

                String[] tryAgain = {"Search Again"};

                while (true) {

                    int facultyId;

                    while (true) {

                        String msgID = "Enter the Faculty's ID";

                        String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (idString == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        }

                        if (idString != null && idString.isBlank()) {
                            JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                            startMenu();
                        }

                        try {

                            if (idString != null) {
                                facultyId = Integer.parseInt(idString);
                                break;
                            }


                        } catch (NumberFormatException e) {
                            JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                        }


                    }           // END of Search Faculty ID

                    for (Faculty faculty : allFacultyList) {
                        if (faculty.getFacultyId()==facultyId) {
                            msgFacultyInfo +=   " Faculty ID :" + faculty.getFacultyId() +
                                    "\n Faculty Name : " + faculty.getFacultyName() +
                                    "\n Faculty Position : " + faculty.getFacultyPosition();

                            JOptionPane.showOptionDialog(null, msgFacultyInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit!=0)
                        break;


                }

            }           //END of search by ID


            else if (selectSearch == 1) {

                String[] tryAgain = {"Search Again"};

                while (true) {
                    String facultyName;
                    while (true) {

                        String msgID = "Enter the Faculty Name";
                        facultyName = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                        if (facultyName == null) {
                            int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                            if (exitCheck == 0)
                                startMenu();
                        } else
                            break;

                    }

                    if (facultyName.isBlank()) {
                        JOptionPane.showOptionDialog(null, "Faculty Name iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }       // END search Name


                    for (Faculty faculty : allFacultyList) {
                        if (faculty.getFacultyName().equals(facultyName)) {
                            msgFacultyInfo +=   " Faculty ID :" + faculty.getFacultyId() +
                                    "\n Faculty Name : " + faculty.getFacultyName() +
                                    "\n Faculty Position : " + faculty.getFacultyPosition();

                            JOptionPane.showOptionDialog(null, msgFacultyInfo, title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                            startMenu();
                            break;
                        }
                    }


                    int selectEXit = JOptionPane.showOptionDialog(null, "Faculty Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (selectEXit != 0)
                        break;



                }


            }           // END of search by Name




        }           // END of Search Faculty Info







        else if (select == 3) {         // Search whether a student takes a course


            String[] tryAgain = {"Search Again"};

            while (true) {

                // Search Course ID
                String courseID;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseID = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseID == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseID.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }           // END of search Course ID


                int exitSt = 0;
                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID))
                        exitSt++;
                }
                if (exitSt==0) {
                    JOptionPane.showOptionDialog(null, "Course ID Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                int studentId;

                while (true) {

                    String msgID = "Enter the Student's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            studentId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID



                boolean courseTakenFound = false;


                int exitSt2 = 0;
                for (Student student : allStudentList) {
                    if (student.getStudentId()==studentId)
                        exitSt2++;
                }
                if (exitSt2==0) {
                    JOptionPane.showOptionDialog(null, "Student ID Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID)) {
                        for (Student student : course.getStudentList()) {
                            if (student.getStudentId()==studentId) {
                                JOptionPane.showOptionDialog(null, "Student took the Course : " + course.getCourseId(), title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                                courseTakenFound = true;
                                startMenu();
                                break;
                            }
                        }
                    }
                }


                if (!courseTakenFound) {
                    JOptionPane.showOptionDialog(null, "Student haven't took the Course : " + courseID, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                    break;
                }


            }



        }           //END of Search whether a student takes a course




        else if (select == 4) {         // Search whether a faculty teaches a course

            String[] tryAgain = {"Search Again"};

            while (true) {

                // Search Course ID
                String courseID;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseID = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseID == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseID.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }           // END of search Course ID



                int exitFt = 0;
                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID))
                        exitFt++;
                }
                if (exitFt==0) {
                    JOptionPane.showOptionDialog(null, "Course ID Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                int facultyId;

                while (true) {

                    String msgID = "Enter the Faculty's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            facultyId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID


                int exitFt2 = 0;
                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId)
                        exitFt2++;
                }
                if (exitFt2==0) {
                    JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                boolean facultyFound = false;

                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID)) {


                        try {
                            if (course.getFaculty().getFacultyId() == facultyId) {
                                JOptionPane.showOptionDialog(null, "Course taught by the faculty", title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                                facultyFound = true;
                                startMenu();
                                break;
                            }
                        } catch (NullPointerException e) {
                            facultyFound = false;
                        }


                    }
                }


                if (!facultyFound) {
                    JOptionPane.showOptionDialog(null, "Faculty haven't taught the Course : " + courseID, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                    break;
                }


            }




        }               // END of Search whether a faculty teaches a course


        else if (select == 5) {         // Search courses taken by a student



            String[] tryAgain = {"Search Again"};

            while (true) {

                int studentId;

                while (true) {

                    String msgID = "Enter the Student's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            studentId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID

                int exitSt = 0;
                for (Student student : allStudentList) {
                    if (student.getStudentId()==studentId)
                        exitSt++;
                }
                if (exitSt==0) {
                    JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                // Search Course ID
                String courseID;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseID = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseID == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseID.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }           // END of search Course ID


                boolean studentFound = false;
                boolean courseFound = false;

                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID)) {
                        courseFound = true;
                        for (Student student : course.getStudentList()) {
                            if (student.getStudentId()==studentId) {
                                JOptionPane.showOptionDialog(null, "Course taken by the Student", title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                                studentFound = true;
                                startMenu();
                                break;
                            }
                        }
                    }
                }

                if (!courseFound) {
                    int exitSelect = JOptionPane.showOptionDialog(null, "Course ID not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (exitSelect==-1)
                        startMenu();
                }


                else if (!studentFound) {
                    JOptionPane.showOptionDialog(null, "Student haven't took the Course : " + courseID, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                    break;
                }


            }



        }           //END of Search courses taken by a student


        else if (select == 6) {         // Search courses taught by a faculty



            String[] tryAgain = {"Search Again"};

            while (true) {

                int facultyId;

                while (true) {

                    String msgID = "Enter the Faculty's ID";

                    String idString = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (idString == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    }

                    if (idString != null && idString.isBlank()) {
                        JOptionPane.showOptionDialog(null, "ID number iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                        startMenu();
                    }

                    try {

                        if (idString != null) {
                            facultyId = Integer.parseInt(idString);
                            break;
                        }


                    } catch (NumberFormatException e) {
                        JOptionPane.showMessageDialog(null, "Please input correct ID format", title, JOptionPane.ERROR_MESSAGE);
                    }


                }           // END of Search Student ID

                int exitSt = 0;
                for (Faculty faculty : allFacultyList) {
                    if (faculty.getFacultyId()==facultyId)
                        exitSt++;
                }
                if (exitSt==0) {
                    JOptionPane.showOptionDialog(null, "ID number Not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    continue;
                }



                // Search Course ID
                String courseID;
                while (true) {

                    String msgID = "Enter the Course ID";
                    courseID = JOptionPane.showInputDialog(null, msgID, title, JOptionPane.QUESTION_MESSAGE);

                    if (courseID == null) {
                        int exitCheck = JOptionPane.showOptionDialog(null, "Are you sure ???", title, JOptionPane.OK_CANCEL_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption, 0);
                        if (exitCheck == 0)
                            startMenu();
                    } else
                        break;

                }

                if (courseID.isBlank()) {
                    JOptionPane.showOptionDialog(null, "Course ID iS  b l A n K", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, returnOption2, 0);
                    startMenu();
                }           // END of search Course ID


                boolean facultyFound = false;
                boolean courseFound = false;

                for (Course course : allCourseList) {
                    if (course.getCourseId().equals(courseID)) {
                        courseFound = true;

                        try {
                            if (course.getFaculty().getFacultyId() == facultyId) {
                                JOptionPane.showOptionDialog(null, "Course taught by the faculty", title, JOptionPane.DEFAULT_OPTION, JOptionPane.INFORMATION_MESSAGE, null, returnOption2, 0);
                                facultyFound = true;
                                startMenu();
                                break;
                            }
                        } catch (NullPointerException e) {
                            facultyFound = false;
                        }


                    }
                }

                if (!courseFound) {
                    int exitSelect = JOptionPane.showOptionDialog(null, "Course ID not Found", title, JOptionPane.DEFAULT_OPTION, JOptionPane.ERROR_MESSAGE, null, tryAgain, 0);
                    if (exitSelect==-1)
                        startMenu();
                }


                else if (!facultyFound) {
                    JOptionPane.showOptionDialog(null, "Faculty haven't taught the Course : " + courseID, title, JOptionPane.DEFAULT_OPTION, JOptionPane.WARNING_MESSAGE, null, returnOption2, 0);
                    break;
                }


            }



        }           //END of Search courses taught by a faculty


    }                                   // END of search Option





    public static void main(String[] args) {


        startMenu();


    }
}
