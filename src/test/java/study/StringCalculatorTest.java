package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatIllegalArgumentException;

public class StringCalculatorTest {

	private StringCalculator stringCalculator;

	@BeforeEach
	void init() {
		stringCalculator = new StringCalculator();
	}

	@DisplayName("숫자와 사칙연산으로 된 문자열을 파싱하여 결과값을 내는 테스트")
	@ParameterizedTest
	@CsvSource(value = {"1 + 3 - 5:-1", "6 / 3 * 2:4"}, delimiter = ':')
	void calculate(String input, int result) {
		assertThat(stringCalculator.calculate(input)).isEqualTo(result);

		assertThatIllegalArgumentException().isThrownBy(() -> {
			stringCalculator.calculate(null);
			stringCalculator.calculate("1 & 3 + 2");
		});
	}
}
