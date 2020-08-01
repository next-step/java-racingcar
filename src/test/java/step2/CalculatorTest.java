package step2;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;
import org.junit.platform.commons.util.StringUtils;

public class CalculatorTest {
	
	@ParameterizedTest
	@CsvSource(value = {"3 + 3:6", "5 - 3:2", "4 * 3:12", "12 / 6:2", "2 + 3 * 4 / 2:10", "3 + 3 / 2 + 2:5"}, delimiter = ':')
	@DisplayName(value = "덧셈, 뺄셈, 곱셈, 나눗셈 테스트")
	void 사칙연산_테스트(String input, int answer) {
		int result = Calculator.calculation(input);
		assertEquals(result, answer);
	}

	@ParameterizedTest
    @ValueSource(strings = {"", "   "})
    @NullSource
    @DisplayName(value = "공백 테스트")
    void 공백_테스트(String input) {
        assertTrue(StringUtils.isBlank(input));
        assertThatIllegalArgumentException().isThrownBy(()->{
        	Calculator.calculation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = {"2 + 3 + 4 ) 2", "  + 3 + 4 + 2", "2"})
    @DisplayName(value = "잘못된 연산 테스트(계산식)")
    void 사칙연산_예외테스트1(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
        	Calculator.calculation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }

    @ParameterizedTest
    @ValueSource(strings = { "3 + 3 / 0 + 2"})
    @DisplayName(value = "잘못된 연산 테스트(0으로 나누기)")
    void 사칙연산_예외테스트2(String input) {
        assertThatIllegalArgumentException().isThrownBy(()->{
        	Calculator.calculation(input);
        }).isInstanceOf(IllegalArgumentException.class);
    }
}
