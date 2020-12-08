package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {
	Calculator calculator = new Calculator();

	@Test
	public void 덧셈_테스트() throws Exception {
	    // given
		long expectedResult = 6;
	    // when
		String expression = "1 + 2 + 3";
		long actualResult = calculator.calculate(expression);
	    // then
		assertThat(actualResult).isEqualTo(expectedResult);
	}
}