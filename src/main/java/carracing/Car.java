package carracing;

public class Car {
    private static final int MOVE_REFERENCE_NUM = 4;
    private CarPosition position;
    private final CarName carName;

    public Car(String carName) {
        this.carName = new CarName(carName);
        this.position = new CarPosition();
    }
    public CarPosition getPosition() {
        return this.position;
    }

    public String getCarNameString() {
        return this.carName.getValue();
    }

    public void move(int value) {
        if (value >= MOVE_REFERENCE_NUM) {
            this.position = this.position.increase();
        }
    }

    public int getMax(int max) {
        return this.position.getMax(max);
    }

    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }
}
