package calculator;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.ValueSource;

import calculator.StringAddCalculator;

public class StringAddCalculatorTest {

	@DisplayName("null 값 또는 빈문자가 들어올 시 0을 반환한다.")
	@ParameterizedTest
	@NullAndEmptySource
	public void splitAndSum_null_또는_빈문자(String str)  {
		int result = StringAddCalculator.splitAndSum(str);
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자가 하나 들어올 시 해당 숫자를 반환한다")
	@Test
	public void splitAndSum_숫자하나()  {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName("쉼표, 콜론, 커스텀 규칙을 기준으로 숫자를 구분하고 합한다.")
	@ParameterizedTest
	@ValueSource(strings = {"1,2,3,4", "1:2:3:4", "1,2:3,4", "//;\n1:2;3,4"})
	public void splitAndSum_쉼표_또는_콜론_또는_커스텀_구분자(String str) {
		int result = StringAddCalculator.splitAndSum(str);
		assertThat(result).isEqualTo(10);
	}

	@DisplayName("숫자 중 음수가 있을 시 IllegalException을 발생시킨다.")
	@Test
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(IllegalArgumentException.class);
	}

	@DisplayName("숫자가 아닌 값이 들어왔을 때 NumberFormatException이 발생한다.")
	@Test
	public void splitAndSum_not_num() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("안녕하세요,2,3"))
			.isInstanceOf(NumberFormatException.class);
	}
}
