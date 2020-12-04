package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {
	@Test
	@DisplayName("덧셈 테스트")
	void additionTest() {
		Calculator calculator = new Calculator("1", "+", "2");
		int result = calculator.calculate();
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("뻴셈 테스트")
	void subtractionTest() {
		Calculator calculator = new Calculator("3", "-", "2");
		int result = calculator.calculate();
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("곱셈 테스트")
	void multiplicationTest() {
		Calculator calculator = new Calculator("3", "*", "2");
		int result = calculator.calculate();
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("나눗셈 테스트")
	void divisionTest() {
		Calculator calculator = new Calculator("8", "/", "2");
		int result = calculator.calculate();
		assertThat(result).isEqualTo(4);
	}

	@Test
	@DisplayName("값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
	void throwIllegalArgumentExceptionWhenInputEmptyTest() {
		assertThatThrownBy(() -> new Calculator("", "/", "2"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@Test
	@DisplayName("연산기호가 사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	void throwIllegalArgumentExceptionWhenOperationIsNotFourArithmeticTest() {
		Calculator calculator = new Calculator("8", "%", "2");
		assertThatThrownBy(() -> calculator.calculate()).isInstanceOf(IllegalArgumentException.class);
	}
}
