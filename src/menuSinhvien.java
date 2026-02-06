import Quyenhan.*;

import java.sql.SQLException;
import java.util.Scanner;

public class menuSinhvien {
    public static void thuchien()throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU CHÍNH ===");
            System.out.println("1. Xem tất cả sách đã mượn");
            System.out.println("2. Tìm theo tên sách hoặc tác giả");
            System.out.println("3. Mượn sách (theo id)");
            System.out.println("4. Trả sách (theo id)");
            System.out.println("5. Thoát");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();

            switch (chon) {
                case 1:
                    XemPhieu.thuchien();
                    break;
                case 2:
                    TimSach.thuchien();
                    break;
                case 3:
                    MuonSach.thuchien();
                    break;
                case 4:
                    TraSach.thuchien();
                    break;
                case 5: System.exit(0);
            }
        }
    }
}