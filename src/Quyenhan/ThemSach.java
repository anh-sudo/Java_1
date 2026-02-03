package Quyenhan;

import java.sql.*;
import java.util.Scanner;
public class ThemSach  {
    static String URL = "jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException{
        Connection conn=DriverManager.getConnection(URL);
        String sql="INSERT INTO Sach(id,ten_sach,tac_gia,so_luong) VALUES (?,?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);

        String id=sc.nextLine();
        String ten_sach=sc.nextLine();
        String tac_gia=sc.nextLine();
        Integer  so_luong=sc.nextInt();
        pst.setString(1, id);
        pst.setString(2, ten_sach);
        pst.setString(3, tac_gia);
        pst.setInt(4, so_luong);
        pst.executeUpdate();
        conn.close();
    }
}