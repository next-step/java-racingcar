package racinggame.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @DisplayName("이동하는 경우 position 증가, 정지일 경우 position 그대로.")
    @ParameterizedTest
    @CsvSource(value = {"true:0:1", "false:3:3"}, delimiter = ':')
    void move(boolean isMove, int position, int expected) {
        RacingCar racingCar = new RacingCar(position);
        racingCar = racingCar.move(isMove);
        assertThat(racingCar.getPosition()).isEqualTo(expected);
    }
}