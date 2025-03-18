package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.config.GameConfig;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class RacingCarGame {

    private static final int FORWARD_THRESHOLD = 4;

    private final GameConfig config;
    private final NumberGenerator numberGenerator;
    private final Car[] cars;
    private final List<Round> rounds = new ArrayList<>();

    public RacingCarGame(final GameConfig config) {
        this(config, new RandomNumberGenerator());
    }

    public RacingCarGame(final GameConfig config, final NumberGenerator numberGenerator) {
        this.config = config;
        this.numberGenerator = numberGenerator;
        this.cars = initializeCars(config.getCarCount());
    }

    private Car[] initializeCars(final int carCount) {
        Car[] cars = new Car[carCount];
        for (int i = 0; i < carCount; i++) {
            cars[i] = new Car();
        }
        return cars;
    }

    public void startRace() {
        for (int roundNumber = 0; roundNumber < config.getAttemptCount(); roundNumber++) {
            rounds.add(new Round(roundNumber, executeRound()));
        }
    }

    private Map<Car, Integer> executeRound() {
        Map<Car, Integer> carPositions = new HashMap<>();
        for (Car car : cars) {
            if (isMovementAllowed()) {
                carPositions.put(car, car.moveForward());
                continue;
            }
            carPositions.put(car, car.getPosition());
        }
        return carPositions;
    }

    private boolean isMovementAllowed() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }

    public List<Round> getResult() {
        return rounds;
    }

    public Car[] getCars() {
        return cars;
    }
}
