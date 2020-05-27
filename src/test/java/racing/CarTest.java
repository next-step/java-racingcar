package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.ValueSource;
import racing.domain.car.Car;

import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CarTest {

    @ParameterizedTest
    @DisplayName("Car 전진 또는 정지")
    @ValueSource(ints = {1, 0})
    void moveTest(int expected) {
        //Car car = new Car(new CarForwardBehavior());

        // assertThat(CarForwardBehavior.action()).isEqualTo(expected);
    }

    @ParameterizedTest
    @DisplayName("자동차 이름이 없을 때")
    @EmptySource
    void checkCarNameNullTest(String input) {
        assertThatThrownBy(() -> Car.checkCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 비어있습니다. 이름을 모두 입력해주세요.");
    }
}
