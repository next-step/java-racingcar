package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {

	private Calculator calculator;
	@ParameterizedTest
	@CsvSource(value = {"1 + 2 3", "4 - 2 2", "2 * 3 6", "10 / 2 5"}, delimiter = ' ')
	@DisplayName("계산 부호 추가 테스트")
	void calculateTest(int number1, String sign, int number2, int result) {

		calculator = new Calculator(number1);
		calculator.calculate(sign, number2);
		assertThat(calculator.getResult()).isEqualTo(result);
	}


	@Test
	@DisplayName("덧셈 계산 테스트 ")
	void plusTest() {

		calculator = new Calculator(4);
		calculator.calculate("+", 5);
		assertThat(calculator.getResult()).isEqualTo(9);
	}

	@Test
	@DisplayName("뺄셈 계산 테스트")
	void minusTest() {

		calculator = new Calculator(6);
		calculator.calculate("-", 4);
		assertThat(calculator.getResult()).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈 계산 테스트")
	void modTest() {

		calculator = new Calculator(10);
		calculator.calculate("/", 2);
		assertThat(calculator.getResult()).isEqualTo(5);
	}

	@Test
	@DisplayName("곱셈 계산 테스트")
	void multiTest() {

		calculator = new Calculator(3);
		calculator.calculate("*", 6);
		assertThat(calculator.getResult()).isEqualTo(18);
	}
}
