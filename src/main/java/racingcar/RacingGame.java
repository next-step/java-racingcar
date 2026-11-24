package racingcar;

import java.util.ArrayList;
import java.util.List;
import java.util.function.IntSupplier;

public class RacingGame {

    private final Cars cars;
    private final int tryCount;

    public RacingGame(List<String> names, int tryCount) {
        this.cars = new Cars(names);
        this.tryCount = tryCount;
    }

    public List<TurnResult> race(IntSupplier numbers) {
        List<TurnResult> history = new ArrayList<>();
        for (int turn = 0; turn < tryCount; turn++) {
            cars.moveAll(numbers);
            history.add(cars.toTurnResult());
        }
        return history;
    }

    public List<String> winners() {
        return cars.winners();
    }
}
