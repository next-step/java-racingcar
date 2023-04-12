package study.carrace.step3.domain;


import java.util.ArrayList;
import java.util.List;

public class Car {
    private static final char POSITION_CURSOR = '-';

    private final String name;
    private final MoveStrategy moveStrategy;
    private final List<Boolean> moveStatuses;

    public Car(String name, MoveStrategy moveStrategy) {
        this.name = name;
        this.moveStrategy = moveStrategy;
        this.moveStatuses = new ArrayList<>();
    }

    public void moveOrStop() {
        moveStatuses.add(moveStrategy.moveOrStop());
    }

    public String currentPosition() {
        StringBuilder currentPosition = new StringBuilder()
                .append(name)
                .append(" : ");

        moveStatuses.stream()
                .filter(moveStatus -> moveStatus)
                .forEach(moveStatus -> currentPosition.append(POSITION_CURSOR));

        return currentPosition.toString();
    }
}
