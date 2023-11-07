package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class CalculatorTest {
	// 231102 강의 후 셀프 피드백
	// 각 요구사항을 철저히 분석하고, 요구사항별로 Test로 구현한다.

	@ParameterizedTest
	@NullAndEmptySource
	@DisplayName("cal_null or 빈 값_0")
	public void null_or_빈값(String input) {
		assertThat(cal(input)).isEqualTo(0);
	}

	@Test
	@DisplayName("cal_문자 한개_문자")
	public void 문자_한개_문자열() {
		assertThat(cal("1")).isEqualTo(1);
	}

	@Test
	@DisplayName("cal_컴마로만 구분된 문자열_문자합")
	public void 컴마로만_구분된_문자열() {
		assertThat(cal("1,2,3")).isEqualTo(6);
	}

	@ParameterizedTest
	@CsvSource({"1:2:3,6", "2:2:2,6", "3:3:3,9"})
	@DisplayName("cal_콜론으로만 구분된 문자열_문자합")
	public void 콜론으로만_구분된_문자열(String input, int expected) {
		assertThat(cal(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@CsvSource(value = {"1:2,3/6", "1,2:3/6", "1,2:3,4/10"}, delimiter = '/')
	@DisplayName("cal_콜론과 컴마가 섞인 문자열_문자합")
	public void 콜론_컴마_섞인_구분자(String input, int expected) {
		assertThat(cal(input)).isEqualTo(expected);
	}

	@ParameterizedTest
	@ValueSource(strings = {"-1", "야호", "-1:1:1", "야호:1:1"})
	@DisplayName("cal_숫자가 아닌 값 or 음수가 포함된 문자열_ThrowRuntimeException")
	public void 숫자_이외의_값_혹은_음수(String input) {
		assertThatThrownBy(() -> {
			cal(input);
		}).isInstanceOf(RuntimeException.class).hasStackTraceContaining(".getNumber");
	}

	@Test
	@DisplayName("cal_커스텀 구분자로 구분된 문자열_문자합")
	public void 커스텀_구분자() {
		assertThat(cal("//;\n1;2;3")).isEqualTo(6);
		assertThat(cal("//!\n1!2!3")).isEqualTo(6);
	}
}
