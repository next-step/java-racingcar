package racing;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import racing.domain.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {
    private Car car;

    @BeforeEach
    void setup() {
        car = new Car();
        assertThat(car.findCurrentPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("차가 움직였을때 위치 확인")
    void moveTest() {
        car.move(() -> true);
        assertThat(car.findCurrentPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("차가 움직이지 않았을때 위치 확인")
    void notMoveTest() {
        car.move(() -> false);
        assertThat(car.findCurrentPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("잘못된 CarMovement 전달 시 Exception")
    void notValidCarMovement() {
        assertThatThrownBy(() -> car.move(null))
                .isInstanceOf(IllegalArgumentException.class);
    }
}