package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void init() {
		calculator = new Calculator();
	}

	@DisplayName(value = "덧셈 테스트")
	@CsvSource(value = {"1:2:3", "1:0:1", "3:10:13"}, delimiter = ':')
	@ParameterizedTest
	void plus(int number1, int number2, int expect) {
		assertThat(getResult(number1, number2, "+")).isEqualTo(expect);
	}

	@DisplayName(value = "뺄셈 테스트")
	@CsvSource(value = {"1:2:-1", "5:2:3", "3:3:0"}, delimiter = ':')
	@ParameterizedTest
	void minus(int number1, int number2, int expect) {
		assertThat(getResult(number1, number2, "-")).isEqualTo(expect);
	}

	@DisplayName(value = "곱셈 테스트")
	@CsvSource(value = {"1:2:2", "1:0:0", "2:10:20"}, delimiter = ':')
	@ParameterizedTest
	void multiply(int number1, int number2, int expect) {
		assertThat(getResult(number1, number2, "*")).isEqualTo(expect);
	}

	@DisplayName(value = "나눗셈 테스트")
	@CsvSource(value = {"1:2:0", "0:1:0", "5:2:2"}, delimiter = ':')
	@ParameterizedTest
	void divide(int number1, int number2, int expect) {
		assertThat(getResult(number1, number2, "/")).isEqualTo(expect);
	}

	@DisplayName(value = "0으로 나눌 때 실패 테스트")
	@CsvSource(value = {"1:0", "3:0", "0:0"}, delimiter = ':')
	@ParameterizedTest
	void failDivide(int number1, int number2) {
		assertThatThrownBy(() -> getResult(number1, number2, "/"))
			.isInstanceOf(IllegalArgumentException.class)
			.hasMessageContaining("0으로 나눌 수 없어요!");
	}

	@DisplayName(value = "문자열 계산기 테스트")
	@CsvSource(value = {"1 + 2 / 1 * 3:9", "3 - 5 + 2 * 1 / 2:0"}, delimiter = ':')
	@ParameterizedTest
	void calculate(String input, int expect) {
		int result = calculator.execute(input);

		assertThat(result).isEqualTo(expect);
	}

	private int getResult(int number1, int number2, String operator) {
		String expression = formatToExpression(number1, number2, operator);
		return calculator.execute(expression);
	}

	private String formatToExpression(int number1, int number2, String operator) {
		return String.format("%d %s %d", number1, operator, number2);
	}
}
