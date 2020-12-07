package study.calculator;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

class CalculatorTest {
	@ParameterizedTest
	@CsvSource(value = {"1 + 1:2", "1 - 1:0", "10 * 2:20", "12 / 3:4", " 2 + 3 * 4 / 2:10"}, delimiter = ':')
	@DisplayName("input을 입력으로 결과값을 계산하는 기능 테스트")
	public void calculate_input_test(String input, int answer) throws Exception {
		//Given
		Operators operators = new Operators();
		Calculator calculator = new Calculator(operators);

		//When
		int result = calculator.calculateInput(input);

		//Then
		Assertions.assertThat(result).isEqualTo(answer);

	}
}
