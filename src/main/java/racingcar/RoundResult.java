package racingcar;

import java.util.List;

public class RoundResult {
    private final List<Integer> positions;

    public RoundResult(List<Integer> positions) {
        validate(positions);
        this.positions = List.copyOf(positions);
    }

    private void validate(List<Integer> positions) {
        if (positions == null) {
            throw new IllegalArgumentException("위치 정보는 null일 수 없습니다.");
        }

        if (positions.isEmpty()) {
            throw new IllegalArgumentException("위치 정보는 비어있을 수 없습니다.");
        }
    }

    public List<Integer> positions() {
        return this.positions;
    }
}
