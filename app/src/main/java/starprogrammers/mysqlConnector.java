package starprogrammers;

import java.sql.Connection;
import java.sql.DriverManager;

public class mysqlConnector {
  Connection conn;
  String url1, user, password;

  public mysqlConnector(String url, String user, String password) {
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
