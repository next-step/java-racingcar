package racingcar;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayNameGeneration;
import org.junit.jupiter.api.DisplayNameGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

@DisplayNameGeneration(DisplayNameGenerator.ReplaceUnderscores.class)
class CarTest {

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {0, 3})
    void move_랜덤값이_0_이상_또는_3_이하이면_정지한다(int input) {
        Car car = new Car();

        car.move(input);

        assertThat(car.getDistance()).isZero();
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {4, 9})
    void move_랜덤값이_4_이상_또는_9_이하이면_전진한다(int input) {
        Car car = new Car();

        car.move(input);

        assertThat(car.getDistance()).isGreaterThan(0);
    }

    @ParameterizedTest(name = "입력값: {0}")
    @ValueSource(ints = {-1, 10})
    void move_랜덤값이_0_미만_또는_9_초과면_예외가_발생한다(int input) {
        Car car = new Car();

        assertThatThrownBy(() -> car.move(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("랜덤 값은 0 이상 9 이하이어야 합니다.");
    }

    @Test
    void 전진할_때_1_칸씩_이동한다() {
        Car car = new Car();

        car.move(4);

        assertThat(car.getDistance()).isEqualTo(1);
    }
}
