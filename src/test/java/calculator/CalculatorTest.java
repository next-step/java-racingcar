package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Nested;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

public class CalculatorTest {

	@DisplayName("입력값이 null 또는 빈 문자열인 경우 0을 반환한다")
	@ParameterizedTest(name = "{0} 문자열인 경우")
	@NullSource
	@ValueSource(strings = {""})
	void nullOrEmpty(String text) {
		//when & then
		assertThat(Calculator.calculate(text)).isEqualTo(0);
	}

	@DisplayName("컴마(,) 또는 콜론(:) 구분자로 입력하는 경우 숫자의 합을 반환한다.")
	@ParameterizedTest(name = " {0} 구분자로 입력하는 경우")
	@CsvSource(value = {"1,2-3", "1,2:3-6"}, delimiter = '-')
	void commaOrColon(String text, int expected) {
		//when & then
		assertThat(Calculator.calculate(text)).isEqualTo(expected);
	}

	@Test
	@DisplayName("숫자 하나를 문자열로 입력할 경우 해당 숫자를 반환")
	void oneNumber() {
		//given
		String text = "1";

		//when & then
		assertThat(Calculator.calculate(text)).isEqualTo(Integer.parseInt(text));
	}

	@Nested
	@DisplayName("//와 \n 문자 사이에 커스텀 구분자를 지정")
	class customDelimiter {

		@Test
		@DisplayName("커스텀 문자가 ; 일 경우")
		void customDelimiterSemiColon() {
			//given
			String text = "//;\n1;2;3";
			//when & then
			assertThat(Calculator.calculate(text)).isEqualTo(6);
		}

		@Test
		@DisplayName("커스텀 문자가 | 일 경우")
		void customDelimiter() {
			//given
			String text = "//|\n1|2|3";
			//when & then
			assertThat(Calculator.calculate(text)).isEqualTo(6);
		}

		@Test
		@DisplayName("커스텀 문자가 역슬래시 일 경우")
		void customDelimiterBackSlash() {
			//given
			String text = "//\\\n1\\2\\3";
			//when & then
			assertThat(Calculator.calculate(text)).isEqualTo(6);
		}
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1:2:3", "//|\n1|-2|3"})
	@DisplayName("음수를 전달 할 경우 RuntimeException 예외가 발생한다.")
	void negative(String text) {
		//when & then
		assertThatExceptionOfType(RuntimeException.class)
			.isThrownBy(() -> Calculator.calculate(text));
	}
}
