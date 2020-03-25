package CarRacing;

public class Car {
    private final String name;
    private int currentPosition = 0;

    public Car(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public int getCurrentPosition() {
        return currentPosition;
    }

    public void move(final RacingStrategy racingStrategy) {
        if (racingStrategy.movable()) {
            this.currentPosition++;
        }
    }
}
