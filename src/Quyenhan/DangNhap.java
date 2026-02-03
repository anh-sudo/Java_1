package Quyenhan;

import java.sql.*;
import java.util.Scanner;
public class DangNhap {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static String thuchien() throws  SQLException {
        Scanner sc=new Scanner(System.in);
        Connection conn = DriverManager.getConnection(URL);
        System.out.print("username:");
        String username=sc.next();
        System.out.print("password:");
        String password=sc.next();

        String sql="SELECT *FROM TaiKhoan WHERE username=? AND password=?";
        PreparedStatement pst=conn.prepareStatement(sql);

        pst.setString(1,username);
        pst.setString(2,password);

        ResultSet rs=pst.executeQuery();
        if(rs.next()){
            String chucvu=rs.getString("role");
            conn.close();
            return chucvu;
        }
        else {
            conn.close();
            return null;
        }
    }
}
