package Quyenhan;
import java.sql.*;
import java.time.Period;
import java.util.Scanner;

public class DangKi {
    static String URL="jdbc:sqlite:identifier.sqlite";
    public static void thuchien() {
        Connection conn=null;
        try {
             conn = DriverManager.getConnection(URL);
            Scanner sc = new Scanner(System.in);
            PreparedStatement pst = conn.prepareStatement("insert into TaiKhoan VALUES (?,?,?)");
            PreparedStatement pst1 = conn.prepareStatement("insert into ThongTin VALUES (?,?)");
            conn.setAutoCommit(false);

            System.out.print("MSV");
            String MSV = sc.nextLine();
            System.out.print("ten");
            String ten = sc.nextLine();
            System.out.print("password");
            String password = sc.nextLine();

            pst.setString(1, MSV);
            pst.setString(2, password);
            pst.setString(3, "SINH_VIEN");
            pst.executeUpdate();
            pst1.setString(1, MSV);
            pst1.setString(2, ten);
            pst1.executeUpdate();

            conn.commit();
            System.out.println("✅ Đăng ký thành công cho sinh viên: " + ten);
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
            if(conn!=null)
              try {
                  conn.rollback();
              }
            catch (SQLException ex) {ex.printStackTrace();}
        }

    }

}
