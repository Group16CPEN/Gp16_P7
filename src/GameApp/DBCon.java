package GameApp;


import java.sql.*;



public class DBCon {
    private static Connection con;
    private static String GAME="GAME";

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection("jdbc:mysql://localhost/"+GAME+"?useTimezone=true&serverTimezone=UTC", "root", "");
        } catch (Exception ex) {
            System.out.println(ex.getMessage());
        }
        return con;
    }

}