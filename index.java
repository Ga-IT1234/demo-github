
import java.util.Random;
import java.util.Scanner;
public class index{
    public static void main(String[] args) {
while (true) {
			Random rd = new Random();
			int random = rd.nextInt(3) + 1;
			String may = null;
			if (random == 1) {
				may = "Kéo";
			} else if (random == 2) {
				may = "Búa";
			} else {
				may = "Bao";
			}
			Scanner sc = new Scanner(System.in);
			System.out.println(">> Mời bạn nhập: Kéo ; Búa ; Bao << ");
			System.out.printf(">> ");
			String ban = sc.nextLine();
			if (ban.equalsIgnoreCase("kéo") || (ban.equalsIgnoreCase("búa") || (ban.equalsIgnoreCase("bao")))) {

			} else {
				System.out.println("! Chỉ nhập >> Kéo ; Búa ; Bao ");
			}
			System.out.println("--------------------------");
			System.out.println(" Bạn chọn: " + ban);
			System.out.println(" Máy chọn: " + may);

			if (ban.equalsIgnoreCase(may)) {
				System.out.println(" Game hòa");
			} else {
				if (ban.equalsIgnoreCase("Kéo")) {
					if (may.equalsIgnoreCase("Bao")) {
						System.out.println(" Bạn Đã Thắng");
					} else { // or máy chọn búa
						System.out.println(" Bạn Đã Thua");
					}
				}

				if (ban.equalsIgnoreCase("Búa")) {
					if (may.equalsIgnoreCase("Kéo")) {
						System.out.println(" Bạn Đã Thắng");
					} else { // or máy chọn bao
						System.out.println(" Bạn Đã Thua");
					}
				}
				if (ban.equalsIgnoreCase("Bao")) {
					if (may.equalsIgnoreCase("Búa")) {
						System.out.println(" Bạn Đã Thắng");
					} else {// máy chọn kéo
						System.out.println(" Bạn Đã Thua");
					}
				}
			}
			System.out.println("--------------------------");
		}
    }

}