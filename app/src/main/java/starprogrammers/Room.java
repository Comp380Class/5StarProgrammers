package starprogrammers;

import java.io.PrintWriter;
import java.util.Scanner;

public class Room implements Comparable<Room> {
    private String firstName;
    private String lastName;
    private int roomNumber;
    private String roomType;
    private String bedType;
    private int bedQuantity;
    private int roomPrice;
    private int numberOfOccupants;

    public Room() {}

    public Room(String lasName, String firstName, int roomNumber,String roomType,String bedType,int bedQuantity,int roomPrice,int numberOfOccupants) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.roomNumber = roomNumber;
        this.roomType = roomType;
        this.bedType = bedType;
        this.bedQuantity = bedQuantity;
        this.roomPrice = roomPrice;
        this.numberOfOccupants = numberOfOccupants;
    }

    public int getnumberOfOccupants() { return numberOfOccupants; }

    public String customerName(){
        return firstName + " " + lastName;
    }

    public String roomType(){
        return roomType;
    }

    public String bedType(){
        return bedType;
    }

    public int getPrice(){return roomPrice;}

    public void readFrom(Scanner input) {
        roomNumber = input.nextInt();   
        input.useDelimiter("/");
        input.reset();
        bedQuantity = input.nextInt();
        roomPrice = input.nextInt();
        numberOfOccupants = input.nextInt();
    }

    public void writeTo(PrintWriter output) {
        output.print(firstName);
        output.print(" ");
        output.print(lastName);
        output.print(" ");
        output.print(roomNumber);
        output.print(" ");
        output.print(roomType);
        output.print(" ");
        output.print(bedType);
        output.print(" ");
        output.print(bedQuantity);
        output.print(" ");
        output.print(roomPrice);
        output.print(" ");
        output.println(numberOfOccupants);
    }

    public String toString() {
        return "Room Number: "+ roomNumber + " " + "Number of occupants allowed: " + numberOfOccupants + " Room Type: " +roomType + " Bed Type: " + bedType;
    }

    @Override
    public int compareTo(Room t) {
        if(roomPrice <= t.bedQuantity)
            return -1;
        else if(bedQuantity >= t.roomPrice)
            return 1;
        return 0;
    }

    public String roomInfo(){
        return "\nPrice/Night: "
            + roomPrice
            + "\nType of room: "
            + roomType
            + "\nBed Quantity: " + bedQuantity
            + "\nRoom Number: " + roomNumber;
      }
}
