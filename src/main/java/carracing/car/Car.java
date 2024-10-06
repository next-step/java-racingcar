package carracing.car;

public class Car {
    private static final int MOVE_REFERENCE_NUM = 4;
    private Position position;
    private final Name name;

    public Car(String carName) {
        this.name = new Name(carName);
        this.position = new Position();
    }

    private Car(Name carName, Position position) {
        this.name = carName;
        this.position = position;
    }

    public void move(int value) {
        if (value >= MOVE_REFERENCE_NUM) {
            this.position = this.position.increase();
        }
    }

    public int compareMax(int max) {
        return this.position.compareMax(max);
    }

    public boolean isSamePosition(int position) {
        return this.position.isSame(position);
    }
    public Position getPosition() {
        return this.position;
    }

    public String getNameString() {
        return this.name.getValue();
    }

    public Car deepCopy() {
        return new Car(this.name, this.position);
    }
}
