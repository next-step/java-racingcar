package com.cspark.nextstep.step3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class DriverTest {

    private final int MIN = 0;
    private final int MAX = 9;
    private Dice dice;
    private Driver driver;

    @BeforeEach
    void setUp() {
        this.dice = new Dice(MIN, MAX);
        this.driver = new Driver((d) -> d.cast() > 3);
    }

    @DisplayName("전진/정지 운전하다")
    @Test
    void drive() {
        assertThat(driver.drive(dice))
                .isLessThanOrEqualTo(1);
        assertThat(driver.drive(dice))
                .isLessThanOrEqualTo(2);
        assertThat(driver.drive(dice))
                .isLessThanOrEqualTo(3);
        assertThat(driver.drive(dice))
                .isLessThanOrEqualTo(4);
    }
}