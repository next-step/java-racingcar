package step5.domain.result;

import step5.domain.CarName;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;

public class CarMovementRoundResults {
    private final LinkedList<CarMovementRoundResult> results = new LinkedList<>();

    public void add(CarMovementRoundResult roundResult) {
        results.add(roundResult);
    }

    public void forEach(Consumer<CarMovementRoundResult> action) {
        results.forEach(action);
    }

    public List<String> winnerNames() {
        if (results.isEmpty()) {
            return Collections.emptyList();
        }
        return results.getLast().winnerNames();
    }

    public Optional<CarMovementRoundResult> lastRoundResult() {
        if (results.isEmpty()) {
            return Optional.empty();
        }
        return Optional.of(results.getLast());
    }
}
