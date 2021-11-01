package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class StringTest {
	@Test
	void split() {
		String[] result1 = "1,2".split(",");
		String[] result2 = "1".split(",");

		assertThat(result1).containsExactly("1", "2");
		assertThat(result2).contains("1");
	}

	@Test
	void substring() {
		String result = "(1,2)".substring(1, 4);

		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName("특정 위치의 문자를 가져올 때 위치 값을 벗어나면 StringIndexOutOfBoundsException 발생")
	@Test
	void charAt() {
		String target = "abc";

		assertThatThrownBy(() -> target.charAt(5))
			.isInstanceOf(StringIndexOutOfBoundsException.class);
	}
}
