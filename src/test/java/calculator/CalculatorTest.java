package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	@DisplayName("덧셈")
	void addition() {
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorOperator addOperator =  CalculatorOperatorFactory.create(CalculatorOperator.PLUS);

		CalculatorNumber result = addOperator.operate(two, three);

		assertThat(result.toInteger()).isEqualTo(5);
	}
}
