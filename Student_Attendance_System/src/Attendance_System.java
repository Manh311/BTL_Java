import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Attendance_System {

    // Phương thức đọc danh sách sinh viên từ file
    public static List<Student> ReadFileStudent(String filePath) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] Information = line.split(",");
                if (Information.length == 3) {
                    Student st = new Student(Information[0], Information[1], Information[2]);
                    studentList.add(st);
                }
            }
        } catch (IOException e) {
            System.out.println("Error reading file: " + e.getMessage());
        }
        return studentList;
    }

    // Phương thức ghi danh sách điểm danh vào file
    public static void CreatFileRollCall(List<Student> studentList, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Student st : studentList) {
                bw.write(st.toString() + "\n");
            }
        } catch (IOException e) {
            System.out.println("Error writing file: " + e.getMessage());
        }
    }
}