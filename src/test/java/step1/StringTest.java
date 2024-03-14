package step1;

import static org.assertj.core.api.AssertionsForClassTypes.*;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("요구사항 1 - split을 이용한 문자열 분리")
	@Test
	void split() {
		// given
		String input = "1,2";

		// when
		String[] result = input.split(",");

		// then
		assertThat(result).contains("1", "2");
	}

	@Test
	void splitSingleNumber() {
		// given
		String input = "1";

		// when
		String[] result = input.split(",");

		// then
		assertThat(result).containsExactly("1");
	}

	@DisplayName("요구사항 2 - 문자열에서 () 제거 ")
	@Test
	void removeParentheses() {
		// given
		String input = "(1,2)";

		// when
		String result = input.substring(1, input.length() - 1);

		// then
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("요구사항 3 - 특정 위치의 문자를 가져오기")
	@Test
	void getCharacterAtIndex() {
		// given
		String input = "abc";
		int index = 3;

		// when, then
		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				input.charAt(index);
			}).withMessageMatching("String index out of range: " + index);
	}
}
