package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;

class OperatorStatusTest {

	@Test
	public void plus_operator_validation_success_test() throws Exception {
		//Given
		String operator = "+";

		//When
		OperatorStatus operatorStatus = OperatorStatus.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(OperatorStatus.PLUS);
	}

	@Test
	public void minus_operator_validation_success_test() throws Exception {
		//Given
		String operator = "-";

		//When
		OperatorStatus operatorStatus = OperatorStatus.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(OperatorStatus.MINUS);
	}

	@Test
	public void multiply_operator_validation_success_test() throws Exception {
		//Given
		String operator = "*";

		//When
		OperatorStatus operatorStatus = OperatorStatus.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(OperatorStatus.MULTIPLY);
	}

	@Test
	public void divide_operator_validation_success_test() throws Exception {
		//Given
		String operator = "/";

		//When
		OperatorStatus operatorStatus = OperatorStatus.mapOperatorStatus(operator);

		//Then
		Assertions.assertThat(operatorStatus).isEqualTo(OperatorStatus.DIVIDE);
	}

	@Test
	public void invalid_operator_validation_fail_test() throws Exception {
		//Given
		String operator = "?";

		//When and Then
		Assertions.assertThatThrownBy(() -> {
			OperatorStatus operatorStatus = OperatorStatus.mapOperatorStatus(operator);
		}).isInstanceOf(IllegalArgumentException.class);
	}

}
