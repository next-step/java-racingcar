package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class WinnerTest {

    private String INPUT_CAR_NAME = "car";
    private String INPUT_CAR_NAME_COMPARED = "car_compared";

    private WinnerMaker winnerMaker;
    private Car mCar;
    private Car mCompared;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        mCar        = new Car(INPUT_CAR_NAME);
        mCompared   = new Car(INPUT_CAR_NAME_COMPARED);

        cars = Arrays.asList(mCompared, mCar);

        winnerMaker = new WinnerMaker(cars);
    }

    @Test
    void winner() {
        mCompared.go();

        assertThat(new WinnerMaker(cars).getWinners()).containsExactly(mCompared);
    }

    @Test
    void winners_두명이상() {
        assertThat(new WinnerMaker(cars).getWinners()).contains(mCar, mCompared);
    }
}
