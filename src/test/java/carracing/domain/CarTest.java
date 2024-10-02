package carracing.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import carracing.exception.RacingCarIllegalArgumentException;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CarTest {

    @DisplayName("난수 값이 4미만이면 자동차를 움직이지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveCar(int position) {
        // given
        Car car = Car.from("green");

        // when
        car.move(position);

        // then
        assertThat(car.getPosition()).isEqualTo(1);
    }

    @DisplayName("자동차 이름은 1글자부터 5글자 이하의 길이를 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"green", "blue", "red"})
    void carNameReturnSuccess(String carName) {
        // given
        Car car = Car.from(carName);

        // when
        car.move(1);

        // then
        assertThat(car)
                .extracting("name", "position")
                .containsExactly(carName, 1);
    }

    @DisplayName("자동차 이름은 비어있는 이름을 사용할 수 없다.")
    @ParameterizedTest
    @NullAndEmptySource
    void carNameWithEmptyString(String carName) {

        // then
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(RacingCarIllegalArgumentException.class);
    }

    @DisplayName("자동차 이름은 5자를 초과할 수 없다.")
    @ParameterizedTest
    @ValueSource(strings = {"cleancode", "exception", "georgia"})
    void carNameReturnException(String carName) {

        // then
        assertThatThrownBy(() -> Car.from(carName))
                .isInstanceOf(RacingCarIllegalArgumentException.class);
    }
}
