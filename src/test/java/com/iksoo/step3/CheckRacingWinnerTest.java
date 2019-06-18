package com.iksoo.step3;

<<<<<<< HEAD
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CheckRacingWinnerTest {
    private final int TRY_OF_NUMBERS = 3;
    private final int GOSTOP_CRITERION = 4;
    private final int RANDOM_SEED = 190620;
    private final String[] carNames = {"pobi", "crong", "honux"};

    private CheckRacingWinner checkRacingWinner;
    private Random random;
    private List<Car> cars;

    @BeforeEach
    void setUp() {
        checkRacingWinner = new CheckRacingWinner();
        random = new Random(RANDOM_SEED);

        cars = CarMain.initiateCar(carNames, TRY_OF_NUMBERS);
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addNextInning(random.nextInt(10), GOSTOP_CRITERION);
        }
    }

    @Test
    void getMaxDistanceTest() {
        assertThat(checkRacingWinner.getMaxDistance(cars)).isEqualTo(1);
    }

    @Test
    void isWinnerThenAddTest() {
        List<Object> winner = new ArrayList<Object>();

        for (int i = 0; i < cars.size(); i++) {
            checkRacingWinner.isWinnerThenAdd(cars.get(i), winner, checkRacingWinner.getMaxDistance(cars));
        }

        assertThat(winner).contains("pobi", "crong");
    }
=======
public class CarTest {
>>>>>>> fix(CheckWinner) : 불필요한 메소드 파라미터 제거
}
