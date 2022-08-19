package starprogrammers;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Scanner;
import java.time.format.DateTimeFormatter;
import javax.swing.JOptionPane;

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
    String userInput, fullName, firstName, lastName, emailAddr, payment;
    int age, partyNum, spaceIndex;
    LocalDate checkIn, checkOut;
    DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

    // program displays whether room is available, if so prompt user for info(name,
    // age, email address, # of people, payment, check in & out dates)
    userInput = JOptionPane.showInputDialog("Enter check in date(DD/MM/YYYY)");
    checkIn = LocalDate.parse(userInput, formatter);    
    userInput = JOptionPane.showInputDialog("Enter check out date(DD/MM/YYYY)");
    checkOut = LocalDate.parse(userInput, formatter);    
	  fullName = JOptionPane.showInputDialog("Enter first and last name");
    spaceIndex = fullName.lastIndexOf(' ');
    firstName = fullName.substring(0, spaceIndex);
    lastName = fullName.substring(spaceIndex+1);
    age = Integer.parseInt(JOptionPane.showInputDialog("Enter age"));
    partyNum = Integer.parseInt(JOptionPane.showInputDialog("Enter number of people in party"));
    emailAddr = JOptionPane.showInputDialog("Enter email address");
    payment= JOptionPane.showInputDialog("Enter payment information");
    
    String searchFilter = searchForRoomType();
    int roomNumber = selectRoom(searchFilter);
    Reservation newReservation = new Reservation(lastName, firstName, age, payment, emailAddr, partyNum, roomNumber,
        checkIn, checkOut);
    ReservationDataBase reservationManager = new ReservationDataBase();
    int reservationKey = reservationManager.insertReservation(newReservation);
    Room customersRoom = RoomDataBase.getSpecifiedRoom(newReservation.getRoomNumber());
    Email confirmationEmail = new Email(newReservation, customersRoom, reservationKey);
    confirmationEmail.sendEmail("reserve");
    // if all prompts successfully completed, create new reservation and email
    // confirmation to user
  }

  /**
   * selectRoom presents the user with the rooms available for renting. The user
   * picks their preferred room by entering its room number.
   *
   * @return integer value corresponding to the room number that the customer
   *         wants to stay in.
   */
  public static int displayFilteredRooms(ArrayList<Room> filteredRooms) {
    int roomNumberSelected;
    String roomSelected;
    String first;
    Object choice;
    Object[] options = new Object[filteredRooms.size()];
    for (int i = 0; i < filteredRooms.size(); i++) {
      options[i] = filteredRooms.get(i).toString();
    }
    first = (String) options[0];
    choice = JOptionPane.showInputDialog(null, "Please select the room you would like to book:", "Book Room", JOptionPane.QUESTION_MESSAGE, null, options, first);
    roomSelected = String.valueOf(choice);
    roomNumberSelected = Integer.parseInt( roomSelected.substring(13, 16));
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
   * @param searchFilter String representing the filter the user would like to
   *                     apply to his search.
   * @return integer representing the room number the user chose.
   */
  private static int selectRoom(String searchFilter) {
    ArrayList<Room> filteredRooms = RoomDataBase.filterRooms(searchFilter);
    int roomNumber = 0;
    roomNumber = displayFilteredRooms(filteredRooms);
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
    String first = "Regular";
    Object choice;
    Object[] options = {"Regular" , "Smoking" , "Suite"};
    choice = JOptionPane.showInputDialog(null, "Please select your preferred type of room:", "Room Selection", JOptionPane.QUESTION_MESSAGE, null, options, first);
    roomType = String.valueOf(choice);
    roomType = RoomDataBase.convertStringFilterToSQL(roomType);
    return roomType;
  }

  /**
   *Allows user to cancel their reservation if their reservation key and last name match an
   * entry in the Reservation table.
   */
  static void cancelReservation() {
    ReservationDataBase reservationManager = new ReservationDataBase();
    int reservationKey;
    reservationKey = Integer.parseInt(JOptionPane.showInputDialog("Enter your reservation number:"));
    if (reservationManager.doesReservationExist(reservationKey)) {
      reservationManager.cancelReservation(reservationKey);
    } else {
      JOptionPane.showMessageDialog(null, "Reservation does not exist. Please try again or contact customer service.", "Unable to find reservation", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * user inputs identifying data(name?, password?, payment info?), if successful
   * then they are given the option to request a different type of room
   */
  static void changeReservation() {
    int reservationNum, newRoomNum;
    Reservation res;
    ReservationDataBase reservationManager = new ReservationDataBase();
    reservationNum = Integer.parseInt(JOptionPane.showInputDialog("Enter your reservation number:"));
    if(reservationManager.doesReservationExist(reservationNum)){
      res = reservationManager.getSpecificReservation(reservationNum);
      newRoomNum = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the new room for the reservation:"));
      reservationManager.modifyRoomNumber(res.getRoomNumber(), newRoomNum);
    }
    else{
      JOptionPane.showMessageDialog(null, "Reservation does not exist. Please try again or contact customer service.", "Unable to find reservation", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * Allows the user to view their reservation after they enter their reservation
   * id number.
   */
  static void viewReservation() {
    int reservationKey;
    String userLastName;
    ReservationDataBase reservationManager = new ReservationDataBase();
    reservationKey = Integer.parseInt(JOptionPane.showInputDialog("Enter your reservation number:"));
    userLastName = JOptionPane.showInputDialog("Enter your last name:");
    Reservation userReservation = reservationManager.getSpecificReservation(reservationKey);
    if (userReservation != null) {
      if (userReservation.getLastName().equals(userLastName)) {
        JOptionPane.showMessageDialog(null, userReservation, "Reservation", JOptionPane.PLAIN_MESSAGE);
      } else {
        JOptionPane.showMessageDialog(null, "Incorrect information. Please try again.", "Error", JOptionPane.PLAIN_MESSAGE);
      }
    } else {
      JOptionPane.showMessageDialog(null, "Reservation does not exist. Please try again or contact customer service.", "Error", JOptionPane.PLAIN_MESSAGE);
    }
  }
}

class Manager extends User {

  /**
   * user selects reservation from database then selects an unbooked room to
   * replace current room
   */
  static void changeRoomReservation() {
    int reservationNum, newRoomNum;
    Reservation res;
    ReservationDataBase reservationManager = new ReservationDataBase();
    reservationNum = Integer.parseInt(JOptionPane.showInputDialog("Enter the reservation number:"));
    if(reservationManager.doesReservationExist(reservationNum)){
      res = reservationManager.getSpecificReservation(reservationNum);
      newRoomNum = Integer.parseInt(JOptionPane.showInputDialog("Enter the number of the new room for the reservation:"));
      reservationManager.modifyRoomNumber(res.getRoomNumber(), newRoomNum);
    }
    else{
      JOptionPane.showMessageDialog(null, "Cannot find reservation in the hotel database!", "Error", JOptionPane.PLAIN_MESSAGE);
    }
  }

  /**
   * user selects reservation from database, reservation is then deleted from
   * database
   */
  static void cancelRoomReservation() {
    ReservationDataBase reservationManager = new ReservationDataBase();
    int reservationKey;
    reservationKey = Integer.parseInt(JOptionPane.showInputDialog("Enter the reservation number:"));
    if (reservationManager.doesReservationExist(reservationKey)) {
      reservationManager.cancelReservation(reservationKey);
    } else {
      System.out.println("Reservation does not exist. Please try again or contact customer service.");
    }
  }

  /**
   * user enters reservation number, database containing info for the room in the 
   * reservation updates the name for the room with the name from the reservation
   */
  static void checkCustomerIn() {
    int reservationKey, resRoomNum;
    Reservation res;
    ReservationDataBase reservationManager = new ReservationDataBase();
    reservationKey = Integer.parseInt(JOptionPane.showInputDialog("Enter the reservation number:"));
    if (reservationManager.doesReservationExist(reservationKey)) {
      res = reservationManager.getSpecificReservation(reservationKey);
      resRoomNum = res.getRoomNumber();
      // TODO: change name in room to name in reservation
    } else {
      System.out.println("Reservation does not exist. Please try again or contact customer service.");
    }

  }
}
