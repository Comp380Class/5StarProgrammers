package starprogrammers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement
public class RoomDataBase {
  RoomDataBase() {}

  public boolean doesTableExist() {
    String sql =
        "SELECT count(*) "
            + "FROM information_schema.tables "
            + "WHERE table_name = ?"
            + "LIMIT 1;";
    try (Connection conn = MysqlConnector.getConnection(); ) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, "Room");
      ResultSet resultSet = pstmt.executeQuery();
      resultSet.next();
      return resultSet.getInt(1) != 0;

    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void createRoomTable() { // Room#, type, bed, quant, roomPrice
    if (!doesTableExist()) {
      try (Connection conn = MysqlConnector.getConnection(); ) {
        final String createTable =
            "CREATE TABLE sql3511682.Room ("
                + "room_number INT(255) NOT NULL),"
                + "room_type VARCHAR(255) NOT NULL,"
                + "bed_type VARCHAR(255) NOT NULL,"
                + "bed_quantity INT(255) NOT NULL,"
                + "room_price INT(255) NOT NULL,)";
        Statement stmt = conn.createStatement();
        stmt.executeUpdate(createTable);
        System.out.println("Room table created");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public boolean doesRowExist(int roomNumber) {
    String sql = "SELECT room_number FROM Room where room_number = ?";
    try (Connection conn = MysqlConnector.getConnection(); ) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, roomNumber);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        System.out.println("Room already exists in database");
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  public void insertRoom(
      int roomNumber, String roomType, String bedType, int bedQuantity, int roomPrice) {
    if (!doesRowExist(roomNumber)) {
      try (Connection conn = MysqlConnector.getConnection(); ) {
        String sql = "INSERT INTO Room VALUE (?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, roomNumber);
        pstmt.setString(2, roomType);
        pstmt.setString(3, bedType);
        pstmt.setInt(4, bedQuantity);
        pstmt.setInt(5, roomPrice);
        pstmt.executeUpdate();
        System.out.println("Room inserted to table");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  public void printAllRooms() {
    String sql = "SELECT room_number, room_type, bed_type, bed_quantity, room_price FROM Room";
    try (Connection conn = MysqlConnector.getConnection(); ) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      System.out.println("Room#\tType\tBed\tBed#\tPrice");
      while (resultSet.next()) {
        System.out.println(
            resultSet.getInt("room_number")
                + "\t"
                + resultSet.getString("room_type")
                + "\t"
                + resultSet.getString("bed_type")
                + "\t"
                + resultSet.getInt("bed_quantity")
                + "\t"
                + resultSet.getInt("room_price"));
      }
    } catch (SQLException e){
		e.printStackTrace();
	}
  }
  public void printSmokingRooms() {
    String sql = "SELECT room_number, room_type, bed_type, bed_quantity, room_price FROM Room WHERE room_type = 'Smoking'";
    try (Connection conn = MysqlConnector.getConnection(); ) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      System.out.println("Room#\tType\tBed\tBed#\tPrice");
      while (resultSet.next()) {
        System.out.println(
            resultSet.getInt("room_number")
                + "\t"
                + resultSet.getString("room_type")
                + "\t"
                + resultSet.getString("bed_type")
                + "\t"
                + resultSet.getInt("bed_quantity")
                + "\t"
                + resultSet.getInt("room_price"));
      }
    } catch (SQLException e){
		e.printStackTrace();
	}
  }	public void printNonSmokingRooms(String test) {
	  test = "'smoking'";
		  String sql =String.format("SELECT room_number, room_type, bed_type, bed_quantity, room_price FROM Room WHERE room_type =  %s", test);
    try (Connection conn = MysqlConnector.getConnection(); ) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      System.out.println("Room#\tType\tBed\tBed#\tPrice");
      while (resultSet.next()) {
        System.out.println(
            resultSet.getInt("room_number")
                + "\t"
                + resultSet.getString("room_type")
                + "\t"
                + resultSet.getString("bed_type")
                + "\t"
                + resultSet.getInt("bed_quantity")
                + "\t"
                + resultSet.getInt("room_price"));
      }
    } catch (SQLException e){
		e.printStackTrace();
	}
  }	
}
