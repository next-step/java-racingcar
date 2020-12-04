package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CalculatorTest {

	int result;


	@Test
	@DisplayName("계산 테스트 ")
	void plusTest() {

		result = Calculator.plus(4, 5);
		assertThat(result).isEqualTo(9);
	}

	@Test
	@DisplayName("계산 테스트")
	void minusTest() {

		result = Calculator.minus(6, 4);
		assertThat(result).isEqualTo(2);
	}

	@Test
	@DisplayName("계산 테스트")
	void modTest() {

		result = Calculator.mod(10,2);
		assertThat(result).isEqualTo(5);
	}

	@Test
	@DisplayName("계산 테스트")
	void multiTest() {

		result = Calculator.multi(3, 6);
		assertThat(result).isEqualTo(18);
	}
}
