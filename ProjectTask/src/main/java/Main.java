import java.sql.*;

public class Main {
    public static void main(String[] args) {

//        System.out.println("Hello");


        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://127.0.0.1:3306/aboutstudent", "root","password");
            Statement statement = con.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * from asd");

            while (resultSet.next()) {

                System.out.println(resultSet.getString(1) + " " + resultSet.getString(2) );
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }
}
