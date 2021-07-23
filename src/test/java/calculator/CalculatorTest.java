package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculatorTest {

	@Test
	@DisplayName("덧셈")
	void addition() {
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorOperator addOperator =  CalculatorOperatorFactory.create(CalculatorOperator.PLUS);

		CalculatorNumber result = addOperator.operate(two, three);

		assertThat(result.toInteger()).isEqualTo(5);
	}

	@Test
	@DisplayName("뺄셈")
	void subtraction() {
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorOperator subOperator =  CalculatorOperatorFactory.create(CalculatorOperator.MINUS);

		CalculatorNumber result = subOperator.operate(three, two);

		assertThat(result.toInteger()).isEqualTo(1);
	}

	@Test
	@DisplayName("곱셈")
	void multiplication() {
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorOperator mulOperator =  CalculatorOperatorFactory.create(CalculatorOperator.MULTIPLY);

		CalculatorNumber result = mulOperator.operate(three, two);

		assertThat(result.toInteger()).isEqualTo(6);
	}

	@Test
	@DisplayName("나눗셈")
	void division() {
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorOperator divOperator =  CalculatorOperatorFactory.create(CalculatorOperator.DIVIDE);

		CalculatorNumber result = divOperator.operate(three, two);

		assertThat(result.toInteger()).isEqualTo(1);
	}

	@Test
	@DisplayName("사칙연산")
	void fourFundamentalArithmeticOperations() {
		CalculatorNumber two = new CalculatorNumber(2);
		CalculatorNumber three = new CalculatorNumber(3);
		CalculatorNumber four = new CalculatorNumber(4);
		CalculatorOperator addOperator =  CalculatorOperatorFactory.create(CalculatorOperator.PLUS);
		CalculatorOperator subOperator =  CalculatorOperatorFactory.create(CalculatorOperator.MINUS);
		CalculatorOperator mulOperator =  CalculatorOperatorFactory.create(CalculatorOperator.MULTIPLY);
		CalculatorOperator divOperator =  CalculatorOperatorFactory.create(CalculatorOperator.DIVIDE);

		// 2 + 3 * 4 / 2 - 2 = 8
		CalculatorNumber result = subOperator.
			operate(divOperator.
				operate(mulOperator.
					operate(addOperator.
						operate(two, three), four), two), two);

		assertThat(result.toInteger()).isEqualTo(8);
	}

	@Test
	@DisplayName("계산기")
	void calculator() {
		String testCase = "2 + 3 * 4 / 2";

		Calculator calculator = new Calculator();

		int result = calculator.calculate(testCase);

		assertThat(result).isEqualTo(10);
	}

	@Test
	@DisplayName("입력 값이 null이거나 빈 공백 문자일 경우 IllegalArgumentException throw")
	void nullAndEmpty() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String testCase = " ";
			Calculator calculator = new Calculator();
			int result = calculator.calculate(testCase);
		});
	}

	@Test
	@DisplayName("사칙연산 기호가 아닌 경우 IllegalArgumentException throw")
	void notFourFundamentalArithmeticOperations() {
		assertThatIllegalArgumentException().isThrownBy(() -> {
			String testCase = "2 & 3";
			Calculator calculator = new Calculator();
			int result = calculator.calculate(testCase);
		});
	}
}
