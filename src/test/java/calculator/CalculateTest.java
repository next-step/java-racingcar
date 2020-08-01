package calculator;


import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import calculator.executor.Calculator;

@DisplayName("사칙연산 테스트")
public class CalculateTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@DisplayName("덧셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 1:2", "115 + 234:349", "283 + 1888495:1888778"}, delimiter = ':')
	public void plusTest(String userInput, int result) {
		assertThat(calculator.execute(userInput)).isEqualTo(result);
	}

	@DisplayName("뺄셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"10 - 3:7", "22 - 98:-76", "500 - 1:499"}, delimiter = ':')
	public void minusTest(String userInput, int result) {
		assertThat(calculator.execute(userInput)).isEqualTo(result);
	}

	@DisplayName("곱셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"2 * 3:6", "22 * 10:220", "114 * 4:456"}, delimiter = ':')
	public void multiplyTest(String userInput, int result) {
		assertThat(calculator.execute(userInput)).isEqualTo(result);
	}

	@DisplayName("나눗셈 테스트")
	@ParameterizedTest
	@CsvSource(value = {"5 / 5:1", "10 / 3:3", "17 / 3:5"}, delimiter = ':')
	public void divisionTest(String userInput, int result) {
		assertThat(calculator.execute(userInput)).isEqualTo(result);
	}


	@DisplayName("다양한 연산 결과 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2:3", "2 * 3:6", "2 + 3 * 7:35"}, delimiter = ':')
	public void calculateTest(String userInput, int result) {
		assertThat(calculator.execute(userInput)).isEqualTo(result);
	}


}
