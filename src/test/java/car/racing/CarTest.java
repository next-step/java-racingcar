package car.racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;

public class CarTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void verifyCarForward() {
        Car car = new Car("kyle");
        car.forward("-");
        assertThat(car.forwardResult()).isEqualTo("kyle : -");
    }

    @DisplayName("4 이상일 때 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void verifyForwardable(int randomNum) {
        CarForwardable forwardable = new CarForwardableImpl();
        assertThat(forwardable.forwardable(randomNum)).isEqualTo(true);
    }

    @DisplayName("4 미만일 때 멈춤 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void verifyFowardDisable(int randomNum) {
        CarForwardable forwardable = new CarForwardableImpl();
        assertThat(forwardable.forwardable(randomNum)).isEqualTo(false);
    }
}
