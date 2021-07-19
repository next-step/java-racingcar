package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.Test;

public class StringTest {

	/**
	 * 요구사항 1
	 */
	@Test
	void split() {
		String[] result = "1,2".split(",");

		assertThat(result).containsExactly("1", "2");

		result = "1".split(",");

		assertThat(result).containsExactly("1");
	}

	/**
	 * 요구사항 2
	 */
	@Test
	void substring() {
		String result = "(1,2)".substring(1,4);

		assertThat(result).isEqualTo("1,2");
	}

	/**
	 * 요구사항 3-1
	 */
	@Test
	void charAt() {
		char result = "abc".charAt(1);

		assertThat(result).isEqualTo('b');
	}

	/**
	 * 요구사항 3-2
	 */
	@Test
	void stringIndexOutOfBoundsException() {
		assertThatExceptionOfType(IndexOutOfBoundsException.class)
			.isThrownBy(() -> {
				char result = "abc".charAt(6);
			}).withMessageMatching("String index out of range: \\d+");
	}
}
