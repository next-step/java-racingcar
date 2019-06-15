package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


	@Test
	void test_adding_two_numbers(){
		// Arrange
		String input = "2 + 4";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(6);
	}
}
