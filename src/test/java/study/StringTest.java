package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	void split() {
		String[] result = "1,2".split(",");
		assertThat(result).contains("1");
		assertThat(result).contains("2");
		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void substring() {
		String input = "(1,2)";
		assertThat(input.substring(1, input.length() - 1)).isEqualTo("1,2");
	}

	@Test
	void charAt() {
		String input = "abc";
		assertThatThrownBy(() -> {
			input.charAt(input.length());
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
		  .hasMessageContaining("String index out of range: " + input.length());
	}
}
