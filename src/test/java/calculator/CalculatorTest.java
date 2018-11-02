package calculator;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.Test;

public class CalculatorTest {

	@Test
	public void add() {
		int result = Calculator.add(3, 5);
		assertThat(result).isEqualTo(8);
	}

	@Test
	public void subtract() {
		int result = Calculator.subtract(5, 3);
		assertThat(result).isEqualTo(2);
	}
}