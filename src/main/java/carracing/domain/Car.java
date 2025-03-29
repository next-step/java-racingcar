package carracing.domain;

public class Car {
    private final CarName carName;
    private int position;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int position) {
        this.carName = new CarName(carName);
        this.position = position;
    }

    public String getName() {
        return carName.getValue();
    }

    public int getPosition() {
        return position;
    }

    public void move(boolean canMove) {
        if (canMove) {
            position++;
        }
    }
}
