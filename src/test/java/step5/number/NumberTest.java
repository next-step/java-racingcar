package step5.number;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import step4.number.Number;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class NumberTest {

    @ParameterizedTest
    @DisplayName("숫자는 0과 9 사이여야 한다")
    @ValueSource(ints = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9})
    void normalValue(int value) {
        assertDoesNotThrow(() -> new Number(value));
    }

    @ParameterizedTest
    @DisplayName("숫자가 0보다 작은 경우 에러가 발생한다")
    @ValueSource(ints = {-1, -2})
    void lessThanZero(int value) {
        assertThrows(IllegalArgumentException.class, () -> new Number(value));
    }

    @ParameterizedTest
    @DisplayName("숫자가 9보다 큰 경우 에러가 발생한다")
    @ValueSource(ints = {10, 20})
    void lessThanNine(int value) {
        assertThrows(IllegalArgumentException.class, () -> new Number(value));
    }
}