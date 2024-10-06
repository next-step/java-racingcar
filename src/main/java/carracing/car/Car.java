package carracing.car;

public class Car {
    private static final int MOVE_REFERENCE_NUM = 4;
    private Position position;
    private final Name name;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = new Position();
    }

    public void move(int value) {
        if (value >= MOVE_REFERENCE_NUM) {
            this.position = this.position.increase();
        }
    }

    public int getMax(int max) {
        return this.position.compareMax(max);
    }

    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }
    public Position getPosition() {
        return this.position;
    }

    public String getCarNameString() {
        return this.name.getValue();
    }
}
