package starprogrammers;

import java.util.*;
import javax.swing.JOptionPane;

public class Hotel {
/**
 * Hotel class serves as the class that allows users and manager/employees to get options on
 * what they can do.
 */
  private Hotel() {
  }

  /** @return returns an ArrayList of all currently available rooms. */
  public static void printAllRooms() {
    ArrayList<Room> allRooms = RoomDataBase.getAllRooms();
    String output = "";
    for(int i = 0; i < allRooms.size(); i++){
      output += allRooms.get(i);
      output += "\n";
    }
    JOptionPane.showMessageDialog(null, output, "All Rooms In Hotel", JOptionPane.PLAIN_MESSAGE);
  }

  /** @return returns an ArrayList of all current reservations. */
  public static void getReservations() {
    ReservationDataBase reservationManager = new ReservationDataBase();
    reservationManager.printDatabase();
  }

  /** @return returns an ArrayList of all currently reserved rooms. */
  public static void getReservedRooms() {
    ArrayList<Room> occupiedRooms = RoomDataBase.getAllOccupiedRooms();
    JOptionPane.showMessageDialog(null, occupiedRooms, "All Currently Reserved Rooms In Hotel", JOptionPane.PLAIN_MESSAGE);
  }
/**
 * uses ReservationDataBase class to search for rooms that need to be checked out
 * on current date.
 */
  public static void getRoomsToCheckOut() {
    ReservationDataBase reservationManager = new ReservationDataBase();
    ArrayList<Reservation> roomsThatNeedCheckOut = reservationManager.getReservationsThatNeedCheckOut();
    if(roomsThatNeedCheckOut.size() > 0){
      JOptionPane.showMessageDialog(null, roomsThatNeedCheckOut, "Rooms That Need To Be Checked-out", JOptionPane.PLAIN_MESSAGE);
    } else {
      JOptionPane.showMessageDialog(null, "Currently there are no rooms that need to be checked-out.", "No Rooms to Check-out", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * Generates a text-user-interface with various reports that a Manager might
   * want to view.
   *
   * @param scnr scanner object passed from the main method.
   */
  private static void generateManagerReport(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Back");
      System.out.println("1) All available rooms");
      System.out.println("2) All current reservations.");
      System.out.println(
          "3) All Rooms that need to be Checked-Out."); // Room XXX needs to check out.
      System.out.println("4) All reserved rooms"); // Room reserved by X from checkIn to Checkout.
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          printAllRooms();
          break;
        case 2: 
           getReservations();
          break;
        case 3:
          getRoomsToCheckOut();
          
                    break;
        case 4:
          getReservedRooms();
          break;
        default:
          System.out.println("Invalid input. Please select one of the following options.");
      }
    }

  }

/**
 * Presents a text user interface for customers.
 * @param scnr scanner object passed in by main.
 */
  private static void presentUserOptions(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Go back");
      System.out.println("1) Book a room");
      System.out.println("2) View reservation");
      System.out.println("3) Change reservation");
      System.out.println("4) Cancel reservation");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          User.bookRoom();
          break;
        case 2:
          User.viewReservation();
          break;
        case 3:
          User.changeReservation();
          break;
        case 4:
          User.cancelReservation();
          break;
        default:
          System.out.println("Invalid input. Try one of the following options: ");
          break;
      }
    }
  }

  /**
   * Presents a text user interface for employee options and manager reports.
   *
   * @param scnr object passed by main method.
   */
  private static void presentEmployeeOptions(Scanner scnr) {
    boolean exitFlag = false;
    while (!exitFlag) {
      System.out.println("");
      System.out.println("0) Go back");
      System.out.println("1) Generate manager reports");
      System.out.println("2) Change Customer Room");
      System.out.println("3) Cancel Customer Reservation");
      System.out.println("4) Check Custromer in");
      int userInput = scnr.nextInt();
      switch (userInput) {
        case 0:
          exitFlag = true;
          break;
        case 1:
          generateManagerReport(scnr);
          break;
        case 2:
          Manager.changeRoomReservation();
          break;
        case 3:
          Manager.cancelRoomReservation();
          break;
        case 4:
          Manager.checkCustomerIn();
          break;
        default:
          System.out.println("Invalid input. Please try one of the following options");
          break;
      }
    }
  }

  /**
   * Generates a text-user-interface with 2 options to select the user-type and 1
   * option to * quit
   * the program.
   */
  public static void main(String[] args) {
    RoomDataBase.initializationOfRoomTable();
    HotelGUI.OpenHotelMenu();
  }
}
