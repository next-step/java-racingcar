package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	public void splitMoreThanTwoElements() {
		String[] actual = "1,2".split(",");

		assertThat(actual).contains("1", "2");
	}

	@Test
	public void splitOnlyOneElement() {
		String[] actual = "1".split(",");

		assertThat(actual).containsOnly("1");
	}

	@Test
	public void subStringExcludedFirstAndLastIndex() {
		String testString = "(1,2)";
		String actual = testString.substring(1, testString.length() - 1);

		assertThat(actual).isEqualTo("1,2");
	}

	@DisplayName("charAt() 성공 테스트")
	@Test
	public void charAtSuccess() {
		String testString = "abc";

		for (int i = 0; i < testString.length(); i++) {
			char actual = testString.charAt(i);

			assertThat(actual).isEqualTo((char)('a' + i));
		}
	}

	@DisplayName("charAt() 실패 테스트")
	@Test
	public void charAtFail() {
		String testString = "abc";

		assertThatThrownBy(() -> {
			testString.charAt(testString.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: %d", testString.length());
	}
}
