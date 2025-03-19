package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.config.GameConfig;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class RacingCarGame {

    private static final int FORWARD_THRESHOLD = 4;

    private final GameConfig config;
    private final NumberGenerator numberGenerator;
    private final List<Car> cars;
    private final List<Round> rounds = new ArrayList<>();

    public RacingCarGame(final GameConfig config) {
        this(config, new RandomNumberGenerator());
    }

    public RacingCarGame(final GameConfig config, final NumberGenerator numberGenerator) {
        this.config = config;
        this.numberGenerator = numberGenerator;
        this.cars = initializeCars(config.getCarNames());
    }

    private List<Car> initializeCars(final String[] carNames) {
        return Stream.of(carNames)
                .map(Car::new)
                .collect(Collectors.toUnmodifiableList());
    }

    public void startRace() {
        for (int roundNumber = 0; roundNumber < config.getAttemptCount(); roundNumber++) {
            rounds.add(new Round(roundNumber, executeRound()));
        }
    }

    private Map<Car, Integer> executeRound() {
        Map<Car, Integer> carPositions = new HashMap<>();
        for (Car car : cars) {
            int position = isMovementAllowed() ? car.moveForward() : car.getPosition();

            carPositions.put(car, position);
        }
        return carPositions;
    }

    private boolean isMovementAllowed() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }

    public List<Car> getWinners() {
        Integer maxPosition = cars.stream().map(Car::getPosition).max(Comparator.comparingInt(a -> a)).orElse(-1);

        return cars.stream().filter(entry -> entry.getPosition() == maxPosition).collect(Collectors.toList());
    }

    public List<Round> getResult() {
        return rounds;
    }

    public List<Car> getCars() {
        return cars;
    }
}
