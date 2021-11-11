package study.calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class FormulaTest {

	@Test
	@DisplayName("formula 계산식 테스트")
	void calcFormula() {
		MyNumber first = new MyNumber(1);
		MyNumber second = new MyNumber(2);
		String operator = "+";
		Formula formula = new Formula(first, operator, second);

		MyNumber result = formula.calculate();

		assertThat(result).isEqualTo(new MyNumber(3));
	}

}
