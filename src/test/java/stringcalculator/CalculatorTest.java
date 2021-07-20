package stringcalculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.EmptySource;
import org.junit.jupiter.params.provider.NullSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

class CalculatorTest {

	private Calculator calculator = new Calculator();

	@ParameterizedTest(name = "문자열에 값이 없는 경우 테스트 {index} [{arguments}]")
	@EmptySource
	@NullSource
	@DisplayName("문자열에 값이 없는 경우 테스트")
	void blank_string_formula(String formula) throws Exception {
		//then
		assertThatIllegalArgumentException().isThrownBy(() -> calculator.calculate(formula));
	}

	@ParameterizedTest(name = "사칙연산 계산 테스트 {index} [{arguments}]")
	@CsvSource(value = {
			"1 + 2 + 3 + 4 + 5 + 6 + 7 + 8 + 9 + 10,55",
			"2 + 3 * 4 / 2,10",
			"34 * 4 - 376 / 45 + 6,1"
	})
	@DisplayName("사칙연산 계산 테스트")
	void calculate(String formula, int solution) throws Exception {
		//when
		int result = calculator.calculate(formula);

		//then
		assertThat(result).isEqualTo(solution);
	}

}
