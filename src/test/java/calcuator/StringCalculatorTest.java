package calcuator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import calcuator.validator.CompositeValidator;

class StringCalculatorTest {
	private StringCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new StringCalculator(new CompositeValidator());
	}

	@DisplayName("덧셈 연산 검증")
	@Test
	void plus() {
		// given
		String input = "2 + 3";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(5);
	}

	@DisplayName("뺄셈 연산 검증")
	@Test
	void minus() {
		// given
		String input = "10 - 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(8);
	}

	@DisplayName("곱셈 연산 검증")
	@Test
	void multiply() {
		// given
		String input = "5 * 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(10);
	}

	@DisplayName("나눗셈 연산 검증")
	@Test
	void divide() {
		// given
		String input = "8 / 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(4);
	}

	@DisplayName("다양한 사칙 연산 검증")
	@ParameterizedTest
	@CsvSource(value = {
		"2 + 3 * 4 / 2 = 10",
		"9 - 3 * 2 + 7 = 19",
		"20 + 111 - 33 = 98",
		"9 - 5 * 3 + 1 = 13",
		"20 / 5 - 3 * 6 = 6"
	}, delimiter = '=')
	void calculate(String input, int expected) {
		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("입력 값이 null 이거나 빈 공백 문자일 경우 IllegalArgumentException")
	@ParameterizedTest
	@NullAndEmptySource
	void validateNullOrEmpty(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
	}
}
