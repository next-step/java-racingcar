package calculator;


import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.apache.commons.lang3.StringUtils;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.exception.IllegalDividendException;
import calculator.exception.IllegalInputException;
import calculator.exception.IllegalOperandException;
import calculator.exception.IllegalOperatorException;
import calculator.executor.Calculator;

@DisplayName("연산 예외 테스트")
public class CalculatorExceptionTest {
	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@DisplayName("사용자의 입력값이 비었을 때 테스트")
	@Test
	public void argumentEmptyTest() {
		assertThatThrownBy(() -> {
			calculator.execute(StringUtils.EMPTY);
		}).isInstanceOf(IllegalInputException.class);

		assertThatThrownBy(() -> {
			calculator.execute(null);
		}).isInstanceOf(IllegalInputException.class);

		assertThatThrownBy(() -> {
			calculator.execute("              ");
		}).isInstanceOf(IllegalInputException.class);
	}


	@DisplayName("숫자만 입력된 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1", "1 "})
	public void noExistOperationTest(String input) {
		assertThatThrownBy(() -> {
			calculator.execute(input);
		}).isInstanceOf(IllegalInputException.class)
		  .hasMessageContaining("계산에 필요한 입력이 유효하지 않습니다.");

	}

	@DisplayName("연산자만 입력된 경우 발생하는 예외 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"+", "-", "*", "/"})
	public void noExistNumberTest(String input) {
		assertThatThrownBy(() -> {
			calculator.execute(input);
		}).isInstanceOf(IllegalInputException.class)
		  .hasMessageContaining("계산에 필요한 입력이 유효하지 않습니다.");
	}

	@DisplayName("피연산자 올바르지 못한 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"* * -", "1 * +", "u * 1", "2d * 1"})
	public void illegalOperandTest(String input) {
		assertThatThrownBy(() -> {
			calculator.execute(input);
		}).isInstanceOf(IllegalOperandException.class)
		  .hasMessageContaining("계산에 필요한 피연산자가 입력되지 않습니다.");
	}

	@DisplayName("연산자가 올바르지 못한 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"1 ( 2", "1 3 2", "1 = 3", "1 % 4"})
	public void illegalOperatorTest(String input) {
		assertThatThrownBy(() -> {
			calculator.execute(input);
		}).isInstanceOf(IllegalOperatorException.class)
		  .hasMessageContaining("올바르지 못한 연산자가 입력되었습니다.");
	}

	@DisplayName("제수가 0인 경우 테스트")
	@ParameterizedTest
	@ValueSource(strings = {"2 / 0", "2 + 1 / 0", "10 + 1 * 23 / 2 / 0"})
	public void dividendIs0Test(String input) {
		assertThatThrownBy(() -> {
			calculator.execute(input);
		}).isInstanceOf(IllegalDividendException.class)
		  .hasMessageContaining("0을 제수로 사용할 수는 없습니다.");
	}
}
