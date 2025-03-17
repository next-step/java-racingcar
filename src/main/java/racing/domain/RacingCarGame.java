package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.config.GameConfig;

public class RacingCarGame {

    private static final int FORWARD_THRESHOLD = 4;

    private final GameConfig config;
    private final NumberGenerator numberGenerator;
    private final Car[] cars;

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
        for (int round = 0; round < config.getAttemptCount(); round++) {
            executeRound(round);
        }
    }

    private void executeRound(final int roundNumber) {
        for (Car car : cars) {
            if (isMovementAllowed()) {
                car.moveForward(roundNumber);
                continue;
            }
            car.stay(roundNumber);
        }
    }

    private boolean isMovementAllowed() {
        return numberGenerator.generate() >= FORWARD_THRESHOLD;
    }

    public Car[] getCars() {
        return cars;
    }

}
