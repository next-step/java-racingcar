package car.domain;

public class Car {

    private static final int MOVE_THRESHOLD = 4;
    private static final int MOVE_STEP = 1;
    private int position;
    private CarName carName;

    public Car(String name) {
        this(0, name);
    }

    public Car(int position, String name) {
        this.position = position;
        this.carName = new CarName(name);
    }

    public void move(int value) {
        if (value >= MOVE_THRESHOLD) {
            position += MOVE_STEP;
        }
    }

    public String getName() {
        return carName.getName();
    }

    public int getPosition() {
        return position;
    }
}
