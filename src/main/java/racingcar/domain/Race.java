package racingcar.domain;

import java.util.List;

public class Race {
    private final Cars cars;
    private final TryCount tryCount;
    private final NumberGenerator numberGenerator;

    public Race(List<CarName> names, TryCount tryCount, NumberGenerator numberGenerator) {
        this.cars = new Cars(names.stream().map(name -> new Car(name, 0)).toList());
        this.tryCount = tryCount;
        this.numberGenerator = numberGenerator;
    }

    public RoundResult playRound() {
        tryCount.decrease();
        cars.move(numberGenerator);
        return cars.toResult();
    }

    public boolean isInProgress() {
        return tryCount.hasRemaining();
    }
}
