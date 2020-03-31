package CarRacing.domain;

public class Car {
    private final String name;
    private int currentPosition;

    public Car(String name) {
        this(name, 0);
    }

    public Car(String name, int currentPosition) {
        this.name = name;
        this.currentPosition = currentPosition;
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
