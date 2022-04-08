package racingcar.domain;

import java.util.List;

public class RacingCarGame {

    private static final int MOVE_LOWER_BOUND = 4;
    private final List<Car> cars;
    private int rounds;

    public RacingCarGame(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void proceedRound() {
        decreaseGameRound();
        cars.forEach(this::moveOrStop);
    }

    private void decreaseGameRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }

        rounds = rounds - 1;
    }

    private void moveOrStop(Car car) {
        if (MOVE_LOWER_BOUND <= RandomGenerator.generateRandom()) {
            car.move();
        }
    }
}
