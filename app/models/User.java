package models;
import java.sql.*;
import java.sql.*;

public class User {
    public int srno;
    public String user_name,user_pswd;

    public User(){

    }
    public User(String user_name, String user_pswd,int srno)
    {
        this.user_name = user_name;
        this.user_pswd = user_pswd;
        this.srno = srno;
    }

    public Connection connection()
    {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection(
                    "jdbc:mysql://localhost:3306/playDb", "root", "");
            return con;
        }
        catch(Exception e)
        {
            System.out.println(e);
            return null;
        }

    }

    public ResultSet view()throws SQLException
    {
        Connection con = connection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM user");
        return rs;
    }

    public void remove(String user_name) throws SQLException {
        Connection con = connection();
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("DELETE FROM user WHERE name="+user_name);
        con.close();
    }

}
