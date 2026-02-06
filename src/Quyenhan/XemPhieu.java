package Quyenhan;

import java.sql.*;
import static Quyenhan.DangNhap.p_user;

public class XemPhieu {
    static String URL="jdbc:sqlite:identifier.sqlite";

    public static void thuchien() {
        try {
            Connection conn = DriverManager.getConnection(URL);
            String sql = "SELECT * FROM PhieuMuon WHERE MSV=?";
            PreparedStatement pst = conn.prepareStatement(sql);

            pst.setString(1, p_user);

            ResultSet rs = pst.executeQuery();
            boolean check = false;

            while(rs.next()){
                check = true;
                String ten = rs.getString("ten_sach_muon");
                String ngay = rs.getString("ngay_muon");
                String han = rs.getString("ngay_den_han");

                System.out.println("- " + ten + " (Muon: " + ngay + " | Han: " + han + ")");
            }

            if(!check){
                System.out.println("Ban chua muon cuon nao ca.");
            }

            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}