package racingcar.model;

import racingcar.pattern.ValueGenerateStrategy;

public class Car {
    private static final int MOVE_BOUNDARY_VALUE = 4;
    private static final int UNIT_DISTANCE = 1;
    private Name name;
    private PositiveNumber moveDistance;

    Car(int moveDistance, String id) {
        this.name = new Name(id);
        this.moveDistance = new PositiveNumber(moveDistance);
    }


    public boolean isWinner(int maxDistance) {
        return this.moveDistance.isMaxNumber(maxDistance);
    }

    public int maxDistance(int maxDistance) {
        return this.moveDistance.maxNumber(maxDistance);
    }

    public void tryToMove(ValueGenerateStrategy valueGenerateStrategy) {
        if (new PositiveNumber(valueGenerateStrategy.generate()).isGreaterThanOrEqual(MOVE_BOUNDARY_VALUE)) {
            this.moveDistance.plus(new PositiveNumber(UNIT_DISTANCE));
        }
    }

    public String getName() {
        return this.name.getName();
    }

    public int getMoveDistance() {
        return this.moveDistance.getNumber();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Car car = (Car) o;

        if (name != null ? !name.equals(car.name) : car.name != null) return false;
        return moveDistance != null ? moveDistance.equals(car.moveDistance) : car.moveDistance == null;
    }

    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + (moveDistance != null ? moveDistance.hashCode() : 0);
        return result;
    }
}
