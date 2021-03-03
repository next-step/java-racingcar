package im.juniq.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	@DisplayName("덧셈 테스트")
	@ParameterizedTest
	@CsvSource({"2 + 3, 5", "2 + 3 + 1, 6", "2 + 3 + 1 + 7, 13"})
	void addition(String input, int expected) {
		assertThat(new Calculator(input).calculate()).isEqualTo(expected);
	}

	@DisplayName("뺄셈 테스트")
	@ParameterizedTest
	@CsvSource({"3 - 2, 1", "2 - 3 - 1, -2", "17 - 3 - 1 - 7, 6"})
	void subtraction(String input, int expected) {
		assertThat(new Calculator(input).calculate()).isEqualTo(expected);
	}

	@DisplayName("곱셈 테스트")
	@ParameterizedTest
	@CsvSource({"3 * 2, 6", "2 * 3 * 4, 24", "7 * 3 * 1 * 7, 98"})
	void multiplication(String input, int expected) {
		assertThat(new Calculator(input).calculate()).isEqualTo(expected);
	}

	@DisplayName("나눗셈 테스트")
	@ParameterizedTest
	@CsvSource({"4 / 2, 2", "16 / 2 / 4, 2"})
	void division(String input, int expected) {
		assertThat(new Calculator(input).calculate()).isEqualTo(expected);
	}
}
