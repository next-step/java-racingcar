package calculator;

import domain.Calculator;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

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
		String input = "//;\n1;2;3";
		Calculator calculator = new Calculator();

		// when
		int result = calculator.additionCalculate(input);

		// then
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("숫자 이외의 값이나 음수를 입력시에 RuntimeException")
	@ParameterizedTest
	@ValueSource(strings = {"wege", "32g:23g", "-1:3"})
	void additionCalculateRuntimeException(String input) {
		// given
		Calculator calculator = new Calculator();

		// when&then
		assertThatThrownBy(() -> calculator.additionCalculate(input))
				.isInstanceOf(RuntimeException.class);
	}
}
