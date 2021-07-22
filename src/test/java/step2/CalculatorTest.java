package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@DisplayName(value = "덧셈 테스트")
	@CsvSource(value = {"1:2:3", "-1:0:-1", "-1:-1:-2"}, delimiter = ':')
	@ParameterizedTest
	void plus(int number1, int number2, int expect) {
		int result = calculator.plus(number1, number2);

		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "뺄셈 테스트")
	@CsvSource(value = {"1:2:-1", "-1:0:-1", "-1:-1:0"}, delimiter = ':')
	@ParameterizedTest
	void minus(int number1, int number2, int expect) {
		int result = calculator.minus(number1, number2);

		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "곱셈 테스트")
	@CsvSource(value = {"1:2:2", "-1:0:0", "-1:-1:1"}, delimiter = ':')
	@ParameterizedTest
	void multiply(int number1, int number2, int expect) {
		int result = calculator.multiply(number1, number2);

		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "나눗셈 테스트")
	@CsvSource(value = {"1:2:0", "0:-1:0", "-1:-1:1"}, delimiter = ':')
	@ParameterizedTest
	void divide(int number1, int number2, int expect) {
		int result = calculator.divide(number1, number2);

		assertThat(result).isEqualTo(expect);
	}

	@DisplayName(value = "0으로 나눌 때 실패 테스트")
	@Test
	void failDivide() {
		assertThatThrownBy(() -> calculator.divide(1, 0))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0으로 나눌 수 없습니다.");
	}

	@DisplayName(value = "문자열 계산기 테스트")
	@CsvSource(value = {"1 + 2 / 1 * 3:9", "3 - 5 + 2 * 1 / 2:0"}, delimiter = ':')
	@ParameterizedTest
	void calculate(String input, int expect) {
		int result = calculator.calculate(input);

		assertThat(result).isEqualTo(expect);
	}
}
