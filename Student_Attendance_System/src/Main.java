import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Student> studentList = null;

        int choice;
        do {
            System.out.println("\n====== MENU ======");
            System.out.println("1. Student Roll Call");
            System.out.println("2. Show Student List");
            System.out.println("3. Display Student List After Roll Call");
            System.out.println("4. Save Attendance List To File");
            System.out.println("0. Exit Program");
            System.out.print("Enter selection: ");
            choice = scanner.nextInt();
            scanner.nextLine(); // Đọc bỏ dòng mới sau khi nhập số

            switch (choice) {
                case 1:
                    // Đọc danh sách sinh viên từ file txt
                    studentList = Attendance_System.ReadFileStudent("Dssv.txt");

                    // Thực hiện điểm danh
                    for (Student st : studentList) {
                        System.out.println(st.getStudentID() + "  " + st.getStudentName() + "  Class: " + st.getStudentClass());
                        System.out.print("Students present ? (y/n): ");
                        String input = scanner.nextLine();
                        if (input.equalsIgnoreCase("y")) {
                            st.setAttend(true);
                        } else {
                            st.setAttend(false);
                        }
                    }

                    System.out.println("\nRoll Call complete.");
                    break;

                case 2:
                    // Hiển thị danh sách sinh viên (trước khi điểm danh)
                    studentList = Attendance_System.ReadFileStudent("Dssv.txt");
                    System.out.println("\n===== List of students =====");
                    for (Student st : studentList) {
                        System.out.println(st.getStudentID() + " | " + st.getStudentName() + " | " + st.getStudentClass());
                    }
                    break;

                case 3:
                    // Hiển thị danh sách sinh viên sau khi điểm danh
                    if (studentList != null) {
                        System.out.println("\n===== List of students after Roll Call =====");
                        for (Student st : studentList) {
                            System.out.println(st);
                        }
                    } else {
                        System.out.println("No student list yet. Please check in first.");
                    }
                    break;

                case 4:
                    // Ghi danh sách điểm danh vào file
                    if (studentList != null) {
                        Attendance_System.CreatFileRollCall(studentList, "RollCall.txt");
                        System.out.println("\nThe attendance list has been saved to file: 'RollCall.txt'.");
                    } else {
                        System.out.println("There is no student list to save. Please check in first.");
                    }
                    break;

                case 0:
                    System.out.println("Program End!");
                    break;

                default:
                    System.out.println("Invalid selection! Please try again.");
            }
        } while (choice != 0);

        scanner.close();
    }
}