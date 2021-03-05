package study;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	@DisplayName("split 활용 문자열 자르기 테스")
	void splitTest() {
		String[] data = "1,2".split(",");
		assertThat(data).contains("1");
		assertThat(data).contains("2");
		assertThat(data).containsExactly("1", "2");
	}

	@Test
	@DisplayName("substring 활용 문자열 자르기 테스트")
	void substringTest() {
		String data = "(1,2)".substring(1, 4);
		assertThat(data).isEqualTo("1,2");
	}

	@Test
	@DisplayName("charAt 활용 특정 위치의 문자열 가져오기 테스트")
	void chatAtTest() {
		String data = "abc";
		assertThat(data.charAt(0)).isEqualTo('a');
		assertThat(data.charAt(1)).isEqualTo('b');
		assertThat(data.charAt(2)).isEqualTo('c');

		assertThatThrownBy(() -> {
			data.charAt(4);
		}).isInstanceOf(IndexOutOfBoundsException.class)
			.hasMessageContaining("String index out of range:");
	}
}
