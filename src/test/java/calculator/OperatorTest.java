package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class OperatorTest {

	StringCaculator stringCaculator = new StringCaculator();

	@ParameterizedTest
	@NullSource
	@ValueSource(strings = {"", "  ", "1 A 3"})
	@DisplayName("입력값이 잘못됐을 경우 예외처리 테스트")
	void throwException_WhenInvalidInput(String input) {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			stringCaculator.validate(input);
		});
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2", "24,56", "100,1", "2314,235"}, delimiter = ',')
	@DisplayName("더하기 테스트")
	void plus(Integer frontNumber, Integer rearNumber) {
		assertEquals(stringCaculator.plus(frontNumber, rearNumber), frontNumber + rearNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2", "24,56", "100,1", "2314,235"}, delimiter = ',')
	@DisplayName("빼기 테스트")
	void minus(Integer frontNumber, Integer rearNumber) {
		assertEquals(stringCaculator.minus(frontNumber, rearNumber), frontNumber - rearNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2", "24,56", "100,1", "2314,235"}, delimiter = ',')
	@DisplayName("곱하기 테스트")
	void mutiple(Integer frontNumber, Integer rearNumber) {
		assertEquals(stringCaculator.multiply(frontNumber, rearNumber), frontNumber * rearNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"1,2", "24,56", "100,1", "2314,235"}, delimiter = ',')
	@DisplayName("나누기 테스트")
	void divide(Integer frontNumber, Integer rearNumber) {
		assertEquals(stringCaculator.divide(frontNumber, rearNumber), (Integer) frontNumber / rearNumber);
	}

	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2"})
	@DisplayName("사칙 연산을 모두 포함하는 기능 테스트")
	void calculate(String input) {
		assertEquals(stringCaculator.calculate(input), 10);
	}


}
