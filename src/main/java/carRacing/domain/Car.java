package carRacing.domain;

import carRacing.util.MoveStrategy;

public class Car {
    private final Name name;
    private Position position;
    private final MoveStrategy moveStrategy;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = new Name(name);
        this.moveStrategy = moveStrategy;
        this.position = new Position(0);
    }

    public void move(int number) {
        if (moveStrategy.isRide(number)) {
            this.position = this.position.move();
        }
    }

    public boolean isSamePosition(int i) {
        return this.position.isSame(i);
    }

    public int findGreaterNumber(int max) {
        return position.max(max);
    }

    public String getName() {
        return name.name();
    }

    public int getPositionForPrint() {
        return position.position();
    }
}
