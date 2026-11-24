package racingcar;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Objects;

public class RoundResult {

    private final Map<String, Integer> positions;

    public RoundResult(Map<String, Integer> positions) {
        this.positions = new LinkedHashMap<>(positions);
    }

    public Map<String, Integer> getPositions() {
        return new LinkedHashMap<>(positions);
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
