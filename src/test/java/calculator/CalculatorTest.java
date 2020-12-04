package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

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
}
