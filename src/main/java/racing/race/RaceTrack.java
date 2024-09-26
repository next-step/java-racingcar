package racing.race;

import racing.input.RaceInput;

import java.util.List;
import java.util.Random;

import static racing.Constants.*;

public class RaceTrack {

    private final RacingChecker checker;

    public RaceTrack(RacingChecker checker) {
        this.checker = checker;
    }

    public void race(RaceInput input, List<Car> racingCars) {
        for (int i = 0; i < input.getNumOfAttempt(); i++) {
            racingCars.forEach(this::forward);
        }
    }

    private void forward(Car car) {
        car.forward(this.checker.isForward(new Random().nextInt(RANDOM_NUMBER_BOUND)));
    }
}
