package step5.view.result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Collectors;

public class CarMovementRoundResult {
    private static final int CAR_MIN_MOVE_COUNT = 0;
    private final List<CarMovementResult> results = new ArrayList<>();

    public static CarMovementRoundResult from(List<CarMovementResult> results) {
        return new CarMovementRoundResult(results);
    }

    public CarMovementRoundResult(List<CarMovementResult> results) {
        if (results != null && !results.isEmpty()) {
            this.results.addAll(results);
        }
    }

    public void forEach(Consumer<CarMovementResult> action) {
        results.forEach(action);
    }

    public List<String> winnerNames() {
        final int maxMoveCount = maxMoveCount();

        return results.stream()
                .filter(result -> result.moveCount() == maxMoveCount)
                .map(CarMovementResult::carName)
                .collect(Collectors.toList());
    }

    private int maxMoveCount() {
        return results.stream()
                .mapToInt(CarMovementResult::moveCount)
                .max()
                .orElse(CAR_MIN_MOVE_COUNT);
    }
}
