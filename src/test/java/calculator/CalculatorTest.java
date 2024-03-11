package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class CalculatorTest {

	private Calculator sut = new Calculator();

	@Test
	void test_calculator_빈문자_또는_null_입력() {
		String expected = "0";

		assertThat(sut.calculate(null)).isEqualTo(expected);
		assertThat(sut.calculate("")).isEqualTo(expected);
	}

}
