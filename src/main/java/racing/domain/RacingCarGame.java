package racing.domain;

import racing.util.NumberGenerator;
import racing.util.RandomNumberGenerator;
import racing.config.GameConfig;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;

import static java.util.stream.Collectors.toMap;

public class RacingCarGame {

    private static final int FORWARD_THRESHOLD = 4;

    private final GameConfig config;
    private final Cars cars;
    private final List<Round> rounds = new ArrayList<>();


    public RacingCarGame(final GameConfig config) {
        this.config = config;
        this.cars = config.getCars();
    }

    public void startRace() {
        for (int roundNumber = 0; roundNumber < config.getAttemptCount(); roundNumber++) {
            rounds.add(new Round(roundNumber, executeRound()));
        }
    }

    private Map<Car, Integer> executeRound() {
        return cars.getAll().stream().collect(Collectors.toMap(Function.identity(), this::determineCarPosition));
    }

    private int determineCarPosition(final Car car) {
        if (isMovementAllowed()) {
            return car.moveForward();
        }
        return car.getPosition();
    }

    private boolean isMovementAllowed() {
        return config.getNumberGenerator().generate() >= FORWARD_THRESHOLD;
    }

    public List<Car> getWinners() {
        return cars.getWinners();
    }

    public List<Round> getResult() {
        return rounds;
    }

    public List<Car> getCars() {
        return cars.getAll();
    }
}
