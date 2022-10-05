package step3;

public class Car {
    private static final int ADVANCE_COUNT = 4;
    private final StringBuilder location;

    public Car(String initLocation) {
        this.location = new StringBuilder(initLocation);
    }

    public StringBuilder getAdvancedOrDefaultLocation(int randomNumber) {
        if (isAdvance(randomNumber)) {
            return getLocation().append("-");
        }
        return getLocation();
    }

    public StringBuilder getLocation() {
        return location;
    }

    private boolean isAdvance(int randomNumber) {
        return randomNumber >= ADVANCE_COUNT;
    }
}
