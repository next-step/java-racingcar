package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("자동차 테스트")
class CarTest {

    private static final int INITIATION_POSITION_NUMBER = 0;
    private static final int FIRST_MOVING_POSITION_NUMBER = INITIATION_POSITION_NUMBER + 1;

    @DisplayName("유효한 자동차 생성 확인")
    @Test
    void createCarTest() {
        // when
        Car car = new Car();
        // then
        assertThat(car).isNotNull();
        assertThat(car.getPosition()).isEqualTo(new CarPosition(INITIATION_POSITION_NUMBER));
    }

    @DisplayName("자동차가 움직일 수 있는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void moveCarTest() {
        // given
        Car car = new Car();
        // when
        car.move(() -> true);
        // then
        assertThat(car.getPosition()).isEqualTo(new CarPosition(FIRST_MOVING_POSITION_NUMBER));
    }

    @DisplayName("자동차가 움직일 수 없는 경우, 자동자의 위치가 변경되는지 확인")
    @Test
    void checkUnmovableCarTest() {
        // given
        Car car = new Car();
        // when
        car.move(() -> false);
        // then
        assertThat(car.getPosition()).isEqualTo(new CarPosition(INITIATION_POSITION_NUMBER));
    }
}
