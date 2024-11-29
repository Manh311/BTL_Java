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
        return this.studentID;
    }

    public String getStudentName() {
        return this.studentName;
    }

    public String getStudentClass() {
        return this.studentClass;
    }

    public boolean isAttend() {
        return this.attend;
    }

    public void setAttend(boolean attend) {
        this.attend = attend;
    }

    public String toString() {
        return  "ID: " + this.studentID +
                " | Name: " + this.studentName +
                " | Class: " + this.studentClass +
                " | Attended: " + (this.attend ? "Yes" : "No");
    }
}
