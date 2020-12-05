package step2.calculator;

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

	@DisplayName("곱셈 사칙 연산 판단")
	@Test
	void given_input_with_asterisk_sign_when_factory_of_then_return_multiplication_operator() {
		String input = "2 * 3";
		Operator operator = OperatorFactory.of(input);
		assertThat(operator).isInstanceOf(MultiplicationOperator.class);
	}

	@DisplayName("나눗셈 사칙 연산 판단")
	@Test
	void given_input_with_slash_sign_when_factory_of_then_return_multiplication_operator() {
		String input = "2 / 3";
		Operator operator = OperatorFactory.of(input);
		assertThat(operator).isInstanceOf(DivisionOperator.class);
	}

	@DisplayName("숫자와 사칙연산 기호 분리하여 기호에 따른 연산 구현체 포함된 리스트 응답")
	@Test
	void given_input_number_and_signs_when_separate_return_list_contains_only_operator_sign() {
		String input = "2 + 3 - 1 * 4 / 2";
		Calculator calculator = new Calculator();
		calculator.separate(input);

		assertThat(calculator.getOperators().size()).isEqualTo(4);

	}

	@DisplayName("계산 기능 테스트")
	@ParameterizedTest
	@CsvSource(value = { "2 + 3 * 4 / 2:10", "10 - 1 * 2 / 6:3" }, delimiter = ':')
	void given_input_when_calculate_then_return_result(final String input, final String expectResult) {
		Calculator calculator = new Calculator();
		int result = calculator.calculate(input);
		assertThat(result).isEqualTo(Integer.parseInt(expectResult));
	}

}
