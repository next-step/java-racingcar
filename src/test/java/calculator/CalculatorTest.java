package calculator;

import org.junit.Test;

import static org.assertj.core.api.Assertions.assertThat;

/**
 * Created by hspark on 02/11/2018.
 */
public class CalculatorTest {

	@Test
	public void add() {
		double result = Calculator.add(3, 5);
		assertThat(result).isEqualTo(8);
	}

	@Test
	public void substarct() {
		double result = Calculator.sub(3, 5);
		assertThat(result).isEqualTo(-2);
	}

	@Test
	public void dvide() {
		double result = Calculator.divide(4, 2);
		assertThat(result).isEqualTo(2);
	}

}

