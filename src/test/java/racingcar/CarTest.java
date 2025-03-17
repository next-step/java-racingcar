package racingcar;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;

class CarTest {

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
