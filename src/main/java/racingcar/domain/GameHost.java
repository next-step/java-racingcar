package racingcar.domain;

import java.util.List;
import java.util.Random;

public class GameHost {

    private static final int MOVE_LOWER_BOUND = 4;
    private static final Random RANDOM_GENERATOR = new Random();
    private final List<Car> cars;
    private int rounds;

    public GameHost(List<Car> cars, int rounds) {
        this.cars = cars;
        this.rounds = rounds;
    }

    public void proceedRound() {
        if (rounds <= 0) {
            throw new IllegalStateException("game is already over");
        }

        this.rounds = rounds - 1;

        cars.forEach(car -> {
            int random = RANDOM_GENERATOR.nextInt(10);
            if (MOVE_LOWER_BOUND <= random) {
                car.move();
            }
        });
    }
}
