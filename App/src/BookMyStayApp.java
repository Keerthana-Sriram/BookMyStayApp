abstract class Room {
    protected int numberOfBeds;
    protected int squareFeet;
    protected double pricePerNight;

    public Room(int numberOfBeds, int squareFeet, double pricePerNight) {
        this.numberOfBeds = numberOfBeds;
        this.squareFeet = squareFeet;
        this.pricePerNight = pricePerNight;
    }

    void displayDetails() {
        System.out.println("Beds: " + numberOfBeds + "\nSize: " + squareFeet+" sqft \nPrice per night: " + pricePerNight);
    }
}

class SingleRoom extends Room {
    public SingleRoom () { super(1,250,1500.00); }
}
class DoubleRoom extends Room {
    public DoubleRoom () { super(2,400,2500.00); }
}
class SuiteRoom extends Room {
    public SuiteRoom () { super(3,750,5000.00); }
}

public class BookMyStayApp {
    public static void main(String[] args) {
        System.out.println("Hotel Room Initialization");
        SingleRoom s1 = new SingleRoom ();
        System.out.println("Single Room:");
        s1.displayDetails();
        DoubleRoom s2 = new DoubleRoom ();
        System.out.println("Double Room:");
        s2.displayDetails();
        SuiteRoom s3 = new SuiteRoom ();
        System.out.println("Suite Room:");
        s3.displayDetails();
    }
}