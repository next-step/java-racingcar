package com.iksoo.step4.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Java6Assertions.assertThat;

public class CarTest {
    private Car car;

    @BeforeEach
    void setUp() {
        car = new Car("pobi", 3);
        car.doRacing(4);
    }

    @Test
    void getCarNameTest() {
        assertThat(car.getCarName()).isEqualTo("pobi");
    }

    @Test
    void getTotalInningTest() {
        assertThat(car.getTotalInning()).isEqualTo(3);
    }

    @Test
    void getRanHistoryTest() {
        assertThat(car.getRanHistory(1)).isEqualTo("pobi : -");
    }

    @Test
    void isVictoryTest() {
        assertThat(car.isVictory(1)).isTrue();
    }

    @Test
    void getFinalPositionTest() {
        assertThat(car.getFinalPosition()).isEqualTo(1);
    }
}
