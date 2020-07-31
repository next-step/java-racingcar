package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {
	@DisplayName("덧셈")
	@ParameterizedTest
	@CsvSource(value = {"1:2:3", "-2:1:-1", "0:1:1"}, delimiter = ':')
	void add(int a, int b, int expect) {
		//when
		int actual = Calculator.calculate("+", a, b);

		//then
		assertEquals(expect, actual);
	}

	@DisplayName("뺄셈")
	@ParameterizedTest
	@CsvSource(value = {"1:2:-1", "-2:1:-3", "5:1:4"}, delimiter = ':')
	void subtract(int a, int b, int expect) {
		//when
		int actual = Calculator.calculate("-", a, b);

		//then
		assertEquals(expect, actual);
	}

	@DisplayName("곱셈")
	@ParameterizedTest
	@CsvSource(value = {"1:2:2", "-2:1:-2", "5:2:10", "1:0:0"}, delimiter = ':')
	void multiply(int a, int b, int expect) {
		//when
		int actual = Calculator.calculate("*", a, b);

		//then
		assertEquals(expect, actual);
	}

	@DisplayName("0으로 나눌때 예외처리")
	@ParameterizedTest
	@CsvSource(value = {"1:0"}, delimiter = ':')
	void divideByZero(int a, int b) {
		assertThatThrownBy(() -> Calculator.calculate("/", a, b))
				.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("나눗셈")
	@ParameterizedTest
	@CsvSource(value = {"1:2:0", "-2:1:-2", "5:2:2"}, delimiter = ':')
	void divide(int a, int b, int expect) {
		//when
		int actual = Calculator.calculate("/", a, b);

		//then
		assertEquals(expect, actual);
	}

	@DisplayName("주어진 문자열을 계산한다.")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2:3", "1 * 2 - 0:2", "1 + 3 * 5 / 4:5"}, delimiter = ':')
	void process(String value, int expect) {
		//when
		int actual = Calculator.process(value);

		//then
		assertEquals(expect, actual);
	}
}
