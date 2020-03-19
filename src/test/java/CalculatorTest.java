import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

	Calculator calculator;
	int left;
	int right;

	@BeforeEach
	void setUp() {
		left = 5;
		right = 2;
		calculator = new Calculator();
	}

	@Test
	void plus() {
		assertThat(calculator.plus(left, right))
				.isEqualTo(left + right);
	}

	@Test
	void minus() {
		assertThat(calculator.minus(left, right))
				.isEqualTo(left - right);
	}

	@Test
	void mul() {
		assertThat(calculator.mul(left, right))
				.isEqualTo(left * right);
	}

	@Test
	void division() {
		assertThat(calculator.division(left, right))
				.isEqualTo((double) left / right);
	}

	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2 :10"}, delimiter = ':')
	void calculate(String expression, double expectedValue) {
		assertThat(calculator.calculate(expression))
				.isEqualTo(expectedValue);
	}

	@ParameterizedTest
	@ValueSource(strings = {"", "3 ^ 7"})
	void calculateIllegalArgumentException(String expectingIllegalArgumentExpression) {
		assertThatThrownBy(() -> {
			calculator.calculate(expectingIllegalArgumentExpression);
		}).isInstanceOf(IllegalArgumentException.class);
	}
}