package domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차 관련")
class RacingCarTest {

    @DisplayName("랜덤 숫자가 4이상인 경우 move를 호출하고 위치를 1 이동한다.")
    @Test
    void car_move() {

        final RacingCar racingCar = RacingCar.init();
        racingCar.move();

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }
}
