package step2.calculator.domain;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

	@DisplayName("덧셈 사칙 연산 판단")
	@Test
	void given_input_with_plus_when_factory_of_then_return_addition_operator() {
		String input = "2 + 3";
		Operator operator = OperatorFactory.findOperator(input.split(OperatorFactory.INPUT_DELIMITER)[1]);
		assertThat(operator).isInstanceOf(AdditionOperator.class);
	}

	@DisplayName("뺄셈 사칙 연산 판단")
	@Test
	void given_input_with_minus_sign_when_factory_of_then_return_subtraction_operator() {
		String input = "2 - 3";
		Operator operator = OperatorFactory.findOperator(input.split(OperatorFactory.INPUT_DELIMITER)[1]);
		assertThat(operator).isInstanceOf(SubtractionOperator.class);
	}

	@DisplayName("곱셈 사칙 연산 판단")
	@Test
	void given_input_with_asterisk_sign_when_factory_of_then_return_multiplication_operator() {
		String input = "2 * 3";
		Operator operator = OperatorFactory.findOperator(input.split(OperatorFactory.INPUT_DELIMITER)[1]);
		assertThat(operator).isInstanceOf(MultiplicationOperator.class);
	}

	@DisplayName("나눗셈 사칙 연산 판단")
	@Test
	void given_input_with_slash_sign_when_factory_of_then_return_multiplication_operator() {
		String input = "2 / 3";
		Operator operator = OperatorFactory.findOperator(input.split(OperatorFactory.INPUT_DELIMITER)[1]);
		assertThat(operator).isInstanceOf(DivisionOperator.class);
	}

	@DisplayName("숫자와 사칙연산 기호 분리하여 기호에 따른 연산 구현체 포함된 리스트 응답")
	@Test
	void given_input_number_and_signs_when_separate_return_list_contains_only_operator_sign() {
		String input = "2 + 3 - 1 * 4 / 2";
		ArithmeticOperationInputSeparator separator = new ArithmeticOperationInputSeparator(input);
		assertThat(separator.getOperators().size()).isEqualTo(4);

	}

	@DisplayName("계산 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = { "2 + 3 * 4 / 2:10", "10 - 1 * 2 / 6:3" }, delimiter = ':')
	void given_input_when_calculate_then_return_result(final String input, final String expectResult) {
		ArithmeticOperationInputSeparator separator = new ArithmeticOperationInputSeparator(input);
		Calculator calculator = new Calculator();
		int result = calculator.calculate(separator.getNumbers(), separator.getOperators());
		assertThat(result).isEqualTo(Integer.parseInt(expectResult));
	}

	@DisplayName("입력 값이 없을 경우 익셉션")
	@Test
	void given_none_input_when_separate_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String input = "";
			new ArithmeticOperationInputSeparator(input);
		}).withMessage("입력 값이 없습니다.");
	}

	@DisplayName("사칙연산 기호가 아닌 경우 익셉션")
	@Test
	void given_other_sign_input_when_calculate_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String input = "1 ! 3";
			new ArithmeticOperationInputSeparator(input);
		}).withMessage("사칙 연산 기호가 아닙니다.");
	}

	@DisplayName("잘못된 값이 있을 경우 익셉션 - 숫자가 더 많음")
	@Test
	void given_wrong_input_more_number_when_calculate_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String input = "1 * 3 3 3 3";
			new ArithmeticOperationInputSeparator(input);
		}).withMessage("계산 대상 수와 사칙 연산의 짝이 안 맞습니다.");
	}

	@DisplayName("잘못된 값이 있을 경우 익셉션 - 사칙연산 기가 더 많음")
	@Test
	void given_wrong_input_more_sign_when_calculate_then_throw_exception() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String input = "1 * 3 * / + -";
			new ArithmeticOperationInputSeparator(input);
		}).withMessage("계산 대상 수와 사칙 연산의 짝이 안 맞습니다.");
	}

}
