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

    @DisplayName("랜덤값이 4이상 9이하 일때에만 차를 전진하게 한다.")
    @Test
    void move_car_when_reference_is_between_4_and_9() {
        CarRacing carRacing = CarRacing.builder().moveTryCount(3).cars(5).build();
        Car given = carRacing.getCars().get(0);
        carRacing.moveCar(given, 4);
        carRacing.moveCar(given, 9);

        assertThat(given.getMoveStatus()).isEqualTo(2);
    }


    @DisplayName("랜덤값이 4 미만, 9 초과 일때에는 차가 전진하지 않는다.")
    @Test
    void do_not_move_car_when_reference_is_lowerThan_4_or_biggerThan_9() {
        CarRacing carRacing = CarRacing.builder().moveTryCount(3).cars(5).build();
        Car given = carRacing.getCars().get(0);

        carRacing.moveCar(given, 3);
        carRacing.moveCar(given, 10);

        assertThat(given.getMoveStatus()).isZero();
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
