package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import racingcar.util.CarStatusSetterForTest;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @Test
    @DisplayName("[성공] 자동차가 4 이상의 값을 전달받는 경우 전진한다.")
    void 자동차_전진() {
        // Given
        Car car = new Car();

        // When
        car.move(4);

        // Then
        assertThat(car.getDistance()).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 자동차가 4 미만의 값을 전달받는 경우 전진하지 않는다.")
    void 자동차_정지() {
        // Given
        Car car = new Car();

        // When
        car.move(3);

        // Then
        assertThat(car.getDistance()).isEqualTo(0);
    }


    @Test
    @DisplayName("[성공] 자동차가 5번 전진하면 자동차의 위치가 5로 변경된다.")
    void 자동차_5회_전진() {
        // Given
        Car car = new Car();

        // When
        CarStatusSetterForTest.repeatMove(car, 5);

        // Then
        assertThat(car.getDistance()).isEqualTo(5);
    }

    @Nested
    @DisplayName("[학습 테스트]")
    class LearningTest {

        @Test
        @DisplayName("[학습 테스트] String.repeat()")
        void string_repeat() {
            assertThat("-".repeat(3)).isEqualTo("---");

            // repeat 인자로 음수를 전달하는 경우
            assertThatThrownBy(() -> {
                "-".repeat(-1);
            })
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("count is negative: -1");
        }

    }
}
