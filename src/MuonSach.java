import java.sql.*;
import java.util.Scanner;

public class MuonSach {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien() throws SQLException {
        Connection conn=DriverManager.getConnection(URL);
        Scanner sc=new Scanner(System.in);

        String index=sc.nextLine();
        PreparedStatement pst=conn.prepareStatement("select *from Sach where id=?");

        pst.setString(1,index);
        ResultSet rs=pst.executeQuery();
        boolean check=false;
        while(rs.next()) {
            check=true;
            String ten_sach = rs.getString("ten_sach");
            String tac_gia = rs.getString("tac_gia");
            System.out.println(index + " " + ten_sach + " " + tac_gia);
        }
        if(!check) {System.out.println("Khong ton tai cuon sach nay");}
    }
}
