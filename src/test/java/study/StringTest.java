package study;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.*;

public class StringTest {

	@DisplayName("요구사항 1 - split 메서드를 활용한 문자열 분리")
	@Test
	void split() {
		// given
		String input = "1,2";

		// when
		String[] split = input.split(",");

		// then
		assertThat(split).containsExactly("1", "2");
	}

	@DisplayName("요구사항 2 - substring 메서드를 활용한 문자열 추출")
	@Test
	void removeParentheses() {
		// given
		String input = "(1,2)";

		// when
		String actual = input.substring(1, input.length() - 1);

		// then
		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("요구사항 3 - charAt 메서드를 활용한 문자 추출 예외 처리")
	@Test
	void getSpecificCharacters() {
		// given
		String input = "abc";

		// when & then
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					input.charAt(3);
				}).withMessageMatching("String index out of range: \\d");
	}
}
