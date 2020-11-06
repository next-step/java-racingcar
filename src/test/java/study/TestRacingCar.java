package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

public class TestRacingCar {
    RacingCar racingCar;

    @DisplayName("자동차 생성")
    @Test
    void test_racing_car() {
        racingCar = new RacingCar(5);
        assertThat(racingCar.getLength()).isEqualTo(5);
    }

    @DisplayName("자동차 이동")
    @ParameterizedTest
    @CsvSource({"true,1", "false,1",})
    void test_moveForward(boolean movement, int resultIndex) {
        racingCar = new RacingCar(1);
        racingCar.moveForward(movement);
        assertThat(racingCar.getIndex()).isEqualTo(resultIndex);
    }
}
