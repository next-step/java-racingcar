package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class RacingCarTest {

    @Test
    @DisplayName("입력된 값만큼 전진한다.")
    void test_racing_car_move() {
        assertThat(RacingCar.init(0).move(3).getPosition()).isEqualTo(3);
    }

    @Test
    @DisplayName("자동차 초기화를 하면 출발 지점으로 세팅한다")
    void test_racing_car_init() {
        assertThat(RacingCar.init(0).getPosition()).isEqualTo(0);
    }
}