package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CalculatorTest {

	Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@ParameterizedTest
	@CsvSource(value = {
			"2 + 3 :5",
			"2 - 3 :-1",
			"2 * 3 :6",
			"5 / 2 :2.5",
			"2 + 3 * 4 / 2 :10",
	}, delimiter = ':')
	void calculate(String expression, double expectedValue) {
		assertThat(calculator.calculate(expression))
				.isEqualTo(expectedValue);
	}

	@ParameterizedTest
	@NullSource
	@EmptySource
	@ValueSource(strings = {"3 8"})
	void calculateIllegalArgumentException(String expectingIllegalArgumentExpression) {
		assertThatThrownBy(() -> {
			calculator.calculate(expectingIllegalArgumentExpression);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("validation check failed");
	}

	@ParameterizedTest
	@ValueSource(strings = {
			"3 ^ 7",
			"3 & 7",
			"3 = 7",
			"3  7"})
	void calculateIllegalOperator(String expectingIllegalArgumentExpression) {
		assertThatThrownBy(() -> {
			calculator.calculate(expectingIllegalArgumentExpression);
		}).isInstanceOf(IllegalArgumentException.class)
				.hasMessageContaining("check operation failed");
	}
}