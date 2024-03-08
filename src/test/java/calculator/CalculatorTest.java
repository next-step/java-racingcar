package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

	@DisplayName("덧셈 계산")
	@Test
	void additionCalculate() {
		// given
		String input = "1,2;3";
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(6);
	}
}
