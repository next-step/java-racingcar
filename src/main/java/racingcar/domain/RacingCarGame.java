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

    public void proceedRound(List<Integer> randomNumbers) {
        assert cars.size() == randomNumbers.size();

        decreaseGameRound();
        for (int i = 0; i < cars.size(); i++) {
            this.moveOrStop(cars.get(i), randomNumbers.get(i));
        }
    }

    private void decreaseGameRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }

        rounds = rounds - 1;
    }

    private void moveOrStop(Car car, int random) {
        if (MOVE_LOWER_BOUND <= random) {
            car.move();
        }
    }
}
