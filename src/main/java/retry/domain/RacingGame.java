package retry.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class RacingGame {

    private static final int PIVOT_NUMBER = 4;
    private static final int RANDOM_BOUND_NUMBER = 9;
    private List<Cars> racingCars;
    private Cars cars;
    public RacingGame(Cars cars) {
        this.racingCars = new ArrayList<>();
        this.cars = cars;
    }

    public List<Cars> racingGame() {
        racingCars.add(cars.moveCarsPositionByInterface(() -> getRandomNumber() >= PIVOT_NUMBER));
        return racingCars;
    }

    private int getRandomNumber() {
        return new Random().nextInt(RANDOM_BOUND_NUMBER);
    }

}
