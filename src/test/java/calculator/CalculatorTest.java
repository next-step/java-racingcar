package calculator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class CalculatorTest {

	private Calculator calculator;

	@BeforeEach
	void setUp() {
		calculator = new Calculator();
	}

	@Test
	@DisplayName("OperatingEntry 를 순차적으로 입력받아 계산한 결과가 맞는지 테스트")
	void calculate() {
		// given
		Long firstOperand = 5L;
		OperatingEntry entry1 = OperatingEntry.of(FourRuleOperator.PLUS, 5L);
		OperatingEntry entry2 = OperatingEntry.of(FourRuleOperator.MULTIPLY, 3L);
		List<OperatingEntry> entryList = Arrays.asList(entry1, entry2);

		// when
		Long result = calculator.calculate(firstOperand, entryList);

		// then
		assertThat(result).isEqualTo(30L);
	}
}