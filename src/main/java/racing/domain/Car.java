package racing.domain;

public class Car {

    public static final int FORWARD_STANDARD_NUMBER = 4;

    private String name;
    private int distance;

    public Car() {
    }

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getDistance() {
        return distance;
    }

    public void move(int value) {
        if(isAvailableForward(value)) {
            this.distance++;
        }
    }

    private boolean isAvailableForward(int value) {
        return value >= FORWARD_STANDARD_NUMBER;
    }
}
