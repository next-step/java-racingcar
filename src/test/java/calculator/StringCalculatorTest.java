package calculator;

import static calculator.StringCalculator.*;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

class StringCalculatorTest {

	@DisplayName("빈 문자열 또는 null 값인 경우 0을 반환한다")
	@ParameterizedTest(name = "입력값: {0}")
	@NullAndEmptySource
	void nullOrBlank(String input) {
		assertThat(splitAndSum(input)).isEqualTo(0);
	}

	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환한다")
	@Test
	void oneStringToNum() {
		assertThat(splitAndSum("3")).isEqualTo(3);
	}

	@DisplayName("음수를 전달할 경우 RuntimeException 예외를 던진다")
	@Test
	void negativeNumException() {
		assertThatThrownBy(() -> splitAndSum("-3"))
				.isInstanceOf(IllegalArgumentException.class)
				.hasMessage("음수는 입력할 수 없습니다.");
	}

	@DisplayName("숫자 두개를 컴마 구분자로 입력할 경우 두 숫자의 합을 반환한다")
	@Test
	void splitCommaAndSum() {
		assertThat(splitAndSum("1,3")).isEqualTo(4);
	}

	@DisplayName("구분자를 컴마 이외에 콜론을 사용할 수 있음")
	@Test
	void splitcolonAndSum() {
		assertThat(splitAndSum("1:3,5")).isEqualTo(9);
	}

	@DisplayName("“//”와 “\\n” 문자 사이에 커스텀 구분자를 지정")
	@Test
	void splitWithCustomDelimiter() {
		assertThat(splitAndSum("//;\n1;2;3")).isEqualTo(6);
	}
}