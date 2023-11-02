import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringAddCalculatorTest {
	@Test
	@DisplayName("null 값이 들어올 시 0을 반환한다.")
	public void splitAndSum_null_또는_빈문자() {
		int result = StringAddCalculator.splitAndSum(null);
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("빈문자가 들어올 시 0을 반환한다.")
	public void splitAndSum_빈문자() {
		int result = StringAddCalculator.splitAndSum("");
		assertThat(result).isEqualTo(0);
	}

	@Test
	@DisplayName("숫자가 하나 들어올 시 해당 숫자를 반환한다")
	public void splitAndSum_숫자하나()  {
		int result = StringAddCalculator.splitAndSum("1");
		assertThat(result).isEqualTo(1);
	}

	@Test
	@DisplayName("쉼표로 숫자를 구분하여 합한다.")
	public void splitAndSum_쉼표구분자() {
		int result = StringAddCalculator.splitAndSum("1,2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("콜론으로 숫자를 구분하여 합한다.")
	public void splitAndSum_콜론구분자() {
		int result = StringAddCalculator.splitAndSum("1:2");
		assertThat(result).isEqualTo(3);
	}

	@Test
	@DisplayName("쉼표와 콜론을 혼합하여 숫자를 구분하고 합한다.")
	public void splitAndSum_쉼표_또는_콜론_구분자() {
		int result = StringAddCalculator.splitAndSum("1,2:3");
		assertThat(result).isEqualTo(6);
	}

	@Test
	@DisplayName("기본 규칙에 커스텀 규칙을 더해 합할 수 있다.")
	public void splitAndSum_custom_구분자_혼합() {
		int result = StringAddCalculator.splitAndSum("//;\n1:2;3,4");
		assertThat(result).isEqualTo(10);
	}

	@Test
	@DisplayName("숫자 중 음수가 있을 시 RuntimeException을 발생시킨다.")
	public void splitAndSum_negative() {
		assertThatThrownBy(() -> StringAddCalculator.splitAndSum("-1,2,3"))
			.isInstanceOf(RuntimeException.class);
	}
}
