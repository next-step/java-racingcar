package calculation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {

	private static final int LAST_NUMBER_INDEX_COUNT = 1;

	@Test
	@DisplayName("더하기 계산")
	public void plusCalculation() {
		CalculationFormula data = new CalculationFormula("4 + 2");
		assertThat(calculate(data)).isEqualTo(6);
	}

	@Test
	@DisplayName("빼기 계산")
	public void minusCalculation() {
		CalculationFormula data = new CalculationFormula("4 - 2");
		assertThat(calculate(data)).isEqualTo(2);
	}

	@Test
	@DisplayName("곱하기 계산")
	public void multiplyCalculation() {
		CalculationFormula data = new CalculationFormula("4 * 2");
		assertThat(calculate(data)).isEqualTo(8);
	}

	@Test
	@DisplayName("나누기 계산")
	public void divideCalculation() {
		CalculationFormula data = new CalculationFormula("4 / 2");
		assertThat(calculate(data)).isEqualTo(2);
	}

	@Test
	@DisplayName("연산자 여러개 계산")
	public void allCalculation() {
		CalculationFormula data = new CalculationFormula("4 + 2 + 3 * 10 + 10 / 10");
		assertThat(calculate(data)).isEqualTo(10);
	}

	private int calculate(CalculationFormula formula) {
		Number number = new Number(formula.getFormula());
		Operator operator = new Operator(formula.getFormula());

		int result = 0;
		int operatorSize = operator.size();
		for (int i = 0; i < operatorSize; i++) {
			result = number.firstNumber(result, i);
			result = Calculation.calculate(operator.value(i), result, number.value(i + LAST_NUMBER_INDEX_COUNT));
		}

		return result;
	}
}
