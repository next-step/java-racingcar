package step3.car.game.unit;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step3.domain.Car;
import step3.domain.Cars;

import static org.assertj.core.api.Assertions.*;


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

    @Test
    void 모든_자동차를_이동() {
        Cars cars = new Cars(5);

        assertThatCode(() -> cars.move())
                .doesNotThrowAnyException();
    }
}
