package com.iksoo.step3;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMainTest {
    private final int TRY_OF_NUMBERS = 3;

    private String[] carNames = {"pobi", "crong", "honux"};
    private List<Car> cars = CarMain.initiateCar(carNames, TRY_OF_NUMBERS);

    @Test
    void initiateCarTest() {
        cars = CarMain.initiateCar(carNames, TRY_OF_NUMBERS);
        assertThat(cars.get(0).getCarName()).contains("pobi");
    }
}
