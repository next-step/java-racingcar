package step2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

    @ParameterizedTest
    @CsvSource(value = {"+, 1, 1, 2", "+, 9, 9, 18", "-, 5, 5, 0", "-, 8, 9, -1", "*, 3, 3, 9", "*, 3, -4, -12", "/, 8, 2, 4", "/, 2, 1, 2"})
    @DisplayName("사칙연산 테스트")
    void operate(String symbol, int x, int y, int expected) {
        assertEquals(expected, Operator.operate(symbol, x, y));
    }

    @ParameterizedTest
    @CsvSource(value = {"!, 1, 1", "@, 2, 2"})
    @DisplayName("사칙연산 기호가 아닌 기호를 입력")
    void operatorTest(String symbol, int x, int y) {
        assertThatIllegalArgumentException().isThrownBy(() -> Operator.operate(symbol, x, y))
            .withMessageMatching(Constants.INVALID_SYMBOL);
    }

}
