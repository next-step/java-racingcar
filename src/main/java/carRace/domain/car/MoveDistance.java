package carRace.domain.car;

import carRace.error.ErrorMessage;
import carRace.error.exception.NotPositiveNumberException;
import java.util.Comparator;
import java.util.Objects;

public class MoveDistance implements Comparable<MoveDistance> {

    private static final Comparator<MoveDistance> COMPARATOR =
        Comparator.comparingInt(MoveDistance::getMoveDistance);

    private int moveDistance;

    public MoveDistance(int moveDistance) {
        this.moveDistance = moveDistance;

        if (moveDistance < 0) {
            throw new NotPositiveNumberException(
                ErrorMessage.MOVE_DISTANCE_NOT_POSITIVE_NUMBER.getMessage());
        }
    }

    public int getMoveDistance() {
        return moveDistance;
    }

    public void plusMoveDistance() {
        moveDistance += 1;
    }

    @Override
    public int compareTo(MoveDistance other) {
        return COMPARATOR.compare(this, other);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (!(o instanceof MoveDistance)) {
            return false;
        }
        MoveDistance that = (MoveDistance) o;
        return getMoveDistance() == that.getMoveDistance();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getMoveDistance());
    }
}
