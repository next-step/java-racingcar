package step3.racing;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {

    private static final int DEFAULT_LOCATION = 0;
    private int location;

    public Car() {
        this.location = DEFAULT_LOCATION;
    }

    public Car(Car car) {
        this.location = car.location;
    }

    public void move(int distance) {
        this.location += distance;
    }

    public void stop() {
    }

    public int location() {
        return this.location;
    }
}
