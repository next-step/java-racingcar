package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class OperatorTest {
	@ParameterizedTest
	@CsvSource(value = {"1,4,5", "10,12,22"})
	@DisplayName("두 숫자를 더한 값을 반환한다.")
	void plusTest(int left, int right, int expected) {
		assertThat(Operator.PLUS.operate(left, right)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,4", "215,210,5"})
	@DisplayName("두 숫자를 뺀 값을 반환한다.")
	void minusTest(int left, int right, int expected) {
		assertThat(Operator.MINUS.operate(left, right)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"8,4,32", "15,36,540"})
	@DisplayName("두 숫자를 곱한 값을 반환한다.")
	void multiplyTest(int left, int right, int expected) {
		assertThat(Operator.MULTIPLY.operate(left, right)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"32,8,4", "540,36,15"})
	@DisplayName("두 숫자를 나눈 값을 반환한다.")
	void divideTest(int left, int right, int expected) {
		assertThat(Operator.DIVIDE.operate(left, right)).isEqualTo(expected);
	}
}
