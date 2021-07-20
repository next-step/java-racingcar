package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

	@Test
	@DisplayName("문자열에 값이 없는 경우 테스트")
	void blank_string_formula() throws Exception {
		//given
		String nill = null;
		String formula = " ";

		//when
		Calculator calculator = new Calculator();

		//then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(nill));
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(formula));
	}

}
