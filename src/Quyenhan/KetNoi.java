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
            Integer so_luong = rs.getInt("so_luong");

            System.out.println(id+" | "+ten_sach+" | "+tac_gia+" | "+so_luong);
        }
        conn.close();
    }
}