package training;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class StringTest {

	public static final String COMMA = ",";

	@Test
	@DisplayName("요구사항1-1")
	void split() {
		splitTest("1,2");
	}

	private void splitTest(String s) {
		String[] oneAndTwo = splitString(s);
		assertThat(oneAndTwo).containsExactly("1", "2");
	}

	@Test
	@DisplayName("요구사항1-2")
	void splitLength() {
		String[] one = splitString("1");
		assertThat(one).hasSize(1);
	}

	private String[] splitString(String str) {
		return str.split(COMMA);
	}

	@Test
	@DisplayName("요구사항2")
	void substring() {
		String includeBracket = "(1,2)";
		String removeBracket = includeBracket.substring(1, includeBracket.length() - 1);

		splitTest(removeBracket);
	}

	@Test
	@DisplayName("요구사항3-1")
	void charAtException() {
		//given
		String alphabet = "abc";
		int location = 5;

		//when

		//then
		assertThatThrownBy(() -> {
			getCharAt(alphabet, location);
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
		  .hasMessageContaining("StringIndexOutOfBoundsException");

	}

	@Test
	@DisplayName("요구사항3-2")
	void charAt() {
		//given
		String alphabet = "abc";
		int location = 3;

		//when
		char charAt = getCharAt(alphabet, location);

		//then
		assertThat(charAt).isEqualTo('c');
	}

	private char getCharAt(String alphabet, int location) {
		if (location >= alphabet.length()) {
			throw new StringIndexOutOfBoundsException("StringIndexOutOfBoundsException");
		}
		return alphabet.charAt(location);
	}

}
