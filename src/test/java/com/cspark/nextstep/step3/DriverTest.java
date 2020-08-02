package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    private final int MIN = 0;
    private final int MAX = 9;
    private Dice dice;
    private RacingCar racingCar;
    private Driver driver;

    @BeforeEach
    void setUp() {
        this.dice = new Dice(MIN, MAX);
        this.racingCar = new RacingCar();
        this.driver = new Driver(dice, racingCar);
    }

    @DisplayName("전진/정지 운전하다")
    @Test
    void drive() {
        assertThat(driver.drive())
                .isLessThanOrEqualTo(1);
        assertThat(driver.drive())
                .isLessThanOrEqualTo(2);
        assertThat(driver.drive())
                .isLessThanOrEqualTo(3);
        assertThat(driver.drive())
                .isLessThanOrEqualTo(4);
    }
}