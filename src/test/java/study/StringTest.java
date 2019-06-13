package study;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatExceptionOfType;

public class StringTest {

	@Test
	public void test_spilt_normal(){
		String[] result = "1,2".split(",");

		assertThat(result).contains("1");
		assertThat(result).doesNotContain(",");
		assertThat(result.length).isEqualTo(2);

		assertThat(result).containsExactly("1", "2");
	}

	@Test
	public void test_spilt_no_separator(){
		String[] result = "1".split(",");

		assertThat(result.length).isEqualTo(1);
		assertThat(result).contains("1");
	}

	@Test
	public void test_substring(){

		// Arrange
		String value = "(1,2)";

		// Action
		String result = value.substring(1, 4);

		// Assertion
		assertThat(result).isEqualTo("1,2");
	}

	@Test
	public void test_char_at(){
		// Arrange
		String value = "abc";

		// Action
		char result = value.charAt(1);

		// Assertion
		assertThat(result).isEqualTo('b');

		assertThatExceptionOfType(IndexOutOfBoundsException.class)
				.isThrownBy(() -> {
					value.charAt(value.length() + 1);
				});
	}
}
