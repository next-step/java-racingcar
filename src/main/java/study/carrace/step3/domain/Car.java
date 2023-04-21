package study.carrace.step3.domain;


import study.carrace.step3.domain.exception.IllegalCarNameException;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class Car {
    private static final char POSITION_CURSOR = '-';
    private static final int CAR_NAME_LENGTH_THRESHOLD = 5;

    private final String name;
    private final MoveStrategy moveStrategy;
    private final List<Boolean> moveStatuses;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.moveStatuses = new ArrayList<>();

        validateNameLength(name);
    }

    public void moveOrStop() {
        moveStatuses.add(moveStrategy.moveOrStop());
    }

    public String positionAt(int iteration) {
        StringBuilder currentPosition = new StringBuilder()
                .append(name)
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

    public String name() {
        return name;
    }

    private void validateNameLength(String name) {
        if(name.length() > CAR_NAME_LENGTH_THRESHOLD) {
            throw new IllegalCarNameException(name);
        }
    }
}
