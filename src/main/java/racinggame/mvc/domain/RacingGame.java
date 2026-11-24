package racinggame.mvc.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.function.IntSupplier;

public class RacingGame {

    private final List<Car> racer;
    private final IntSupplier numberSupplier;
    private final RemainingRounds remainingRounds;

    public RacingGame(String carNames, RemainingRounds remainingRounds, IntSupplier numberSupplier) {
        this(parseCars(carNames), remainingRounds, numberSupplier);
    }

    public RacingGame(List<Car> cars, RemainingRounds remainingRounds, IntSupplier numberSupplier) {
        if (cars.isEmpty()) {
            throw new IllegalArgumentException("경주에 참가할 자동차가 필요합니다.");
        }

        this.racer = List.copyOf(cars);
        this.remainingRounds = Objects.requireNonNull(remainingRounds);
        this.numberSupplier = Objects.requireNonNull(numberSupplier);
    }

    private static List<Car> parseCars(String carNames) {
        List<Car> cars = new ArrayList<>();
        for (String name : carNames.split(",", -1)) {
            String trimmedName = name.trim();
            if (trimmedName.isEmpty()) {
                throw new IllegalArgumentException("자동차 이름을 입력해야 합니다.");
            }
            cars.add(new Car(trimmedName));
        }
        return cars;
    }

    public boolean isEnd() {
        return remainingRounds.isExhausted();
    }

    public RacingResult race() {
        remainingRounds.ensureAvailable();
        for (Car car : racer) {
            car.move(numberSupplier.getAsInt());
        }
        remainingRounds.decrease();

        List<Car> racers = racer.stream()
            .map(car -> new Car(car.getName(), car.getPosition()))
            .toList();
        List<Car> winners = isEnd() ? findWinners(racers) : List.of();
        return new RacingResult(racers, winners);
    }

    private List<Car> findWinners(List<Car> racers) {
        int farthestPosition = racers.stream()
            .mapToInt(Car::getPosition)
            .max()
            .orElseThrow();
        return racers.stream()
            .filter(car -> car.getPosition() == farthestPosition)
            .toList();
    }
}
