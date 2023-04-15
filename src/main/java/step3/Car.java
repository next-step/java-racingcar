package step3;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car {

    private int location;

    public Car() {
        this.location = 0;
    }

    public void move(int distance) {
        this.location += distance;
    }

    public int location() {
        return this.location;
    }

    public void stop() {

    }
}
