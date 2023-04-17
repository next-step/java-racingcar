package step3.racing;

/**
 * @author : 0giri
 * @since : 2023/04/15
 */
public class Car implements Cloneable{

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

    @Override
    public Car clone() {
        try {
            return (Car) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }
}
