package study.carrace.step3.domain;


import java.util.stream.IntStream;

public class Car {
    private static final char POSITION_CURSOR = '-';

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
        StringBuilder currentPosition = new StringBuilder()
                .append(carName)
                .append(" : ");

        IntStream.range(0, iteration)
                .filter(carPosition::isMovedAt)
                .forEach(i -> currentPosition.append(POSITION_CURSOR));

        return currentPosition.toString();
    }

    public long numberOfMove() {
        return carPosition.numberOfMove();
    }

    public CarName carName() {
        return carName;
    }
}
