package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

public class StringTest {

	@Test
	void split() {
		String data = "1,2";

		String[] result = data.split(",");

		assertThat(result).containsExactly("1", "2");
	}

	@Test
	void substring() {
		String data = "(1,2)";

		String result = data.substring(1, data.length() - 1);

		assertThat(result).isEqualTo("1,2");
	}

	@Test
	void stringIndexOutOfBounds() {
		String data = "abc";
		int stringLength = data.length();

		assertThatThrownBy(() -> {
			for (int i = 0; i < stringLength + 1; i++) {
				char c = data.charAt(i);
			}
		}).isInstanceOf(StringIndexOutOfBoundsException.class)
				.hasMessage("String index out of range: " + stringLength);
	}
}
