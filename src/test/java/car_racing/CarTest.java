package car_racing;

import car_racing.domain.model.Car;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

class CarTest {
    @ParameterizedTest(name = "자동차를 움직이면 자동차가 움직인 만큼 위치가 변한다. 움직인 값: {0}")
    @ValueSource(ints = {1, 2, 3})
    void shouldMoveCarByGivenDistance(int inputDistance) {
        Car car = new Car("");
        car.move(inputDistance);
        assertThat(car.getDistance()).isEqualTo(inputDistance);
    }

    @ParameterizedTest(name = "자동차를 음수만큼 움직이면 예외가 발생한다. 움직인 값: {0}")
    @ValueSource(ints = {-1})
    void shouldThrowRuntimeExceptionWhenNegativeDistanceIsGiven(int inputDistance) {
        Car car = new Car("");
        assertThatThrownBy(() -> car.move(inputDistance))
                .isInstanceOf(RuntimeException.class);
    }
}
