package study.carrace.step3.domain;


import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Car {
    private static final char POSITION_CURSOR = '-';

    private final CarName carName;
    private final MoveStrategy moveStrategy;
    private final List<Boolean> moveStatuses;

    public Car(String name, MoveStrategy moveStrategy) {
        this(new CarName(name), moveStrategy);
    }

    public Car(CarName name, MoveStrategy moveStrategy) {
        this.carName = name;
        this.moveStrategy = moveStrategy;
        this.moveStatuses = new ArrayList<>();
    }

    public void moveOrStop() {
        moveStatuses.add(moveStrategy.moveOrStop());
    }

    public String positionAt(int iteration) {
        StringBuilder currentPosition = new StringBuilder()
                .append(carName)
                .append(" : ");

        IntStream.range(0, iteration)
                .filter(moveStatuses::get)
                .forEach(i -> currentPosition.append(POSITION_CURSOR));

        return currentPosition.toString();
    }

    public long numberOfMove() {
        return moveStatuses.stream()
                .filter(b -> b)
                .count();
    }

    public CarName carName() {
        return carName;
    }
}
