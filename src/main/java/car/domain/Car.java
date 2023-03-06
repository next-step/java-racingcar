package car.domain;

import car.ui.View;
import car.ui.Winner;

public class Car {
    private final Name name;
    private final Position position;

    public Car(Name name, Position position) {
        this.name = name;
        this.position = position;
    }

    public void move() {
        this.position.increasePosition();
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

    public View toView() {
        return new View(this.name, this.position);
    }

    public Winner toWinner() {
        return new Winner(this.name);
    }
}
