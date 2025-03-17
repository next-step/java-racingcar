package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarTest {

    @ParameterizedTest
    @CsvSource(value = {"2:0", "3:0", "4:1", "5:1"}, delimiter = ':')
    @DisplayName("숫자가 4 이상이 나오면 자동차는 움직일 수 있다")
    void moveTest(int number, int expectedPosition) {
        Car car = Car.of("pobi");
        car.move(new RandomForTest(number));
        int actualPosition = car.getPosition();
        Assertions.assertThat(actualPosition).isEqualTo(expectedPosition);
    }

    @ParameterizedTest
    @ValueSource(strings = {"a", "ab", "abc", "abcd", "abcde"})
    @DisplayName("자동차 이름이 1자 이상 5자 이하면 정상적으로 생성된다")
    void generateInstanceSuccessTest(String carName) {
        assertDoesNotThrow(() -> Car.of(carName));
    }

    @ParameterizedTest
    @ValueSource(strings = {"", "abcdef", "abcdefghijklmn"})
    @DisplayName("자동차 이름이 0자거나 5자 초과면 에러가 발생한다")
    void generateInstanceFailTest(String carName) {
        Assertions.assertThatThrownBy(() -> Car.of(carName))
                .isInstanceOf(IllegalArgumentException.class);
    }
}
