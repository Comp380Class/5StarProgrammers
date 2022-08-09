package starprogrammers;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MysqlConnector {
  Connection conn;
    
  private final static String url = URL;
  private final static String user = USER;
  private final static String password = PASSWORD;

  public MysqlConnector() {}

  public boolean connect() {
    try {
      this.conn = DriverManager.getConnection(url, user, password);
      return true;

    } catch (Exception ex) {
      System.out.println("An error occurred.");
      ex.printStackTrace();
      return false;
    }
  }
  
  public static Connection getConnection() throws SQLException{
      return DriverManager.getConnection(url, user, password);
  }
}
