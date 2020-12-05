package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	@DisplayName("덧셈 테스트")
	void additionTest() {
		int result = Calculator.calculate(1, "+", 2);
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("뻴셈 테스트")
	void subtractionTest() {
		int result = Calculator.calculate(3, "-", 2);
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("곱셈 테스트")
	void multiplicationTest() {
		int result = Calculator.calculate(3, "*", 2);
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("나눗셈 테스트")
	void divisionTest() {
		int result = Calculator.calculate(8, "/", 2);
		assertThat(result).isEqualTo(4);
	}

	@Test
	@DisplayName("연산기호가 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	void throwIllegalArgumentExceptionWhenOperationIsNotFourArithmeticTest() {
		assertThatThrownBy(() -> Calculator.calculate(8, "%", 2)).isInstanceOf(IllegalArgumentException.class);
	}
}
