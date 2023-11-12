package racingcar.domain;

public class Car implements Comparable<Car> {

    private Name name;
    private int moveCount = 0;

    public Car(String carName) {
        this(carName, 0);
    }

    public Car(String carName, int moveCount) {
        name = new Name(carName);
        this.moveCount = moveCount;
    }

    public String getName() {
        return name.getName();
    }

    public int getMoveCount() {
        return moveCount;
    }

    @Override
    public int compareTo(Car other) {
        return moveCount - other.moveCount;
    }

    public Car stopOrMove(Strategy strategy) {
        if (strategy.isMovable()) {
            return new Car(name.getName(), moveCount + 1);
        }
        return this;
    }
}
