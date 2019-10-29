package step2;

import java.util.Collections;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;
import java.util.stream.LongStream;

public class GameRunner {
    private List<Car> cars;
    private final int tryTimes;
    private final CarDistanceGenerator carDistanceGenerator;

    private GameRunner(final int tryTimes,
                       final int numberOfCars,
                       final CarDistanceGenerator carDistanceGenerator) {
        if (tryTimes <= 0) {
            throw new IllegalArgumentException();
        }
        if (numberOfCars <= 0) {
            throw new IllegalArgumentException();
        }
        if (Objects.isNull(carDistanceGenerator)) {
            throw new IllegalArgumentException();
        }

        this.tryTimes = tryTimes;
        this.cars = Collections.unmodifiableList(LongStream.range(0, numberOfCars)
                                                           .mapToObj(i -> new Car(String.format("car at %s", i)))
                                                           .collect(Collectors.toList()));
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
        private int numberOfCars;
        private CarDistanceGenerator carDistanceGenerator;

        private RacingGameRunnerBuilder() {
        }

        public RacingGameRunnerBuilder tryTimes(final int tryTimes) {
            this.tryTimes = tryTimes;
            return this;
        }

        public RacingGameRunnerBuilder numberOfCars(final int numberOfCars) {
            this.numberOfCars = numberOfCars;
            return this;
        }

        public RacingGameRunnerBuilder carDistanceGenerator(final CarDistanceGenerator carDistanceGenerator) {
            this.carDistanceGenerator = carDistanceGenerator;
            return this;
        }

        public GameRunner build() {
            return new GameRunner(tryTimes, numberOfCars, carDistanceGenerator);
        }
    }
}
