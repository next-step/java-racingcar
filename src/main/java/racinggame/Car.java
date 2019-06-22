package racinggame;

public class Car {
    public static final int MOVE_DISTANCE_PER_ONCE = 1;
    public static final int INITIAL_CAR_POSITION = 1;
    private int position;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
        this.position = INITIAL_CAR_POSITION;
    }

    public void move() {
        this.position += MOVE_DISTANCE_PER_ONCE;
    }

    public int getPosition() {
        return position;
    }

    public String getCarName() {
        return carName;
    }
}
