package starprogrammers;

import java.time.LocalDate;
import java.util.ArrayList;
//import java.sql.*;
//import java.util.logging.Level;
//import java.util.logging.Logger;
//import java.util.Date;
import java.util.Scanner;

/**
 * A user is able to access and the necessary functions of the hotel such as
 * search for the type of room they desire,
 * book a reservation, and view, change or cancel their reservation
 */
public class User {
  /**
   * user selects a room from the list of available rooms displayed by program,
   * and a new reservation is made under the user's name
   */
  public static void bookRoom() {
    String firstName, lastName, emailAddr, payment;
    int age, partyNum;
    LocalDate checkIn, checkOut;

    Scanner input = new Scanner(System.in);
    // user inputs check in and check out dates then selects type of room

    // TODO: Create GUI to allow user to input dates and select a type of room

    // program displays whether room is available, if so prompt user for info(name,
    // age, email address, # of people, payment, check in & out dates)
    System.out.println("Enter check in date(YYYY MM DD)");
    int checkInYear = input.nextInt();
    int checkInMonth = input.nextInt();
    int checkInDay = input.nextInt();
    checkIn = LocalDate.of(checkInYear, checkInMonth, checkInDay);
    System.out.println("Enter check in date(YYYY MM DD)");
    int checkOutYear = input.nextInt();
    int checkOutMonth = input.nextInt();
    int checkOutDay = input.nextInt();
    checkOut = LocalDate.of(checkOutYear, checkOutMonth, checkOutDay);
    System.out.println("Enter first name: ");
    firstName = input.next();
    System.out.println("Enter last name: ");
    lastName = input.next();
    System.out.println("Enter age: ");
    age = input.nextInt();
    System.out.println("Enter number of people in party: ");
    partyNum = input.nextInt();
    System.out.println("Enter email address: ");
    emailAddr = input.next();
    System.out.println("Enter payment info: ");
    payment = input.next();
    //
    String searchFilter = searchForRoomType();
    int roomNumber = selectRoom(input, searchFilter);
    Reservation newReservation = new Reservation(lastName, firstName, age, payment, emailAddr, partyNum, roomNumber,
        checkIn, checkOut);
    System.out.println(newReservation); // Instead of print, send to the class that send the reservation to the DB.
    // if all prompts successfully completed, create new reservation and email
    // confirmation to user
  }

  /**
   * selectRoom presents the user with the rooms available for renting. The user
   * picks their preferred room by entering its room number.
   *
   * @param Scanner object passed by bookRoom method.
   * @return integer value corresponding to the room number that the customer
   *         wants to stay in.
   */
  public static int displayFilteredRooms(Scanner input, ArrayList<Room> filteredRooms) {
    for (Room room : filteredRooms) {
      System.out.println(room);
    }
    int roomNumberSelected = input.nextInt();
    return verifyRoomSelection(roomNumberSelected, filteredRooms);

  }

  /**
   * Checks to see if the room number selected by the user is a valid room from
   * the filtered rooms list.
   * 
   * @param roomNumberSelected integer representing the room number that the user
   *                           has chosen to book.
   * @param filteredRooms      array list of room objects that represent the rooms
   *                           available with the filter type the user chose.
   * @return returns the user input if the room number selected is a valid room
   *         number from the filtered rooms list. Returns 1 otherwise.
   */
  private static int verifyRoomSelection(int roomNumberSelected, ArrayList<Room> filteredRooms) {
    for (Room room : filteredRooms) {
      if (roomNumberSelected == room.getRoomNumber()) {
        int userInput = roomNumberSelected;
        return userInput;
      }
    }
    return 1;
  }

  /**
   * 
   * @param input        scanner object passed in by the bookRoom method.
   * @param searchFilter String representing the filter the user would like to
   *                     apply to his search.
   * @return integer representing the room number the user chose.
   */
  private static int selectRoom(Scanner input, String searchFilter) {
    ArrayList<Room> filteredRooms = RoomDataBase.filterRooms(searchFilter);
    int roomNumber = 0;
    System.out.println("Select your preferred room by entering the room number");
    while (roomNumber == 0) {
      roomNumber = displayFilteredRooms(input, filteredRooms);
      if (roomNumber == 1) {
        System.out.println("Invalid selection. Please select one of the following: ");
        roomNumber = 0;
      }
    }
    return roomNumber;
  }

  /**
   * Method that asks the user to input one of 3 possible filter types. Returns
   * the string
   * corresponding to the chosen filter type.
   * 
   * @return String representing the filter type the user would like to be
   *         applied.
   */
  static String searchForRoomType() {
    String roomType;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter type of room: Regular, Smoking, or Suite");
    roomType = "";
    while (roomType.equals("")) {
      roomType = input.next();
      roomType = RoomDataBase.convertStringFilterToSQL(roomType);
    }
    return roomType;
  }

  /**
   * user inputs identifying data(name?, password?, payment info?), if successful
   * then their reservation is deleted from the database(email confirmation?)
   */
  static void cancelReservation() {
    String name;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();

    // TODO: implement access to database
  }

  /**
   * user inputs identifying data(name?, password?, payment info?), if successful
   * then they are given the option to request a different type of room
   */
  static void changeReservation() {
    String name, newRoom;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();
    System.out.print("Enter type of room you would like your new room to be: ");
    newRoom = input.next();

    // TODO: implement access to database
  }

  /**
   * user inputs identifying data(name?, password?, payment info?), if successful
   * then information regarding their reservation is displayed
   */
  static void viewReservation() {
    String name;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();

    // TODO: implement access to database to display reservation info
  }
}

class Manager extends User {

  /**
   * user selects reservation from database then selects an unbooked room to
   * replace current room
   */
  static void changeRoomReservation() {
    String name;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();

    // TODO: implement access to database
  }

  /**
   * user selects reservation from database, reservation is then deleted from
   * database
   */
  static void cancelRoomReservation() {
    String name;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();

    // TODO: implement access to database
  }

  /**
   * user selects reservation (or booked room?) and change occupied(or checked-in
   * flag?) to true
   */
  static void checkCustomerIn() {
    String name;
    Scanner input = new Scanner(System.in);
    System.out.print("Enter name: ");
    name = input.next();

    // TODO: implement access to database
  }
}
