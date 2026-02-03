import Quyenhan.*;

import java.sql.SQLException;
import java.util.Scanner;

public class menuThuthu {
    public static void thuchien()throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU CHÍNH ===");
            System.out.println("1. Xem");
            System.out.println("2. Thêm");
            System.out.println("3. Xóa");
            System.out.println("4. Sửa");
            System.out.println("5. Tim sach");
            System.out.print("Chọn: ");
            int chon = sc.nextInt();

            switch (chon) {
                case 1:
                    KetNoi.thuchien();
                    break;
                case 2:
                    ThemSach.thuchien();
                    break;
                case 3:
                    XoaSach.thuchien();
                    break;
                case 4:
                    SuaSach.thuchien();
                    break;
                case 5:
                    TimSach.thuchien();
                    break;
                case 6: System.exit(0);
            }
        }
    }
}