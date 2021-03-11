package racingcar.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

class CarTest {

    @DisplayName("random 값이 4 이상인 경우 전진한다.")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    void moveOrStay_moveTest(int value) {
        // given
        Car testCar = new Car();

        // when
        testCar.moveOrStay(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(Car.INITIAL_POSITION + 1);
    }

    @DisplayName("random 값이 4 미만인 경우 정지한다.")
    @ParameterizedTest
    @ValueSource(ints = {0, 1, 2, 3})
    void moveOrStay_stayTest(int value) {
        // given
        Car testCar = new Car();

        // when
        testCar.moveOrStay(value);

        // then
        assertThat(testCar.getPosition()).isEqualTo(Car.INITIAL_POSITION);
    }
}
