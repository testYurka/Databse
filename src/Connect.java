import java.io.FileWriter;
import java.io.IOException;
import java.sql.*;

public class Connect {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, IOException {
        String url = "jdbc:mysql://localhost:3306/Shop?serverTimezone=UTC";
        String userName = "root";
        String password = "qwerty123";

        Class.forName("com.mysql.cj.jdbc.Driver");

        Connection conn = DriverManager.getConnection(url, userName, password);

        System.out.println("Connection Succesful");

        Statement statement = conn.createStatement();

        String sql;
        sql = "SELECT * FROM shoppers";

        ResultSet resultSet = statement.executeQuery(sql);
        try(FileWriter writer = new FileWriter("notes34.html", false)) {
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String specialty = resultSet.getString("specialty");
                int salary = resultSet.getInt("salary");
                String ss = "\\r\\n";
                writer.write(id + " ");
                writer.write(name + " ");
                writer.write(specialty + " ");
                writer.write(salary);
                writer.write(ss);


            }
        }
        resultSet.close();
        statement.close();
        conn.close();

    }
}
