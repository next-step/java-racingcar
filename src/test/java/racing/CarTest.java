package racing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

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
    @DisplayName("자동차 이름을 공백으로 입력받았을 때")
    @NullSource
    void checkCarNameNullTest(String input) {
        assertThatThrownBy(() -> Car.checkCarName(input))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage("이름이 비어있습니다. 이름을 모두 입력해주세요.");
    }
}
