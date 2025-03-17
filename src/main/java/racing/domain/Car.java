package racing.domain;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Car {
    private final List<Integer> positions = new ArrayList<>();
    private static final int INITIAL_POSITION = 1;

    public void moveForward(final int roundIndex) {
        int newPosition = calculateNewPosition(roundIndex, true);
        positions.add(newPosition);
    }

    public void stay(final int roundIndex) {
        int newPosition = calculateNewPosition(roundIndex, false);
        positions.add(newPosition);
    }

    private int calculateNewPosition(final int roundIndex, final boolean shouldMove) {
        if (roundIndex == 0) {
            return shouldMove ? INITIAL_POSITION + 1 : INITIAL_POSITION;
        }

        int previousPosition = positions.get(roundIndex - 1);
        return shouldMove ? previousPosition + 1 : previousPosition;
    }

    public int getPosition(final int roundIndex) {
        if (roundIndex < 0 || roundIndex >= positions.size()) {
            throw new IndexOutOfBoundsException("Invalid round index: " + roundIndex);
        }
        return positions.get(roundIndex);
    }

    public List<Integer> getPositions() {
        return Collections.unmodifiableList(positions);
    }
}
