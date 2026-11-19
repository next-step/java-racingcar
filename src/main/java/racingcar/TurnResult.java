package racingcar;

import java.util.List;

public record TurnResult(List<Integer> positions) {

    public TurnResult {
        positions = List.copyOf(positions);
    }
}
