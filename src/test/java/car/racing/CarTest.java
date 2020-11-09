package car.racing;

import car.racing.domain.Car;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CarTest {

    @DisplayName("자동차 전진 테스트")
    @Test
    void verifyCarForward() {
        Car car = new Car("kyle", 0);

        for (int i = 0; i < 10; i++) {
            car.forward();
        }

        assertThat(car.getForwardCount()).isEqualTo(10);
    }

    @DisplayName("자동차 올바르지 않은 이름 입력 테스트")
    @Test
    void verifyCarInvalidName() {
        assertThatExceptionOfType(IllegalArgumentException.class)
                .isThrownBy(() -> new Car("kyleee", 0))
                .withMessageMatching("이름 길이가 너무 기네요ㅠ");
    }

    @DisplayName("4 이상일 때 전진 테스트")
    @ParameterizedTest
    @ValueSource(ints = {4, 5, 6, 7, 8})
    void verifyForwardable(int randomNum) {
        Forwardable forwardable = new CarForwardable();
        assertThat(forwardable.forwardable(randomNum)).isEqualTo(true);
    }

    @DisplayName("4 미만일 때 멈춤 테스트")
    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void verifyFowardDisable(int randomNum) {
        Forwardable forwardable = new CarForwardable();
        assertThat(forwardable.forwardable(randomNum)).isEqualTo(false);
    }
}
