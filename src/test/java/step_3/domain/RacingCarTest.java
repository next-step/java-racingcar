package step_3.domain;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step_3.util.Behavior;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    RacingCar racingCar;

    @BeforeEach
    void beforeEach() {
        racingCar = new RacingCar();
    }

    @Test
    @DisplayName("레이싱 카 객체 생성")
    void createRacingCar() {
        assertThat(new RacingCar()).isInstanceOf(RacingCar.class);
    }

    @ParameterizedTest(name = "정지 - {0}")
    @ValueSource(ints = {0, 1, 2, 3})
    void stop(int roundResult) {
        assertThat(this.racingCar.stopOrForward(roundResult)).isEqualTo(Behavior.STOP);
    }

    @ParameterizedTest(name = "전진 - {0}")
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void forward(int roundResult) {
        assertThat(this.racingCar.stopOrForward(roundResult)).isEqualTo(Behavior.FORWARD);
    }
}
