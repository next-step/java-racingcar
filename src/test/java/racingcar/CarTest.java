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
        Car car = new Car();
        int distance = car.move(4);
        assertThat(distance).isEqualTo(1);
    }

    @Test
    @DisplayName("[성공] 자동차가 4 미만의 값을 전달받는 경우 전진하지 않는다.")
    void 자동차_정지() {
        Car car = new Car();
        int distance = car.move(3);
        assertThat(distance).isEqualTo(0);
    }


    @Test
    @DisplayName("[성공] 자동차의 전진거리 만큼 '-'를 반복해서 출력한다.")
    void 자동차_toString() {
        // Given
        Car car = new Car();

        // When
        CarStatusSetterForTest.repeatMove(car, 5);

        // Then
        assertThat(car.toString()).isEqualTo("-----");
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
