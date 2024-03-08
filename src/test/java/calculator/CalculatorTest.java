package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class CalculatorTest {

	@DisplayName("덧셈 계산")
	@Test
	void additionCalculate() {
		// given
		String input = "1,2:3";
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("빈값이나 null값으로 덧셈 계산을 하면 0을 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	void additionCalculateWithNullOrEmptyInputValue(String input) {
		// given
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자 하나 입력시에 그 숫자를 그대로 반환한다.")
	@Test
	void additionCalculateWithSingleNumber() {
		// given
		String input = "3";
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(3);
	}

	@DisplayName("'//'와 '\n' 사이에 위치하는 문자를 덧셈기호로 사용할수 있다.")
	@Test
	void additionCalculateWithCustomSign() {
		// given
		String input = "//;\\n1;2;3";
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(6);
	}
}
