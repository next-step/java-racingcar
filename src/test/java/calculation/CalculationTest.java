package calculation;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class CalculationTest {
	@Test
	@DisplayName("더하기 계산")
	public void plusCalculation() {
		Data data = new Data("4 + 2");
		assertThat(calculate(data)).isEqualTo(6);
	}

	@Test
	@DisplayName("빼기 계산")
	public void minusCalculation() {
		Data data = new Data("4 - 2");
		assertThat(calculate(data)).isEqualTo(2);
	}

	@Test
	@DisplayName("곱하기 계산")
	public void multiplyCalculation() {
		Data data = new Data("4 * 2");
		assertThat(calculate(data)).isEqualTo(8);
	}

	@Test
	@DisplayName("나누기 계산")
	public void divideCalculation() {
		Data data = new Data("4 / 2");
		assertThat(calculate(data)).isEqualTo(2);
	}

	@Test
	@DisplayName("연산자 여러개 계산")
	public void allCalculation() {
		Data data = new Data("4 + 2 + 3 * 10 + 10 / 10");
		assertThat(calculate(data)).isEqualTo(10);
	}

	private int calculate(Data data) {
		int operatorCount = Operator.operatorCount(data);

		int operatorIndex;
		int startIndex = 0;
		int number = 0;
		for (int i = 0; i < operatorCount; i++) {
			operatorIndex = Operator.findTheOperatorIndex(data, startIndex);
			number = Calculation.calculate(Operator.findTheOperator(data, operatorIndex),
				Number.findFirstNumber(data, number, operatorIndex), Number.lastNumber(data, operatorIndex));

			startIndex = operatorIndex + 1;
		}

		return number;
	}
}
