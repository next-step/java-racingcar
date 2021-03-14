package im.juniq.stringcalculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {
	@DisplayName("덧셈 테스트")
	@ParameterizedTest
	@CsvSource({"2 + 3, 5", "2 + 3 + 1, 6", "2 + 3 + 1 + 7, 13"})
	void addition(String input, int expected) {
		assertThat(new Calculator(input).run()).isEqualTo(expected);
	}

	@DisplayName("뺄셈 테스트")
	@ParameterizedTest
	@CsvSource({"3 - 2, 1", "2 - 3 - 1, -2", "17 - 3 - 1 - 7, 6"})
	void subtraction(String input, int expected) {
		assertThat(new Calculator(input).run()).isEqualTo(expected);
	}

	@DisplayName("곱셈 테스트")
	@ParameterizedTest
	@CsvSource({"3 * 2, 6", "2 * 3 * 4, 24", "7 * 3 * 1 * 7, 147"})
	void multiplication(String input, int expected) {
		assertThat(new Calculator(input).run()).isEqualTo(expected);
	}

	@DisplayName("나눗셈 테스트")
	@ParameterizedTest
	@CsvSource({"4 / 2, 2", "16 / 2 / 4, 2"})
	void division(String input, int expected) {
		assertThat(new Calculator(input).run()).isEqualTo(expected);
	}

	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
	@ParameterizedTest
	@NullAndEmptySource
	void inputNullAndBlank(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(input).run());
	}

	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	@ParameterizedTest
	@ValueSource(strings = {"4 @ 2", "3 & 5"})
	void inputNoOperator(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> new Calculator(input).run());
	}

	@DisplayName("사칙 연산을 모두 포함하는 기능 테스트")
	@ParameterizedTest
	@CsvSource({"2 + 3 * 4 / 2, 10", "3 * 2 + 7 / 6 / 2, 1"})
	void calculateFullOperator(String input, int expected) {
		assertThat(new Calculator(input).run()).isEqualTo(expected);
	}
}
