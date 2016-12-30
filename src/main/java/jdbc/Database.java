package jdbc;

import java.sql.*;

public class Database {
    private Connection connection;

    public Connection getConnection() {
        return connection;
    }

    public void setConnection(String login, String password) {
//        String driver = "com.mysql.jdbc.Driver";
        String connectionString = "jdbc:mysql://localhost/users"; // TODO move to property file

        try {
//            Class.forName(driver);
            connection = DriverManager.getConnection(connectionString, login, password);
            connection.setAutoCommit(false);
            connection.commit();
        } catch (/*ClassNotFoundException |*/ SQLException e) {
            e.printStackTrace();
        }
    }

    public ResultSet runSQL(String SQL) {
        try {
            Statement statement = connection.createStatement(ResultSet.TYPE_SCROLL_INSENSITIVE, ResultSet.CONCUR_UPDATABLE);
            if (SQL.toUpperCase().contains("SELECT")) {
                return statement.executeQuery(SQL);
            } else {
                statement.execute(SQL);
            }
        } catch (SQLException e) {
            System.out.println(e);
        }
        return null;
    }

    public int getNextId(String tableName, String fieldName) {
        int nextId = 0;
        String SQL = "SELECT " + fieldName + " FROM " + tableName + " ORDER BY " + fieldName + " DESC";

        try {
            Statement statement = connection.createStatement();
            ResultSet rs = statement.executeQuery(SQL);
            if (rs.next()) {
                nextId = rs.getInt(1) + 1;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return nextId;
    }
}
