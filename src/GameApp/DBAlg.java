package GameApp;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class DBAlg {
    static Connection connection= DBCon.getConnection();
    static ArrayList<words> levelonearraylist;
    static ArrayList<words> leveltwoarraylist;
    static ArrayList<words> levelthreearraylist;


    public static void getAlllevelonewords() {
        levelonearraylist =new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM WORDS WHERE level=1";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                levelonearraylist.add(new words(rs.getString("word"),rs.getString("hint"),rs.getInt("level"),
                        rs.getInt("word_id")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void getAllleveltwowords() {
        leveltwoarraylist =new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM WORDS WHERE level=2";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                leveltwoarraylist.add(new words(rs.getString("word"),rs.getString("hint"),rs.getInt("level"),
                        rs.getInt("word_id")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
    public static void getAlllevelthreewords() {
        levelthreearraylist =new ArrayList<>();
        try {
            Statement st = connection.createStatement();
            String query = "SELECT * FROM WORDS WHERE level=3";
            ResultSet rs = st.executeQuery(query);
            while(rs.next()) {
                levelthreearraylist.add(new words(rs.getString("word"),rs.getString("hint"),rs.getInt("level"),
                        rs.getInt("word_id")));
            }
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

}
