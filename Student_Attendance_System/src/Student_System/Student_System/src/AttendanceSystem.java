import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.io.*;

public class AttendanceSystem {
    private List<Student> studentList;
    private String currentClass;

    public AttendanceSystem() {
        studentList = readFileStudent("Dssv1.txt");
    }
    boolean login() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên tài khoản: ");
        String username = scanner.nextLine();
        System.out.print("Nhập mật khẩu: ");
        String password = scanner.nextLine();

        if (username.equals("admin") && password.equals("1234")) {
            System.out.println("Đăng nhập thành công!");
        } else {
            System.out.println("Thông tin đăng nhập không hợp lệ.");
        }
        return false;
    }

    void chooseClass() {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tên lớp để điểm danh: ");
        currentClass = scanner.nextLine();
        System.out.println("Lớp " + currentClass + " đã được chọn.");
    }

    public void markAttendance() {
        System.out.println("\n===== Điểm danh sinh viên =====");
        Scanner scanner = new Scanner(System.in);
        if (studentList == null || studentList.isEmpty()) {
            System.out.println("Không có sinh viên nào trong danh sách. Vui lòng kiểm tra lại file Dssv1.txt.");
            return;
        }

        for (Student student : studentList) {
            System.out.println(student.getStudentID() + "  " + student.getStudentName() + "  Class: " + student.getStudentClass());
            System.out.print("Sinh viên có mặt? (y/n): ");
            String input = scanner.nextLine();

            if (input.equalsIgnoreCase("y")) {
                student.setAttend(true);
                System.out.println(student.getStudentName() + " đã có mặt.");
            } else {
                student.setAttend(false);
                System.out.println(student.getStudentName() + " không có mặt.");
            }
        }
        System.out.println("\nĐiểm danh hoàn tất.");
    }

    public void displayStudentList() {
        System.out.println("\n===== Danh sách sinh viên =====");
        if (studentList == null || studentList.isEmpty()) {
            System.out.println("Danh sách sinh viên hiện đang trống.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void displayAttendanceList() {
        System.out.println("\n===== Danh sách sinh viên sau khi điểm danh =====");
        if (studentList == null || studentList.isEmpty()) {
            System.out.println("Chưa có dữ liệu điểm danh.");
        } else {
            for (Student student : studentList) {
                System.out.println(student);
            }
        }
    }

    public void saveAttendanceData() {
        if (studentList != null && !studentList.isEmpty()) {
            createFileRollCall(studentList, "RollCall.txt");
            System.out.println("\nDanh sách điểm danh đã được lưu vào file 'RollCall.txt'.");
        } else {
            System.out.println("Chưa có danh sách sinh viên để lưu. Vui lòng thực hiện điểm danh trước.");
        }
    }

    public List<Student> readFileStudent(String filePath) {
        List<Student> studentList = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(filePath))) {
            String line;
            while ((line = br.readLine()) != null) {
                String[] info = line.split(",");
                if (info.length == 3) {
                    Student student = new Student(info[0], info[1], info[2]);
                    studentList.add(student);
                }
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi đọc file: " + e.getMessage());
        }
        return studentList;
    }

    private void createFileRollCall(List<Student> studentList, String filePath) {
        try (BufferedWriter bw = new BufferedWriter(new FileWriter(filePath))) {
            for (Student student : studentList) {
                bw.write(student.toString());
                bw.newLine();
            }
        } catch (IOException e) {
            System.out.println("Lỗi khi ghi file: " + e.getMessage());
        }
    }
    public String getCurrentClass() {
        return currentClass;
    }
}