package racinggame.mvc.domain;

import java.util.ArrayList;
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

    public RacingGame(String carNames, int tryCount, IntSupplier numberSupplier) {
        this(parseCars(carNames), new RemainingRounds(tryCount), numberSupplier);
    }

    private static Cars parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",", -1)) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
            }
            cars.add(new Car(trimmedName));
        }
        return new Cars(cars);
    }

    public boolean isEnd() {
        return remainingRounds.isExhausted();
    }

    public RacingResult race() {
        remainingRounds.ensureAvailable();
        for (Car car : cars.getCars()) {
            car.move(numberSupplier.getAsInt());
        }
        remainingRounds.decrease();

        List<Car> winners = isEnd() ? cars.farthestCars() : List.of();
        return new RacingResult(cars.getCars(), winners);
    }
}
