package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private final TryCount tryCount;
    private final NumberGenerator numberGenerator;

    public Race(List<String> names, TryCount tryCount, NumberGenerator numberGenerator) {
        this.cars = new Cars(names);
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    public List<CarResult> playRound() {
        tryCount.decrease();
        cars.move(numberGenerator);
        return cars.toResults();
    }

    public boolean isInProgress() {
        return tryCount.hasRemaining();
    }
}
