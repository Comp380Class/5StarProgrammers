package starprogrammers;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.MethodSource;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

public class FilterRoomTest {
  public static ArrayList<Room> filterRooms() {
    ArrayList<Room> testRooms = RoomDataBase.filterRooms("Suite");
    return testRooms;
  }

  @ParameterizedTest
  @MethodSource(value = "filterRooms")
  void testRoomFilter(Room filteredRoom) {
    assertEquals("Suite", filteredRoom.getRoomType(), "Hotel contains 6 Suites");
  }
}
