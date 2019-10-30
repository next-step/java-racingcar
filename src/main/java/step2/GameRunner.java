package step2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class GameRunner {
    private List<Car> cars;
    private final int tryTimes;
    private final CarDistanceGenerator carDistanceGenerator;

    private GameRunner(final int tryTimes,
                       final List<Car> initialCars,
                       final CarDistanceGenerator carDistanceGenerator) {
        if (tryTimes <= 0) {
            throw new IllegalArgumentException();
        }
        if (initialCars.size() <= 0) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(carDistanceGenerator)) {
            throw new IllegalArgumentException();
        }

        this.tryTimes = tryTimes;
        this.cars = Collections.unmodifiableList(initialCars);
        this.carDistanceGenerator = carDistanceGenerator;
    }

    public GameResult simulate() {
        final GameResult.Builder result = GameResult.builder(tryTimes, cars.size());

        for (int currentPhase = 0; currentPhase < tryTimes; currentPhase++) {
            final List<Car> movedCars = generateCarSnapshot(this.cars);

            result.addPhase(currentPhase, movedCars);
            cars = movedCars;
        }

        return result.build();
    }

    private List<Car> generateCarSnapshot(List<Car> cars) {
        final List<Car> snapshot = cars.stream()
                                       .map(car -> car.goForward(carDistanceGenerator.next()))
                                       .collect(Collectors.toList());

        return Collections.unmodifiableList(snapshot);
    }

    public static RacingGameRunnerBuilder builder() {
        return new RacingGameRunnerBuilder();
    }

    public static final class RacingGameRunnerBuilder {
        private int tryTimes;
        private List<String> carNames;
        private CarDistanceGenerator carDistanceGenerator;

        private RacingGameRunnerBuilder() {
        }

        public RacingGameRunnerBuilder tryTimes(final int tryTimes) {
            this.tryTimes = tryTimes;
            return this;
        }

        public RacingGameRunnerBuilder carNames(final List<String> carNames) {
            this.carNames = carNames;
            return this;
        }

        public RacingGameRunnerBuilder carDistanceGenerator(final CarDistanceGenerator carDistanceGenerator) {
            this.carDistanceGenerator = carDistanceGenerator;
            return this;
        }

        public GameRunner build() {
            return new GameRunner(tryTimes, generateCars(), carDistanceGenerator);
        }

        private List<Car> generateCars() {
            return carNames.stream()
                           .map(Car::new)
                           .collect(Collectors.toList());
        }
    }
}
