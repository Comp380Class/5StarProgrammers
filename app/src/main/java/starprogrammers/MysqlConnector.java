package starprogrammers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
  Connection conn;
    
  private final static String url = "jdbc:mysql://sql3.freesqldatabase.com/sql3511682";
  private final static String user = "sql3511682";
  private final static String password = "4SYTxuwY6W";

  public MysqlConnector() {}
  
  public static Connection getConnection() throws SQLException{
      return DriverManager.getConnection(url, user, password);
  }
}
