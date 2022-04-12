package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import racingcar.domain.Car;
import static org.assertj.core.api.Assertions.assertThat;

class CarTest {
    private final Car car = new Car();

    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8, 9})
    @DisplayName("자동차 전진 테스트")
    void moveTest(int value) {
        assertThat(car.moveOrStop(value)).isEqualTo(1);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    @DisplayName("자동차 멈춤 테스트")
    void stopTest(int value) {
        assertThat(car.moveOrStop(value)).isZero();
    }
}
