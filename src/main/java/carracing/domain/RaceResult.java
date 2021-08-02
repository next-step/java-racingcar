package carracing.domain;

import java.util.List;
import java.util.Map;

public class RaceResult {

    private static final String EMPTY_RESULT_EXCEPTION_MESSAGE_FORMAT = "우승자가 존재하지 않습니다.";

    private final Map<Position, List<Car>> result;

    private RaceResult(Map<Position, List<Car>> result) {
        this.result = result;
    }

    public static RaceResult of(Map<Position, List<Car>> result) {
        return new RaceResult(result);
    }

    public List<Car> getWinners() {
        return result.get(positionOfWinner());
    }

    private Position positionOfWinner() {
        return result.keySet()
                .stream()
                .max(Position::compareTo)
                .orElseThrow(() -> new IllegalArgumentException(EMPTY_RESULT_EXCEPTION_MESSAGE_FORMAT));
    }
}
