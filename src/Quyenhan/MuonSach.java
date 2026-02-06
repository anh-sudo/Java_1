package Quyenhan;

import java.sql.*;
import java.util.Scanner;
import static Quyenhan.DangNhap.p_user;

public class MuonSach {
    static String URL="jdbc:sqlite:identifier.sqlite";

    public static void thuchien() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(URL);
            Scanner sc = new Scanner(System.in);
            conn.setAutoCommit(false); // Bắt đầu Transaction

            System.out.print("Nhap ID: ");
            String id = sc.nextLine();

            String sql1 = "SELECT * FROM Sach where id=?";
            PreparedStatement pst1 = conn.prepareStatement(sql1);
            pst1.setString(1, id);
            ResultSet rs = pst1.executeQuery();

            if(rs.next()){
                String ten_sach = rs.getString("ten_sach");
                int sl = rs.getInt("so_luong");

                if(sl > 0) {
                    String sql = "INSERT INTO PhieuMuon(MSV,ten_sach_muon,ngay_muon,ngay_den_han) VALUES(?,?,date('now','localtime'),date('now','localtime','+7 days')) ";
                    PreparedStatement pst = conn.prepareStatement(sql);
                    pst.setString(1, p_user);
                    pst.setString(2, ten_sach);
                    pst.executeUpdate();


                    String sql2 = "UPDATE Sach SET so_luong=so_luong-1 WHERE id=?";
                    PreparedStatement pst2 = conn.prepareStatement(sql2);
                    pst2.setString(1, id);
                    pst2.executeUpdate();


                    if(sl - 1 == 0){
                        String sql3 = "DELETE FROM Sach WHERE id=?";
                        PreparedStatement pst3 = conn.prepareStatement(sql3);
                        pst3.setString(1, id);
                        pst3.executeUpdate();
                    }

                    conn.commit(); // Lưu tất cả thay đổi
                    System.out.println("da muon thanh cong " + ten_sach);
                } else {
                    System.out.println("Sach da het ");
                }
            } else {
                System.out.println("Khong tim thay sach co ID nay");
            }

        } catch (Exception e) {

            try { if(conn!=null) conn.rollback(); } catch(SQLException ex){}
            e.printStackTrace();
        }
    }
}