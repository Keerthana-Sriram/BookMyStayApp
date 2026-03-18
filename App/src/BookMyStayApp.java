 feature/UC7-AddOnServiceSelection
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * ============================================================
 * CLASS - AddOnService
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class represents an optional service
 * that can be added to a confirmed reservation.
 *
 * Examples:
 * - Breakfast
 * - Spa
 * - Airport Pickup
 *
 * @version 7.0
 */
class AddOnService {

    /**
     * Name of the service.
     */
    private String serviceName;

    /**
     * Cost of the service.
     */
    private double cost;

    /**
     * Creates a new add-on service.
     *
     * @param serviceName name of the service
     * @param cost cost of the service
     */
    public AddOnService(String serviceName, double cost) {
        this.serviceName = serviceName;
        this.cost = cost;
=======
/**

        * CLASS - RoomAllocationService

Use Case 6: Reservation Confirmation & Room Allocation

* Description:
This class is responsible for confirming
* booking requests and assigning rooms.

* It ensures:
        - Each room ID is unique
- Inventory is updated immediately
- No room is double-booked

@version 6.0
        */

import java.util.*;

class Reservation {

    private String guestName;
    private String roomType;

    public Reservation(String guestName, String roomType) {
        this.guestName = guestName;
        this.roomType = roomType;
    }

    public String getGuestName() {
        return guestName;
 dev
    }

    /**
     * @return service name
     */
    public String getServiceName() {
        return serviceName;
    }
}

class RoomInventory {

    private HashMap<String, Integer> inventory;

    public RoomInventory() {
        inventory = new HashMap<>();
        inventory.put("Single Room", 2);
        inventory.put("Double Room", 2);
        inventory.put("Suite Room", 1);
    }

    public int getAvailability(String roomType) {
        return inventory.getOrDefault(roomType, 0);
    }

    /**
     * @return service cost
     */
    public double getCost() {
        return cost;
    }
}

/**
 * ============================================================
 * CLASS - AddOnServiceManager
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class manages optional services
 * associated with confirmed reservations.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */
class AddOnServiceManager {

    /**
     * Maps reservation ID to selected services.
     *
     * Key   -> Reservation ID
     * Value -> List of selected services
     */
    private Map<String, List<AddOnService>> servicesByReservation;

    /**
     * Initializes the service manager.
     */
    public AddOnServiceManager() {
        servicesByReservation = new HashMap<>();
    }

    /**
     * Attaches a service to a reservation.
     *
     * @param reservationId confirmed reservation ID
     * @param service add-on service
     */
    public void addService(String reservationId, AddOnService service) {
        servicesByReservation.putIfAbsent(reservationId, new ArrayList<>());
        servicesByReservation.get(reservationId).add(service);
    }

    /**
     * Calculates total add-on cost
     * for a reservation.
     *
     * @param reservationId reservation ID
     * @return total service cost
     */
    public double calculateTotalServiceCost(String reservationId) {
        double total = 0.0;
        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services != null) {
            for (AddOnService service : services) {
                total += service.getCost();
            }
        }

        return total;
    }

    /**
     * Displays all selected services for a reservation.
     *
     * @param reservationId reservation ID
     */
    public void displayServices(String reservationId) {
        List<AddOnService> services = servicesByReservation.get(reservationId);

        if (services == null || services.isEmpty()) {
            System.out.println("No add-on services selected for reservation ID: " + reservationId);
            return;
        }

        System.out.println("Selected add-on services for reservation ID: " + reservationId);
        for (AddOnService service : services) {
            System.out.println("- " + service.getServiceName() + " : Rs. " + service.getCost());
        }
    }
}

/**
 * ============================================================
 * MAIN CLASS - UseCase7AddOnServiceSelection
 * ============================================================
 *
 * Use Case 7: Add-On Service Selection
 *
 * Description:
 * This class demonstrates how optional
 * services can be attached to a confirmed
 * booking.
 *
 * Services are added after room allocation
 * and do not affect inventory.
 *
 * @version 7.0
 */
public class BookMyStayApp {

    /**
     * Application entry point.
     *
     * @param args command-line arguments
     */
    public static void main(String[] args) {
        String reservationId = "RES101";

        AddOnService breakfast = new AddOnService("Breakfast", 500.0);
        AddOnService spa = new AddOnService("Spa", 1500.0);
        AddOnService airportPickup = new AddOnService("Airport Pickup", 800.0);

        AddOnServiceManager manager = new AddOnServiceManager();

        manager.addService(reservationId, breakfast);
        manager.addService(reservationId, spa);
        manager.addService(reservationId, airportPickup);

        System.out.println("===== Book My Stay App =====");
        System.out.println("Use Case 7: Add-On Service Selection");
        System.out.println("Reservation ID: " + reservationId);
        System.out.println();

        manager.displayServices(reservationId);
        System.out.println();

        double totalCost = manager.calculateTotalServiceCost(reservationId);
        System.out.println("Total additional service cost: Rs. " + totalCost);
        System.out.println("Core booking and inventory remain unchanged.");
    }
} 