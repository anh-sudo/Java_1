package Quyenhan;

import java.sql.*;
import java.util.Scanner;

public class XoaSach {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException{
        Connection conn=DriverManager.getConnection(URL);
        PreparedStatement pst=conn.prepareStatement("DELETE FROM Sach WHERE id=?");
        Scanner sc=new Scanner(System.in);

        String id=sc.nextLine();

        pst.setString(1, id);
        pst.executeUpdate();

        conn.close();
    }

}