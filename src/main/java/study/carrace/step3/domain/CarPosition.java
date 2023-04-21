package study.carrace.step3.domain;

import study.carrace.step3.domain.exception.IllegalCarPositionIteration;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.IntStream;

public class CarPosition {
    private static final char POSITION_CURSOR = '-';
    private final List<Boolean> moveStatuses;

    public CarPosition() {
        moveStatuses = new ArrayList<>();
    }

    public CarPosition(List<Boolean> moveStatuses) {
        this.moveStatuses = moveStatuses;
    }

    public void addMoveStatus(Boolean moveStatus) {
        moveStatuses.add(moveStatus);
    }

    public long numberOfMove() {
        return moveStatuses.stream()
                .filter(b -> b)
                .count();
    }

    public String positionAt(int iteration) {
        StringBuilder position = new StringBuilder();
        IntStream.rangeClosed(1, iteration)
                .filter(this::isMovedAt)
                .forEach(i -> position.append(POSITION_CURSOR));

        return position.toString();
    }

    private boolean isMovedAt(int iteration) {
        validateIteration(iteration);
        return moveStatuses.get(iteration-1);
    }

    private void validateIteration(int iteration) {
        if(iteration > moveStatuses.size()) {
            throw new IllegalCarPositionIteration(moveStatuses.size(), iteration);
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        CarPosition that = (CarPosition) o;
        return Objects.equals(moveStatuses, that.moveStatuses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(moveStatuses);
    }
}
