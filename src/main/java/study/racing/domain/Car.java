package study.racing.domain;

public class Car {

    private CarName name;
    private CarPosition position;

    public Car(String name) {
        this(new CarName(name), new CarPosition(0));

    }

    public Car(String name, int position) {
        this(new CarName(name), new CarPosition(position));
    }

    public Car(CarName name, CarPosition position) {
        this.name = name;
        this.position = position;
    }

    public CarName getName() {
        return this.name;
    }

    public CarPosition getPosition() {
        return this.position;
    }

    public void move() {
        if (RandomMoveRule.isRandomNumber()) {
            this.position.increasePosition();
        }
    }

    public boolean isEqualsMaxPosition(int maxPosition) {
        return this.position.value() == maxPosition;
    }

    public int max(int maxPosition) {
        return Math.max(maxPosition, this.getPosition().value());
    }

    public void moveToPosition(int position) {
        this.position = new CarPosition(position);
    }


}
