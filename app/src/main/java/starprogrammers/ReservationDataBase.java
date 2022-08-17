package starprogrammers;


/**
 * 08/09/2022
 * Erin Maldonado
 * ReservationDataBase class is used to create a database,
 * insert, remove and print from database. 
 * 
 * createReservationTable() will create a table, if one does 
 * not yet exist. Also uses auto_increment feature to create
 * reservation id for each new reservation. 
 * 
 * insertReservation(Reservation r) takes a reservation and 
 * inputs the reservation to the database. 
 * 
 */
 
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.ArrayList;

public class ReservationDataBase {
  ReservationDataBase() {
  }

  /**
   * Creates a reservation table
   */
  public void createReservationTable() {
    if (!doesTableExist()) {
      try (Connection conn = MysqlConnector.getConnection();) {
        final String createTable = "CREATE TABLE sql3511682.Reservation ("
            + "reservation_key INT PRIMARY KEY NOT NULL AUTO_INCREMENT,"
            + "last_name VARCHAR(255) NOT NULL,"
            + "first_name VARCHAR(255) NOT NULL,"
            + "age INT(255) NOT NULL,"
            + "payment_info VARCHAR(255) NOT NULL,"
            + "email VARCHAR(255) NOT NULL,"
            + "total_occupants INT(255) NOT NULL,"
            + "room_number INT(255) NOT NULL,"
            + "check_in DATE NOT NULL,"
            + "check_out DATE NOT NULL)";

        Statement stmt = conn.createStatement();

        stmt.executeUpdate(createTable);

        System.out.println("Table created");
      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Checks to see if table already exists
   */
  private boolean doesTableExist() {
    String sql = "SELECT count(*) "
        + "FROM information_schema.tables "
        + "WHERE table_name = ?"
        + "LIMIT 1;";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setString(1, "Reservation");

      ResultSet resultSet = pstmt.executeQuery();
      resultSet.next();
      return resultSet.getInt(1) != 0;
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Checks to see if row in table already exists
   * 
   * @param firstName user's first name
   * @param lastName  user's last name
   */
  private boolean doesRowExist(String firstName, String LastName) {
    String sql = "SELECT first_name FROM Reservation WHERE first_name = ? AND last_name = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setString(1, firstName);
      pstmt.setString(2, LastName);
      ResultSet rs = pstmt.executeQuery();
      if (rs.next()) {
        System.out.println("Already exists in database");
        return true;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return false;
  }

  /**
   * Inserts data into reservation table
   * 
   * @param r Reservation object.
   */
  public void insertReservation(Reservation r) {
    if (!doesRowExist(r.getFirstName(), r.getLastName())) {
      try (Connection conn = MysqlConnector.getConnection();) {
        String SQL = "INSERT INTO Reservation (last_name, first_name, age,"
            + " payment_info, email, total_occupants, room_number,"
            + " check_in, check_out)VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, r.getLastName());
        pstmt.setString(2, r.getFirstName());
        pstmt.setInt(3, r.getCustomerAge());
        pstmt.setString(4, r.getCustomerPaymentInfo());
        pstmt.setString(5, r.getCustomerEmail());
        pstmt.setInt(6, r.getTotalOccupants());
        pstmt.setInt(7, r.getRoomNumber());
        pstmt.setDate(8, r.getCheckIn());
        pstmt.setDate(9, r.getCheckOut());

        pstmt.executeUpdate();
        System.out.println("Inserted records into the table...");

      } catch (SQLException e) {
        e.printStackTrace();
      }
    }
  }

  /**
   * Prints all data in reservation table
   */
  public void printDatabase() {
    String sql1 = "SELECT reservation_key, first_name, last_name, payment_info, email, "
        + "total_occupants, room_number, check_in, check_out FROM Reservation";
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql1);
      System.out.println("ID\tLast First\tPayment Info\tEmail\t\t\t# Occupants\tRoom #\tCheck In\tCheck Out");
      while (resultSet.next()) {
        System.out.println(
            resultSet.getString("reservation_key") + "\t" +
                resultSet.getString("last_name") + " " +
                resultSet.getString("first_name") + "\t" +
                resultSet.getString("payment_info") + "\t" +
                resultSet.getString("email") + "\t\t" +
                resultSet.getInt("total_occupants") + "\t\t" +
                resultSet.getInt("room_number") + "\t" +
                resultSet.getDate("check_in") + "\t" +
                resultSet.getDate("check_out"));
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates check in date
   * 
   * @param currentDate
   * @param newDate
   * @param roomNumber
   */
  public void modifyCheckIn(Date currentDate, Date newDate, int roomNumber) {
    String sql1 = "UPDATE Reservation SET check_in = ? WHERE room_number = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql1);
      pstmt.setDate(1, newDate);
      pstmt.setInt(2, roomNumber);
      pstmt.executeUpdate();
      System.out.println("Check in updated from " + currentDate + " to " +
          newDate + " successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates check out date
   * 
   * @param currentDate
   * @param newDate
   * @param roomNumber
   */
  public void modifyCheckOut(Date currentDate, Date newDate, int roomNumber) {
    String sql = "UPDATE Reservation SET check_out = ? WHERE room_number = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setDate(1, newDate);
      pstmt.setInt(2, roomNumber);
      pstmt.executeUpdate();
      System.out.println("Check out updated from " + currentDate + " to " +
          newDate + " successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Updates room number
   * 
   * @param currentRoom
   * @param newRoom
   */
  public void modifyRoomNumber(int currentRoom, int newRoom) {
    String sql = "UPDATE Reservation SET room_number = ? WHERE room_number = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, newRoom);
      pstmt.setInt(2, currentRoom);
      pstmt.executeUpdate();
      System.out.println("Room number updated from " + currentRoom + " to " +
          newRoom + " successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Removes reservation from database
   */
  public void cancelReservation(int reservationNumber) {
    String sql = "delete from Reservation where reservation_key=?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);

      pstmt.setInt(1, 2);
      pstmt.executeUpdate();

      System.out.println("Reservation deleted successfully");
    } catch (SQLException e) {
      e.printStackTrace();
    }
  }

  /**
   * Searches Reservation table for a specific reservation key, returns that
   * reservation if found. Returns null if reservation did not exist in database.
   * 
   * @param reservationID integer representing the reservation key.
   * @return reservation object that is initialized with customer and room
   *         information if reservation existed in database. Null reservation
   *         object if it did not exist.
   */
  public static Reservation getSpecificReservation(int reservationID) {
    String sql = String.format(
        "SELECT id, first_name, last_name, payment_info, email, "
            + "age, total_occupants, room_number, check_in, check_out FROM Reservation WHERE reservation_key = %d",
        reservationID);
    Reservation specifiedReservation = null;
    try (Connection conn = MysqlConnector.getConnection();) {
      Statement stmt = conn.createStatement();
      ResultSet resultSet = stmt.executeQuery(sql);
      while (resultSet.next()) {
        specifiedReservation = new Reservation(resultSet.getString("last_name"), resultSet.getString("first_name"),
            resultSet.getInt("age"),
            resultSet.getString("payment_info"),
            resultSet.getString("email"), resultSet.getInt("total_occupants"), resultSet.getInt("room_number"),
            resultSet.getDate("check_in").toLocalDate(), resultSet.getDate("check_out").toLocalDate());
        return specifiedReservation;
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return specifiedReservation;

  }
/**
 * Searches Reservation table for specific reservation using reservation key.
 * @param reservationKey int representing the reservation key that was given to the customer when he reserved a room.
 * @return true if the reservation exists in the table, false if it does not.
 */
  public boolean doesReservationExist(int reservationKey) {
    String sql = "SELECT first_name FROM Reservation WHERE reservation_key = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setInt(1, reservationKey);
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
   * Searches Reservation table for all reservations that need to be checked out on the current date.
   * @return array list of Reservation objects that need to be checked out. 
   */
  public ArrayList<Reservation> getReservationsThatNeedCheckOut() {
    ArrayList<Reservation> roomsToBeCheckedOut = new ArrayList<Reservation>();
    String sql = "SELECT reservation_key, first_name, last_name, payment_info, email, "
    + "age, total_occupants, room_number, check_in, check_out FROM Reservation WHERE check_out = ?";
    try (Connection conn = MysqlConnector.getConnection();) {
      PreparedStatement pstmt = conn.prepareStatement(sql);
      pstmt.setDate(1, java.sql.Date.valueOf(LocalDate.now()));
      ResultSet resultSet = pstmt.executeQuery();
      if (resultSet.next()) {
        Reservation reservation = new Reservation(resultSet.getString("last_name"), resultSet.getString("first_name"),
            resultSet.getInt("age"),
            resultSet.getString("payment_info"),
            resultSet.getString("email"), resultSet.getInt("total_occupants"), resultSet.getInt("room_number"),
            resultSet.getDate("check_in").toLocalDate(), resultSet.getDate("check_out").toLocalDate());
        roomsToBeCheckedOut.add(reservation);
      }
    } catch (SQLException e) {
      e.printStackTrace();
    }
    return roomsToBeCheckedOut;
  }

   /**
   * Uses reservation key to get a specific reservation
   * @param reservationKey
   * @return Reservation based on reservationKey
   */
  public Reservation getReservation(int reservationKey){
    String sql = "select * from Reservation";
    try (Connection conn = MysqlConnector.getConnection();){
        Statement stmt = conn.prepareStatement(sql);
        ResultSet rs = stmt.executeQuery(sql);
        rs.absolute(reservationKey);
        String lastName = rs.getString(2);
        String firstName = rs.getString(3);
        int customerAge = rs.getInt(4);
        String customerPaymentInfo = rs.getString(5);
        String customerEmail = rs.getString(6);
        int totalOccupants = rs.getInt(7);
        int roomNumber = rs.getInt(8);
        Date checkInDate = rs.getDate(9);
        Date checkOutDate = rs.getDate(10);
        LocalDate checkIn = LocalDate.ofInstant(checkInDate.toInstant(), ZoneId.systemDefault());
        LocalDate checkOut = LocalDate.ofInstant(checkOutDate.toInstant(), ZoneId.systemDefault());
        Reservation res = new Reservation(lastName, firstName, 
        customerAge, customerPaymentInfo, customerEmail, 
        totalOccupants, roomNumber, checkIn, checkOut);
        return res;
    } catch(SQLException e){
        e.printStackTrace();
        return null;
    }
  }
}
