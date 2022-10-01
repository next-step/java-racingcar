package racinggame;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class RacingGameRoundResult {

    private static final String DISTANCE_SYMBOL = "-";

    private final List<Integer> positions;

    public RacingGameRoundResult() {
        this.positions = new ArrayList<>();
    }

    public RacingGameRoundResult(List<Integer> positions) {
        this.positions = positions;
    }

    public void add(int position) {
        positions.add(position);
    }

    public String getContent() {
        return positions.stream()
                .map(DISTANCE_SYMBOL::repeat)
                .collect(Collectors.joining(StringConstants.NEW_LINE));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RacingGameRoundResult that = (RacingGameRoundResult) o;
        return Objects.equals(positions, that.positions);
    }

    @Override
    public int hashCode() {
        return Objects.hash(positions);
    }

}
