package starprogrammers;

import java.sql.Connection;
import java.sql.DriverManager;

public class MysqlConnector {
  Connection conn;
  String url1, user, password;

  public MysqlConnector(String url, String user, String password) {
    url1 = url;
    this.user = user;
    this.password = password;
  }

  public boolean connect() {

    try {
      this.conn = DriverManager.getConnection(url1, user, password);
      return true;

    } catch (Exception ex) {
      System.out.println("An error occurred.");
      ex.printStackTrace();
      return false;
    }
  }
}
