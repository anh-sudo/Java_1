import Quyenhan.DangKi;
import Quyenhan.DangNhap;

import java.sql.SQLException;
import java.util.Scanner;

public class QuanLy {
    public static void main(String[] args)throws SQLException {
        Scanner sc = new Scanner(System.in);
        while (true) {
            System.out.println("\n====== HỆ THỐNG QUẢN LÝ THƯ VIỆN ======");
            System.out.println("1. Đăng nhập");
            System.out.println("2. Đăng ký tài khoản mới");
            int chon=sc.nextInt();
            switch (chon) {
                case 1:
                    String role= DangNhap.thuchien();
                    if(role==null) continue;
                    System.out.println("xin chao "+role);
                    if(role.equals("THU_THU")) menuThuthu.thuchien();
                    else menuSinhvien.thuchien();
                    break;
                case 2:
                    DangKi.thuchien();
                    break;
            }

        }
    }
}