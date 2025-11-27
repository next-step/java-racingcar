package racingGame;

import java.util.Collections;
import java.util.List;

public class Round {

    private final List<Integer> positions;

    public Round(List<Integer> positions) {
        if (positions.stream().anyMatch(p -> p < 0)) {
            throw new IllegalArgumentException("위치는 음수가 될 수 없습니다.");
        }
        this.positions = List.copyOf(positions);
    }

    public List<Integer> positions() {
        return Collections.unmodifiableList(positions);
    }
}
