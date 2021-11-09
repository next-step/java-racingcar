package calculator;

import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {

	@ParameterizedTest
	@DisplayName("사칙 연산이 가능한 연산 기호를 검증한다")
	@CsvSource(value = {"+:PLUS", "-:MINUS", "*:TIMES", "/:DIVIDE"}, delimiter = ':')
	void calculator(String inputOperand, String operand) {
		assertThat(Operator.operation(inputOperand)).isEqualTo(Operator.valueOf(operand));
		assertThat(Operator.valueOf(operand).value()).isEqualTo(inputOperand);
	}

	@Test
	@DisplayName("사칙연산 기호가 아닌경우 IllegalArgumentException을 throw 한다")
	void notOperandValueThrowsException() {
		assertThatThrownBy(() -> Operator.operation("^")).isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("나눗셈 연산을 하는 경우 분모가 0일때 IllegalArgumentException을 throw 한다")
	void divideByZeroThrowsException() {
		assertThatThrownBy(() -> Operator.DIVIDE.operate(1, 0)).isInstanceOf(IllegalArgumentException.class);
	}

}
