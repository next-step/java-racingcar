package com.iksoo.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;
import java.util.Random;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {
    private final int TRY_OF_NUMBERS = 3;
    private final int GOSTOP_CRITERION = 4;
    private final int RANDOM_SEED = 190620;

    private Random random;
    private List<Car> cars;
    private String[] carNames = {"pobi", "crong", "honux"};

    @BeforeEach
    void setUp() {
        random = new Random(RANDOM_SEED);

        cars = CarMain.initiateCar(carNames, TRY_OF_NUMBERS);
        for (int i = 0; i < cars.size(); i++) {
            cars.get(i).addNextInning(random.nextInt(10), GOSTOP_CRITERION);
        }
    }

    @Test
    void getCarNameTest() {
        assertThat(cars.get(0).getCarName()).isEqualTo("pobi");
    }

    @Test
    void getTotalInningTest() {
        assertThat(cars.get(0).getTotalInning()).isEqualTo(TRY_OF_NUMBERS);
    }

    @Test
    void getFinalPositionTest() {
        assertThat(cars.get(0).getFinalPosition()).isEqualTo(1);
    }
}
