package racing.domain;

import racing.config.GameConfig;

import java.util.*;

public class RacingCarGame {

    private final GameConfig config;
    private final Cars cars;
    private final List<Round> rounds = new ArrayList<>();

    public RacingCarGame(final GameConfig config) {
        this.config = config;
        this.cars = config.getCars();
    }

    public void startRace() {
        for (int roundNumber = 0; roundNumber < config.getAttemptCount(); roundNumber++) {
            Round round = new Round(roundNumber, config.getMoveStrategy());
            round.execute(cars);

            rounds.add(round);
        }
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
