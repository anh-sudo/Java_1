package Quyenhan;

import java.sql.*;

public class XemTatCaPhieu {
    static String URL = "jdbc:sqlite:identifier.sqlite";

    public static void thuchien() {
        try {
            Connection conn = DriverManager.getConnection(URL);


            String sql = "SELECT * FROM PhieuMuon";
            PreparedStatement pst = conn.prepareStatement(sql);
            ResultSet rs = pst.executeQuery();

            boolean coDuLieu = false;
            while(rs.next()){
                coDuLieu = true;
                String msv = rs.getString("MSV");
                String ten = rs.getString("ten_sach_muon");
                String ngay = rs.getString("ngay_muon");
                String han = rs.getString("ngay_den_han");


                System.out.printf(msv+ " | "+ ten+ " | " + ngay+ " | " + han);
            }

            if(!coDuLieu) {
                System.out.println("Hien tai thu vien chua co ai muon sach ca.");
            }

            conn.close();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}