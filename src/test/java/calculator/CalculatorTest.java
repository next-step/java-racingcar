package calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static calculator.Calculator.cal;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class CalculatorTest {
	// 231102 강의 후 셀프 피드백
	// 각 요구사항을 철저히 분석하고, 요구사항별로 Test로 구현한다.

	@Test
	@DisplayName("null 및 빈 값인 경우")
	public void null_및_빈값() {
		assertThat(cal(null)).isEqualTo(0);
		assertThat(cal("")).isEqualTo(0);
	}

	@Test
	@DisplayName("문자 한 개인 경우")
	public void 문자_한개() {
		int result = cal("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("쉼표로만 구분된 문자")
	void 쉼표_구분자() {
		assertThat(cal("1,2,3")).isEqualTo(6);
	}

	@Test
	@DisplayName("콜론으로만 구분된 문자")
	void 콜론_구분자() {
		assertThat(cal("1:2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("콜론과 쉼표가 섞여 구분된 문자")
	void 콜론_쉼표_섞인_구분자() {
		assertThat(cal("1,2:3")).isEqualTo(6);
	}

	@Test
	@DisplayName("숫자가 아닌 값 혹은 음수가 전달된 문자")
	void 숫자_이외의_값_혹은_음수() {
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("-1"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("야호"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("-1:1:1"));
		assertThatExceptionOfType(RuntimeException.class).isThrownBy(() -> cal("야호:1:1"));
	}

	@Test
	@DisplayName("커스텀 구분자를 가진 문자")
	void 커스텀_구분자() {
		assertThat(cal("//;\n1;2;3")).isEqualTo(6);
	}
}
