package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

public class CalculatorTest {

	@ParameterizedTest
	@DisplayName("덧셈, 뺼셈, 곱셈, 나눗셈을 테스트 한다")
	@CsvSource(value = {"1 + 3:4", "3 - 1:2", "2 * 4:8", "4 / 2:2"}, delimiter = ':')
	void calculateTest(String inputString, int result) {
		InputNumber input = new InputNumber(inputString);
		assertThat(Calculator.calculate(input)).isEqualTo(result);
	}

	@ParameterizedTest
	@DisplayName("사칙 연산 모두를 포함하는 기능을 테스트 한다")
	@CsvSource(value = {"1 + 2 * 3 / 3 - 1:2"}, delimiter = ':')
	void allCalc(String input, double result) {
		InputNumber inputNumber = new InputNumber(input);
		assertThat(Calculator.calculate(inputNumber)).isEqualTo(result);
	}

}
