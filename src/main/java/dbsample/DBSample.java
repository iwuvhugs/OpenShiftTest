/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dbsample;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author iwuvhugs
 */
public class DBSample {

    private static Connection getConnection() throws SQLException {
        try {
            Class.forName("com.mysql.jdbc.Driver");
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(DBSample.class.getName()).log(Level.SEVERE, null, ex);
        }

        String host = System.getenv("OPENSHIFT_MYSQL_DB_HOST");
        String port = System.getenv("OPENSHIFT_MYSQL_DB_PORT");
        String username = System.getenv("OPENSHIFT_MYSQL_DB_USERNAME");
        String password = System.getenv("OPENSHIFT_MYSQL_DB_PASSWORD");
        String name = "dbsample";
        String url = "jdbc:mysql://" + host + ":" + port + "/" + name;

        return DriverManager.getConnection(url, username, password);

    }

    public static String getTable() {

        String output = "";
        try {
            Connection connection = getConnection();
            Statement  statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery("SELECT * FROM people");
            while (resultSet.next()){
                output += "<h2>"+resultSet.getString("name") + "</h2>";
                output += "<p>"+resultSet.getString("bio") + "</p>";
            }
            connection.close();
        } catch (SQLException ex) {
            return "SQL exception: " + ex.getMessage();
        }

        return output;

    }

}
