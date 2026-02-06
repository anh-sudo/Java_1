package Quyenhan;

import java.sql.*;
import java.util.Scanner;
import static Quyenhan.DangNhap.p_user;

public class TraSach {
    static String URL = "jdbc:sqlite:identifier.sqlite";

    public static void thuchien() {
        Connection conn = null;
        Scanner sc = new Scanner(System.in);
        try {
            conn = DriverManager.getConnection(URL);
            conn.setAutoCommit(false); // Bắt đầu giao dịch

            String idSach = sc.nextLine();

            String sqlTimTen = "SELECT ten_sach FROM Sach WHERE id=?";
            PreparedStatement pstTim = conn.prepareStatement(sqlTimTen);
            pstTim.setString(1, idSach);
            ResultSet rs = pstTim.executeQuery();

            if (rs.next()) {
                String tenSach = rs.getString("ten_sach");


                String sqlKiemTra = "SELECT * FROM PhieuMuon WHERE MSV=? AND ten_sach_muon=?";
                PreparedStatement pstKiemTra = conn.prepareStatement(sqlKiemTra);
                pstKiemTra.setString(1, p_user);
                pstKiemTra.setString(2, tenSach);

                if (pstKiemTra.executeQuery().next()) {

                    String sqlXoa = "DELETE FROM PhieuMuon WHERE MSV=? AND ten_sach_muon=?";
                    PreparedStatement pstXoa = conn.prepareStatement(sqlXoa);
                    pstXoa.setString(1, p_user);
                    pstXoa.setString(2, tenSach);
                    pstXoa.executeUpdate();


                    String sqlCongKho = "UPDATE Sach SET so_luong = so_luong + 1 WHERE id=?";
                    PreparedStatement pstCong = conn.prepareStatement(sqlCongKho);
                    pstCong.setString(1, idSach);
                    pstCong.executeUpdate();

                    conn.commit(); // Chốt đơn
                    System.out.println("✅ Da tra sach thanh cong: " + tenSach);
                } else {
                    System.out.println("❌");
                }
            } else {
                System.out.println("⚠️ Khong tim thay sach co ID nay trong thu vien.");
            }

        } catch (Exception e) {
            try { if (conn != null) conn.rollback(); } catch (SQLException ex) {}
            e.printStackTrace();
        }
    }
}