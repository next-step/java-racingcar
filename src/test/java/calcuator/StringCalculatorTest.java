package calcuator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import calcuator.validator.CompositeValidator;

class StringCalculatorTest {
	private StringCalculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new StringCalculator(new CompositeValidator());
	}

	@Test
	void plus() {
		// given
		String input = "2 + 3";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(5);
	}

	@Test
	void minus() {
		// given
		String input = "10 - 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(8);
	}

	@Test
	void multiply() {
		// given
		String input = "5 * 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(10);
	}

	@Test
	void divide() {
		// given
		String input = "8 / 2";

		// when
		int result = calculator.calculate(input);

		// then
		assertThat(result).isEqualTo(4);
	}

	@ParameterizedTest
	@NullAndEmptySource
	void validateNullOrEmpty(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(input));
	}
}