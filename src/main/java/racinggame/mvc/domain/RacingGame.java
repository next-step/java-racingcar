package racinggame.mvc.domain;

import java.util.List;
import java.util.Objects;
import java.util.function.IntSupplier;

public class RacingGame {

    private final Cars cars;
    private final IntSupplier numberSupplier;
    private final RemainingRounds remainingRounds;

    public RacingGame(Cars cars, RemainingRounds remainingRounds, IntSupplier numberSupplier) {
        this.cars = Objects.requireNonNull(cars);
        this.remainingRounds = Objects.requireNonNull(remainingRounds);
        this.numberSupplier = Objects.requireNonNull(numberSupplier);
    }

    public RacingGame(String carNames, int tryCount) {
        this(new Cars(carNames), new RemainingRounds(tryCount), new RandomNumberSupplier());
    }

    public boolean isEnd() {
        return remainingRounds.isExhausted();
    }

    public RacingResult race() {
        remainingRounds.ensureAvailable();
        cars.move(numberSupplier);
        remainingRounds.decrease();

        List<Car> winners = isEnd() ? cars.farthestCars() : List.of();
        return new RacingResult(cars.getCars(), winners);
    }
}
