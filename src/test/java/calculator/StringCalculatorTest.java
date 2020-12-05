package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class StringCalculatorTest {
	@ParameterizedTest
	@CsvSource(value = {"1 + 3:4", "10 - 3 - 2:5", "5 * 2:10", "18 / 3:6", "2 + 3 * 4 / 2:10"}, delimiter = ':')
	@DisplayName("문자열 계산 테스트")
	void calculateTest(String inputString, int result) {
		assertThat(StringCalculator.stringCalculate(inputString)).isEqualTo(result);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", " - 3 - 2", "5 % 2", "   / 2"})
	@DisplayName("입력값이 비어있거나 연산기호가 사친연산이 아닐 때 IllegalArgumentException 테스트")
	void throwIllegalArgumentExceptionTest(String inputString) {
		assertThatThrownBy(() -> StringCalculator.stringCalculate(inputString))
			.isInstanceOf(IllegalArgumentException.class);
	}
}
