package calculator;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.exception.CalculatorException;
import calculator.executor.Calculator;

@DisplayName("사칙연산 테스트")
public class CalculatorTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@DisplayName("인자가 비었을 때 테스트")
	@Test
	public void argumentEmptyTest() {
		assertThatThrownBy(() -> {
			calculator.calculate(StringUtils.EMPTY);
		}).isInstanceOf(CalculatorException.class);

		assertThatThrownBy(() -> {
			calculator.calculate(null);
		}).isInstanceOf(CalculatorException.class);

		assertThatThrownBy(() -> {
			calculator.calculate("              ");
		}).isInstanceOf(CalculatorException.class);
	}


	@DisplayName("숫자만 입력된 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "1 "})
	public void noExistOperationTest(String input) {
		assertThatThrownBy(() -> {
			calculator.calculate(input);
		}).isInstanceOf(CalculatorException.class)
		  .hasMessageContaining("계산에 필요한 입력이 유효하지 않습니다.");

	}

	@DisplayName("연산자만 입력된 경우 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	public void noExistNumberTest(String input) {
		assertThatThrownBy(() -> {
			calculator.calculate(input);
		}).isInstanceOf(CalculatorException.class)
		  .hasMessageContaining("계산에 필요한 입력이 유효하지 않습니다.");
	}

	@DisplayName("피연산자 올바르지 못한 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"* * -", "1 * +", "u * 1", "2d * 1"})
	public void noDigitTest(String input) {
		assertThatThrownBy(() -> {
			calculator.calculate(input);
		}).isInstanceOf(CalculatorException.class)
		  .hasMessageContaining("계산에 필요한 피연산자가 입력되지 않습니다.");
	}

	@DisplayName("연산자가 올바르지 못한 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1 ( 2", "1 3 2", "1 = 3", "1 % 4"})
	public void illegalArgumentTest(String input) {
		assertThatThrownBy(() -> {
			calculator.calculate(input);
		}).isInstanceOf(CalculatorException.class)
		  .hasMessageContaining("올바르지 못한 연산자가 입력되었습니다.");
	}
}
