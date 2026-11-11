package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@Test
	@DisplayName(",로 문자열을 split하면 문자열 배열을 반환한다")
	void split() {
		String[] result = "1,2".split(",");

		assertThat(result).contains("1", "2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	@DisplayName("구분자가 없는 문자열을 split하면 문자만 담긴 배열을 반환한다")
	void splitWithoutDelimiter() {
		String[] result = "1".split(",");
		assertThat(result).containsExactly("1");
	}

	@Test
	@DisplayName("substring으로 문자를 제거할 수 있다")
	void substring() {
		String data = "(1,2)";
		String result = data.substring(1, data.length() - 1);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt은 인덱스에 위치한 문자를 반환한다")
	void charAt() {
		char result = "abc".charAt(2);
		assertThat(result).isEqualTo('c');
	}

	@Test
	@DisplayName("문자열을 charAt(인덱스)로 조회 시 문자열 길이를 넘어가면 StringIndexOutOfBoundsException이 발생한다")
	void charAtOutOfRange() {
		assertThatThrownBy(() -> "abc".charAt(3))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
