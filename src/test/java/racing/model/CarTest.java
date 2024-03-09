package racing.model;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @Test
    @DisplayName("랜덤값이 4 미만인 경우, 자동차는 움직이지 않음")
    void move_under_four__ShouldNotMove() {
        // given
        Car car = new Car() {
            @Override
            protected boolean isGoing() {
                return false;
            }
        };

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(0);
        assertThat(car.getPosition()).isBlank();
    }

    @Test
    @DisplayName("랜던값이 4이상인 경우, 자동차는 움직임")
    void move_above_four__ShouldMove() {
        // given when
        Car car = new Car() {
            @Override
            protected boolean isGoing() {
                return true;
            }
        };

        // when
        car.move();

        // then
        assertThat(car.getScore()).isEqualTo(1);
        assertThat(car.getPosition()).isNotBlank();
    }

}
