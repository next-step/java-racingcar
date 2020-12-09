package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorsTest {

	@Test
	public void plus_operator_validation_success_test() throws Exception {
		//Given
		String operator = "+";

		//When
		Operators operatorStatus = Operators.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(Operators.PLUS);
	}

	@Test
	public void minus_operator_validation_success_test() throws Exception {
		//Given
		String operator = "-";

		//When
		Operators operatorStatus = Operators.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(Operators.MINUS);
	}

	@Test
	public void multiply_operator_validation_success_test() throws Exception {
		//Given
		String operator = "*";

		//When
		Operators operatorStatus = Operators.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(Operators.MULTIPLY);
	}

	@Test
	public void divide_operator_validation_success_test() throws Exception {
		//Given
		String operator = "/";

		//When
		Operators operatorStatus = Operators.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(Operators.DIVIDE);
	}

	@Test
	public void invalid_operator_validation_fail_test() throws Exception {
		//Given
		String operator = "?";

		//When and Then
		Assertions.assertThatThrownBy(() -> {
			Operators operatorStatus = Operators.mapOperatorStatus(operator);
		}).isInstanceOf(IllegalArgumentException.class);
	}

}
