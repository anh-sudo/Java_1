package Quyenhan;

import java.sql.*;
import java.util.Scanner;

public class TimSach {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien()throws SQLException{
        Connection con=DriverManager.getConnection(URL);
        Scanner sc=new Scanner(System.in);
        PreparedStatement pst=con.prepareStatement("select * from Sach where ten_sach like ? OR tac_gia like ? ");

        String index=sc.nextLine();
        pst.setString(1,"%"+index+"%");
        pst.setString(2,"%"+index+"%");
        ResultSet rs=pst.executeQuery();
        boolean check=false;
        while(rs.next()){
            check=true;
            String id=rs.getString("id");
            String ten_sach=rs.getString("ten_sach");
            String tac_gia=rs.getString("tac_gia");
            System.out.println(id+" "+ten_sach+" "+tac_gia);
        }
        if(!check) System.out.println("Khong tim thay sach");
    }
}