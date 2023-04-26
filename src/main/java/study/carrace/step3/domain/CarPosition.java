package study.carrace.step3.domain;

import study.carrace.step3.domain.exception.IllegalCarPositionIteration;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class CarPosition {
    private final List<Boolean> moveStatuses;

    public CarPosition() {
        moveStatuses = new ArrayList<>();
    }

    public CarPosition(List<Boolean> moveStatuses) {
        this.moveStatuses = moveStatuses;
    }

    public CarPosition addMoveStatus(List<Boolean> moveStatuses) {
        ArrayList<Boolean> addedMoveStatuses = new ArrayList<>(this.moveStatuses);
        addedMoveStatuses.addAll(moveStatuses);

        return new CarPosition(addedMoveStatuses);
    }

    public long numberOfMove() {
        return moveStatuses.stream()
                .filter(b -> b)
                .count();
    }

    public List<Boolean> moveStatusesAt(int iteration) {
        validateIteration(iteration);
        return Collections.unmodifiableList(moveStatuses.subList(0, iteration));
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
