package calculator;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MethodTest {
	@Test
	void string_isBlank() {
		assertThat("".isBlank()).isTrue();        // true
		assertThat("  ".isBlank()).isTrue();        // true
		String text = null;
		assertThat(text.isBlank()).isTrue();    // NullPointerException
	}

	@Test
	void string_isEmpty() {
		assertThat("".isEmpty()).isTrue();        // true
		assertThat("  ".isEmpty()).isTrue();        // false
		String text = null;
		assertThat(text.isEmpty()).isTrue();    // NullPointerException
	}

	@Test
	void split_두개() {
		assertThat("1:2".split(",|:")).contains("1", "2");
		assertThat("1,2".split(",|:")).containsExactly("1", "2");
		assertThat("1,2:3".split(",|:")).containsExactly("1", "2", "3");
	}

	@Test
	void split_한개(){
		assertThat("1".split(",|:")).containsExactly("1");
	}
}
