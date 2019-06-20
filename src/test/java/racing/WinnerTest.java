package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import racing.domain.Car;
import racing.domain.Cars;
import racing.domain.WinnerMaker;
import racing.domain.strategy.DrivingMoveStrategy;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private String INPUT_CAR_NAME = "car";
    private String INPUT_CAR_NAME_COMPARED = "car_compared";

    private WinnerMaker winnerMaker;
    private List<String> carNames;
    private Cars mCars;

    @BeforeEach
    void setUp() {
        carNames = Arrays.asList(INPUT_CAR_NAME, INPUT_CAR_NAME_COMPARED);
        mCars = new Cars(carNames);

        winnerMaker = new WinnerMaker(mCars);
    }

    @Test
    void winner() {
        Car target = mCars.getCar(0);
        target.goOrNot(new DrivingMoveStrategy());

        assertThat(winnerMaker.getWinners()).containsExactly(target);
    }

    @Test
    void winners_두명이상() {
        Car target = mCars.getCar(1);
        Car anotherTarget = mCars.getCar(1);

        assertThat(winnerMaker.getWinners()).contains(target, anotherTarget);
    }
}
