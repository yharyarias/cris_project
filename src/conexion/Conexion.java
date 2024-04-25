/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package conexion;

import java.sql.Connection;
import java.sql.*;

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
}
