package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.*;

class StringCalculatorTest {
	StringCalculator stringCalculator = new StringCalculator();

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", "  ", "1 A 3"})
	@DisplayName("입력값이 잘못됐을 경우 예외처리 테스트")
	void throwException_WhenInvalidInput(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			stringCalculator.validate(input);
		});
	}

	@ParameterizedTest
	@CsvSource(value = {"1 + 2"})
	@DisplayName("더하기 테스트")
	void plus(String input) {
		assertEquals(stringCalculator.calculate(input), 3);
	}

	@ParameterizedTest
	@CsvSource(value = {"24 - 56"})
	@DisplayName("빼기 테스트")
	void minus(String input) {
		assertEquals(stringCalculator.calculate(input), -32);
	}

	@ParameterizedTest
	@CsvSource(value = {"2 * 3"})
	@DisplayName("곱하기 테스트")
	void mutiple(String input) {
		assertEquals(stringCalculator.calculate(input), 6);
	}

	@ParameterizedTest
	@CsvSource(value = {"20 / 2"})
	@DisplayName("나누기 테스트")
	void divide(String input) {
		assertEquals(stringCalculator.calculate(input), (Integer) 10);
	}

	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2"})
	@DisplayName("사칙 연산을 모두 포함하는 기능 테스트")
	void calculate(String input) {
		assertEquals(stringCalculator.calculate(input), 10);
	}

}