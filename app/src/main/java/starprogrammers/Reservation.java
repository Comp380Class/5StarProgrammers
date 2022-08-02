package starprogrammers;

import java.util.Calendar;
import java.util.GregorianCalendar;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Reservation {
    /**
     * Represents customer name
     */
    private String customerName;
    /**
     * Represents customer age
     */
    private int customerAge;
    /**
     * Represents customer payment info
     */
    private String customerPaymentInfo;
    /**
     * Represents customer email
     */
    private String customerEmail;
    /**
     * Represents number of occupants in room 
     */
    private int numberOfOccupants;

    /**
     * Represents check in date
     */
    private Calendar checkIn;
    /**
     * Represents check out date
     */
    private Calendar checkOut;

    /**
     * Constructs a Reservation with customer information.
     * @param customerName the customer booking room
     * @param customerAge the customer's age
     * @param customerPaymentInfo the customer's payment info
     * @param customerEmail the customer's email
     * @param numberOfOccupants the number of occupants in a room
     * @param checkInYear the check in year
     * @param checkInMonth the check in month
     * @param checkInDate the check in date
     * @param checkOutYear the check out year
     * @param checkOutMonth the check out month
     * @param checkOutDate the check out date
     */
    Reservation(String customerName, int customerAge, String customerPaymentInfo, String customerEmail, int numberOfOccupants, int checkInYear, int checkInMonth, int checkInDate, 
    int checkOutYear, int checkOutMonth, int checkOutDate){
        this.customerName = customerName;
        this.customerAge = customerAge;
        this.customerPaymentInfo = customerPaymentInfo;
        this.customerEmail = customerEmail;
        this.numberOfOccupants = numberOfOccupants;
        this.checkIn = new GregorianCalendar(checkInYear, checkInMonth, checkInDate);
        this.checkOut = new GregorianCalendar(checkOutYear, checkOutMonth, checkOutDate);
    }

    /**
     * TODO
     */
    public void sendConfirmation(){
        
    }

    /**
     * Gets the year of check in or check out 
     * @param cal calendar with year information
     * @return the calendar year
     */
    private int getYear(Calendar cal){
        return cal.get(Calendar.YEAR);
    }

    /**
     * Gets the month of check in or check out 
     * @param cal calendar with month information
     * @return the calendar month
     */

    private int getMonth(Calendar cal){
        return cal.get(Calendar.MONTH);
    }
    
    /**
     * Gets the date of check in or check out 
     * @param cal calendar with date information
     * @return the calendar date
     */

    private int getDate(Calendar cal){
        return cal.get(Calendar.DATE);
    }

    /**
     * Creates a reservation table
     * @param conn connection to database
     */
    public void createReservationTable(Connection conn){
        if(!doesTableExist(conn)){
            try{
                final String createTable =
                "CREATE TABLE sql3507015.Reservation ("
                    + "customer_name VARCHAR(255) NOT NULL,"
                    + "customer_age INT(255) NOT NULL,"
                    + "customer_payment_info VARCHAR(255) NOT NULL,"
                    + "customer_email VARCHAR(255) NOT NULL,"
                    + "number_of_occupants INT(255) NOT NULL,"
                    + "check_in_year INT(255) NOT NULL,"
                    + "check_in_month INT(255) NOT NULL,"
                    + "check_in_date INT(255) NOT NULL,"
                    + "check_out_year INT(255) NOT NULL,"
                    + "check_out_month INT(255) NOT NULL,"
                    + "check_out_date INT(255) NOT NULL)";

                    Statement pstmt = conn.createStatement();

                    pstmt.executeUpdate(createTable);
          
                    System.out.println("Table created");
            } catch(SQLException e){
                e.printStackTrace();
            }
        }
    }

     /**
     * Checks to see if table already exists
     * @param conn connection to database
     */
    private boolean doesTableExist(Connection conn){
        try{
            PreparedStatement preparedStatement = conn.prepareStatement("SELECT count(*) "
              + "FROM information_schema.tables "
              + "WHERE table_name = ?"
              + "LIMIT 1;");
            preparedStatement.setString(1, "Reservation");
        
            ResultSet resultSet = preparedStatement.executeQuery();
            resultSet.next();
            return resultSet.getInt(1) != 0;
        } catch(SQLException e){
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Inserts data into reservation table
     * @param conn connection to database
     */
    public void insertReservation(Connection conn){
        try(conn) {		 
        String SQL = "INSERT INTO Reservation VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
        PreparedStatement pstmt = conn.prepareStatement(SQL);
        pstmt.setString(1, customerName);
        pstmt.setInt(2, customerAge);
        pstmt.setString(3, customerPaymentInfo);
        pstmt.setString(4, customerEmail);
        pstmt.setInt(5, numberOfOccupants);
        pstmt.setInt(6, getYear(checkIn));
        pstmt.setInt(7, getMonth(checkIn));
        pstmt.setInt(8, getDate(checkIn));
        pstmt.setInt(9, getYear(checkOut));
        pstmt.setInt(10, getMonth(checkOut));
        pstmt.setInt(11, getDate(checkOut));

        pstmt.executeUpdate();

         System.out.println("Inserted records into the table...");   	  
      } catch (SQLException e) {
         e.printStackTrace();
      } 
   }
}

