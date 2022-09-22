package step1;

import static org.assertj.core.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class StringTest {
	@Test
	public void 요구사항1() throws Exception {
		assertThat("1,2".split(",")).contains("1");
		assertThat("1,2".split(",")).containsExactly("1", "2");
	}

	@Test
	public void 요구사항2() throws Exception {
		String substring = "(1,2)".substring(1, "(1,2)".length() - 1);

		assertThat(substring).isEqualTo("1,2");
	}

	@Test
	public void 특정_위치_문자확인() throws Exception {
		assertThat("abc".charAt(0)).isEqualTo('a');
		assertThat("abc".charAt(1)).isEqualTo('b');
		assertThat("abc".charAt(2)).isEqualTo('c');
	}

	@Test
	public void stringIndexOutOfBoundsException_확인() throws Exception {
		int index = 3;

		assertThatThrownBy(() -> "abc".charAt(index))
			.isInstanceOf(StringIndexOutOfBoundsException.class)
			.hasMessage("String index out of range: " + index);
	}
}
