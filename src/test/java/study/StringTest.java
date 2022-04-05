package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName("1,2를 ,로 쪼개서 [1, 2]가 리턴")
	@Test
	void split1() {
		String[] result = "1,2".split(",");

		assertThat(result).containsExactly("1", "2");
	}

	@DisplayName("1,를 ,로 쪼개서 [1]이 리턴")
	@Test
	void split2() {
		String[] result = "1".split(",");

		assertThat(result).contains("1");
	}

	@DisplayName("(1,2)를 substring으로 1,2 반환")
	@Test
	void substring() {
		String data = "(1,2)";
		String result = data.substring(1, data.length() - 1);

		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("문자열의 범위를 벗어난 경우 StringIndexOutOfBoundsException 발생")
	@Test
	void charAtException() {
		String data = "abc";

		assertThatThrownBy(() -> data.charAt(data.length()))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: 3");
	}

	@DisplayName("문자열의 범위를 벗어난 경우 StringIndexOutOfBoundsException 발생")
	@Test
	void charAtException2() {
		String data = "abc";

		assertThatExceptionOfType(StringIndexOutOfBoundsException.class)
			.isThrownBy(() -> data.charAt(5))
			.withMessageMatching("String index out of range: \\d+");
	}
}
