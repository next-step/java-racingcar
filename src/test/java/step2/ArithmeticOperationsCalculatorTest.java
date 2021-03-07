package step2;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

public class ArithmeticOperationsCalculatorTest {
	
	private ArithmeticOperationsCalculator calulator;
	
	@BeforeEach
	void setUp() {
		calulator = new ArithmeticOperationsCalculator();
	}

    @ParameterizedTest
	@ValueSource(strings = {"2+3*4/2", "9 / 2 + 3 -10", "2 - 19 *  4"})
	@DisplayName("step2. 사직연산 입려값 정합성 체크 테스트")
	void inputValidationTest(String expression) {
		assertThatThrownBy(() -> {
				calulator.checkInputValueValidation(expression);
			}).isInstanceOf(IllegalArgumentException.class);
	}

    @ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2:10", "2 + 3 * 4 / 2:10", "9 / 2 + 3 * 7 - 10:39", "2 - 19 * 4:-68"}, delimiter = ':')
	@DisplayName("step2. 사칙연산 모듈이 요구사항에 맞게 반환되는지 테스트")
	void calculaterTest(String expression, int expect) {
		assertThat(calulator.calculate(expression)).isEqualTo(expect);
	}
}
