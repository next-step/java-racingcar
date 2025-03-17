package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import step3.game.Car;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {
    @Test
    @DisplayName("움직임이 4 미만일 경우, 자동차는 움직이지 않아야 한다.")
    void carNotMoveTest() {
        Car car = new Car();
        car.move(3);
        assertThat(car.getPosition()).isEqualTo(0);
    }

    @Test
    @DisplayName("움직임이 4 이상일 경우, 자동차는 한 칸 움직여야 한다.")
    void carMoveTest() {
        Car car = new Car();
        car.move(5);
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @Test
    @DisplayName("움직임이 9 이상일 경우, IllegalArgumentException이 발생해야 한다.")
    void carMoveExceptionTest() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(10);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("움직일 수 있는 조건을 벗어났습니다. 값 : 10");
    }

    @Test
    @DisplayName("움직임이 0 미만일 경우, IllegalArgumentException이 발생해야 한다.")
    void carMoveExceptionTest2() {
        Car car = new Car();
        assertThatThrownBy(() -> {
            car.move(-1);
        }).isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("움직일 수 있는 조건을 벗어났습니다. 값 : -1");
    }
}
