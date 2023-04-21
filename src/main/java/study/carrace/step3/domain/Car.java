package study.carrace.step3.domain;


public class Car {
    private final CarName carName;
    private final MoveStrategy moveStrategy;
    private final CarPosition carPosition;

    public Car(String name, MoveStrategy moveStrategy) {
        this(new CarName(name), moveStrategy);
    }

    public Car(CarName name, MoveStrategy moveStrategy) {
        this.carName = name;
        this.moveStrategy = moveStrategy;
        this.carPosition = new CarPosition();
    }

    public void moveOrStop() {
        carPosition.addMoveStatus(moveStrategy.moveOrStop());
    }

    public String positionAt(int iteration) {
        return new StringBuilder()
                .append(carName)
                .append(" : ")
                .append(carPosition.positionAt(iteration))
                .toString();
    }

    public long numberOfMove() {
        return carPosition.numberOfMove();
    }

    public CarName carName() {
        return carName;
    }
}
