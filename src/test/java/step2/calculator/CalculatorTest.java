package step2.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@DisplayName("덧셈 사칙 연산 판단")
	@Test
	void given_input_with_plus_when_factory_of_then_return_addition_operator() {
		String input = "2 + 3";
		Operator operator = OperatorFactory.of(input);
		assertThat(operator).isInstanceOf(AdditionOperator.class);
	}

	@DisplayName("뺄셈 사칙 연산 판단")
	@Test
	void given_input_with_minus_sign_when_factory_of_then_return_subtraction_operator() {
		String input = "2 - 3";
		Operator operator = OperatorFactory.of(input);
		assertThat(operator).isInstanceOf(SubtractionOperator.class);
	}

}
