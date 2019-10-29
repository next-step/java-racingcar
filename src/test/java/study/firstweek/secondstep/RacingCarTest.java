package study.firstweek.secondstep;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class RacingCarTest {

    private RacingCar racingCar;

    @BeforeEach
    void setUp() {
        racingCar = new RacingCar();
    }

    @DisplayName("숫자 4일때 차가 움직인다 ")
    @Test
    void carTest() {
        racingCar.makeCarMove(4);
        assertThat(racingCar.getStepHistory().get(1)).isEqualTo(2);
    }

    @DisplayName("숫자 5일때 차가 움직인다 ")
    @Test
    void carTest2() {
        racingCar.makeCarMove(5);
        assertThat(racingCar.getStepHistory().get(1)).isEqualTo(2);
    }

    @DisplayName("숫자 3일때 차가 안 움직인다 ")
    @Test
    void carTest3() {
        racingCar.makeCarMove(3);
        assertThat(racingCar.getStepHistory().get(1)).isEqualTo(1);
    }
}