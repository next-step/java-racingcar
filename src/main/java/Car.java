public class Car {
    private static final int MOVE_THRESHOLD = 4;
    private final CarName name;
    private final Location location;

    Car(String name) {
        this(name, 0);
    }

    Car(String name, int location) {
        this(new CarName(name), new Location(location));
    }

    Car(CarName name, Location location) {
        this.name = name;
        this.location = location;
    }

    CarName name() {
        return name;
    }

    Location location() {
        return location;
    }

    void makeMove(int number) {
        if (isMovable(number)) {
            location.moveForward();
        }
    }

    boolean isAtLocation(Location targetLocation) {
        return this.location.equals(targetLocation);
    }

    String expressLocationWith(String symbol) {
        return location.toString(symbol);
    }

    private boolean isMovable(int number) {
        return number >= MOVE_THRESHOLD;
    }
}
