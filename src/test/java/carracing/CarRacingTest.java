package carracing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarRacingTest {
    @DisplayName("참여하는 Car 객체들과 이동 시도 횟수를 가지는 레이싱 경기가 생성된다.")
    @Test
    void return_carRacing_instance() {
        CarRacing carRacing = CarRacing.builder().moveTryCount(3).cars(5).build();

        assertThat(carRacing.getCars()).hasSize(5);
        assertThat(carRacing.getPlayCount()).isZero();
        assertThat(carRacing.getMoveTryCount()).isEqualTo(3);
        assertThat(carRacing.getResultView())
                .isNotNull()
                .isInstanceOf(ResultView.class);
    }

    @DisplayName("경주에 참여하는 차들의 초기 이동 상태는 0이다.")
    @Test
    void cars_init_moveStatus_is_zero() {
        CarRacing carRacing = CarRacing.builder().moveTryCount(3).cars(1).build();

        assertThat(carRacing.getCars().get(0).getMoveStatus()).isZero();
    }

    @DisplayName("경기가 진행되고 끝나면 경기의 진행 횟수는 이동 시도 횟수와 같은 값이다.")
    @Test
    void playCount_is_equalTo_moveTryCount_when_carRacing_is_over() {
        final int givenMoveTryCount = 3;
        CarRacing carRacing = CarRacing.builder().moveTryCount(givenMoveTryCount).cars(5).build();

        carRacing.start();

        assertThat(carRacing.getPlayCount()).isEqualTo(givenMoveTryCount);
    }
}
