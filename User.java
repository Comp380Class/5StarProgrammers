package starprogrammers;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;
import javax.swing.JOptionPane;
/** 
    A user is able to access and the necessary functions of the hotel such as search for the type of room they desire,
     book a reservation, and view, change or cancel their reservation
*/
public class User {
    /**
        user selects a room from the list of available rooms displayed by program, and a new reservation is made under the user's name 
	*/
    public static void bookRoom(){
        String userInput, fullName, firstName, lastName, emailAddr, payment;
        int age, partyNum, spaceIndex;
        LocalDate checkIn, checkOut;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("d/MM/yyyy");

        Scanner input = new Scanner(System.in);
        // user inputs check in and check out dates then selects type of room

        //TODO: Create GUI to allow user to input dates and select a type of room

        // program displays whether room is available, if so prompt user for info(name, age, email address, # of people, payment, check in & out dates)
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
	int roomNumber = selectRoom(input);
	Reservation  newReservation = new Reservation(lastName, firstName, age, payment, emailAddr, partyNum, roomNumber, checkIn, checkOut);
	System.out.println(newReservation); //Instead of print, send to the class that send the reservation to the DB.
        // if all prompts successfully completed, create new reservation and email confirmation to user
    }

	/**
	 * selectRoom presents the user with the rooms available for renting. The user
	 * picks their preferred room by entering its room number.
	 *
	 * @param Scanner object passed by bookRoom method.
	 * @return integer value corresponding to the room number that the customer
	 * wants to stay in.
	 */
	public static int selectRoom(Scanner input){
		System.out.println("Select your preferred room by entering the room number");
		System.out.println(Hotel.getAvailableRooms());
		int userInput = input.nextInt();
		return userInput;		
	}

    /**
        user selects a type of room offered, then program displays a list of rooms that match the catagory
     */
    static void searchForRoomType(){
        String roomType;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter type of room: ");
        roomType = input.next();

        //TODO: implement access to database to display rooms
    }

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then their reservation is deleted from the database(email confirmation?)
     */
    static void cancelReservation(){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();
        
        //TODO: implement access to database
    }

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then they are given the option to request a different type of room
     */
   static void changeReservation(){
        String name, newRoom;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();
        System.out.print("Enter type of room you would like your new room to be: ");
        newRoom = input.next();

        //TODO: implement access to database
    }

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then information regarding their reservation is displayed
     */
   static void viewReservation(){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();

        //TODO: implement access to database to display reservation info
    }
}

class Manager extends User{

    /**
        user selects reservation from database then selects an unbooked room to replace current room
     */
    static void changeRoomReservation(){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();

        //TODO: implement access to database
    }

    /**
        user selects reservation from database, reservation is then deleted from database
     */
    static void cancelRoomReservation(){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();

        //TODO: implement access to database
    }

    /** 
        user selects reservation (or booked room?) and change occupied(or checked-in flag?) to true
    */
    static void checkCustomerIn(){
        String name;
        Scanner input = new Scanner(System.in);
        System.out.print("Enter name: ");
        name = input.next();

        //TODO: implement access to database
    }
}
