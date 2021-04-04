package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racingcar.command.NumberType;
import racingcar.domain.RacingCar;

import static org.assertj.core.api.Assertions.assertThat;

public class RacingCarTest {

    @DisplayName("전진 테스트")
    @Test
    void move_test() {
        RacingCar racingCar = new RacingCar("pobi", NumberType.ZERO.value());
        racingCar.move(NumberType.FOUR.value());
        assertThat(racingCar.checkFromLocation(NumberType.ONE.value())).isTrue();

    }

    @DisplayName("멈춤 테스트")
    @Test
    void stop_test() {
        RacingCar racingCar = new RacingCar("pobi", NumberType.ZERO.value());
        racingCar.move(NumberType.THREE.value());
        assertThat(racingCar.checkFromLocation(NumberType.ZERO.value())).isTrue();

    }
}
