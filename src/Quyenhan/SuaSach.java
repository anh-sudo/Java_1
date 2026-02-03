package Quyenhan;

import java.sql.*;
import java.util.Scanner;
public class SuaSach {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException {
        Connection conn=DriverManager.getConnection(URL);
        String sql="UPDATE Sach SET ten_sach=?,tac_gia=?,ngay_sua=datetime('now','localtime') WHERE id=?";
        PreparedStatement pst=conn.prepareStatement(sql);
        Scanner sc=new Scanner(System.in);

        String id=sc.nextLine();
        String ten_sach=sc.nextLine();
        String tac_gia=sc.nextLine();
        pst.setString(1,ten_sach);
        pst.setString(2,tac_gia);
        pst.setString(3,id);

        int check=pst.executeUpdate();
        conn.close();
    }

}