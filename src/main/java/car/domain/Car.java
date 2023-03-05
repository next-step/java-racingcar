package car.domain;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position.increasePosition();
        String positionInfo = printPositionInfo();
        System.out.println(positionInfo);
    }

    public boolean isGreaterThan(int maxPosition) {
        return this.position.isGreaterThan(maxPosition);
    }

    public boolean isEqualPosition(int maxPosition) {
        return this.position.isEqualPosition(maxPosition);
    }

    public int findPosition() {
        return this.position.getPosition();
    }

    private String printPositionInfo() {
        return String.format("%s : %s", this.name.printName(), this.position.printStatus());
    }

    @Override
    public String toString() {
        return this.name.printName();
    }
}
