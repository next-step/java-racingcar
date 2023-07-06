package car.domain;

public class Car {

    private final CarName name;
    private int position = 0;

    public Car(final String carName) {
        this.name = new CarName(carName);
    }

    public String getName() {
        return this.name.getName();
    }

    public int getPosition() {
        return this.position;
    }

    public void move(final int amount) {
        this.position += amount;
    }

    public boolean isSamePosition(int position) {
        return this.position == position;
    }
}
