package racingcar.step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

	@DisplayName("null 또는 빈 문자열을 입력할 경우 0 반환")
	@ParameterizedTest(name = "\"{0}\"일 경우")
	@NullSource
	@ValueSource(strings = {"", " "})
	void sumNullOrEmptyTest(String input) {
		int result = StringAddCalculator.calculate(input);

		assertThat(result).isZero();
	}

	@DisplayName("숫자 하나를 입력할 경우 해당 숫자 반환")
	@ParameterizedTest
	@CsvSource(value = {"1:1", "2:2", "3:3"}, delimiter = ':')
	void sumOneNumberTest(String input, int expected) {
		int result = StringAddCalculator.calculate(input);

		assertThat(result).isEqualTo(expected);
	}

	@DisplayName("숫자 두 개를 컴마(,)로 구분해 합을 반환")
	@Test
	void splitWithCommaAndSumTest() {
		int result = StringAddCalculator.calculate("1,2");

		assertThat(result).isEqualTo(3);
	}

	@DisplayName("컴마와 콜론으로 구분한 숫자들의 합을 반환")
	@Test
	void splitWithSeparatorAndSumTest() {
		int result = StringAddCalculator.calculate("1,2:3");

		assertThat(result).isEqualTo(6);
	}

	@DisplayName("//와 \\n 문자 사이의 커스텀 구분자를 이용하여 구분한 숫자들의 합 반환")
	@Test
	void splitWithCustomSeparatorAndSumTest() {
		int result = StringAddCalculator.calculate("//;\n1;2;3");

		assertThat(result).isEqualTo(6);
	}
}
