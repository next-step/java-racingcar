package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void generatorTest() {
        racingCar.move();
        assertThat(racingCar.getStatus())
                .isBetween(0, 1);
    }
}
