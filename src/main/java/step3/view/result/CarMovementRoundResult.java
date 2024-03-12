package step3.view.result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CarMovementRoundResult {
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
}
