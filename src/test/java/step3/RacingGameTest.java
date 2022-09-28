package step3;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

class RacingGameTest {

    @ParameterizedTest
    @ValueSource(ints = {4,5,6,7,8,9})
    @DisplayName ("랜덤값이 4이상인 경우 전진(true)")
    void move(int randomValue) {
        Car car = new Car();
        assertThat(car.isMove(randomValue)).isEqualTo(true);
    }

    @ParameterizedTest
    @ValueSource(ints = {1,2,3})
    @DisplayName ("랜덤값이 3이하인 경우 멈춤(false)")
    void stop(int randomValue) {
        Car car = new Car();
        assertThat(car.isMove(randomValue)).isEqualTo(false);
    }
}