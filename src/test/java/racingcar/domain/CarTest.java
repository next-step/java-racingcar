package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

public class CarTest {
    
    @Test
    @DisplayName("condition 값이 4 보다 작으면 Car 의 위치값은 유지된다.")
    void carStop() {
        Car car = new Car();
        int oldPosition = car.getPosition();

        car.stopOrGo(3);

        assertThat(car.getPosition()).isEqualTo(oldPosition);
    }

    @Test
    @DisplayName("condition 값이 4 보다 작으면 Car 의 위치값 1 증가한다.")
    void carGo() {
        Car car = new Car();
        int oldPosition = car.getPosition();

        car.stopOrGo(5);

        assertThat(car.getPosition()).isEqualTo(oldPosition + 1);
    }

    @Test
    @DisplayName("condition 음수일경우 IllegalArgument 예외를 반환한다.")
    void negativeException() {
        assertThatThrownBy(() -> new Car().stopOrGo(-1))
                .isInstanceOf(IllegalArgumentException.class);
    }

    @Test
    @DisplayName("condition 9보다 크면 IllegalArgument 예외를 반환한다.")
    void overflowException() {
        assertThatThrownBy(() -> new Car().stopOrGo(10))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
