package starprogrammers;

import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.time.LocalDate;

public class Reservation {
  /** Represents customer name */
  private String customerFirstName;

  private String customerLastName;
  /** Represents customer age */
  private int customerAge;
  /** Represents customer payment info */
  private String customerPaymentInfo;
  /** Represents customer email */
  private String customerEmail;
  /** Represents number of occupants in room */
  private int numberOfOccupants;

  /** Represents check in date */
  private LocalDate checkIn;
  /** Represents check out date */
  private LocalDate checkOut;

  private int roomNumber;
  /**
   * Constructs a Reservation with customer information.
   *
   * @param customerName the customer booking room
   * @param customerAge the customer's age
   * @param customerPaymentInfo the customer's payment info
   * @param customerEmail the customer's email
   * @param numberOfOccupants the number of occupants in a room
   * @param checkIn Customer's check in date.
   * @param checkOut Customer's check out date.
   */
  Reservation(
      String lastName,
      String firstName,
      int customerAge,
      String customerPaymentInfo,
      String customerEmail,
      int numberOfOccupants,
      int roomNumber,
      LocalDate checkIn,
      LocalDate checkOut) {
    this.customerLastName = lastName;
    this.customerFirstName = firstName;
    this.customerAge = customerAge;
    this.customerPaymentInfo = customerPaymentInfo;
    this.customerEmail = customerEmail;
    this.numberOfOccupants = numberOfOccupants;
    this.checkIn = checkIn;
    this.checkOut = checkOut;
    this.roomNumber = roomNumber;
  }

  @Override
  public String toString() {
    return customerLastName
        + " "
        + customerFirstName
        + " has a confirmed reservation for room number "
        + roomNumber
        + ". Check in date of "
        + checkIn
        + " and check out: "
        + checkOut;
  }

  /** TODO */
  public void sendConfirmation() {}

  /**
   * Creates a reservation table
   *
   * @param conn connection to database
   */
  // public void createReservationTable(Connection conn) {
  //   if (!doesTableExist(conn)) {
  //     try {
  //       final String createTable =
  //           "CREATE TABLE sql3507015.Reservation ("
  //               + "customer_name VARCHAR(255) NOT NULL,"
  //               + "customer_age INT(255) NOT NULL,"
  //               + "customer_payment_info VARCHAR(255) NOT NULL,"
  //               + "customer_email VARCHAR(255) NOT NULL,"
  //               + "number_of_occupants INT(255) NOT NULL,"
  //               + "check_in_year INT(255) NOT NULL,"
  //               + "check_in_month INT(255) NOT NULL,"
  //               + "check_in_date INT(255) NOT NULL,"
  //               + "check_out_year INT(255) NOT NULL,"
  //               + "check_out_month INT(255) NOT NULL,"
  //               + "check_out_date INT(255) NOT NULL)";

  //       Statement pstmt = conn.createStatement();

  //       pstmt.executeUpdate(createTable);

  //       System.out.println("Table created");
  //     } catch (SQLException e) {
  //       e.printStackTrace();
  //     }
  //   }
  // }

  // /**
  //  * Checks to see if table already exists
  //  *
  //  * @param conn connection to database
  //  */
  // private boolean doesTableExist(Connection conn) {
  //   try {
  //     PreparedStatement preparedStatement =
  //         conn.prepareStatement(
  //             "SELECT count(*) "
  //                 + "FROM information_schema.tables "
  //                 + "WHERE table_name = ?"
  //                 + "LIMIT 1;");
  //     preparedStatement.setString(1, "Reservation");

  //     ResultSet resultSet = preparedStatement.executeQuery();
  //     resultSet.next();
  //     return resultSet.getInt(1) != 0;
  //   } catch (SQLException e) {
  //     e.printStackTrace();
  //   }
  //   return false;
  // }

  // /**
  //  * Inserts data into reservation table
  //  *
  //  * @param conn connection to database
  //  */
  // public void insertReservation(Connection conn) {
  //   try (conn) {
  //     String SQL = "INSERT INTO Reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
  //     PreparedStatement pstmt = conn.prepareStatement(SQL);
  //     pstmt.setString(1, customerName);
  //     pstmt.setInt(2, customerAge);
  //     pstmt.setString(3, customerPaymentInfo);
  //     pstmt.setString(4, customerEmail);
  //     pstmt.setInt(5, numberOfOccupants);
  //     pstmt.setInt(6, getYear(checkIn));
  //     pstmt.setInt(7, getMonth(checkIn));
  //     pstmt.setInt(8, getDate(checkIn));
  //     pstmt.setInt(9, getYear(checkOut));
  //     pstmt.setInt(10, getMonth(checkOut));
  //     pstmt.setInt(11, getDate(checkOut));

  //     pstmt.executeUpdate();

  //     System.out.println("Inserted records into the table...");
  //   } catch (SQLException e) {
  //     e.printStackTrace();
  //   }
  // }
}
