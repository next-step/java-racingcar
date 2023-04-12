package step3;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;


public class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6})
    void 입력값이_4이상인경우_전진한다(int input) {
        Car car = new Car();
        car.move(input);

        assertThat(car.location()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void 입력값이_4미만인경우_정지한다(int input) {
        Car car = new Car();
        car.move(input);

        assertThat(car.location()).isEqualTo(0);
    }

    @ParameterizedTest
    @ValueSource(ints = {-1, 10, 12})
    void 입력값이_범위를_벗어난경우_예외가_발생한다(int input) {
        Car car = new Car();

        assertThatThrownBy(() -> car.move(input))
                .isInstanceOf(RuntimeException.class);
    }
}
