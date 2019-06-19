package racinggame;

public class Car {
    public static final int MOVE_DISTANCE_PER_ONCE = 1;
    private int position = 1;
    private String carName;

    public Car(String carName) {
        this.carName = carName;
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
