package study.carrace.step3.domain;

import study.carrace.step3.domain.exception.IllegalCarPositionIndex;

import java.util.ArrayList;
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

    public void addMoveStatus(Boolean moveStatus) {
        moveStatuses.add(moveStatus);
    }

    public boolean isMovedAt(int index) {
        validateIndex(index);
        return moveStatuses.get(index);
    }

    public long numberOfMove() {
        return moveStatuses.stream()
                .filter(b -> b)
                .count();
    }

    private void validateIndex(int index) {
        if(index >= moveStatuses.size()) {
            throw new IllegalCarPositionIndex(moveStatuses.size(), index);
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
