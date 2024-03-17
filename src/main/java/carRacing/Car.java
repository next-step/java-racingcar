package carRacing;

import java.util.Objects;

public class Car {
    private static final int MOVE_STANDARD = 4;
    private Name name;
    private Position position;

    public Car(Name name) {
        this.name = name;
        this.position = new Position(0);
    }

    public void move(int number) {
        if (number >= MOVE_STANDARD) {
            this.position.addPosition();
        }
    }

    public int getPosition() {
        return this.position.getPosition();
    }

    public String getName() {
        return this.name.getName();
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof  Car)) {
            return false;
        }
        Car targetCar = (Car) obj;
        return getPosition() == targetCar.getPosition() && getName() == targetCar.getName();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
