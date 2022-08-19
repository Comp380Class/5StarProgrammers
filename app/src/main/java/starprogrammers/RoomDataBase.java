package starprogrammers;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
/**
 * RoomDataBase
 * 08/11/2022
 * Juan Vazquez
 * This class functions as the database manager. It serves to create, read, update, destroy 
 * entries in the Room table of the database. 
 * 
 * Important functions: initializationOfRoomTable() is called by the Hotel main method so the room table always exists.
 * insertRoom(Room r) inserts a given room into the table.
 * removeRoomFromTable(int roomNumber) if the given room number belongs to one of the rooms in the table, it is removed from the table.
 * getSpecifiedRoom(int roomNumber) searches the database table for the given room number, if found returns a room object with the information 
 * from the table. If not found, returns a null Room object.
 * 
 * Important Data Structures: ArrayList used to keep a list of rooms that may be returned to other functions or classes.
 */
public class RoomDataBase {
/**
 * NUMBER_OF_FLOORS reperesents number of floors in the hotel.
 */
  private static final int NUMBER_OF_FLOORS = 2;
  /**
   * ROOMS_PER_FLOOR represents the rooms per floor in the hotel.
   */
  private static final int ROOMS_PER_FLOOR = 20;

  /**
   * Checks if table exists in database, if it does not
   * it creates a table and then populates it with rooms.
   */
  public static void initializationOfRoomTable() {
    if (!doesTableExist()) {
      createRoomTable();
      populateRoomTable();
    }
  }

  /**
   * Populates the table with various rooms.
   */
  private static void populateRoomTable() {
    int numberOfOccupants = 0;
    for (int i = 1; i <= NUMBER_OF_FLOORS; i++) {
      for (int j = 0; j < ROOMS_PER_FLOOR; ++j) {
        int roomNumber = (i * 100) + j;
        String roomType = "Regular";
        String bedType = "Full";
        int bedQuantity = 2;
        int roomPrice = 50;
        if (j % 3 == 0) {
          roomType = "Smoking";
          bedType = "Full";
          bedQuantity = 2;
          roomPrice = 65;
        } else if (j % 4 == 0) {
          roomType = "Suite";
          bedType = "King";
          bedQuantity = 1;
          roomPrice = 100;
        }
        Room room = new Room(null, null, roomNumber + i, roomType, bedType, bedQuantity, roomPrice, numberOfOccupants);
        insertRoom(room);
      }
    }
  }

