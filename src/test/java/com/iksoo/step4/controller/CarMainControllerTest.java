package com.iksoo.step4.controller;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CarMainControllerTest {
    private String[] carNames = {"pobi", "crong", "honux"};
    private int tryOfNumbers = 3;

    @BeforeEach
    void setUp() {
    }

    @Test
    void initiateCarTest() {
        assertThat(CarMainController.initiateCar(carNames, tryOfNumbers).get(0).getCarName()).isEqualTo("pobi");
    }

    @Test
    void getRandomTest() {
        assertThat(CarMainController.getRandom()).isBetween(0, 9);
    }
}
