package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {
	@ParameterizedTest
	@CsvSource(value = {"1,4,5", "10,12,22"})
	@DisplayName("두 숫자를 더한 값을 반환한다.")
	void plusTest(int left, int right, int expected) {
		assertThat(Operator.PLUS.operate(new Operand(left), new Operand(right)))
			.isEqualTo(new Operand(expected));
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,4", "215,210,5"})
	@DisplayName("두 숫자를 뺀 값을 반환한다.")
	void minusTest(int left, int right, int expected) {
		assertThat(Operator.MINUS.operate(new Operand(left), new Operand(right)))
			.isEqualTo(new Operand(expected));
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,32", "15,36,540"})
	@DisplayName("두 숫자를 곱한 값을 반환한다.")
	void multiplyTest(int left, int right, int expected) {
		assertThat(Operator.MULTIPLY.operate(new Operand(left), new Operand(right)))
			.isEqualTo(new Operand(expected));
	}

	@ParameterizedTest
	@CsvSource(value = {"32,8,4", "540,36,15"})
	@DisplayName("두 숫자를 나눈 값을 반환한다.")
	void divideTest(int left, int right, int expected) {
		assertThat(Operator.DIVIDE.operate(new Operand(left), new Operand(right)))
			.isEqualTo(new Operand(expected));
	}

	@Test
	@DisplayName("+를 입력하면 PLUS Operator를 반환한다.")
	void valueOfSign_ReturnPlus() {
		assertThat(Operator.valueOfSign("+")).isEqualTo(Operator.PLUS);
	}

	@Test
	@DisplayName("-를 입력하면 MINUS Operator를 반환한다.")
	void valueOfSign_ReturnMinus() {
		assertThat(Operator.valueOfSign("-")).isEqualTo(Operator.MINUS);
	}

	@Test
	@DisplayName("*를 입력하면 MULTIPLY Operator를 반환한다.")
	void valueOfSign_ReturnMultiply() {
		assertThat(Operator.valueOfSign("*")).isEqualTo(Operator.MULTIPLY);
	}

	@Test
	@DisplayName("/를 입력하면 DIVIDE Operator를 반환한다.")
	void valueOfSign_ReturnDivide() {
		assertThat(Operator.valueOfSign("/")).isEqualTo(Operator.DIVIDE);
	}

	@Test
	@DisplayName("정의되지 않은 연산자를 입력하면 IllegalArgumentException을 발생한다.")
	void valueOfSign_ThrowIllegalArgumentException() {
		assertThatIllegalArgumentException()
			.isThrownBy(() -> Operator.valueOfSign(null))
			.withMessage(Message.UNDEFINED_OPERATOR);

		assertThatIllegalArgumentException()
			.isThrownBy(() -> Operator.valueOfSign("&"))
			.withMessage(Message.UNDEFINED_OPERATOR);
	}
}
