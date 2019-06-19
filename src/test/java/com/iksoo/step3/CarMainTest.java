package com.iksoo.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMainTest {
    String[] carNames = {"pobi","crong","honux"};
    Car[] cars;

    @BeforeEach
    void setUp() {
    }

    @Test
    void initiateCarTest() {
        cars = CarMain.initiateCar(carNames);
        assertThat(cars[0].getCarName()).contains("pobi");
        assertThat(cars[1].getCarName()).contains("crong");
        assertThat(cars[2].getCarName()).contains("honux");
    }

    @Test
    void judgeGoOrStopTest() {
        assertThat(CarMain.judgeGoOrStop(3)).isEqualTo("0");
        assertThat(CarMain.judgeGoOrStop(4)).isEqualTo("1");
        assertThat(CarMain.judgeGoOrStop(5)).isEqualTo("1");
    }
}
