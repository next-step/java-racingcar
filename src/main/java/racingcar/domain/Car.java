package racingcar.domain;

public class Car {

    private final MoveStrategy moveStrategy;
    private final CarName carName;
    private final Position position;

    public Car(final String name, final MoveStrategy moveStrategy) {
        this.moveStrategy = moveStrategy;
        this.carName = new CarName(name);
        this.position = new Position();
    }

    public void racing() {
        if (moveStrategy.isMove()) {
            position.numberIncrease();
        }
    }

    public boolean isWinner(Car car) {
        return car.samePosition(this.position);
    }

    private boolean samePosition(Position position) {
        return position.equals(this.position);
    }

    public int comparePosition(Car car) {
        return this.position.compareTo(car.getPosition());
    }

    private Position getPosition() {
        return this.position;
    }

    public int positionValue() {
        return this.position.getNumber();
    }

    public String nameValue() {
        return this.carName.getName();
    }
}
