package starprogrammers;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class ReservationDataBase {
    ReservationDataBase(){}
    
    /**
     * Creates a reservation table
     */
    public void createReservationTable(){
        if(!doesTableExist()){
            try(Connection conn = MysqlConnector.getConnection();){
                final String createTable =
                "CREATE TABLE sql3511682.Reservation ("
                    + "reservation_id VARCHAR(255) NOT NULL,"
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
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * Checks to see if table already exists
     */
    private boolean doesTableExist(){
        String sql = "SELECT count(*) "
        + "FROM information_schema.tables "
        + "WHERE table_name = ?"
        + "LIMIT 1;";
        try(Connection conn = MysqlConnector.getConnection();){
            PreparedStatement pstmt = conn.prepareStatement(sql);

            pstmt.setString(1, "Reservation");
        
            ResultSet resultSet = pstmt.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) != 0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Checks to see if row in table already exists
     * @param firstName user's first name 
     * @param lastName user's last name
     */
    private boolean doesRowExist(String firstName, String LastName){
        String sql = "SELECT first_name FROM Reservation WHERE first_name = ? AND last_name = ?";
        try(Connection conn = MysqlConnector.getConnection();){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, firstName);
            pstmt.setString (2, LastName);
            ResultSet rs = pstmt.executeQuery();
            if(rs.next()){
                System.out.println("Already exists in database");
                return true;
            }
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }


    /**
     * Inserts data into reservation table
     * @param firstName
     * @param lastName
     * @param customerAge
     * @param customerPaymentInfo
     * @param customerEmail
     * @param totalOccupants
     * @param roomNumber
     * @param checkIn
     * @param checkOut
     */
    public void insertReservation(String reservationId, String firstName, String lastName, int customerAge,
        String customerPaymentInfo, String customerEmail, int totalOccupants, 
        int roomNumber,Date checkIn, Date checkOut){
        if(!doesRowExist(firstName,lastName)){
        try(Connection conn = MysqlConnector.getConnection();) {      
            String SQL = "INSERT INTO Reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement pstmt = conn.prepareStatement(SQL);
            pstmt.setString(1, reservationId);
            pstmt.setString(2, lastName);
            pstmt.setString(3, firstName);
            pstmt.setInt(4, customerAge);
            pstmt.setString(5, customerPaymentInfo);
            pstmt.setString(6, customerEmail);
            pstmt.setInt(7, totalOccupants);
            pstmt.setInt(8, roomNumber);
            pstmt.setDate(9, checkIn);
            pstmt.setDate(10, checkOut);

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
    public void printDatabase(){
        String sql1 = "SELECT reservation_id, first_name, last_name, payment_info, email, "
        + "total_occupants, room_number, check_in, check_out FROM Reservation";
        try(Connection conn = MysqlConnector.getConnection();) {     
            Statement stmt = conn.createStatement();
            ResultSet resultSet = stmt.executeQuery(sql1);
            System.out.println("Last First\tPayment Info\tEmail\t\t\t# Occupants\tRoom #\tCheck In\tCheck Out");
                while(resultSet.next()){
                    System.out.println(
                    resultSet.getString("reservation_id") + "\t" +    
                    resultSet.getString("last_name") + " " + 
                    resultSet.getString("first_name")  + "\t" +
                    resultSet.getString("payment_info")  + "\t" +
                    resultSet.getString("email") + "\t\t" +
                    resultSet.getInt("total_occupants") + "\t\t" + 
                    resultSet.getInt("room_number") + "\t" + 
                    resultSet.getDate("check_in") + "\t" + 
                    resultSet.getDate("check_out"));
                }
        } catch(SQLException e){
            e.printStackTrace();
        }
   }

    /**
     * Updates check in date
     * @param currentDate
     * @param newDate
     * @param roomNumber
     */
    public void modifyCheckIn(Date currentDate, Date newDate, int roomNumber){
        String sql1 = "UPDATE Reservation SET check_in = ? WHERE room_number = ?";
        try(Connection conn = MysqlConnector.getConnection();) {     
            PreparedStatement pstmt = conn.prepareStatement(sql1);
            pstmt.setDate(1, newDate);
            pstmt.setInt(2, roomNumber);
            pstmt.executeUpdate();
            System.out.println("Check in updated from " + currentDate + " to " +
            newDate + " successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
   }

    /**
    * Updates check out date
    * @param currentDate
    * @param newDate
    * @param roomNumber
    */
    public void modifyCheckOut(Date currentDate, Date newDate, int roomNumber){
        String sql = "UPDATE Reservation SET check_out = ? WHERE room_number = ?";
        try(Connection conn = MysqlConnector.getConnection();){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setDate(1, newDate);
            pstmt.setInt(2, roomNumber);
            pstmt.executeUpdate();
            System.out.println("Check out updated from " + currentDate + " to " +
            newDate + " successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
   }

    /**
     * Updates room number
     * @param currentRoom
     * @param newRoom
     */
    public void modifyRoomNumber(int currentRoom, int newRoom){
        String sql = "UPDATE Reservation SET room_number = ? WHERE room_number = ?";
        try(Connection conn = MysqlConnector.getConnection();){
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, newRoom);
            pstmt.setInt(2, currentRoom);
            pstmt.executeUpdate();
            System.out.println("Room number updated from " + currentRoom + " to " +
            newRoom + " successfully");
        } catch(SQLException e){
            e.printStackTrace();
        }
   }

    /**
     * Removes reservation from database
     */
    public void cancelReservation(){
        String sql = "delete from Reservation where reservation_id=?";
        try (Connection conn = MysqlConnector.getConnection();){
        PreparedStatement pstmt = conn.prepareStatement(sql);
      
        pstmt.setInt(1, 2);
        pstmt.executeUpdate();
      
        System.out.println("Reservation deleted successfully");
        } catch (SQLException e) {
            e.printStackTrace();
        }
  }
}
