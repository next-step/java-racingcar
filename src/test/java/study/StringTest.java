package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {

	@DisplayName(value = "split 테스트")
	@Test
	void split() {
		String[] result1 = "1,2".split(",");
		assertThat(result1).containsExactly("1", "2");

		String[] result2 = "1".split(",");
		assertThat(result2).containsExactly("1");
	}

	@DisplayName(value = "substring 테스트")
	@Test
	void substring() {
		String result = "(1,2)".substring(1, 4);
		assertThat(result).isEqualTo("1,2");
	}

	@DisplayName(value = "charAt 테스트")
	@Test
	void charAt() {
		int index = 5;
		assertThatThrownBy(() -> "abc".charAt(index))
			.isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range: " + index);
	}
}
