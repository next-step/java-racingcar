package step3;

public class Car {

    private static final int MINIMUM_RANDOM_VALUE = 4;
    private final String currentStatus;

    public Car(String currentStatus) {
        this.currentStatus = currentStatus;
    }

    public static boolean isMovable(int times) {
        return times >= MINIMUM_RANDOM_VALUE;
    }

    public String go() {
        return this.currentStatus == null ? "-" : this.currentStatus + "-";
    }
}
