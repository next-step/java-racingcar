package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("StringCalculator : 사칙 연산을 모두 포함하는 기능이 실제 실행되는 클래스")
class StringCalculatorTest {

	@DisplayName("calculate : 사칙 연산을 하기 위한 문자열을 받아 올바른 결과값을 리턴함")
	@ParameterizedTest
	@CsvSource(value = {"2 + 3 * 4 / 2, 10", "2 + 3 - 4 * 2, 2"})
	void calculate(String input, int result) {
		assertThat(new StringCalculator().calculate(input))
			.isEqualTo(result);
	}

}