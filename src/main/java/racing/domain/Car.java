package racing.domain;


/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {
    private static final int DEFAULT_LOCATION = 0;
    private static final int MOVE_AVAILABLE_BOUND = 4;

    private int location;

    public Car() {
        this.location = DEFAULT_LOCATION;
    }

    public Car(Car car) {
        this.location = car.location;
    }

    public void move(int distance) {
        if (canMove(distance)) {
            changeLocation(distance);
        }
    }

    private boolean canMove(int distance) {
        return MOVE_AVAILABLE_BOUND <= distance;
    }

    private void changeLocation(int distance) {
        this.location += distance;
    }

    public int location() {
        return this.location;
    }
}
