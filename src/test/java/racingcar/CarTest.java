package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @ParameterizedTest
    @ValueSource(ints = {4, 9})
    @DisplayName("자동차 이동 성공 테스트")
    void checkCarMovingSuccess(int value) {
        Car car = Car.makeCar("name");
        car.move(value);
        assertThat(car.getCurrentPosition()).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 3})
    @DisplayName("자동차 이동 실패 테스트")
    void checkCarMovingFail(int value) {
        Car car = Car.makeCar("name");
        car.move(value);
        assertThat(car.getCurrentPosition()).isEqualTo(0);
    }

}