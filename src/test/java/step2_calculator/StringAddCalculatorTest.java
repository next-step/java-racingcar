package step2_calculator;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringAddCalculatorTest {

	StringAddCalculator calc = StringAddCalculator.getInstance();

	@DisplayName("NULL EMPTY")
	@Test
	public void splitAndSum_null_또는_빈문자() {
		int result = calc.splitAndSum(null);
		assertThat(result).isEqualTo(0);

		result = calc.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@DisplayName("숫자 1개")
	@Test
	public void splitAndSum_숫자하나() throws Exception {
		int result = calc.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@DisplayName(" 쉼표 구분자 포함")
	@Test
	public void splitAndSum_쉼표구분자() throws Exception {
		int result = calc.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@DisplayName(" 콜론구분자 포함 ")
	@Test
	public void splitAndSum_쉼표_또는_콜론_구분자() throws Exception {
		int result = calc.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("커스텀 구분자")
	@Test
	public void splitAndSum_custom_구분자() throws Exception {
		int result = calc.splitAndSum("//;\n1;2;3");
		assertThat(result).isEqualTo(6);
	}

	@DisplayName("Exception_음수")
	@Test
	public void splitAndSum_negative() throws Exception {
		assertThatThrownBy(() -> calc.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

	@DisplayName("Exception_숫자 이외의 값")
	@Test
	public void splitAndSum_negative_char() throws Exception {
		assertThatThrownBy(() -> calc.splitAndSum("a,2,3"))
			.isInstanceOf(RuntimeException.class);
	}

}
