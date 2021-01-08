package models;

import java.sql.*;

public class Estate {
    
        public int estate_id;
        public String estate_name, estate_type;
        public float estate_length, estate_breadth, cost_per_feet;

        public Estate(){

        }
        public Estate(String estate_name, float estate_length, float estate_breadth, float cost_per_feet, String estate_type)
        {
            this.estate_name = estate_name;
            this.estate_length = estate_length;
            this.estate_breadth = estate_breadth;
            this.cost_per_feet = cost_per_feet;
            this.estate_type = estate_type;
        }

        public Connection connection()
        {
            try {
                Class.forName("com.mysql.jdbc.Driver");
                Connection con = DriverManager.getConnection(
                        "jdbc:mysql://localhost:3306/rEPlayDb", "root", "");
                return con;
            }
            catch(Exception e)
            {
                System.out.println(e);
                return null;
            }

        }

    public void insert()throws SQLException
    {
        try{

            Connection con = connection();
            String sql = "insert into estate(estate_name,estate_type,estate_length,estate_breadth,cost_per_feet) values(?,?,?,?,?)";
            PreparedStatement stmt = con.prepareStatement(sql);

            stmt.setString(1, estate_name);
            stmt.setFloat(2, estate_length);
            stmt.setFloat(3, estate_breadth);
            stmt.setFloat(4, cost_per_feet);
            stmt.setString(5, estate_type);

            int i = stmt.executeUpdate();
            System.out.println("Customer Details Added Successfully..!");
            con.close();
         }
        catch (Exception e)
        {
          System.out.println(e);
        }
    }

    public void remove(int estate_id) throws SQLException {
        Connection con = connection();
        Statement stmt = con.createStatement();
        int i = stmt.executeUpdate("DELETE FROM estate WHERE estate_ID="+estate_id);
        con.close();
    }
    public ResultSet view()throws SQLException
    {
        Connection con = connection();
        Statement stmt=con.createStatement();
        ResultSet rs=stmt.executeQuery("SELECT * FROM estate");
        return rs;
    }

}
