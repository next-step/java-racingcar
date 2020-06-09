package edu.nextstep.racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {
    private RacingCar racingCar;
    private RacingCarMovingCheck racingCarMovingCheck;
    private MovingCheckTest movingCheckTest;

    @BeforeEach
    void setUp() {
        RandomNumber randomNumber = new RandomNumber();
        this.racingCarMovingCheck = new RacingCarMovingCheck(randomNumber);
        this.movingCheckTest = new MovingCheckTest();
        racingCar = new RacingCar();
    }

    @DisplayName("자동차 이동 테스트")
    @Test
    void generatorTest() {
        racingCar.move(racingCarMovingCheck);
        assertThat(racingCar.getStatus())
                .isBetween(0, 1);
    }

    @DisplayName("전진 테스트")
    @Test
    void carMovingTest() {
        movingCheckTest.setFlag(true);
        racingCar.move(movingCheckTest);
        assertThat(racingCar.getStatus())
                .isEqualTo(1);
    }

    @DisplayName("정지 테스트")
    @Test
    void carStopTest() {
        movingCheckTest.setFlag(false);
        racingCar.move(movingCheckTest);
        assertThat(racingCar.getStatus())
                .isEqualTo(0);
    }
}

