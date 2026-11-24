package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class RoundResult {

    private final List<Integer> positions;

    public RoundResult(List<Integer> positions) {
        this.positions = new ArrayList<>(positions);
    }

    public List<Integer> getPositions() {
        return new ArrayList<>(positions);
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        RoundResult that = (RoundResult) o;
        return positions.equals(that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }
}
