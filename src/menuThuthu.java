import Quyenhan.*;

import java.sql.SQLException;
import java.util.Scanner;

public class menuThuthu {
    public static void thuchien()throws SQLException {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== MENU CHÍNH ===");
            System.out.println("1. Xem sách");
            System.out.println("2. Thêm sách");
            System.out.println("3. Xóa sách");
            System.out.println("4. Sửa sách");
            System.out.println("5. Tìm sách");
            System.out.println("6. Xem phiếu mượn");
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
                case 6:
                    XemTatCaPhieu.thuchien();
                    break;
                case 7: System.exit(0);
            }
        }
    }
}