package Database;
import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DataBaseConnection {
    private Statement st;
    private String DBMySQLUrl;
    private String DBUserName;
    private String DBPassword;

    public DataBaseConnection(String DBMySQLUrl, String DBUserName, String DBPassword) {
        this.DBMySQLUrl = DBMySQLUrl;
        this.DBUserName = DBUserName;
        this.DBPassword = DBPassword;
        try {this.st=statement();} catch (SQLException ex) {
            System.out.println(ex);
        }
    }

    private Statement statement() throws SQLException {
            Connection connection = DriverManager.getConnection(DBMySQLUrl, DBUserName, DBPassword);
            Statement statement = connection.createStatement();
            return statement;
    }

    public Statement getSt() {
        return st;
    }

    public void setSt(Statement st) {
        this.st = st;
    }

    public String getDBMySQLUrl() {
        return DBMySQLUrl;
    }

    public String getDBUserName() {
        return DBUserName;
    }

    public String getDBPassword() {
        return DBPassword;
    }
}
