package racingcar.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.random.TestRandomNumberGenerator;

import static org.assertj.core.api.Assertions.assertThat;

class CarControllerTest {

    @DisplayName("난수값이 4이상이면 자동차를 1만큼 움직인다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 9, 100})
    void moveCar(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);
        CarController carController = new CarController(testRandomNumberGenerator);

        Car car = new Car();

        // when
        carController.moveCar(car);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("난수 값이 4미만이면 자동차를 움직이지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void noMoveCar(int randomNumber) {
        // given
        TestRandomNumberGenerator testRandomNumberGenerator = new TestRandomNumberGenerator(randomNumber);
        CarController carController = new CarController(testRandomNumberGenerator);

        Car car = new Car();

        // when
        carController.moveCar(car);

        // then
        assertThat(car.getPosition()).isZero();
    }
}