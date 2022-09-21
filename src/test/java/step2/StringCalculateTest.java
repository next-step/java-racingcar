package step2;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

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

	@ParameterizedTest
	@DisplayName("기본 구분자로 split 하기")
	@ValueSource(strings = {"1,2,3", "1:2:3"})
	public void splitByOtherSeparators(String input) throws Exception {
		StringCalculator calculator = new StringCalculator();
		String[] expected = calculator.split(input);
		assertThat(new String[] {"1", "2", "3"}).isEqualTo(expected);
	}

	@Test
	@DisplayName("분리된 문자배열을 숫자배열로 반환")
	public void convertToIntArray() throws Exception {
		StringCalculator calculator = new StringCalculator();
		String[] arr = {"1", "2", "3"};
		int[] expected = calculator.convertToInt(arr);

		assertThat(new int[] {1, 2, 3}).isEqualTo(expected);
	}
}
