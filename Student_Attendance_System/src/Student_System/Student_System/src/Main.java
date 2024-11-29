import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        AttendanceSystem attendanceSystem = new AttendanceSystem();
        displayMenu(attendanceSystem);
    }

    public static void displayMenu(AttendanceSystem attendanceSystem) {
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n===== MENU =====");
            System.out.println("1. Đăng nhập vào tài khoản");
            System.out.println("2. Chọn lớp điểm danh");
            System.out.println("3. Điểm danh sinh viên");
            System.out.println("4. Hiển thị danh sách sinh viên");
            System.out.println("5. Hiển thị danh sách sinh viên sau khi điểm danh");
            System.out.println("6. Lưu trữ dữ liệu");
            System.out.println("7. Thoát chương trình");
            System.out.print("Nhập lựa chọn: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Đọc dòng mới

            switch (choice) {
                    case 1:
                        attendanceSystem.login();
                        break;
                    case 2:
                        attendanceSystem.chooseClass();
                        break;
                    case 3:
                        attendanceSystem.markAttendance();
                        break;
                    case 4:
                        attendanceSystem.displayStudentList();
                        break;
                    case 5:
                        attendanceSystem.displayAttendanceList();
                        break;
                    case 6:
                        attendanceSystem.saveAttendanceData();
                        break;
                    case 7:
                        System.out.println("Thoát chương trình...");
                        running = false;
                        break;
                    default:
                        System.out.println("Lựa chọn không hợp lệ. Vui lòng chọn lại.");
                        break;
                }
            }
            scanner.close();
        }
}
