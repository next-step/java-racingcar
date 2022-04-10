package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@DisplayName("빈문자열이거나 Null인 경우 0")
	@Test
	void When_BlackOrNull_Expect_Zero() {
		assertThat(StringAddCalculator.splitAndSum("")).isEqualTo(0);
		assertThat(StringAddCalculator.splitAndSum(null)).isEqualTo(0);
	}

	@DisplayName("쉼표 구분자")
	@Test
	void When_commaSeparator_Then_Sum() {
		assertThat(StringAddCalculator.splitAndSum("1,2")).isEqualTo(3);
	}

	@DisplayName("숫자가 하나인 경우")
	@Test
	void When_OnlyOneNumber_Then_ReturnNumber() {
		assertThat(StringAddCalculator.splitAndSum("1")).isEqualTo(1);
	}

	@DisplayName("콜론 구분자")
	@Test
	void When_ColonSeparator_Then_Sum() {
		assertThat(StringAddCalculator.splitAndSum("2:3")).isEqualTo(5);
	}

	@DisplayName("custom 구분자")
	@Test
	void When_CustomSeparator_Then_Sum() {
		assertThat(StringAddCalculator.splitAndSum("//-\n1-2-3")).isEqualTo(6);
	}

	@DisplayName("구분자_연속사용_RuntimeException_발생")
	@Test
	void When_SeriesOfSeparator_Then_RunTimeException() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1::2"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("custom_구분자포맷이_아닌_구분자_RuntimeException_발생")
	@Test
	void When_UndeclaredSeparator_Then_RunTimeException() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("1;2:3"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("음수_RuntimeException_발생")
	@Test
	void When_NegativeNumber_Then_RunTimeException() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("음수와_custom_구분자_RuntimeException_발생")
	@Test
	void When_NegativeNumberAndCustomSeparator_Then_RunTimeException() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//;\n-1;2;3"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("음수와_custom_구분자가_마이너스일때_RuntimeException_발생")
	@Test
	void When_NegativeNumberAndMinusSeparator_Then_RunTimeException() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("//-\n1--2-3"))
			.isInstanceOf(RuntimeException.class);
	}
}