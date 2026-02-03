package Quyenhan;

import java.sql.*;
import java.util.Scanner;
public class ThemSach  {
    static String URL = "jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException{
        Connection conn=DriverManager.getConnection(URL);
        String sql="INSERT INTO Sach(id,ten_sach,tac_gia) VALUES (?,?,?)";
        PreparedStatement pst = conn.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);

        String id=sc.nextLine();
        String ten_sach=sc.nextLine();
        String tac_gia=sc.nextLine();
        pst.setString(1, id);
        pst.setString(2, ten_sach);
        pst.setString(3, tac_gia);

        int ketqua=pst.executeUpdate();
        conn.close();
    }
}