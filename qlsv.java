
// 22/04/2025
import java.util.ArrayList;
import java.util.Scanner;
class Student {
	private String id;
	private String name;
	private double gpa;

	public Student(String id, String name, double gpa) {
		this.id = id;
		this.name = name;
		this.gpa = gpa;
	}
	public String getId() {
		return id;
	}

	public String getName() {
		return name;
	}

	public double getGpa() {
		return gpa;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void setGpa(double gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "ID: " + id + ", Tên: " + name + ", GPA: " + gpa;
	}
}
public class qlsv {
	public static void main(String[] args) {
		ArrayList<Student> students = new ArrayList<>();
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("\n>> Quản Lý Sinh Viên <<");
			System.out.println("1. Thêm sinh viên");
			System.out.println("2. Sửa thông tin sinh viên");
			System.out.println("3. Xóa sinh viên");
			System.out.println("4. Tìm kiếm sinh viên theo ID");
			System.out.println("5. Hiển thị danh sách sinh viên");
			System.out.println("6. Thoát");
			System.out.print("Mời chọn: ");
			int choice = sc.nextInt();
			sc.nextLine(); 
			if (choice == 6) {
				System.out.println("Hẹn gặp lại!");
				break;
			}
			switch (choice) {
			case 1:
				System.out.print("Nhập ID: ");
				String id = sc.nextLine();
				
				if (findStudentById(students, id) != null) {
					System.out.println("ID đã tồn tại!");
					break;
				}
				System.out.print("Nhập tên: ");
				String name = sc.nextLine();
				System.out.print("Nhập GPA: ");
				double gpa = sc.nextDouble();
				while (gpa < 0 || gpa > 10) {
					System.out.print("GPA phải từ 0-10. Hãy nhập lại: ");
					gpa = sc.nextDouble();
				}
				students.add(new Student(id, name, gpa));
				System.out.println("Thêm sinh viên thành công!");
				break;

			case 2: 
				System.out.print("Nhập ID sinh viên cần sửa: ");
				id = sc.nextLine();
				Student studentToEdit = findStudentById(students, id);
				if (studentToEdit == null) {
					System.out.println("Không tìm thấy sinh viên này: "+id);
					break;
				}
				System.out.print("Nhập tên mới (Enter để giữ nguyên): ");
				name = sc.nextLine();
				if (!name.isEmpty()) {
					studentToEdit.setName(name);
				}
				System.out.print("Nhập GPA mới (nhập -1 để giữ nguyên): ");
				gpa = sc.nextDouble();
				if (gpa != -1) {
					while (gpa < 0 || gpa > 10) {
						System.out.print("GPA phải từ 0-10. Nhập lại: ");
						gpa = sc.nextDouble();
					}
					studentToEdit.setGpa(gpa);
				}
				System.out.println("Cập nhật thông tin thành công!");
				break;

			case 3: 
				System.out.print("Nhập ID sinh viên cần xóa: ");
				id = sc.nextLine();
				Student studentToRemove = findStudentById(students, id);
				if (studentToRemove == null) {
					System.out.println("Không tìm thấy sinh viên!");
					break;
				}
				students.remove(studentToRemove);
				System.out.println("Xóa sinh viên thành công!");
				break;

			case 4: 
				System.out.print("Nhập ID sinh viên cần tìm: ");
				id = sc.nextLine();
				Student foundStudent = findStudentById(students, id);
				if (foundStudent == null) {
					System.out.println("Không tìm thấy sinh viên!");
				} else {
					System.out.println(foundStudent);
				}
				break;

			case 5: 
				if (students.isEmpty()) {
					System.out.println("Danh sách sinh viên trống!");
				} else {
					System.out.println("Danh sách sinh viên:");
					for (Student student : students) {
						System.out.println(student);
					}
				}
				break;

			default:
				System.out.println("Lựa chọn không hợp lệ!");
			}
		}
		sc.close();
	}
	private static Student findStudentById(ArrayList<Student> students, String id) {
		for (Student student : students) {
			if (student.getId().equals(id)) {
				return student;
			}
		}
		return null;
	}
}
