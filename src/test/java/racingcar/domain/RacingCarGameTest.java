package racingcar.domain;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.List;
import org.junit.jupiter.api.Test;

class RacingCarGameTest {

    @Test
    void 자동차_게임_횟수만큼_자동차가_전진한다() {
        final List<Car> cars = Arrays.asList(new Car("dami"), new Car("jason"));
        final int TRY_COUNT = 1;

        RacingCarGame racingCarGame = new RacingCarGame(cars, TRY_COUNT);
        racingCarGame.play();

        final List<Car> movingCars = racingCarGame.getMovingCars();

    }

}