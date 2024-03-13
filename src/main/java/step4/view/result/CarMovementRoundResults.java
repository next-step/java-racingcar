package step4.view.result;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class CarMovementRoundResults {
    private final List<CarMovementRoundResult> results = new ArrayList<>();

    public void add(CarMovementRoundResult roundResult) {
        results.add(roundResult);
    }

    public void forEach(Consumer<CarMovementRoundResult> action) {
        results.forEach(action);
    }
}
