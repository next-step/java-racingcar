package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class CalculatorTest {


	@Test
	void test_sum_two_numbers(){
		// Arrange
		String input = "2 + 4";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(6);

		// Arrange
		calculator = new Calculator("2 + 3");

		// Action
		result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(5);
	}

	@Test
	void test_difference_two_numbers(){
		// Arrange
		String input = "4 - 2";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(2);
	}

	@Test
	void test_multiply_two_numbers(){
		// Arrange
		String input = "4 * 2";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(8);
	}


	@Test
	void test_division_two_numbers(){
		// Arrange
		String input = "4 / 2";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(2);
	}

	@Test
	void test_calculate_more_than_two_numbers(){
		// Arrange
		String input = "2 + 3 * 4 / 2";
		Calculator calculator = new Calculator(input);

		// Action
		int result = calculator.execute();

		// Assertion
		assertThat(result).isEqualTo(10);
	}
}
