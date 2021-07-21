package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

class CalculatorTest {

	Calculator calculator = new Calculator();

	@DisplayName("간단 연산 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2=3",
		"1 - 2=-1",
		"1 * 0=0",
		"100 / 10=10"
	}, delimiter = '=')
	void simpleCalc(String input, Integer expected) {
		Integer result = calculator.calc(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("간단 연산 실패 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2=9",
		"1 - 2=1",
		"1 * 0=1",
		"100 / 10=11"
	}, delimiter = '=')
	void failSimpleCalc(String input, Integer expected) {
		Integer result = calculator.calc(input);

		assertThat(result).isNotEqualTo(expected);
	}

	@DisplayName("복잡 연산 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2 - 1 * 10 / 1=20",
		"100 / 10 + 7 - 5=12"
	}, delimiter = '=')
	void calc(String input, Integer expected) {
		Integer result = calculator.calc(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("복잡 연산 실패 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 2 - 1 * 10 / 1=21",
		"100 / 10 + 7 - 5=1"
	}, delimiter = '=')
	void failCalc(String input, Integer expected) {
		Integer result = calculator.calc(input);

		assertThat(result).isNotEqualTo(expected);
	}

	@DisplayName("Operator가 잘못들어가면 IllegalArgumentException 발생")
	@ParameterizedTest
	@ValueSource(strings = {
		"100 ) 10 * 1",
		"100 더하기 199"
	})
	void operatorCheck(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.calc(input))
			.withMessageMatching("Operator가 잘못되었습니다.");
	}

	@DisplayName("빈 공백이 들어가면 IllegalArgumentException 발생")
	@ParameterizedTest
	@ValueSource(strings = {
		""
	})
	void emptyCheck(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.calc(input))
			.withMessageMatching("빈 공백이 들어왔습니다.");
	}

	@DisplayName("잘못된 수식이 들어가면 IllegalArgumentException 발생")
	@ParameterizedTest
	@ValueSource(strings = {
		"+ 10 20",
		"10 20",
		"+ - *"
	})
	void mathematicalExpressionCheck(String input) {
		assertThatExceptionOfType(IllegalArgumentException.class)
			.isThrownBy(() -> calculator.calc(input))
			.withMessageMatching("수식이 잘못되었습니다.");
	}
}