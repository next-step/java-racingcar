package carracing.domain.car;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("난수 값이 4미만이면 자동차를 움직이지 못한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveCar(int position) {
        Car car = Car.from(Name.from("green"));

        Car result = car.move(position);

        assertThat(result)
                .isEqualTo(Car.of(Name.from("green"), Position.from(1)));
    }

    @DisplayName("자동차 이름은 1글자부터 5글자 이하의 길이를 허용한다.")
    @ParameterizedTest
    @ValueSource(strings = {"green", "blue", "red"})
    void carNameReturnSuccess(String carName) {
        Car car = Car.from(Name.from(carName));

        Car result = car.move(1);

        assertThat(result)
                .isEqualTo(Car.of(Name.from(carName), Position.from(1)));
    }

}
