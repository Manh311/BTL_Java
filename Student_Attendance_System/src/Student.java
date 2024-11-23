public class Student {
    private String studentID;
    private String studentName;
    private String studentClass;
    private boolean attend;

    public Student(String studentID, String studentName, String studentClass) {
        this.studentID = studentID;
        this.studentName = studentName;
        this.studentClass = studentClass;
        this.attend = false;
    }

    public String getStudentID() {
        return studentID;
    }

    public String getStudentName() {
        return studentName;
    }

    public String getStudentClass() {
        return studentClass;
    }

    public boolean isAttend() {
        return attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    @Override
    public String toString() {
        return "ID: " + studentID + " | Name: " + studentName + " | Class: " + studentClass + " | Attended: " + (attend ? "Yes" : "No");
    }
}