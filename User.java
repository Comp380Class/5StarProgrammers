/** 
    A user is able to access and the necessary functions of the hotel such as search for the type of room they desire,
     book a reservation, and view, change or cancel their reservation
*/
class User {
    /**
        user selects a room from the list of available rooms displayed by program, and a new reservation is made under the user's name 
     */
    bookRoom(){}

    /**
        user selects a type of room offered, then program displays a list of rooms that match the catagory
     */
    searchForRoomType(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then their reservation is deleted from the database
     */
    cancelReservation(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then they are given the option to request a different type of room
     */
    changeReservation(){}

    /**
        user inputs identifying data(name?, password?, payment info?), if successful then information regarding their reservation is displayed
     */
    viewReservation(){}
}

class manager extends user{
    
}