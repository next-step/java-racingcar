package racingcar;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @DisplayName("이름을 가진 자동차가 생성된다")
    @ParameterizedTest
    @ValueSource(strings = {"a", "car05"})
    void createCar(String name) {
        Car car = new Car(name);
        assertThat(car).isNotNull();
    }

    @DisplayName("이름이 빈 값이거나 5자 초과인 경우 예외가 발생한다")
    @ParameterizedTest
    @ValueSource(strings = {"", "   ", "car006"})
    void carNameLongThrowsException(String name) {
        assertThatThrownBy(() -> new Car(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("자동차 이름");
    }

    @DisplayName("값이 4 이상일 때 자돋차가 이동한다")
    @ParameterizedTest
    @CsvSource({"0,0", "3,0", "4,1", "9,1"})
    void canMoveWhenAtLeast(int number, int expected) {
        Car car = new Car("car1");
        car.moveIfPossible(number);
        assertThat(car.position()).isEqualTo(expected);
    }
}
