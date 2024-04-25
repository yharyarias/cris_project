/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.*;
import java.util.HashMap;
import java.util.Map;
import model.User;

public class Conexion {

    private Connection connection;
    private Statement statement;

    public Conexion() {
        connectDB();
    }

    private void connectDB() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/example", "root", "");
            statement = connection.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public int insert(String code, String name, Double price, Integer units) throws SQLException {
        return statement.executeUpdate("INSERT INTO your_table (code, name, price, units) VALUES ('" + code + "', '" + name + "', " + price + ", " + units + ")");
    }

    public int update(String code, String name, Double price, Integer units) throws SQLException {
        return statement.executeUpdate("UPDATE your_table SET name='" + name + "', price=" + price + ", units=" + units + " WHERE code='" + code + "'");
    }

    public int delete(String code) throws SQLException {
        return statement.executeUpdate("DELETE FROM your_table WHERE code='" + code + "'");
    }

    public ResultSet read(String code) throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table WHERE code='" + code + "'");
        return resultSet;
    }

    public ResultSet readAll() throws SQLException {
        ResultSet resultSet = statement.executeQuery("SELECT * FROM your_table");
        return resultSet;
    }

    public User login(String user, String pass) throws SQLException {
        String loginQuery = "SELECT  u.username, r.can_create, r.can_read, r.can_update, r.can_delete "
                + "FROM users u "
                + "INNER JOIN roles r ON u.role_id = r.id "
                + "WHERE u.username = '" + user + "' AND u.password = '" + pass +"'";
       
        ResultSet resultSet = statement.executeQuery(loginQuery);

        if (resultSet.next()) {
            String username = resultSet.getString("username");
           

            boolean can_create = resultSet.getBoolean("can_create");
            boolean can_read = resultSet.getBoolean("can_read");
            boolean can_update = resultSet.getBoolean("can_update");
            boolean can_delete = resultSet.getBoolean("can_delete");

            return new User(username, can_create, can_read, can_update, can_delete);
        } else {
            return null;
        }
    }
}
