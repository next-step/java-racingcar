package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;

class FourRuleOperatorTest {

	@ParameterizedTest
	@CsvSource(value = {"8,4,12", "0,-5,-5", "-2,-2,-4"})
	@DisplayName("더하기 연산 테스트")
	void operate_PLUS(Long firstOperand, Long secondOperand, Long expected) {
		// when
		Long result = FourRuleOperator.PLUS.operate(firstOperand, secondOperand);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,4", "0,-5,5", "-3,5,-8"})
	@DisplayName("빼기 연산 테스트")
	void operate_MINUS(Long firstOperand, Long secondOperand, Long expected) {
		// when
		Long result = FourRuleOperator.MINUS.operate(firstOperand, secondOperand);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,32", "0,-5,0", "-3,5,-15", "-3,-3,9"})
	@DisplayName("곱하기 연산 테스트")
	void operate_MULTIPLY(Long firstOperand, Long secondOperand, Long expected) {
		// when
		Long result = FourRuleOperator.MULTIPLY.operate(firstOperand, secondOperand);

		// then
		assertThat(result).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,2", "0,-5,0", "-15,3,-5", "-3,-3,1"})
	@DisplayName("곱하기 연산 테스트")
	void operate_DIVIDE(Long firstOperand, Long secondOperand, Long expected) {
		// when
		Long result = FourRuleOperator.DIVIDE.operate(firstOperand, secondOperand);

		// then
		assertThat(result).isEqualTo(expected);
	}
}