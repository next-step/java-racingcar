package racing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("레이싱 자동차 객체 테스트")
class RacingCarTest {

    @DisplayName("시작하지 않는 레이킹카의 기본 위치는 0이다.")
    @Test
    void before_start() {

        final RacingCar racingCar = new RacingCar(new CarName("codeleesh"));

        assertThat(racingCar.getPosition()).isZero();
    }

    @DisplayName("랜덤 숫자가 4이상인 경우 move를 호출하고 위치를 1 이동한다.")
    @Test
    void car_move() {

        final RacingCar racingCar = new RacingCar(new CarName("codeleesh"));
        racingCar.move();

        assertThat(racingCar.getPosition()).isEqualTo(1);
    }

    @DisplayName("중간 결과 포맷을 확인한다.")
    @Test
    void car_move_format() {

        final RacingCar racingCar = new RacingCar(new CarName("codeleesh"));
        racingCar.move();

        assertThat(racingCar.extracted()).isEqualTo("codeleesh : -");
    }
}
