package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class StringAddCalculatorTest {

	@Test
	@DisplayName("입력값이 null 이면 0을 반환한다")
	void inputNullReturnZero() {
		Integer result = StringAddCalculator.splitAndSumAll(null);
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("입력값이 빈문자열이면 0을 반환한다")
	void inputEmptyStringReturnZero() {
		Integer result = StringAddCalculator.splitAndSumAll("");
		assertThat(result).isEqualTo(0);
	}

	@ParameterizedTest
	@ValueSource(strings = {"1", "2", "10"})
	@DisplayName("숫자 하나를 입력하면 그 숫자를 반환한다")
	void inputOneNumberReturnOneNumber(String input) {
		Integer result = StringAddCalculator.splitAndSumAll(input);
		assertThat(result).isEqualTo(Integer.parseInt(input));
	}

	@Test
	@DisplayName("구분자 콤마(,)를 사용해 2개 숫자의 합을 반환한다")
	void inputTwoNumberReturnSum() {
		Integer result = StringAddCalculator.splitAndSumAll("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("구분자 콤마(,)와 콜론(:)을 사용해 3개 숫자의 합을 반환한다")
	void inputThreeNumberReturnSum() {
		Integer result = StringAddCalculator.splitAndSumAll("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@ParameterizedTest
	@ValueSource(strings = {"//;\n1;2;3", "//@\n1@2@3", "//#\n1#2#3"})
	@DisplayName("//와 \\n 문자사이에 커스텀 구분자를 지정할 수 있다")
	void useCustomDelimiter(String input) {
		Integer result = StringAddCalculator.splitAndSumAll(input);
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("음수를 전달할 경우 IllegalArgumentException이 발생한다")
	void containNegativeNumbers() {
		assertThatThrownBy(() -> {
			Integer result = StringAddCalculator.splitAndSumAll("-1,2,3");
		}).isInstanceOf(IllegalArgumentException.class);
	}
}
