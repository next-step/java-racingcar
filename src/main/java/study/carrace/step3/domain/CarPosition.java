package study.carrace.step3.domain;

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

    public List<Boolean> moveStatuses() {
        return Collections.unmodifiableList(moveStatuses);
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