  /**
   * Checks if room table exists in the database.
   * 
   * @return true if table exists in database, false if it does not.
   */
  private static boolean doesTableExist() {
    String sql = "SELECT count(*) "
        + "FROM information_schema.tables "
        + "WHERE table_name = ?"
        + "LIMIT 1;";
    try (Connection conn = MysqlConnector.getConnection();) {
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

  /**
   * Creates Room table on the database.
   */
  private static void createRoomTable() {
    try (Connection conn = MysqlConnector.getConnection();) {
      final String createTable = "CREATE TABLE sql3511682.Room ("
          + "room_number INT NOT NULL PRIMARY KEY,"
          + "room_type VARCHAR(255) NOT NULL,"
          + "bed_type VARCHAR(255) NOT NULL,"
          + "bed_quantity INT NOT NULL,"
          + "room_price INT NOT NULL,"
          + "number_of_occupants INT NOT NULL,"
          + "last_name VARCHAR(255) NULL,"
          + "first_name VARCHAR(255) NULL)";
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(createTable);
      System.out.println("Room table created");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Inserts a room to the room table.
   * 
   * @param room The room to be inserted into the table.
   */
  public static void insertRoom(Room room) {
    if (!doesRoomExist(room.getRoomNumber())) {
      try (Connection conn = MysqlConnector.getConnection();) {
        String sql = "INSERT INTO Room VALUE (?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, room.getRoomNumber());
        pstmt.setString(2, room.getRoomType());
        pstmt.setString(3, room.getBedType());
        pstmt.setInt(4, room.getBedQuantity());
        pstmt.setInt(5, room.getPrice());
        pstmt.setInt(6, room.getnumberOfOccupants());
        pstmt.setString(7, room.getLastName());
        pstmt.setString(8, room.getFirstName());
        pstmt.executeUpdate();
        System.out.println("Room inserted to table");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Searches the Room table for the specified room number and removes it from the
   * table.
   * 
   * @param roomNumber an integer representing the room number of the room to be
   *                   removed from the table.
   */
  public static void removeRoomFromTable(int roomNumber) {
    if (doesRoomExist(roomNumber)) {
      String sql = "DELETE FROM Room WHERE room_number = ?";
      try (Connection conn = MysqlConnector.getConnection();) {
        PreparedStatement pstmt = conn.prepareStatement(sql);
        pstmt.setInt(1, roomNumber);
        pstmt.executeUpdate();
        System.out.println("Room removed successfully");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    } else {
      System.out.println("Room does not exist in database.");
    }
  }

  /**
   * Checks to see if row already exists in table.
   * 
   * @param roomNumber integer representing a room number which are the primary
   *                   keys of the room table.
   * @return true if the table already has that room inserted.
   */
  public static boolean doesRoomExist(int roomNumber) {
    String sql = "SELECT room_number FROM Room where room_number = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, roomNumber);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Searches the Room table for all rooms in the hotel.
   * 
   * @return array list consisting of all rooms in the hotel.
   */
  public static ArrayList<Room> getAllRooms() {
    ArrayList<Room> allRooms = new ArrayList<Room>();
    String sql = "SELECT room_number, room_type, bed_type, bed_quantity, room_price, number_of_occupants, last_name, first_name FROM Room";
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        Room room = new Room("last_name", "first_name", resultSet.getInt("room_number"),
            resultSet.getString("room_type"),
            resultSet.getString("bed_type"), resultSet.getInt("bed_quantity"), resultSet.getInt("room_price"),
            resultSet.getInt("number_of_occupants"));
        allRooms.add(room);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return allRooms;
  }

  /**
   * Searches the Room table for all rooms that are occupied.
   * 
   * @return array list of all occupied rooms.
   */
  public static ArrayList<Room> getAllOccupiedRooms() {
    ArrayList<Room> allRooms = new ArrayList<Room>();
    String sql = "SELECT room_number, room_type, bed_type, bed_quantity, room_price, number_of_occupants, last_name, first_name FROM Room WHERE number_of_occupants > 0";
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        Room room = new Room("null", "null", resultSet.getInt("room_number"), resultSet.getString("room_type"),
            resultSet.getString("bed_type"), resultSet.getInt("bed_quantity"), resultSet.getInt("room_price"),
            resultSet.getInt("number_of_occupants"));
        allRooms.add(room);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return allRooms;
  }

  /**
   * Searches the Room table for all rooms that are unoccupied.
   * 
   * @return array list of all unoccupied rooms.
   */
  public static ArrayList<Room> getAllUnoccupiedRooms() {
    ArrayList<Room> allRooms = new ArrayList<Room>();
    String sql = "SELECT room_number, room_type, bed_type, bed_quantity, room_price, number_of_occupants FROM Room WHERE last_name = NULL AND first_name IS NULL";
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        Room room = new Room("null", "null", resultSet.getInt("room_number"), resultSet.getString("room_type"),
            resultSet.getString("bed_type"), resultSet.getInt("bed_quantity"), resultSet.getInt("room_price"),
            resultSet.getInt("	number_of_occupants"));
        allRooms.add(room);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return allRooms;
  }

  /**
   * Uses the string given by converStringFilterToSQL method to search the room
   * table for all rooms meeting the filter criteria while also being unoccupied.
   * 
   * @param filter a string representing the users' chosen filter type. Passed in
   *               by the converStringFilterToSQL method.
   * @return an array list of Room objects that consist of only the rooms that met
   *         the filter criteria.
   */
  public static ArrayList<Room> filterRooms(String filter) {
    String sqlFilter = filter;
    String sql = String.format(
        "SELECT room_number, room_type, bed_type, bed_quantity, room_price, number_of_occupants FROM Room WHERE room_type = '%s' AND last_name IS NULL AND first_name IS NULL",
        sqlFilter);
    ArrayList<Room> filteredRooms = new ArrayList<Room>();
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        Room room = new Room("null", "null", resultSet.getInt("room_number"), resultSet.getString("room_type"),
            resultSet.getString("bed_type"), resultSet.getInt("bed_quantity"), resultSet.getInt("room_price"),
            resultSet.getInt("number_of_occupants"));
        filteredRooms.add(room);
      }
      return filteredRooms;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return filteredRooms;
  }

  /**
   * Converts the given string to the specific way the database looks for room
   * types.
   * 
   * @param filter a string representing the users' chosen filter type.
   * @return a string that the roomDataBase class can use to search through the
   *         database table.
   */
  public static String convertStringFilterToSQL(String filter) {
    String sqlFilter = "";
    switch (filter.toLowerCase()) {
      case "regular":
        sqlFilter = "Regular";
        break;
      case "smoking":
        sqlFilter = "Smoking";
        break;
      case "suite":
        sqlFilter = "Suite";
        break;
      default:
        System.out.println("invalid input");
        sqlFilter = "";
        break;
    }
    return sqlFilter;
  }

  /**
   * Creates and returns a room object with the information from the database. If
   * the room is not found on the database, returns
   * a null room object.
   * 
   * @param roomNumber integer representing the room number that the customer was
   *                   assigned to.
   * @return a null room object or an initialized room object with customer name
   *         and room information.
   */
  public static Room getSpecifiedRoom(int roomNumber) {
    String sql = String.format(
        "SELECT room_number, room_type, bed_type, bed_quantity, room_price, number_of_occupants, last_name, first_name FROM Room WHERE room_number = '%d'",
        roomNumber);
    Room specifiedRoom = null;
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        specifiedRoom = new Room("last_name", "first_name", resultSet.getInt("room_number"),
            resultSet.getString("room_type"),
            resultSet.getString("bed_type"), resultSet.getInt("bed_quantity"), resultSet.getInt("room_price"),
            resultSet.getInt("number_of_occupants"));
        return specifiedRoom;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return specifiedRoom;
  }
}
