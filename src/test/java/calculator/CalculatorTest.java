package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	@ParameterizedTest
	@CsvSource(value = {"1 + 2 3", "4 - 2 2", "2 * 3 6", "10 / 2 5"}, delimiter = ' ')
	@DisplayName("계산 부호 추가 테스트")
	void calculateTest(int number1, String sign, int number2, int result) {

		assertThat(Calculator.calculate(number1, number2, sign)).isEqualTo(result);
	}


	@Test
	@DisplayName("덧셈 계산 테스트 ")
	void plusTest() {

		assertThat(Calculator.plus(4, 5)).isEqualTo(9);
	}

	@Test
	@DisplayName("뺄셈 계산 테스트")
	void minusTest() {

		assertThat(Calculator.minus(6, 4)).isEqualTo(2);
	}

	@Test
	@DisplayName("나눗셈 계산 테스트")
	void modTest() {

		assertThat(Calculator.mod(10,2)).isEqualTo(5);
	}

	@Test
	@DisplayName("곱셈 계산 테스트")
	void multiTest() {

		assertThat(Calculator.multi(3, 6)).isEqualTo(18);
	}
}
