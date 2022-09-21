package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringCalculateTest {
	@Test
	@DisplayName("빈 문자열이거나 null 일 때 0 처리")
	public void blankOrNull() throws Exception {
		String str1 = "";
		String str2 = null;
		StringCalculator calculator = new StringCalculator();
		assertThat(calculator.calculate(str1)).isEqualTo(0);
		assertThat(calculator.calculate(str2)).isEqualTo(0);
	}
}
