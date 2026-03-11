/**

        * CLASS - RoomInventory

* Use Case 3: Centralized Room Inventory Management

Description:
        * This class acts as the single source of truth
* for room availability in the hotel.

* Room pricing and characteristics are obtained
* from Room objects, not duplicated here.

* This avoids multiple sources of truth and
* keeps responsibilities clearly separated.

        * @version 3.1
        */

abstract class Room {
    protected String roomType;
    protected int beds;
    protected int size;
    protected double price;

    public Room(String roomType, int beds, int size, double price) {
        this.roomType = roomType;
        this.beds = beds;
        this.size = size;
        this.price = price;
    }
import java.util.HashMap;
import java.util.Map;

    class RoomInventory {

        private HashMap<String, Integer> inventory;

        public void displayRoomDetails() {
            System.out.println("Room Type: " + roomType);
            System.out.println("Beds: " + beds);
            System.out.println("Size: " + size + " sq.ft");
            System.out.println("Price per night: $" + price);
    public RoomInventory() {
                inventory = new HashMap<>();

                inventory.put("Single Room", 5);
                inventory.put("Double Room", 3);
                inventory.put("Suite Room", 2);
            }
        }

        class SingleRoom extends Room {
            public SingleRoom() {
                super("Single Room", 1, 200, 80);
                public int getAvailability(String roomType) {
                    return inventory.getOrDefault(roomType, 0);
                }
            }

            class DoubleRoom extends Room {
                public DoubleRoom() {
                    super("Double Room", 2, 350, 120);
                    public void updateAvailability(String roomType, int count) {
                        if (inventory.containsKey(roomType)) {
                            inventory.put(roomType, count);
                        }
                    }
                }

                class SuiteRoom extends Room {
                    public SuiteRoom() {
                        super("Suite Room", 3, 500, 250);
                        public void displayInventory() {
                            System.out.println("=== Current Room Inventory ===");
                            for (Map.Entry<String, Integer> entry : inventory.entrySet()) {
                                System.out.println(entry.getKey() + " : " + entry.getValue() + " rooms available");
                            }
                        }
                    }
                    public class BookMyStayApp {
                        public static void main (String[] args){
                            Room singleRoom = new SingleRoom();
                            Room doubleRoom = new DoubleRoom();
                            Room suiteRoom = new SuiteRoom();

                            int singleAvailability = 5;
                            int doubleAvailability = 3;
                            int suiteAvailability = 2;
                            RoomInventory inventory = new RoomInventory();

                            System.out.println("=== Book My Stay App : Room Availability ===\n");
                            inventory.displayInventory();

                            singleRoom.displayRoomDetails();
                            System.out.println("Available Rooms: " + singleAvailability);
                            System.out.println();

                            doubleRoom.displayRoomDetails();
                            System.out.println("Available Rooms: " + doubleAvailability);
                            System.out.println("Availability of Single Room: " + inventory.getAvailability("Single Room"));

                            inventory.updateAvailability("Single Room", 4);

                            System.out.println();
                            System.out.println("After updating inventory:");

                            suiteRoom.displayRoomDetails();
                            System.out.println("Available Rooms: " + suiteAvailability);
                            inventory.displayInventory();
                        }
                    }