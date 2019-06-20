package com.iksoo.step4.model;

import com.iksoo.step4.controller.CarMainController;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarsTest {
    private String[] carNames = {"pobi", "crong", "honux"};
    private int tryOfNumbers = 3;

    private Cars cars = new Cars(CarMainController.initiateCar(carNames, tryOfNumbers));

    @Test
    void getCarsTest() {
        assertThat(cars.getCars().get(0).getCarName()).isEqualTo("pobi");
    }
}
