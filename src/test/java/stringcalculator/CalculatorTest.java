package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

	@ParameterizedTest(name = "문자열에 값이 없는 경우 테스트 {index} [{arguments}]")
	@EmptySource
	@NullSource
	@DisplayName("문자열에 값이 없는 경우 테스트")
	void blank_string_formula(String formula) throws Exception {
		//when
		Calculator calculator = new Calculator();

		//then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(formula));
	}

}
