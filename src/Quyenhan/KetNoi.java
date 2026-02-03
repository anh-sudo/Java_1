package Quyenhan;

import java.sql.*;
public class KetNoi {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException {
        Connection conn=DriverManager.getConnection(URL);
        Statement st=conn.createStatement();
        ResultSet rs=st.executeQuery("SELECT *FROM Sach order by id ASC");

        while(rs.next()){
            String id = rs.getString("id");
            String ten_sach = rs.getString("ten_sach");
            String tac_gia = rs.getString("tac_gia");
            String ngay_sua = rs.getString("ngay_sua");

            System.out.println(id+" "+ten_sach+" "+tac_gia+" "+ngay_sua);
        }
        conn.close();
    }
}